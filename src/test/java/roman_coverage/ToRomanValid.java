package roman_coverage;

import org.junit.jupiter.api.Test;

import roman.RomanConverter;
import roman.RomanConverterImpl;
import roman.RomanConverterImplA;
import roman.RomanConverterImplB;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToRomanValid {
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
    public void testToRomanValid() {
        for (int thous = 0; thous < numeralThous.length; thous++) {
            for (int hunds = 0; hunds < numeralHunds.length; hunds++) {
                for (int tens = 0; tens < numeralTens.length; tens++) {
                    for (int ones = 0; ones < numeralOnes.length; ones++) {
                        int intVal = constructInt(thous, hunds, tens, ones);
                        String strVal = numeralThous[thous] + numeralHunds[hunds] + numeralTens[tens]
                                + numeralOnes[ones];

                        assertEquals(strVal, converter.toRoman(intVal));
                        assertEquals(strVal, converterA.toRoman(intVal));
                        assertEquals(strVal, converterB.toRoman(intVal));
                    }
                }
            }
        }
    }
}
