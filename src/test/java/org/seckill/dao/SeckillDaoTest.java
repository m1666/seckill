package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create bu M on 2018/6/3
 */

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() {
        long id = 1000  ;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /**
         * Seckill{seckillId=1000, name='1000元秒杀iPhone6', number=100, startTime=Sat Nov 11 08:00:00 CST 2017, endTime=Sun Nov 12 08:00:00 CST 2017, createTime=Mon Jun 04 01:02:44 CST 2018}
         */
    }

    @Test
    public void queryAll() {
        // List<Seckill> queryAll(int offet, int limit)
        // java没有保存形参的记录：queryAll(int offet,int limit) -> queryAll(arg0,arg1)
        //
        List<Seckill> seckills = seckillDao.queryAll(0,100) ;
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
        /**
         * Seckill{seckillId=1000, name='1000元秒杀iPhone6', number=100, startTime=Sat Nov 11 08:00:00 CST 2017, endTime=Sun Nov 12 08:00:00 CST 2017, createTime=Mon Jun 04 01:02:44 CST 2018}
         * Seckill{seckillId=1001, name='600元秒杀iPad2', number=200, startTime=Sat Nov 11 08:00:00 CST 2017, endTime=Sun Nov 12 08:00:00 CST 2017, createTime=Mon Jun 04 01:02:44 CST 2018}
         * Seckill{seckillId=1002, name='300元秒杀小米note', number=300, startTime=Sat Nov 11 08:00:00 CST 2017, endTime=Sun Nov 12 08:00:00 CST 2017, createTime=Mon Jun 04 01:02:44 CST 2018}
         * Seckill{seckillId=1003, name='200元秒杀魅族note', number=400, startTime=Sat Nov 11 08:00:00 CST 2017, endTime=Sun Nov 12 08:00:00 CST 2017, createTime=Mon Jun 04 01:02:44 CST 2018}
         */
    }

    @Test
    public void reduceNumber() {
        Date killTime = new Date() ;
        int updateCount = seckillDao.reduceNumber(1000L,killTime);
        System.out.println(updateCount);
    }

}