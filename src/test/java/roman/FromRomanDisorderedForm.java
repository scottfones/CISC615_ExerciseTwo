package roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FromRomanDisorderedForm {
    private RomanConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = { "IIIIIV", "VX", "LC", "DM", "VL", "XD", "IM" })
    public void testFromRomanInvalidForm(String invNumeral) {
        assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(invNumeral));
    }
}
