---

---

JMeter常用的三种断言类型：

## 一、Response Assertion（响应断言）

### Response Assertion配置参数

![](.\img\1580128320356.png)

 __名称（name）__ ：断言名称
 __Apply to__ :断言应用的范围

- Main sample and sub-samples 作用于父节点取样器及其子节点取样器
- Main sample only	仅作用于父节点取样器
- Sub-samples only	仅作用于子节点取样器
- JMeter Variable Name to use	作用于JMeter变量（输入框可以输入JMeter的变量名称）

__Field to Test(要测试的响应字段)__ ：
- Text Response		匹配从服务器返回的响应文本（不包括Response Headers）
- Response Code		匹配响应状态码
- Response Message	匹配响应信息。如：OK	
- Response Headers	匹配响应头
- Request Headers	匹配请求头
- URL Sampled		匹配URL链接
- Document(text)	匹配文档内容
- Ignore Status		一个请求多项响应断言时，忽略某一项断言的响应结果，而继续下一项断言
- Request Data		匹配请求数据

__Pattern Mactching Rules：模式匹配规则__ 
- Contains		返回的结果包括所指定的内容，支持正则匹配
- Matches		根据指定内容进行匹配
- Equals			返回结果与所指定的内容一致
- Substring		返回结果包括所指定结果的字符串，不支持正则匹配
- Not			不进行匹配就算是Pass
- Or			暂不确定该模式的用法

 __Patterns to Test:__ 
- Patterns to Test	需要匹配的正则表达式、字符串。可以添加多项，每一项会分开进行验证，若某一项验证失败，则其后的不会再进行验证。

## 二、Size Assertion（数据包字节大小断言）
判断响应结果是否包含正确数量的byte。可定义（=, !=, >, <, >=, <=）

## 三、Duration Assertion（持续时间断言）
判断是否在给定的时间内返回响应结果

## 四、JSON Schema Assertion

