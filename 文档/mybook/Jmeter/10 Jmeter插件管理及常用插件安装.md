Jmeter插件管理及常用插件安装.

1、下载 jmeter-plugins-manager-1.3.jar

1、进入JMeter Plugins官网：https://jmeter-plugins.org/，下载plugins-manager.jar文件；     

 2、将jar文件放入JMeter安装目录下的lib/ext目录下；     

 3、重启JMeter，在Options-Plugins Manager中可以看到插件页面如下，展示已安装及可安装的插件。

下载地址：https://jmeter-plugins.org/wiki/PluginsManager/

线程组：

JMeter自带的线程组无法实现复杂的测试场景，只能设定固定线程数，对于类似浪涌式线程无法实现。JMeter Plugins提供了2个支持复杂场景的线程组元件，Ultimate Thread Group和Stepping Thread Group。

**1、Ultimate Thread Group** 

Ultimate Thread Group可以设置多条线程的任务，具体任务设置如下：

第一个任务：10个线程在10秒内启动，持续运行1800秒，然后在10秒内结束运行； 

第二个任务：10个线程在第620秒的时候在10秒内启动完成，并运行1200秒，然后在10秒内结束运行； 

第三个任务：10个线程在第1240秒的时候在10秒内启动完成，运行600秒之后在10秒内结束运行； 以此组成一个浪涌场景，30个线程分三次启动，也即一个稳定性测试场景。线程任务场景如下图所示。

![cu9ou2yoll](\img\cu9ou2yoll.jpeg)

**2、Stepping Thread Group** 

Ultimate Thread Group的设置中，需要每次都计算Initial Dealy的值，比较麻烦。Stepping Thread Group则更为简单。 下图设置的具体场景为：

- 共100个线程按照阶梯状递增，每5秒内加载20个线程直到加到100个线程。
- 其中每个阶梯运行600秒，最后一个阶梯运行1000秒，即最终并发100个线程时的运行时间为1000秒。
- 最后每秒停止10个线程。

这是一个典型的负载场景，持续增加负载，检验在不同负载下的性能。

![5kw28gxkp4](\img\5kw28gxkp4.jpeg)

