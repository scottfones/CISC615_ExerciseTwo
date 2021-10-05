package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FromRomanInvalid {
    private RomanConverter converter;

    static String[] numeralOnes = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static String[] numeralTens = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    static String[] numeralHunds = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    static String[] numeralThous = { "M", "MM", "MMM" };

    @BeforeEach
    public void setUp() {
        converter = TestImplValue.getImplValue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "IIIIIV", "VX", "LC", "DM", "VL", "XD", "IM" })
    public void testFromRomanInvalidForm(String invNumeral) {
        assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(invNumeral));
    }

    @Test
    public void testFromRomanEmpty() {
        assertEquals(0, converter.fromRoman(""));
        //assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(""));
    }

    @Test
    public void testFromRomanInvalidDoubleUnits() {
        for (int i = 4; i < 9; i++) {
            String onesNum = numeralOnes[i] + numeralOnes[i];
            assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(onesNum));

            String tensNum = numeralTens[i] + numeralTens[i];
            assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(tensNum));

            String hundsNum = numeralHunds[i] + numeralHunds[i];
            assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(hundsNum));

        }
    }
}
