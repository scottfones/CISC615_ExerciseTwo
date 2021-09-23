package roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToRomanInvalidInputTest {

    private RomanConverterImpl converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @Test
    public void testInputTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(4000));
    }

    @Test
    public void testInputTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(0));
    }

    @Test
    public void testInputNegative() {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(-1));
    }

}
