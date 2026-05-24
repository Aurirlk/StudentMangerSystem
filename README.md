# 学生成绩管理系统 (StudentManagerSystem)

## 项目简介

基于 **Spring Boot + Vue** 前后端分离架构的高校学生成绩管理系统，旨在实现学生成绩的数字化、可视化管理，替代传统纸质管理模式，提升教务管理效率。

## 技术栈

### 后端
| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.5.6 | 主框架 |
| MyBatis | 1.3.1 (starter) | ORM 持久层框架 |
| MySQL | 8.0.19 | 数据库 |
| Maven | - | 构建工具 |
| JWT (java-jwt) | 3.4.0 | Token 认证 |
| PageHelper | 1.4.1 | 分页插件 |
| Fastjson | 1.2.62 | JSON 处理 |
| Druid / C3P0 | - | 数据库连接池 |
| Lombok | - | 代码简化 |
| Java | 1.8 | 运行环境 |

### 前端
| 技术 | 版本 | 说明 |
|------|------|------|
| Vue | 2.5.2 | 前端框架 |
| Element UI | 2.12.0 | UI 组件库 |
| Vue Router | 3.0.1 | 路由管理 |
| Vuex | 3.1.1 | 状态管理 |
| Axios | 0.19.0 | HTTP 请求库 |
| ECharts / VCharts | 4.7.0 / 1.19.0 | 数据可视化图表 |
| XLSX / FileSaver | 0.15.6 / 2.0.2 | Excel 导出 |
| Webpack | 3.6.0 | 前端构建工具 |

## 开发工具

- **后端开发**: IntelliJ IDEA / Eclipse（项目同时提供两份 IDE 配置）
- **前端开发**: Visual Studio Code
- **数据库管理**: Navicat Premium
- **版本控制**: Git
- **接口测试**: Postman（推荐）

## 项目结构

```
StudentMangerSystem/
├── sql/
│   └── student_manager_system.sql    # 数据库初始化脚本
├── StudentManagerSystemApi - idea/   # 后端项目（IDEA 版）
│   ├── pom.xml                       # Maven 依赖配置
│   └── src/main/
│       ├── java/com/rabbiter/sms/
│       │   ├── StudentMisApplication.java  # 启动类
│       │   ├── config/                     # 配置类（CORS、拦截器等）
│       │   ├── controller/                 # 控制层（API 接口）
│       │   │   ├── User/                   # 用户登录、管理员、学生、教师
│       │   │   ├── Course/                 # 课程管理
│       │   │   ├── Score/                  # 成绩管理
│       │   │   ├── Timetable/              # 课程表管理
│       │   │   ├── TeacherCourse/          # 教师课程分配
│       │   │   ├── Profession/             # 专业管理
│       │   │   └── Upload/                 # 文件上传
│       │   ├── service/                    # 业务逻辑层
│       │   ├── dao/                        # 数据访问层（Mapper）
│       │   ├── domain/                     # 实体对象
│       │   ├── dto/                        # 数据传输对象
│       │   └── utils/                      # 工具类（JWT、拦截器注解等）
│       └── resources/
│           ├── application.properties      # 配置文件
│           ├── mybatis-config.xml          # MyBatis 配置
│           └── mapper/                     # MyBatis XML 映射文件
├── StudentManagerSystemApi - eclipse/      # 后端项目（Eclipse 版，内容同上）
└── StudentManagerSystemVue/                # 前端项目
    ├── package.json                        # npm 依赖配置
    ├── config/
    │   └── index.js                        # Webpack 配置（端口、代理等）
    ├── build/                              # Webpack 构建脚本
    └── src/
        ├── main.js                         # 入口文件
        ├── App.vue                         # 根组件
        ├── router/                         # 路由配置及守卫
        ├── vuex/                           # 状态管理
        ├── axios/                          # Axios 封装（拦截器、Token 管理）
        ├── components/                     # 页面组件
        │   ├── login/                      # 登录页
        │   ├── home.vue                    # 主框架（Header + Sidebar + Tabs）
        │   ├── dashboard/                  # 首页仪表盘（管理员/教师/学生）
        │   ├── score/                      # 成绩查询与录入
        │   ├── analysis/                   # 成绩可视化分析
        │   ├── timetable/                  # 课程表
        │   ├── course/                     # 课程管理
        │   ├── student/                    # 学生用户管理
        │   ├── teacher/                    # 教师用户管理
        │   ├── admin/                      # 管理员用户管理
        │   ├── account/                    # 教师-课程分配管理
        │   ├── common/                     # 通用组件（Header/Aside/Tabs/404）
        │   └── base/                       # 基础表格组件
        └── assets/                         # 静态资源
```

