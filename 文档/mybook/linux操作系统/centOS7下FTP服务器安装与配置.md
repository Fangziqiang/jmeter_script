### 1、安装 FTP 服务

- 检查是否已安装vsftpd软件

  ```
  rpm -qa |grep vsftpd
  ```

  

- 如果没有安装，使用YUM命令进行安装

  `yum install vsftpd -y`

  

### 2、启动 VSFTPD 服务

- 安装完成后，启动 FTP 服务：

  ```shell
  systemctl start vsftpd.service
  # 老版本执行命令：
  service vsftpd start
  - 启动后，可以看到系统已经监听了 21 端口： 
  `netstat -nltp | grep 21` 
  ```

  

- 停止 ftp 服务

  ```shell
  systemctl stop vsftpd.service
  # 老版本执行命令：service vsftpd stop
  ```

  

- 重启 ftp 服务

  ```shell
  systemctl restart vsftpd.service
  # 老版本执行命令：service vsftpd restart
  ```

  ### 3、配置 FTP 权限