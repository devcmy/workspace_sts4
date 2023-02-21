package com.itwill.annotation.exe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  //type에서만 쓸수있게제한
public @interface Component {

}