## 数据库设计

数据库 `student_manager_system` 包含以下核心表：

| 表名 | 说明 | 主要字段 |
|------|------|----------|
| `admin` | 管理员表 | id, username, password, real_name, level, school, email, phone, sex |
| `student` | 学生表 | id(学号), username, password, real_name, school, profession, grade, email, phone, sex |
| `teacher` | 教师表 | id, username, password, real_name, school, email, phone, sex |
| `course` | 课程表 | id, name, credits(学分), score(满分), number(课时), year, term, type(必修/选修), profession |
| `course_info` | 课程安排表 | id, course_id, start(开始周), end(结束周), room(教室), profession |
| `score` | 成绩表 | id, student_id, course_id, score(成绩), point(绩点) |
| `student_course` | 学生选课表 | id, student_id, course_id, name, score, point, credits, term, year |
| `profession` | 专业表 | id, name |
| `teacher_course` | 教师课程分配表 | id, teacher_id, course_id, profession, grade |
| `week_course` | 周课程表 | id, monday~sunday, profession, grade, year, term, week |
| `silent` | 系统静默表 | id, state |
| `upload` | 上传文件表 | id, user_id, level, url |

## 角色权限体系

系统采用三级角色权限控制，通过 `level` 字段区分：

| Level | 角色 | 权限范围 |
|-------|------|----------|
| 0 | 管理员 | 全部功能：用户管理、课程管理、成绩录入导出、课程表编排、教师课程分配、系统设置 |
| 1 | 教师 | 成绩查询与录入（管辖班级）、课程表查看、成绩可视化分析 |
| 2 | 学生 | 个人主页、成绩查询、课程表查看、个人成绩可视化分析 |

## 功能模块

### 1. 登录与认证
- 基于 JWT Token 的身份认证，支持 Token 自动刷新
- 自定义 `@UserLoginToken` / `@PassToken` 注解实现接口级权限控制
- 前端路由守卫控制页面访问权限，未登录自动跳转登录页

### 2. 用户管理（管理员）
- **管理员管理**: 新增、编辑、删除、批量删除管理员账户
- **学生管理**: 新增、编辑、删除、批量删除学生账户，支持按学号/姓名搜索
- **教师管理**: 新增、编辑、删除、批量删除教师账户
- 所有用户支持头像上传、密码修改

### 3. 课程管理（管理员）
- 录入课程信息：课程名、学分、满分、课时、学年、学期、必修/选修、适用专业
- 支持按专业、学期等条件组合查询
- 编辑和删除课程

### 4. 成绩管理（核心模块）
- **分页查询**: 按班级、课程、学期等条件筛选查询成绩
- **批量录入/编辑**: 支持批量录入和修改学生成绩
- **等级统计**: 按不及格、及格、优秀等区间统计人数
- **Excel导出**: 将成绩数据导出为 Excel 文件
- **绩点计算**: 自动查询学生总学分和总绩点

### 5. 数据可视化分析
- **学生端**: 饼图展示各科成绩分布，折线图展示历次成绩趋势
- **教师端**: 按所管班级查看成绩统计分析图表
- **管理端**: 全局成绩数据统计分析

### 6. 课程表管理
- **管理员**: 编排课程表，设置每周课程、上课周次、教室、适用专业班级
- **教师**: 查看个人课程安排
- **学生**: 查看班级课程表

