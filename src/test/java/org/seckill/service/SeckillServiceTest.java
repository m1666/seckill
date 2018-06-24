package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by M on 2018/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

    @Autowired
    private SeckillService seckillService ;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() {
        long id = 1000 ;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testexportSeckillUrl() {
        long id = 1000 ;
        Exposer exposer = seckillService.exportSeckillUrl(id) ;
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeSeckill() {
        long id = 1000 ;
        long phone = 18742423451L ;
        String md5 = "d020a2ccf129e195f6930792a4f7a81d" ;
       try {
             SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
             logger.info("eresult={}",execution);
       } catch (RepeatKillException e){
           logger.error(e.getMessage()) ;
       } catch (SeckillCloseException e) {
           logger.error(e.getMessage()) ;
       }
    }

    // 测试代码完整逻辑，注意可重复执行
    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1000 ;
        Exposer exposer = seckillService.exportSeckillUrl(id) ;
        if (exposer.isExposed()) {
            logger.info("exposer={}",exposer);
            long phone = 18742423451L ;
            String md5 = exposer.getMd5() ;
            try {
                SeckillExecution execution = seckillService.executeSeckill(id,phone,md5);
                logger.info("eresult={}",execution);
            } catch (RepeatKillException e){
                logger.error(e.getMessage()) ;
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage()) ;
            }
        } else {
            // 秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1000 ;
        long phone = 13177321967L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId) ;
        System.out.println("***********************************" + exposer.getMd5());
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5() ;
            SeckillExecution execution = seckillService.executeSeckillProcedure(seckillId,phone,md5) ;
            logger.info(execution.getStateInfo());
         }
    }
}