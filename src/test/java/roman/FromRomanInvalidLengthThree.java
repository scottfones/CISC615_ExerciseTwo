package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FromRomanInvalidLengthThree {
    private RomanConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @Test
    public void testFromRomanInvalidLengthThree() {
        String[] valArray = { "a", "A", "9", "-", " " };

        for (String s0 : valArray) {
            for (String s1 : valArray) {
                for (String s2 : valArray) {
                    String testStr = s0 + s1 + s2;
                    assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(testStr));
                }
            }
        }
    }
}