### 7. 教师课程分配
- 管理员为教师分配所管理的专业、班级、课程
- 教师登录后可查看管辖班级的学生并录入成绩

### 8. 系统设置
- **默哀模式**: 一键开启/关闭，开启后系统界面全局置灰

## 快速开始

### 环境要求

| 环境 | 版本要求 |
|------|----------|
| JDK | 1.8+ |
| Maven | 3.x |
| MySQL | 8.0+ |
| Node.js | >= 6.0.0（推荐 16.13.2） |
| npm | >= 3.0.0 |

### 第一步：初始化数据库

1. 使用 Navicat 或命令行创建数据库：
   ```sql
   CREATE DATABASE `student_manager_system` DEFAULT CHARACTER SET utf8;
   ```

2. 导入 `sql/student_manager_system.sql` 脚本到该数据库。

### 第二步：启动后端服务

**方式一：命令行运行（推荐）**

```bash
# 进入后端项目目录（以 IDEA 版为例）
cd StudentManagerSystemApi - idea

# 使用 Maven 编译打包
mvn clean package -DskipTests

# 运行
java -jar target/StudentManagerSystemApi-0.0.1-SNAPSHOT.jar
```

**方式二：IDE 运行**

用 IntelliJ IDEA 或 Eclipse 打开对应版本的后端项目，运行 `StudentMisApplication.java` 主类。

> 后端默认端口：**9121**
>
> 如需修改数据库连接，编辑 `src/main/resources/application.properties` 中的 `jdbc.url`、`jdbc.username`、`jdbc.password`。

### 第三步：启动前端服务

```bash
# 进入前端项目目录
cd StudentManagerSystemVue

# 切换淘宝镜像源（加速依赖下载）
npm config set registry https://registry.npm.taobao.org

# 安装依赖
npm install

# 启动开发服务器
npm run dev
```

> 前端默认端口：**9122**
>
> 浏览器访问：`http://localhost:9122`
>
> 开发模式下前端通过 Webpack 代理将 `/api` 请求转发到后端 `http://localhost:9121/`（配置见 `config/index.js` 中的 `proxyTable`）。

### 生产构建

```bash
cd StudentManagerSystemVue

# 构建生产包
npm run build

# 构建产物输出到 dist/ 目录
# 可将 dist/ 部署到 Nginx 或 Spring Boot 的 static 目录
```

## 默认账号

| 角色 | 用户名 | 密码 | 说明 |
|------|--------|------|------|
| 管理员 | root | password | 可访问全部功能 |
| 学生 | — | 123456 | 学生账号默认密码 |

> 数据库中预置了北京大学的演示数据，包含多个专业、班级和课程。

## 默认账号

| 角色 | 用户名 | 密码 |
|------|--------|------|
| 超级管理员 | root | password |
| 学生 | 各学号（详见数据库） | 123456 |

## API 接口概览

| 模块 | 基路径 | 主要接口 |
|------|--------|----------|
| 用户认证 | `/api/sms/user` | 登录、修改密码、获取权限树、默哀模式 |
| 管理员管理 | `/api/sms/user/admin` | CRUD、分页查询 |
| 学生管理 | `/api/sms/user/student` | CRUD、分页查询 |
| 教师管理 | `/api/sms/user/teacher` | CRUD、分页查询 |
| 课程管理 | `/api/sms/course` | CRUD、分页查询、按条件查询 |
| 成绩管理 | `/api/sms/score` | 分页查询、批量录入、Excel导出、统计 |
| 课程表管理 | `/api/sms/timetable` | 编排、查询（管理员/学生/教师） |
| 教师课程 | `/api/sms/teacher/course` | 分配、查询 |
| 专业管理 | `/api/sms/profession` | 获取专业列表 |
| 文件上传 | `/api/sms/upload` | 头像上传/获取 |

## 目标人群

- **高校教务管理员**：日常管理用户、课程、排课，统筹全局成绩数据
- **教师/辅导员**：对所带班级学生进行成绩录入与查询，关注班级学业情况
- **在校学生**：查询个人成绩、查看课程表、通过可视化图表分析自身学业表现
