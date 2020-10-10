Jmeter踩坑：响应中文显示为unicode（如何断言）

在断言一个接口返回信息时，接口返回的是unicode编码的内容，部分响应信息如下：

```json
{"status":"0","msg":"\u64CD\u4F5C\u6210\u529F","data":{"coush_array":[{"id":"4147","name":"1-3\u5E74\u7EA7\u8BED\u6587\u6625\u5B63\u5F00\u5B66\u6536\u5FC3\u8BFE","cover_picture":"https:%5C*****%5C/lilclpic%5C/lilclpic_1579077026207.png","price_current":"8","student_num":"209","numer":"3","lecture_type":"10","start_time":"","subject_id":"34","lesson_type_id":"0","brand":"0","lesson_type":"1","class_type":"1","type":"2","brand_type":2}]},}
```

于是添加了一个响应断言，如下：

![1582427923124](.\img\1582427923124.png)

但是断言失败了

![1582428092873](.\img\1582428092873.png)

又修改断言结果中的msg为中文："status": "0","msg": "操作成功",

再次运行，还是失败，此刻我已经有点懵了。

后来看到网上有人已经踩过这种坑，解决办法就是添加一个beanshell断言，将相应结果转化为utf-8,直接贴代码 

```java
String s=new String(prev.getResponseData(),"UTF-8");
        char aChar;
        int len= s.length();
        StringBuffer outBuffer=new StringBuffer(len);
        for(int x =0; x <len;){
            aChar= s.charAt(x++);
            if(aChar=='\\'){
                aChar= s.charAt(x++);
                if(aChar=='u'){
                    int value =0;
                    for(int i=0;i<4;i++){
                        aChar= s.charAt(x++);
                        switch(aChar){
                            case'0':
                            case'1':
                            case'2':
                            case'3':
                            case'4':
                            case'5':
                            case'6':
                            case'7':
                            case'8':
                            case'9':
                                value=(value <<4)+aChar-'0';
                                break;
                            case'a':
                            case'b':
                            case'c':
                            case'd':
                            case'e':
                            case'f':
                                value=(value <<4)+10+aChar-'a';
                                break;
                            case'A':
                            case'B':
                            case'C':
                            case'D':
                            case'E':
                            case'F':
                                value=(value <<4)+10+aChar-'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx  encoding.");}}
                    outBuffer.append((char) value);}else{
                    if(aChar=='t')
                        aChar='\t';
                    else if(aChar=='r')
                    aChar='\r';
                    else if(aChar=='n')
                    aChar='\n';
                    else if(aChar=='f')
                    aChar='\f';
                    outBuffer.append(aChar);}}else
                outBuffer.append(aChar);}
prev.setResponseData(outBuffer.toString());
```

 注意脚本的放置位置，如果是父级是线程组，则对于整个线程组都起作用 

此时再使用"status": "0","msg": "操作成功"进行断言，OK，断言通过