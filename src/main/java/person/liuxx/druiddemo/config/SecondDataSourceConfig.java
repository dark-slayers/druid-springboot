package person.liuxx.druiddemo.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @author 刘湘湘
 * @version 1.0.0<br>
 *          创建时间：2017年12月25日 上午9:57:21
 * @since 1.0.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "person.liuxx.druiddemo.dao.second",
        entityManagerFactoryRef = "entityManagerFactory2",
        transactionManagerRef = "transactionManager2")
public class SecondDataSourceConfig
{
    @Bean(name = "datasource2")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSource2()
    {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactory2")
    public EntityManagerFactory entityManagerFactory2()
    {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("person.liuxx.druiddemo.domain.second");
        factory.setDataSource(dataSource2());
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager2()
    {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory2());
        return txManager;
    }
}
