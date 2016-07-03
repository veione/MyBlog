##简介
这是一个本人的学习项目，所以会不断改进集成优秀的东西，但也有为了学习和分享强行融入进来的。
我会尽量注释完整方便大家一起交流学习。
大多数东西是基本使用，需要深入再根据需求自行了解。
###理想计划
	后面会加工作流activity(简单使用实现游客发表博客，管理员审核通过。强行使用啊- -)，项目较小还没想好怎么用MQ，或者kafka。
	后面可能会改成dubbo形式项目结合zoonkeeper。
##后端
* `框架`：Spring+SpringMvc+MyBatis 
* `项目构建工具`：Maven3.3+
* `连接池`：Druid，集成监控，访问MyBlog/druid
* `异常统一管理`：Spring4新特性，@ControllerAdvice，可以自动对不同的异常做不同处理，详情见exception包
* `缓存管理`：Spring集成Redis，需要安装Redis，并修改配置文件。现在是注解使用，不灵活。可以用util包下的工具类 
* `简洁代码`：lombok注解声明Bean，简化代码需要找到Jar包双击安装
* `Api查看`：集成Swagger， 访问MyBlog/api查看所有Api
* `项目管理`：github，可以使用Egit
* `MyBatis分页`：pageHelper 比较好的分页插件，作者另外一个Mapper自动CRUD也值得使用
* `基本CRUD`：mybatis-plus，基本的CRUD操作
* `全文检索`：lucene5+中文分词+高亮，注释完整
* `shiro`：权限管理。  还没开始用哦，等我看完开涛哥的博客
* `验证码`：kcaptcha 比较老的验证码生成工具了
* `Excel导出`：easypoi 开源中国下比较火的poi工具，方便快捷
 
##前端
* `基本布局`：Bootstrap
* `前台`：AngularJs+路由  `后台`：EasyUi
* `包加载`：requireJs按需引入包
* `jquey`：jquey2.x 
* `兼容html5`：html5shiv
* `表单验证`：bootstrapValidator
* `分页`：kkPager
* `编辑器`：UEditor或者kindEditor(等后面写到了再选)

##有问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件:tracy5546@sina.com
* QQ: 332309254

##感激
感谢以下的项目，排名不分先后

* [java1234](http://www.java1234.com/)  主要的代码参考者，本项目在其之上集成改进
* [pageHelper](https://github.com/pagehelper/Mybatis-PageHelper)  分页插件，拦截器。
* [mybatis-plus](http://git.oschina.net/juapk/mybatis-plus)  基本CRUD，简化使用。也带了分页拦截器。（本项目没有使用，习惯了上一个）
* [easypoi](http://git.oschina.net/jueyue/easypoi)  poi工具类，基本使用很简洁，结合SpringMvc。

##关于作者

```javascript
  var author = {
    name  : "陶宇",
    qq : 332309254
  }
```