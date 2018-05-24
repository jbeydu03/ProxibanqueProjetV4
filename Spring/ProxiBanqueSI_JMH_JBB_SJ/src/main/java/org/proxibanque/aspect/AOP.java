package org.proxibanque.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

	private static Logger LOGGER = LoggerFactory.getLogger(AOP.class);

	@Pointcut("execution(* org.proxibanque.service.ServiceOperation.faireVirement(..))") // Raccourci
	public void pointCutCalled() {
	}

	// @Before("execution(*
	// org.proxibanque.service.ServiceClient.selectAllClient())") // ATTENTION LE
	// getBEAN DOIT ETRE DU MEME TYPE (Interface)
	// public void beforeMethod() {
	//
	// System.out.println("---> beforeMethod() <---");
	// }
	//
	@AfterReturning("pointCutCalled()") // Après que la méthode se soit bien déroulée
	public void afterMethod() {

		LOGGER.warn("AOP");

//		final Object[] args = joinpoint.getArgs();
//		final StringBuffer sb = new StringBuffer();
//		sb.append(joinpoint.getSignature().toString());
//		sb.append(" avec les parametres : (");
//
//		for (int i = 0; i < args.length; i++) {
//			sb.append(args[i]);
//			if (i < args.length - 1) {
//				sb.append(", ");
//			}
//		}
//		sb.append(")");
//		LOGGER.info("Debut methode : " + sb);

	}
	//
	// @AfterThrowing("pointCutCalled()") // Après que la méthode ai levée une
	// exception
	// public void exceptionMethod() {
	//
	// System.out.println("---> ExceptionMethod() <---");
	// }

	// @Around("pointCutCalled()")
	// public void aroundMethod(ProceedingJoinPoint pjp) {
	// try {
	//
	// System.out.println("---> try - before pjp.proceed() - ExceptionMethod()
	// <---");
	// pjp.proceed(); // Execute la methode sur laquelle on intervient
	// System.out.println("---> try - after pjp.proceed() - ExceptionMethod()
	// <---");
	//
	// }catch(Throwable e){
	// System.out.println("---> catch - ExceptionMethod() <---");
	// }
	//
	//
	// }
}
