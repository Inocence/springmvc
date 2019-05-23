## SpringMVC的理解
### 流程
- tomcat将所有请求转交给DispatcherServlet(web.xml)，所以只有一个servlet对象
- DispatcherServlet根据url匹配，然后由Interceptor处理，在调用相应的Controller(springmvc-servlet.xml)

### JSP
- springmvc配置的viewResolver的jsp定位，只能页面跳转，直接访问jsp需要放置在web根目录

### 文件上传
- 需要指定multipartResolver
- 需要创建目录
- 需要配置资源文件的servlet，并放置在最前面

### 拦截器
- 拦截器与过滤不同，拦截器主要是用于处理业务逻辑
- preHandle在controller执行之前调用
    如果返回false：
        从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链；
    如果返回true：
        执行下一个拦截器,直到所有的拦截器都执行完毕，
        再执行被拦截的Controller ，然后进入拦截器链,
        从最后一个拦截器往回执行所有的postHandle()，
        接着再从最后一个拦截器往回执行所有的afterCompletion() 
- postHandle在controller调用之后，渲染视图之前执行
- afterCompletion在DispatcherServlet完全处理完请求后被调用,可用于清理资源等；
    当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 