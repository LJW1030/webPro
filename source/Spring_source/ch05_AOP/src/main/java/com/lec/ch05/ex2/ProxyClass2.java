package com.lec.ch05.ex2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class ProxyClass2 {
	// around Advice : 핵심기능 전후로 공통기능 수행
//	@Pointcut("within(com.lec.ch05.ex2.*)")
//	private void aroundM() {}
//	@Around("aroundM()")
	@Around("within(com.lec.ch05.ex2.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★★");
		String signatureName = joinPoint.getSignature().toString(); // 핵심기능 메소드명
		System.out.println(signatureName + "가 시작되었습니다");
		long startTime = System.currentTimeMillis(); // 시작시점
		try {
			Object obj = joinPoint.proceed(); // 핵심기능 실행
			return obj;
		} finally { // 핵심기능 이후에 실행
			long endTime = System.currentTimeMillis(); // 핵심기능 수행 후 시점
			System.out.println(signatureName + "가 수행되는 경과 시간 : " + (endTime-startTime));
		} 
	}
	@Before("execution(* com.lec.ch05.ex2.Student2.*())")
	// before Advice
	public void beforeAdvice() {
		System.out.println("핵심기능 수헁하기 전 알아서 beforeAdvice(공통기능) 수행");
	}
	// after Advice
	@After("bean(stud*)")
	public void afterAdvice() {
		System.out.println("핵심기능 수헁하고 알아서 afterAdvice(공통기능) 수행");
	}
	// after-returning Advice
	@AfterReturning("within(com.lec.ch05.ex2.Worker2)")
	public void afterReturningAdvice() {
		System.out.println("정상적으로(예외x) 핵심기능 수헁된 후 afterReturningAdvice 수행");
	}
	// after-throwing Advice
	@AfterThrowing("execution(void com.lec.ch05.ex2.Worker2.get*())")
	public void afterThrowingAdvice() {
		System.out.println("예외가 발생된 핵심기능이 수행된 후 이 afterThrowingAdvice 수행");
	}
}
