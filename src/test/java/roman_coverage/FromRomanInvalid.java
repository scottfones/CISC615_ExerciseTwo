package roman_coverage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import roman.RomanConverter;
import roman.RomanConverterImpl;
import roman.RomanConverterImplA;
import roman.RomanConverterImplB;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FromRomanInvalid {
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
    @ValueSource(strings = { "IIIIIV", "VX", "LC", "DM", "VL", "XD", "IM" })
    public void testFromRomanInvalidForm(String invNumeral) {
        assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(invNumeral));
        assertThrows(IllegalArgumentException.class, () -> converterA.fromRoman(invNumeral));
        assertThrows(IllegalArgumentException.class, () -> converterB.fromRoman(invNumeral));
    }
}
