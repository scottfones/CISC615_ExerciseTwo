package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FromRomanUnitsValidation {
    private RomanConverter converter;

    static String[] numeralOnes = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static String[] numeralTens = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    static String[] numeralHunds = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    static String[] numeralThous = { "M", "MM", "MMM" };

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @Test
    public void testFromRomanUnits() {
        for (int i = 0; i < 9; i++) {
            assertEquals(i + 1, converter.fromRoman(numeralOnes[i]));
            assertEquals(10 * (i + 1), converter.fromRoman(numeralTens[i]));
            assertEquals(100 * (i + 1), converter.fromRoman(numeralHunds[i]));

            if (i < 3) {
                assertEquals(1000 * (i + 1), converter.fromRoman(numeralThous[i]));
            }
        }
    }
}
