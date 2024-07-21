1.基础环境安装
1.1安装/验证JDK
1.1.1环境确认
root123@test1:~/passkey-login-demo_web$ cat /proc/version
Linux version 6.5.0-1016-azure (buildd@bos03-amd64-021) (x86_64-linux-gnu-gcc-11 (Ubuntu 11.4.0-1ubuntu1~22.04) 11.4.0, GNU ld (GNU Binutils for Ubuntu) 2.38) #16~22.04.1-Ubuntu SMP Fri Feb 16 15:42:02 UTC 2024
1.1.2 安装JDK
sudo apt update
sudo apt install openjdk-17-jdk -y
root123@test1:~/passkey-login-demo_web$ java -version
openjdk version "17.0.11" 2024-04-16
OpenJDK Runtime Environment (build 17.0.11+9-Ubuntu-122.04.1)
OpenJDK 64-Bit Server VM (build 17.0.11+9-Ubuntu-122.04.1, mixed mode, sharing)
1.2 安装/验证Maven
sudo apt install maven -y 
root123@test1:~/passkey-login-demo_web$ mvn -version
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 17.0.11, vendor: Ubuntu, runtime: /usr/lib/jvm/java-17-openjdk-amd64
Default locale: en, platform encoding: UTF-8
OS name: "linux", version: "6.5.0-1016-azure", arch: "amd64", family: "unix"
2扩展成web程序
2.1 安装创建Spring Boot
curl https://start.spring.io/starter.zip \
  -d dependencies=web,thymeleaf,data-jpa,h2,devtools \
  -d language=java \
  -d type=maven-project \
  -d groupId=com.example \
  -d artifactId=passkey-login-demo \
  -d name=passkey-login-demo \
  -d packageName=com.example.passkeylogindemo \
  -d javaVersion=11 \
  -o passkey-login-demo_web.zip
2.2 解压passkey-login-demo_web
unzip passkey-login-demo_web.zip
cd passkey-login-demo_web
