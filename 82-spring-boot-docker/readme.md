1.在centos中安装好docker环境
	yum install -y docker 
2.在centos中安装好maven环境
	yum install -y maven
	vim /usr/share/maven/conf/settings.xml
	<!--换成阿里云镜像-->
	<mirror>
		<id>nexus-aliyun</id>
		<mirrorOf>*</mirrorOf>
		<name>Nexus aliyun</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	</mirror>
3.启动停止重启docker
	systemctl start/restart/stop docker
4.
	mvn package #打包spring应用
	mvn install dockerfile:build #把spring应用打成docker镜像
	docker images #查看镜像
	docker run -d -p 8080:8080 <id>#运行镜像