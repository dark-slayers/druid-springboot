# springboot使用Druid配置多数据源
1. 依赖：
`<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>druid-spring-boot-starter</artifactId>
 <version>${druid-version}</version>
</dependency>`
2. 配置文件
spring.datasource.druid.one.url=jdbc:mysql://localhost:3306/zzz_read?useSSL=true
spring.datasource.druid.two.url=jdbc:mysql://localhost:3306/zzz_wirte?useSSL=true
3. 配置类
主数据源的获取DataSource，EntityManagerFactory，PlatformTransactionManager的方法需要@Primary，否则一些自动配置的类会因为Bean重复无法注入导致失败
配置类的@EnableJpaRepositories注解中basePackages = "basePackages = "person.liuxx.druiddemo.dao.master""指向使用该数据源的dao类的包
EntityManagerFactory方法中LocalContainerEntityManagerFactoryBean需要指定使用该数据源的实体类所在的包
factory.setPackagesToScan("person.liuxx.druiddemo.domain.master");
