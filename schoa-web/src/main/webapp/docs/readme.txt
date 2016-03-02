一.环境：

	centos 64位 双核cpu 4G内存

二.准备：

	jdk1.7.0_45.tar.gz
	apache-tomcat-7.0.47.tar.gz
	mysql-linux-5

三.部署：

	/opt
	...java
	...mysql
	...tomcat
	...schoa-web
	...schoa-res
	
	/logs
	
	/bakup
	...res
	...database
	...bakimg.sh 加入到crontab中，每天2:00备份一次图片文件资源,整目录备份，保留最近5天数据
	...baksql.sh 加入到crontab中，每天1:00备份一次数据库，备份为sql文件，保留最近5天数据


#################### 安装jdk ####################

	1.下载jdk1.7.0_45.tar.gz
	
	2.cp到/opt,并解压 /opt/jdk1.7.0_45
	
	3.配置环境变量
	
		vi /etc/profile
		--------------------------------
		JAVA_HOME=/opt/jdk1.7.0.45
		PATH=$JAVA_HOME/bin:$PATH
		CLASSPATH=.:$JAVA_HOME/lib
		export JAVA_HOME
		export PATH
		export CLASSPATH
		--------------------------------
		source /etc/profile

#################### 安装tomcat ####################
	
	1.下载apache-tomcat-7.0.47.tar.gz
	
	2.cp到/opt,并解压 /opt/apache-tomcat-7.0.47
	
	3.删除%tomcatRoot%/webapps目录下的examples、docs文件夹
	
	4.删除小猫图标favicon.ico
	
	5.server.xml默认有下面一行： 修改shutdown的值为想要的shutdown口令。
		<Server port="8005" shutdown="abcdshutdown">
		
	6.server.xml部署项目路径
		<Context docBase="/opt/schoa-web" path="/schoa-web" reloadable="false"/>
		<Context docBase="/opt/schoa-web" path="/schoa-res" reloadable="false"/>
	
	7.修改conf/tomcat-user.xml
		<role rolename="manager-gui"/>
		<user username="bjydtomcat" password="schoa2014" roles="manager-gui" />
		
		登录 http://localhost:8080/manager/ 
		输入密码登录,点击右上角 Server Status 可看到内存使用情况。
	
	8.如果启动失败， 权限设置
		sudo chown -R suifeng apache-tomcat-7.0.47
	
	9.根据jvm情况修改tomcat启动参数
		JAVA_OPTS="-server -Xms512M -Xmx1024M -XX:PermSize=128M -XX:MaxPermSize=128M"

	10.开机自启动tomcat6
	
		修改文件/etc/rc.d/rc.local 倒数第二行中增加如下代码
		
		-------------------------------------------------------
		export JAVA_HOME=/usr/local/java/jdk1.5.0_16
		export JDK_HOME=/usr/local/java/jdk1.5.0_16
		/usr/local/apache-tomcat-6/bin/startup.sh
		-------------------------------------------------------
		
		重启生效