package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToRomanNull {
    private RomanConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @Test
    public void testFromRomanNull() {
        assertThrows(NullPointerException.class, () -> converter.fromRoman(null));
    }
}
