package niceblog.config;

import niceblog.domain.BlogPaper;
import niceblog.domain.BlogPaperInfo;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GeorgeDon on 2017/3/29.
 */
@Configuration
@MapperScan("niceblog.Dao")
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverclassname;

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverclassname);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("mapper/*.xml");
        sessionFactory.setMapperLocations(resources);
        List<Class<?>> alias = new ArrayList<Class<?>>();
        alias.add(BlogPaper.class);
        alias.add(BlogPaperInfo.class);
        sessionFactory.setTypeAliases(alias.toArray(new Class<?>[0]));
        return sessionFactory.getObject();
    }
}
