package com.zaxxer.demo.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by meijunjie on 2019/6/4.
 */
public class Main {

   public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
      HikariConfig config = new HikariConfig();
      config.setDriverClassName("com.mysql.jdbc.Driver");
      config.setJdbcUrl("jdbc:mysql://localhost:3306/mango_example");
      config.setUsername("root");
      config.setPassword("123456");
      config.setMaximumPoolSize(10);
      config.setMinimumIdle(3);
      config.setIdleTimeout(250);
      HikariDataSource dataSource = new HikariDataSource(config);
      System.out.println(dataSource.toString());


      MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();

      // ----------------------------------------------------
      //
      mBeanServer.registerMBean(dataSource,new ObjectName("jmxBean:name=HikariCP DataSource"));

      Thread.sleep(Integer.MAX_VALUE);
   }
}
