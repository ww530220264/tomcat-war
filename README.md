####BeanDefinition加载
* 使用SpringFactoriesLoader从META-INF/spring.factories文件中加载指定类型的配置类
* @Configuration: 可直接使用@Configuration注解,作为一个配置类被BeanFactory管理
* @Import: 也可以在启动类上使用@Import注解引入该类,在加载BeanDefinition时会将该类作为一个配置类进行BeanDefinition的加载
* @ImportBeanDefinitionRegistrar 或者使用@ImportBeanDefinitionRegistrar注解进行导入满足指定规则的BeanDefinition
* @ImportSelector 或者使用@ImportSelector进行导入
