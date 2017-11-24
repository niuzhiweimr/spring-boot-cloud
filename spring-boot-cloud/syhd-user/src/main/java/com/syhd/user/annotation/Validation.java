package com.syhd.user.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author niuzhiwei
 *         <p>
 *         数据验证 此注解存在的局部变量都需进行数据(空值)验证
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validation {

}
