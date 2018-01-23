package com.zoro.mail;

import com.github.pagehelper.PageHelper;
import com.zoro.mail.entity.MstDict;
import com.zoro.mail.mapper.MstDictMapper;
import com.zoro.mail.service.MstDictService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	@Autowired
	private MstDictMapper mstDictMapper;

	@Test
	public void test1() throws Exception {
//        MstDict mstDict1 = null;
//        RowBounds rowBounds = new RowBounds(1,2);
//       List<MstDict> list = mstDictMapper.selectByRowBounds(mstDict1,rowBounds);
        PageHelper.startPage(1,2);
        List<MstDict> list = mstDictMapper.selectAll();
        for(MstDict mstDict : list) {
            System.out.println(mstDict.getName());
        }
    }

    @Autowired
    private MstDictService mstDictService;

    @Test
    public void test2() {
        List<MstDict> list = mstDictService.findByStatus("9");
        for(MstDict mstDict : list) {
            System.out.println("name=" + mstDict.getName());
        }
    }
}
