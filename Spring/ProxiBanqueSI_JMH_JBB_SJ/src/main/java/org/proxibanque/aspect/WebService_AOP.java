package org.proxibanque.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WebService_AOP {

	private static Logger LOGGER = LoggerFactory.getLogger(WebService_AOP.class);

	@Pointcut("within(org.proxibanque.controller.*)")
	public void pointCutCalled() {
	}

	@Before(value = "pointCutCalled()", argNames = "joinPoint")
	public void afterMethod(JoinPoint joinPoint) {

		LOGGER.warn("Method Called => " + joinPoint.getSignature().toShortString() + " | Input arguments => "
				+ Arrays.asList(joinPoint.getArgs()));

	}
}
