package top.crazyman.quick.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import top.crazyman.quick.entities.Entities;
import top.crazyman.quick.enums.EnabledEnum;
import top.crazyman.quick.enums.EntitiesTypeEnum;

import javax.sql.DataSource;

/**
 * Description:
 *
 * @author <a href="liuguotao@zuozh.com">Guotao.Liu</a>
 * @date Create on 2018/5/10
 * @since version 1.0 Copyright 2018 ZZJR All Rights Reserved.
 */
@Configuration
@MapperScan("top.crazyman.quick")
public class Database {

    private final static String URL = "jdbc:mysql://127.0.0.1:3306/quick?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private final static String USER = "root";
    private final static String PASS = "lgt633744";


    @Bean
    DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(URL);
        druidDataSource.setUsername(USER);
        druidDataSource.setPassword(PASS);
        return druidDataSource;
    }

    @Bean
    DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        SqlSessionFactory sqlSessionFactory = sessionFactory.getObject();
        registerTypeHandler(sqlSessionFactory);
        return sqlSessionFactory;
    }

    private void registerTypeHandler(SqlSessionFactory sqlSessionFactory) {
        TypeHandlerRegistry registry = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry();
        registry.register(EntitiesTypeEnum.class, JdbcType.VARCHAR, EnumTypeHandler.class);
        registry.register(EnabledEnum.class, JdbcType.VARCHAR, EnumTypeHandler.class);
    }
}
