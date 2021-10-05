package roman_coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import roman.RomanConverter;
import roman.RomanConverterImpl;
import roman.RomanConverterImplA;
import roman.RomanConverterImplB;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToRomanInvalid {
    private RomanConverter converter;
    private RomanConverter converterA;
    private RomanConverter converterB;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
        converterA = new RomanConverterImplA();
        converterB = new RomanConverterImplB();
    }

   @ParameterizedTest
    @ValueSource(ints = { 0, 4000 })
    public void testToRomanInvalid(int intVal) {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(intVal));
        assertThrows(IllegalArgumentException.class, () -> converterA.toRoman(intVal));
        assertThrows(IllegalArgumentException.class, () -> converterB.toRoman(intVal));
    }
}
