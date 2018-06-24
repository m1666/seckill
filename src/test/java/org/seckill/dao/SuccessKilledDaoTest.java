package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Create bu M on 2018/6/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao ;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000L;
        Long phone = 13177881999L ;
        int insertCount = successKilledDao.insertSuccessKilled(id,phone);
        System.out.println("*****" + insertCount);
        /**
         * ++++SuccessKilled{seckillId=1000, userPhone=13177881999, state=-1, createTime=Tue Jun 05 05:09:12 CST 2018}
         * -----Seckill{seckillId=1000, name='1000元秒杀iPhone6', number=100, startTime=Sat Nov 11 08:00:00 CST 2017, endTime=Sun Nov 12 08:00:00 CST 2017, createTime=Mon Jun 04 01:02:44 CST 2018}
         * 21:14:00.895 [Thread-1] INFO com.alibaba.druid.pool.DruidDataSource - {dataSource-1} closed
         */
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000L;
        Long phone = 13177881999L ;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,phone);
        System.out.println("++++" + successKilled);
        System.out.println("-----" + successKilled.getSeckill());
    }
}