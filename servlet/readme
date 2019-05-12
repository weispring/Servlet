metadata-complete="false" 默认的是 metadata-complete="true" 必须的修改掉
Servlet 3.0 的部署描述文件 web.xml 的顶层标签 <web-app> 有一个 metadata-complete 属性，该属性指定当前的部署描述文件是否是完全的。如果设置为 true，则容器在部署时将只依赖部署描述文件，忽略所有的注解（同时也会跳过 web-fragment.xml 的扫描，亦即禁用可插性支持，）；如果不配置该属性，或者将其设置为 false，则表示启用注解支持（和可插性支持）。
应用注解方便很多，不过现在都用集成spring等基本原始的servlet也不会多写了。