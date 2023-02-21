package com.itwill.annotation.exe;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ComponentMultiValue {
	String value() default ""; //안주면 default값 ""
	String[] names() default {};
	int count(); //괄호기입 필수
	boolean print() default false;
	
}
