package org.seckill.exception;

/**
 * 秒杀关闭异常
 * Create bu M on 2018/6/4
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
