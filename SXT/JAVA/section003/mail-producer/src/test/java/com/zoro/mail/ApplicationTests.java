package com.zoro.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Resource(name="masterDataSource")
    private DataSource masterDataSource;

    @Resource(name="slaveDataSource")
    private DataSource slaveDataSource;


	@Test
	public void contextLoads() throws SQLException {
       Connection connection1 = masterDataSource.getConnection("root", "root");
       System.out.println("c1:" + connection1.getMetaData().getURL());
       Connection connection2 = slaveDataSource.getConnection("root", "root");
       System.out.println("c2:" + connection2.getMetaData().getURL());

	}

}
