---
Appium-server安装
---

 推荐根据这个博客安装：https://www.cnblogs.com/cainiaotest/p/11724761.html 

<img src="..\appium_img\1580531926969.png" alt="1580531926969" style="zoom: 67%;" />

最新安装方法（未实验）：https://testerhome.com/topics/10193?locale=en

- 安装Node.js，推荐LTS版本

- 安装Appium

  官方文档的安装方式（因为服务器在海外，因为众所周知的原因，基本安装不上）

  ```
  npm install -g appium
  ```

  淘宝cnpm（最稳定的方法）

  ```
  npm install -g cnpm --registry=https://registry.npm.taobao.org
  cnpm install -g appium
  ```

  相关链接：https://shimo.im/docs/HCt3j9DgHwCQ8HdD/

  ![1580534946415](..\appium_img\1580534946415.png)

  从appium源代码仓库查看推荐的版本：位置：appium/package.json

  

# **Appium 难安装解决方法**

## Appium 难安装的问题

Appium 的安装有2个主要的过程

- 安装依赖包

- 下载 chromedriver

淘宝的镜像可以方便的下载依赖包, 他能把大部分的依赖都缓存到国内. 但是解决不了第二个问题, 因为第二个是绕过了npm的包管理方式直接下载的.

所以需要两个代理的设置.

- npm 代理

- 普通下载代理

## 安装

proxy=http:*//112.126.81.122:6$(date +%m%d)*

http_proxy=$proxy https_proxy=$proxy npm --proxy $proxy --https-proxy $proxy  install -g appium --verbose

## 安装不同的版本

在上面代理的基础上

npm install appium@x.x.x 

具体版本可通过npm查询出来

npm view appium versions --json

## 淘宝镜像

如果代理不可用了, 最后一招

npm install -g cnpm --registry=https:*//registry.npm.taobao.org*

cnpm install -g appium