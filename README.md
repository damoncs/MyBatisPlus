## MybatisPlus实战
为什么要用MybatisPlus？提高开发速度，让开发更简单化。
Mybatis-Generator普遍用于Mybatis的Mapper生成。但MybatisPlus更为强大。

1、代码生成（通用增删该查，Service层生成，提供批量插入、更新）

2、分页、多种主键策略，其它各种插件和功能（待实战）


好了，资料附上：[文档](http://mp.baomidou.com/#/install),[源码](https://github.com/baomidou/mybatis-plus),[实战项目](http://git.oschina.net/juapk/SpringWind)
### 一、本实战说明
MybatisPlus提供了对Mybatis的使用进行封装，算是一个组件化的工具。本实战的目的在于记录使用过程，帮助自己在下次使用时的方便，同时希望能帮到正在使用Mybatis的人。
相信MyBatisPlus的使用可以很大程度提高使用Mybatis的效率。让开发变得简单高效，并且代码管理规范优美。

### 二、使用
1、mybatis-plugin是专门生成代码的子项目，在MpGenerator中修改相应的配置（有不明白的可以查看MybatisPlus的文档），执行main方法即可生成代码到target文件夹。

2、将生成的代码放到自己的项目下，类似xxxapp（controller可以按照项目组织与dbService分离到不同的Moudle）

### 三、MyBatisPlus与Generator的比较
目前大家基本都在使用某些插件工具来实现Mybatis相关的代码生成，及其一些功能的支持（分页、主键策略、分表、多数据源、读写分离），但我还是想找个最为方便，最为高效的一个工具，让开发变得快速。
而

1、MybatisPlus的通用增删改查不需要Mapper.xml文件。具体怎么实现的待研究。思想大致还是依据原先的xml实现动态代理类，继而实现Mapper接口，提供数据库操作的实现，而MybatisPlus改为另一种方式代替xml

2、MybatisPlus提供了实体包装器，用于处理sql拼接[使用方法](http://mp.baomidou.com/#/wrapper).不过个人角色不建议这样用，因为这样会让sql的拼接可能在service层出现

3、MybatisPlus使用velocity模板引擎生成各个层及Mapper文件。
。。。