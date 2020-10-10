### JMeter的分布式执行及命令行运行脚本

　[**jmeter**](javascript:;)可以适用于主流的各大平台上，但是并不是所有系统都支持GUI的模式，jmeter贴心的提供了命令行的方式进行jmeter脚本的运行，有了命令行的执行方式。在进行大数据量进行压测时，一台执行机会引起本身的性能瓶颈，所以需要用到分布式的执行方式，所以有了分布式的方式。

　　**一、命令行执行jmeter脚本：**

　　**1、jmeter 的参数**

　　-h, –help -> prints usage information and exit

　　-n, –nongui -> run JMeter in nongui mode

　　-t, –testfile -> 要运行的 JMeter [**测试**](javascript:;)脚本文件

　　-l, –logfile -> [**记录**](javascript:;)结果的文件

　　-r, –runremote -> 在Jmter.properties文件中指定的所有远程服务器 (as defined in remote_hosts)

　　-H, –proxyHost -> 设置 JMeter 使用的代理主机

　　-P, –proxyPort -> 设置 JMeter 使用的代理主机的端口号

　　**2、常用命令语句**

　　jmeter 【-n】 【-t】 +文件名.jmx+文件路径 【-l】 文件路径+文件名.jtl

　　PS1：此命令需要在\apache-jmeter-2.11\bin下执行

　　PS2：文件名需要加上后缀

　　在图形界面创建好脚本后，我们可以将我们的脚本拷贝到其他设备上运行，在bin下打开命令行执行命令：

　　提前创建好脚本，此处的脚本为：用户登录系统，1个线程租、执行1次



![img](http://www.51testing.com/attachments/2018/01/14982672_201801151130401nyiC.png)

命令执行登录脚本文件

　　执行完命令后，我们打开jmeter的GUI界面，在聚合报告中，打开结果文件，查看运行的结果：

![img](http://www.51testing.com/attachments/2018/01/14982672_201801151130402amul.png)

查看结果文件

　　这种方式可以方便的在[**Linux**](javascript:;)及其他设备上运行，增加脚本的可移植性

　　**二、分布式jmeter执行**

　　1、使用Jmeter进行分布式测试的主要步骤是如下：

　　2、在所有的机器上安装相同版本的Jmeter,然后在jemter\bin\下运行jmeter-server文件

　　3、修改执行机上的jmeter properties文档中，修改端口：server_port、[**server**](javascript:;).rmi.localport 两个参数的端口（一般建议从5开头的端口）如果是注释的请去掉前面的：#

![img](http://www.51testing.com/attachments/2018/01/14982672_2018011511304034hX0.png)

修改参数为“5073”

　　PS：为了保证端口的唯一和可执行性，需要修改端口

　　可以启在jmeter_server.bat 查看IP：

![img](http://www.51testing.com/attachments/2018/01/14982672_2018011511304043L2X.png)

jmeter_server.bat查看IP及端口

　　4、在Cotroller机器上%Jmeter_Home%/bin下,找到Jmeter.properties,把执行机的ip添加到remote_hosts=10.10.17.9:5073,10.10.17.11:5088

![img](http://www.51testing.com/attachments/2018/01/14982672_201801151130405Kcqa.png)

设置执行机的IP

　　完成后重新启动jmeter_server、以及jmeter

　　5、在Controller机器上》运行>Remote Start/Remote Start All. 注意Controller本身也可以做为Agent(需重复步骤3和4)

![img](http://www.51testing.com/attachments/2018/01/14982672_201801151130406sBaU.png)

运行

　　ps：远程启动，每次只启动选中的IP，运程全部启动，则执行所有的执行IP

　　我们选择，10.10.17.9.5073

　　图中红框表示在运行

![img](http://www.51testing.com/attachments/2018/01/14982672_201801151130407V5vz.png)

选择执行机运行

　　查看聚合报告：

![img](http://www.51testing.com/attachments/2018/01/14982672_201801151130408tVa3.png)

运行后的聚合报告

　　查看结果树：

![img](http://www.51testing.com/attachments/2018/01/14982672_2018011511304095vze.png)

结果树结果

　　以上为，图像界面的分布式部署执行jmeter脚本，但是我们还可以通过命令行的界面执行以上操作

　　**三、非GUI下分布式执行脚本**

　　**1、修改执行机及控制机的参数**

　　./jmeter -Djava.rmi.server.hostname=XX.XX.XX.XX -Dserver.rmi.localport=XXXX -Dserver_port=XXXX -s -j jmeter-server.log "$@"

　　**2、执行脚本输出结果**

　　jmeter -n -t xx.jmx -R xxx.xxx.xxx.xxx:5174,xxx.xxx.xxx.xxx:5172 -l xxx.jtl -j xxx.log

　　PS：-R表示选择执行=远程启动

　　-r 表示启动所有执行机=远程全部启动