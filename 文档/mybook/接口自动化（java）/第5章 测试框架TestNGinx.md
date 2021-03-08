**5-1 TestNG的基本介绍和如何在maven中引用**

**适合测试人员使用的原因**：

- 比Junit涵盖功能更全面的测试框架
- Junit更适合隔离型比较强的单元测试
- TestNGinx更适合复杂的集成测试

在pom中引用

```xml
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.3.0</version>
  <scope>test</scope>
</dependency>
```

**5-2 TestNG基本注解与执行顺序实战**