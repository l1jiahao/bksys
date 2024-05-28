### Frontend
- Vue
- Ant Design Vue Pro

### Backend
- SpringBoot
- MySQL
- Mybatis-plus
- Lombok





.
├── Dockerfile
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── t6
    │   │           └── bksys
    │   │               ├── BksysApplication.java                        主函数（启动）
    │   │               ├── controller
    │   │               │   ├── AlterStatusController.java          修改教室状态
    │   │               │   ├── AvaliDeskController.java             修改座位状态
    │   │               │   ├── BookController.java                        学生预定座位
    │   │               │   ├── ClassroomCodeController.java   学生输入签到码进行签到
    │   │               │   ├── ClassroomTimeController.java  管理员修改教室开放时间
    │   │               │   ├── FindAllAddressController.java   返回所有地址信息
    │   │               │   ├── FindClassroomController.java   返回所有教室信息 
    │   │               │   ├── InsertClassroomController.java 管理员新增教室
    │   │               │   ├── InsertFloorController.java           管理员新增地址
    │   │               │   ├── RecordSearchController.java      查找预约记录
    │   │               │   ├── UserAlterController.java                管理员选择用户
    │   │               │   ├── UserController.java                     	  获取用户信息
    │   │               │   ├── UserLoginController.java               用户登录
    │   │               │   └── UserRegistrationController.java  用户注册
    │   │               ├── entity                                            				常用数据结构
    │   │               │   ├── Address.java             
    │   │               │   ├── Classroom.java
    │   │               │   ├── Record.java
    │   │               │   ├── Seat.java
    │   │               │   └── User.java
    │   │               ├── GenerateClassroomcode.java             生成教室签到码	

​    │   │               ├──SendafterEmail.java                                 预约超时发送提醒邮件

​    │   │               ├── SendbeforeEmail.java							预约到期前发送提醒邮件

​    │   │               ├── mapper
​    │   │               │   ├── AlterStatusMapper.java
​    │   │               │   ├── AvaliDeskMapper.java
​    │   │               │   ├── BookMapper.java
​    │   │               │   ├── ClassroomCodeMapper.java
​    │   │               │   ├── ClassroomMapper.java
​    │   │               │   ├── ClassroomTimeMapper.java
​    │   │               │   ├── FindAllAddressMapper.java
​    │   │               │   ├── FindClassroomMapper.java
​    │   │               │   ├── InsertClassroomMapper.java
​    │   │               │   ├── InsertFloorMapper.java
​    │   │               │   ├── RecordRemindAfterMapper.java
​    │   │               │   ├── RecordRemindBeforeMapper.java
​    │   │               │   ├── RecordSearchMapper.java
​    │   │               │   ├── SeatMapper.java
​    │   │               │   ├── UserAlterMapper.java
​    │   │               │   ├── UserLoginMapper.java
​    │   │               │   ├── UserMapper.java
​    │   │               │   └── UserRegistrationMapper.java
​    │   │               └── service
​    │   │                   ├── AlterStatusService.java
​    │   │                   ├── AvaliDeskService.java
​    │   │                   ├── BookService.java
​    │   │                   ├── ClassroomCodeService.java
​    │   │                   ├── ClassroomService.java
​    │   │                   ├── ClassroomTimeService.java
​    │   │                   ├── FindAllAddressService.java
​    │   │                   ├── FindClassroomService.java
​    │   │                   ├── InsertClassroomService.java
​    │   │                   ├── InsertFloorService.java
​    │   │                   ├── MailUtil.java
​    │   │                   ├── RecordRemindAfterService.java
​    │   │                   ├── RecordRemindBeforeService.java
​    │   │                   ├── RecordSearchService.java
​    │   │                   ├── UserAlterService.java
​    │   │                   ├── UserLoginService.java
​    │   │                   ├── UserRegistrationService.java
​    │   │                   └── UserService.java
​    │   └── resources
​    │       ├── application.properties
​    │       └── logback.xml
​    └── test
​        └── java
​            └── com
​                └── t6
​                    └── bksys
​                        └── BksysApplicationTests.java
