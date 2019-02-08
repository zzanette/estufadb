package com.projeto.estufadb.domainTests;


import com.projeto.estufadb.domain.EspeciePlanta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EspeciePlantaTest {

    private Validator validator;

    @Before
    public void init() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public EspeciePlanta generateCompleteEspeciePlanta() {
        EspeciePlanta especiePlanta = new EspeciePlanta();
        especiePlanta.setId(new Long("1"));
        especiePlanta.setNome("Teste de nome");
        especiePlanta.setUmidadeMinima(new Float(45.66));
        especiePlanta.setUmidadeMaxima(new Float(55.66));
        especiePlanta.setImgUrl("http://defaultimage.com/avatar.png");

        return especiePlanta;
    }

    public Set<ConstraintViolation<EspeciePlanta>> getValidationEspeciePlanta(EspeciePlanta especiePlanta) {
        Set<ConstraintViolation<EspeciePlanta>> violations = validator.validate(especiePlanta);

        return violations;
    }

    @Test
    public void whenNomeIsNull_ThenNomeValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setNome(null);

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenNomeIsEmpty_ThenNomeValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setNome("");

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenNomeIsBlank_ThenNomeValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setNome("              ");

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenUmidadeMinimaIsNull_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setUmidadeMinima(null);

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenUmidadeMinimaLessThen0_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setUmidadeMinima(new Float(-1.55));

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenUmidadeMinimaGratherThen100_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setUmidadeMinima(new Float(101));

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenUmidadeMaximaIsNull_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setUmidadeMaxima(null);

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenUmidadeMaximaLessThen0_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setUmidadeMaxima(new Float(-1.55));

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenUmidadeMaximaGratherThen100_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setUmidadeMaxima(new Float(101));

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenImgUrlNotHasExtensionJPGOrGIFOrJPEGOrPNG_thenValidationFails() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();
        especiePlanta.setImgUrl("myFile.pdf");

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), false);
    }

    @Test
    public void whenEspeciePlantaHasCorrectData_thenValidationPass() {
        EspeciePlanta especiePlanta = generateCompleteEspeciePlanta();

        assertEquals(getValidationEspeciePlanta(especiePlanta).isEmpty(), true);
    }
}
