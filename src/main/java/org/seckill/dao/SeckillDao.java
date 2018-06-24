package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create bu M on 2018/6/2
 */
public  interface SeckillDao {

    /**
     * 减库存，
     * @param seckillId
     * @param killTime
     * @return
     */
    public abstract int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime) ;

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    public abstract Seckill queryById(long seckillId) ;

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offet
     * @param limit
     * @return
     */
    public abstract List<Seckill> queryAll(@Param("offset") int offet, @Param("limit") int limit) ;

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String,Object> paramMap) ;
}
