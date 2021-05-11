# 工程简介

## 技术栈
## 遇到的坑
#### 21-05-11
1. `MybatisPlus`的乐观锁使用条件, 应该先使用selectById, 在更新才会触发乐观锁
> TODO: 后面深究理论


## 完成过程
#### 21-05-11
实现乐观锁控制导师指导学生数量, 避免老师指导学生数大于初始化值
> 思考: 添加乐观锁后, 同一时间大量线程失败的概率比较大, 对用户不太友好, 通过Jmeter测试, 每10个线程大概只有1-2
>个可以选择成功

#### 21-05-10
学生选导师功能设计开发(类似秒杀性质)
##### 1. 数据库表设计

teacher: count

student-teacher: id, sid, tid

关系: 一个学生只能选择一个导师, 一个导师可以带指定count的学生

##### 2. Restful 风格API设计
- 查看教师带的学生数量: GET /api/common/{teacherId}/count
- 教师查看选择自己的学生: GET /api/teacher/graduation/students
- 学生查看自己选择的教师: GET /api/common/graduation/teacher
- 学生选择教师: POST: /api/common/graduation/teacher
- 初始化教师所带的学生数: /api/admin/init/teacher/count

#### 3. 
#### 21-05-09
完成系统大部分简单的CRUD功能
## 思考
#### TODO(21-5-09)
1. 生产环境下数据库或者敏感数据的配置
2. 生产环境下将swagger去除
3. 登陆的token 永远不会过期
4. 完成秒杀子系统: 学生选择导师
5. 通过Github/Docker 部署
6. 通过redis/caffine 缓存优化系统前端展示页面


