package com.projeto.estufadb.services.validations.validators;

import com.projeto.estufadb.services.validations.annotations.CpfCnpj;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj constraintAnnotation) {}

    @Override
    public boolean isValid(String cpfCnpj, ConstraintValidatorContext constraintValidatorContext) {
        return cpfCnpj == null || cpfCnpj.isEmpty() || isCPF(cpfCnpj) || isCNPJ(cpfCnpj);
    }

    private boolean isCPF(String cpf) {
        /*TODO: Implementar a validação de CPF aqui...*/
        return true;
    }

    private boolean isCNPJ(String cnpj) {
        /*TODO; Implementar a validação de CNPJ aqui...*/
        return true;
    }
}
