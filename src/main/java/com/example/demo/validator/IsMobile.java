package com.example.demo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = IsMobileValidator.class)
public @interface IsMobile {
    boolean require() default true;
    String message() default "手机号码格式不正确";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
