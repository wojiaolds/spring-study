package com.lds.dyn.importSelector.annotation;

import com.lds.dyn.importSelector.config.SpringStudySelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: lds
 * @Date: 2019/7/16 14:17
 */
@Retention ( RetentionPolicy.RUNTIME)
@Documented
@Target ( ElementType.TYPE)
@Import (SpringStudySelector.class)
public @interface EnableSpringStudy {
}
