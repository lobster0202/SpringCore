package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/* 스프링 aop는 서블릿의 필터랑 비슷한 느낌이다*/
@Aspect
@Component
public class LoggingAspect {
    /* @Pointcut : 여러 조인 포인트를 매치하기 위해 지정한 표현식 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void LogPointcut() {
    }

    /* JoinPoint : 포인트컷으로 패치한 실행 시점
     *  이렇게 매치된 조인포인트에서 해야 할 일이 어드바이스이다.
     *  매개변수로 전달한 JoinPoint 객체는 현재 조인 포인트의 메소드명,
     *  인수값 등의 자세한 정보를 엑세스 할 수 있다.                   */

    @Before("LoggingAspect.LogPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    /* 포인트 컷을 동일한 클래스 내에서 사용하는 것이면 클래스명은 생략 가능하다.
     *  단, 패키지가 다르면 패키지를 포함한 클래스명을 기술해야 한다. */
    @After("LogPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    /* returning의 값이랑 매개변수의 Object 값이랑 같아야 한다. */
    @AfterReturning(pointcut="LogPointcut()", returning="result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result " + result);
        /* 리턴할 결과값을 변경해 줄 수 도 있다. */
        if(result != null && result instanceof Map) {
            ((Map<Long , MemberDTO>) result).put(100L, new MemberDTO(100L, "반환 값 가공"));
        }
    }

    /* throwing 속성의 이름과 매개변수의 이름이 동일해야한다. */
    @AfterThrowing(pointcut = "LogPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {
        System.out.println("After Throwing exception" + exception);
    }

    /* Around는 굉장히 강력한 애다. 다른 애들은 joinPoint만 노린다면 얘는 전부다를 노린다.
    *  얘를 써서 안에 있는거 까지 건드려서 문제가 일어날 수 있으니 안쓰는게 제일 낫다        */
    @Around("LogPointcut()")
    /* 어떤 타입이 올지 몰라서 Object로 한다. */
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Before" + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 실행한다. */
        Object result = joinPoint.proceed();
        System.out.println("Around After" + joinPoint.getSignature().getName());
        /* 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환한다. */

        return result;
    }

}
