package aspects;

import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class);

    public void addAppender(){
        logger.addAppender(new WriterAppender());
    }

    @Before("execution (* dbService.*.*(..))")
    public void before(){
        logger.info("Before method...");
    }

    @After("execution (* dbService.*.*(..))")
    public void after(){
        logger.info("After method...");
    }

    public void afterReturning(){
        logger.info("After returning...");
    }
    public void afterThrowing(){
        logger.info("After throwing...");
    }

}