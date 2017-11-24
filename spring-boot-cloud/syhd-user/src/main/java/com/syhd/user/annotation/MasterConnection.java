package com.syhd.user.annotation;

import java.lang.annotation.*;

/**
 * 
 * @author niuzhiwei 有此注解运行 主数据库操作
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface MasterConnection {

}
