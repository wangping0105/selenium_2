# 目录结构
- com.test.base 
 - 全局基本类（如数据库配置，数据库模型，文件配置读取等等）

- com.test.base 
 - 测试基本类

- com.test.page
 - page 类，写着所有的页面以及其逻辑代码 

- com.test.testcase
 - 测试用例类，编写各种测试用例

- com.test.util
 - 工具类

- log4j.propertise
 - 日志配置

- config
 - 项目个人配置

- locator 
 - page类所对应的元素定位位置

- test-data
 - 测试数据

- 一般情况下，开发人员只需要写 page + testcases + locator 等代码