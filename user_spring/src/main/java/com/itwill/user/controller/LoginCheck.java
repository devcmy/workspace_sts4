package com.itwill.user.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface LoginCheck { //이 어노테이션을 flag it 하는것.잇으면 필터체크, 없으면 가던길가라~

}
