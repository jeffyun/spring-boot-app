spring 的 schema扩展
1. 编写自定义Schema文件;  
META-INF/people.xsd
2. 编写自定义NamespaceHandler；  
PeopleNamespaceHandler
3. 编写解析BeanDefinition的parser
PeopleBeanDefinitionParser
4. 在Spring中注册上述组建  
spring.handlers  
spring.schemas

Applicaton 测试 Main

applicatin-bean.xml bean定义