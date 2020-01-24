# RBAC-数据库设计

## 表分析

![](/Users/buluke/Desktop/7.png)





## 用户表 部门表

* Sys_Dept  (系统级别的Dept表)

| 属性名       | 类型    | 备注                                     |
| :----------- | ------- | ---------------------------------------- |
| id           | Integer | 唯一编号                                 |
| name         | String  | 部门名称                                 |
| level        | String  | 部门等级（比如1级，2级，3级）（最多3级） |
| seq          | Integer | 排序序列                                 |
| remark       | String  | 备注信息                                 |
| parentId     | Integer | 父部门唯一编号                           |
| operator     | String  | 操作者                                   |
| operatorTime | Date    | 操作时间                                 |
| operatorIp   | String  | 操作者IP                                 |



## 用户表

* Sys_User  (系统级别的User表)

  | 属性         | 类型    | 备注                        |
  | ------------ | ------- | --------------------------- |
  | id           | Integer | 用户唯一编号                |
  | username     | String  | 用户名                      |
  | telephone    | String  | 用户手机号码                |
  | mail         | String  | 用户邮箱                    |
  | password     | String  | 用户密码                    |
  | remark       | String  | 用户备注                    |
  | deptId       | Integer | 部门唯一编号                |
  | status       | Integer | 用户当前状态(0:冻结 1:正常) |
  | operator     | String  | 操作者                      |
  | operatorTime | Date    | 操作时间                    |
  | operateIp    | String  | 操作Ip                      |

## 权限表，权限模块表

* SysAclModule （权限模块表）

  | 属性        | 类型    | 备注                                 |
  | ----------- | ------- | ------------------------------------ |
  | id          | Integer | 权限模块唯一编号                     |
  | name        | String  | 权限模块名称                         |
  | parentId    | Integer | 父权限模块唯一编号                   |
  | level       | String  | 权限模块级别                         |
  | status      | Integer | 权限模块状态（0:冻结，1:正常）       |
  | seq         | Integer | 权限模块在当前层级下的顺序，由小到大 |
  | remark      | String  | 备注                                 |
  | operator    | String  | 操作者                               |
  | operateTime | Date    | 操作时间                             |
  | operateIp   | String  | 操作者IP                             |

## 权限表

* SysAcl

  | 属性        | 类型    | 备注                                  |
  | ----------- | ------- | ------------------------------------- |
  | id          | Integer | 权限唯一编号                          |
  | code        | String  | 权限编码                              |
  | name        | String  | 权限名称                              |
  | aclmodule   | Integer | 权限模块编号                          |
  | url         | String  | 权限将要处理的url（可以填正则表达式） |
  | type        | Integer | 类型（按钮，菜单，其他（eg页面））    |
  | status      | Integer | 状态（0:冻结，1:启用）                |
  | seq         | Integer | 权限在当前模块下排序，从小到大        |
  | remark      | String  | 备注                                  |
  | operator    | String  | 操作者                                |
  | operateTime | Date    | 操作时间                              |
  | operateIp   | String  | 操作者IP                              |

  



##角色表

* SysRole

  | 属性        | 类型    | 备注                       |
  | ----------- | ------- | -------------------------- |
  | id          | Integer | 角色唯一编号               |
  | name        | String  | 角色名称                   |
  | type        | Integer | 角色类型                   |
  | status      | Integer | 角色状态（0:冻结；1:启用） |
  | remark      | String  | 备注                       |
  | operator    | String  | 操作者                     |
  | operateTime | Date    | 操作时间                   |
  | operateIp   | String  | 操作者IP                   |

  ## 角色用户关联表

  

* sys_roleuser

  | 属性        | 类型    | 备注         |
  | ----------- | ------- | ------------ |
  | id          | Integer | 记录唯一编号 |
  | roleId      | Integer | 角色唯一编号 |
  | userId      | Integer | 用户唯一编号 |
  | operator    | Integer | 操作者id     |
  | operateTime | Date    | 操作时间     |
  | operateIp   | String  | 操作者ip     |

  ## 角色权限关联表

* sys_roleacl

  | 属性        | 类型    | 备注         |
  | ----------- | ------- | ------------ |
  | id          | Integer | 记录唯一编号 |
  | roleid      | Integer | 角色唯一编号 |
  | aclid       | Integer | 权限唯一编号 |
  | operator    | String  | 操作者id     |
  | operateTime | Date    | 操作时间     |
  | operateIp   | String  | 操作者ip     |

  

##权限相关Log表

* SysAclLog

  | 属性        | 类型    | 备注                                                         |
  | ----------- | ------- | ------------------------------------------------------------ |
  | id          | Integer | 记录id                                                       |
  | type        | Integer | 7张表中的具体某一张（1：部门，2：用户，3：权限模块，4：权限，5：角色，6：角色用户关系，7：角色权限关系） |
  | targetId    | Integer | 基于type确定的具体表，具体的记录id【比如 user表中第3条记录】（type =2 targetid = 3） |
  | oldValue    | String  | 旧值                                                         |
  | newValue    | String  | 新值                                                         |
  | operator    | String  | 操作者id                                                     |
  | operateTime | Date    | 操作时间                                                     |
  | operateIp   | String  | 操作者ip                                                     |

  