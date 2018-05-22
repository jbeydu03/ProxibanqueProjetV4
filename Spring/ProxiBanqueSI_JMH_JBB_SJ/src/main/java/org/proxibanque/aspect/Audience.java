package org.proxibanque.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.proxibanque.controller.WebServiceController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

	private static Logger LOGGER = LoggerFactory.getLogger(Audience.class);
	
	
	@Pointcut("execution(* org.proxibanque.service.ServiceClient.selectAllClient())") // Raccourci
	public void pointCutCalled() {
	}
	
//	@Before("execution(* org.proxibanque.service.ServiceClient.selectAllClient())") // ATTENTION LE getBEAN DOIT ETRE DU MEME TYPE (Interface)
//	public void beforeMethod() {
//		
//		System.out.println("---> beforeMethod() <---");
//	}
//	
	@AfterReturning("pointCutCalled()") // Après que la méthode se soit bien déroulée
	public void afterMethod() {
		
		LOGGER.warn("AOP");
	}
//	
//	@AfterThrowing("pointCutCalled()") // Après que la méthode ai levée une exception
//	public void exceptionMethod() {
//		
//		System.out.println("---> ExceptionMethod() <---");
//	}
	
//	@Around("pointCutCalled()") 
//	public void aroundMethod(ProceedingJoinPoint pjp) {
//		try {
//			
//			System.out.println("---> try - before pjp.proceed() - ExceptionMethod() <---");
//			pjp.proceed();  // Execute la methode sur laquelle on intervient
//			System.out.println("---> try - after pjp.proceed() - ExceptionMethod() <---");
//			
//		}catch(Throwable e){
//			System.out.println("---> catch - ExceptionMethod() <---");
//		}
//		
//		
//	}
}
	


