package com.springstarter.annotation_01;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Inherited
@Repeatable(CustomDescriptions.class) //表示该注解可多次使用
public @interface CustomDescription {
    String description() default "";
}
