# Tlias 智能学习辅助系统 (后端)

本项目是面向企业培训场景的后端管理系统，支持部门架构、员工信息等核心业务的维护与管理。

## 项目背景与目的
本项目基于实战课程，通过实践企业级 Java 后端开发流程，将 Spring Boot、MyBatis 等技术栈串联应用，并整理为求职简历中的核心项目，用于展示后端开发能力与问题解决思路。

## 主要技术栈
- **核心框架**：Spring Boot
- **数据持久层**：MyBatis（结合 XML 与注解两种方式）
- **数据库**：MySQL
- **版本控制**：Git + GitHub
- **项目构建**：Maven
- **辅助工具**：Lombok、PageHelper、Knife4j、Apifox（接口调试与文档管理）

## 我的核心职责与功能实现
*   **部门管理模块**：实现部门信息的增删改查。**核心逻辑**：在删除部门前，会先校验该部门下是否仍有未离职的员工，如有则提示“该部门存在员工，无法删除”，保证数据的完整性。
*   **员工管理模块**：实现员工信息的增删改查，基于 `PageHelper` 插件完成**分页查询**，并利用 MyBatis 动态 SQL 实现多条件筛选，提升了列表查询的灵活度。
*   **统一响应与异常处理**：封装 `Result` 类，结合 `@RestControllerAdvice` 实现全局异常拦截，**解决了前后端联调时数据结构不统一、排查问题困难**的痛点，提升了接口健壮性。
*   **接口文档与测试**：通过 `Knife4j` 生成在线接口文档，并使用 `Apifox` 进行接口调试与协同，完善了开发流程。
*   **文件上传**：集成阿里云 OSS SDK，实现用户头像等文件的云端存储与访问。

## 如何运行项目
1.  **准备环境**：确保已安装 JDK 17、Maven 和 MySQL。
2.  **导入项目**：使用 IDEA 导入该 Maven 项目。
3.  **创建数据库**：在你的 MySQL 中创建一个名为 `tlias` 的数据库。
4.  **配置数据库**：在 `application.yml` 中，修改 `spring.datasource.username` 和 `spring.datasource.password`。
5.  **启动项目**：运行 `TliasWebManagementApplication` 主类。
6.  **访问接口**：启动后，可通过 `http://localhost:8080/depts` 等路径访问，也可通过 Knife4j 文档页面查看所有接口。

## 项目截图
<img width="1576" height="983" alt="屏幕截图 2026-09-07 134722" src="https://github.com/user-attachments/assets/12ee297b-e8b7-467c-972a-d52b30969afa" />



## 个人收获
*   从头构建项目，理解了 Spring Boot 自动配置原理与 MVC 分层架构的核心思想。
*   掌握了 MyBatis 的 XML 和注解两种映射方式，能编写复杂的动态 SQL。
*   实践了 Git 的日常开发流程，如 `add`、`commit`、`push` 等操作。
*   学会了通过全局异常处理和统一响应结构来提升 API 的规范性与可维护性。
