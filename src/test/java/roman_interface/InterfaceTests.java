package roman_interface;

import roman.RomanConverter;
import roman.RomanConverterImpl;
import roman.RomanConverterImplA;
import roman.RomanConverterImplB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class InterfaceTests {
    private RomanConverter converter;
    private RomanConverter converterA;
    private RomanConverter converterB;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
        converterA = new RomanConverterImplA();
        converterB = new RomanConverterImplB();
    }

    @Test
    public void testFromRomanNull() {
        assertThrows(NullPointerException.class, () -> converter.fromRoman(null));
        assertThrows(NullPointerException.class, () -> converterA.fromRoman(null));
        assertThrows(NullPointerException.class, () -> converterB.fromRoman(null));
    }

    @Test
    public void testFromRomanEmpty() {
        assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(""));
        assertThrows(IllegalArgumentException.class, () -> converterA.fromRoman(""));
        assertThrows(IllegalArgumentException.class, () -> converterB.fromRoman(""));
    }

    @Test
    public void testFromRomanInvalidLengthThree() {
        String[] valArray = { "a", "A", "9", "-", " " };

        for (String s0 : valArray) {
            for (String s1 : valArray) {
                for (String s2 : valArray) {
                    String testStr = s0 + s1 + s2;
                    assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(testStr));
                    assertThrows(IllegalArgumentException.class, () -> converterA.fromRoman(testStr));
                    assertThrows(IllegalArgumentException.class, () -> converterB.fromRoman(testStr));
                }
            }
        }
    }

    @Test
    public void testToRomanValid() {
        assertNotNull(converter.toRoman(1));
        assertNotNull(converterA.toRoman(1));
        assertNotNull(converterB.toRoman(1));
    }

    @ParameterizedTest
    @ValueSource(ints = { Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE })
    public void testToRomanInvalid(int intVal) {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(intVal));
        assertThrows(IllegalArgumentException.class, () -> converterA.toRoman(intVal));
        assertThrows(IllegalArgumentException.class, () -> converterB.toRoman(intVal));
    }
}