package org.seckill.exception;

/**
 * 秒杀相关业务异常
 * Create bu M on 2018/6/4
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
