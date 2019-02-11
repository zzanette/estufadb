package com.projeto.estufadb.services.validations.annotations;

import com.projeto.estufadb.services.validations.validators.CpfCnpjValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = {CpfCnpjValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CpfCnpj {
    String message() default "CPF/CNPJ inválido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
