### 服务器信息管理和性能监控系统——第一期

### 系统介绍：
	服务器信息管理和性能监控系统的作用是帮助服务器管理人员记录服务器的基本信息（例如服务器的硬件配置，cpu、内存、
	磁盘大小和设备号等），代替文本记录这种方式。根据服务器的作用，把服务器分为三种类型，分别是代理服务器、应用服务器
	和数据库服务器。每一台服务器都可以设定为任意一种类型的服务器，也可以不设置任意一种。
	除了信息管理的功能外，还有实时监控服务器的性能的功能，通过图形表的方式去查看服务器的一些基本性能，帮助运维人员快速
	找到一些常见问题，若希望更深入地检查服务器的性能，还是需要登录服务器自行使用命令检测。ps:次功能将放在第二期

----
### 功能:
	1.用户模块
		(1)增删改用户;
		(2)查询用户;
		(3)查询在线用户;
	2.服务器模块
		(1)增删改服务器(代理、应用和数据库服务器);
		(2)查看服务器配置和性能(实时查看性能功能放在第二期完成);

----
### 服务器类型:
	1.代理服务器:虚拟主机名,访问域名,项目根路径,日志路径;
	2.应用服务器:应用名,应用根路径,应用访问路径,应用数据源,部署的tomcat路径;
	3.数据库服务器(oracle):实例名,数据库用户,表空间,临时表空间,使用的项目名称;

----
### 角色权限:
	1.管理员:用户模块;
	2.运维人员:服务器模块;
	3.观察者:服务器模块的查看功能;
