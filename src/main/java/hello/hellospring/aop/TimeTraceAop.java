package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint jointPoint) throws Throwable{
        Long start =  System.currentTimeMillis();

        System.out.println("START : " + jointPoint.toString());

        try{
            return jointPoint.proceed();
        } finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish - start;

            System.out.println("END : " + jointPoint.toString() + " " + timeMs + "ms");

        }
    }
}
