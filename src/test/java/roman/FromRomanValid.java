package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FromRomanValid {
    private RomanConverter converter;
    private RomanConverter converterA;
    private RomanConverter converterB;

    static String[] numeralOnes = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    static String[] numeralTens = { "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    static String[] numeralHunds = { "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    static String[] numeralThous = { "M", "MM", "MMM" };

    public static int constructInt(int thous, int hunds, int tens, int ones) {
        return (thous + 1) * 1000 + (hunds + 1) * 100 + (tens + 1) * 10 + (ones + 1) * 1;
    }

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
        converterA = new RomanConverterImplA();
        converterB = new RomanConverterImplB();
    }

    @Test
    public void testFromRomanValidCombinations() {
        int intVal = 1000;
        String strVal = "";

        for (String thous : numeralThous) {
            if (intVal % 1000 == 0) {
                strVal = thous;

                assertEquals(intVal, converter.fromRoman(strVal));
                assertEquals(intVal, converterA.fromRoman(strVal));
                assertEquals(intVal, converterB.fromRoman(strVal));
                intVal += 100;
            }

            for (String hunds : numeralHunds) {
                if (intVal % 100 == 0) {
                    strVal = thous + hunds;

                    assertEquals(intVal, converter.fromRoman(strVal));
                    assertEquals(intVal, converterA.fromRoman(strVal));
                    assertEquals(intVal, converterB.fromRoman(strVal));
                    intVal += 10;
                }

                for (String tens : numeralTens) {
                    if (intVal % 10 == 0) {
                        strVal = thous + hunds + tens;

                        assertEquals(intVal, converter.fromRoman(strVal));
                        assertEquals(intVal, converterA.fromRoman(strVal));
                        assertEquals(intVal, converterB.fromRoman(strVal));
                        intVal += 1;
                    }

                    for (String ones : numeralOnes) {
                        strVal = thous + hunds + tens + ones;

                        assertEquals(intVal, converter.fromRoman(strVal));
                        assertEquals(intVal, converterA.fromRoman(strVal));
                        assertEquals(intVal, converterB.fromRoman(strVal));
                        intVal += 1;
                    }
                }
            }
        }
    }
}
