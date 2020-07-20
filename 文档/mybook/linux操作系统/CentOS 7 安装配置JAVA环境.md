## 1.打开url选择jdk1.8下载

http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

我选择linux x64版本：

![1595130616421](.\img\1595130616421.png)

## 2.下载

```shell
wget https://download.oracle.com/otn/java/jdk/8u241-b07/1f5b5a70bf22433b84d0e960903adac8/jdk-8u241-linux-x64.tar.gz?AuthParam=1579832015_5fcd01ac5c23ff718eadc95146cc40f8
```

下载地址已失效，可浏览oracle官网获取最新下载地址

## 3.安装

（1）创建安装目录

```shell
mkdir /usr/local/java/
```

（2）解压至安装目录

```shell
tar -zxvf jdk-8u241-linux-x64.tar.gz -C /usr/local/java/
```

## 4.设置环境变量

打开文件

`vim /etc/profile` 在末尾添加

```shell
export JAVA_HOME=/usr/local/java/jdk1.8.0_241export JRE_HOME=${JAVA_HOME}/jreexport CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/libexport PATH=${JAVA_HOME}/bin:$PATH
```

使环境变量生效

```
source /etc/profile
```

添加软链接

```
ln -s /usr/local/java/jdk1.8.0_241/bin/java /usr/bin/java
```

检查

```
java -version
```

![1595130791969](.\img\1595130791969.png)

