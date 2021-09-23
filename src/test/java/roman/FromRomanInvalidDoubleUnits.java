package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FromRomanInvalidDoubleUnits {
    private RomanConverter converter;

    static String[] numeralOnes = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static String[] numeralTens = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    static String[] numeralHunds = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    static String[] numeralThous = { "M", "MM", "MMM" };

    @BeforeEach
    public void setUp() {
        converter = TestImplValue.getImplValue();
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
