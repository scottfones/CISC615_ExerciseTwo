package roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToRomanInvalid {
    private RomanConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

   @ParameterizedTest
    @ValueSource(ints = { Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE })
    public void testToRomanInvalid(int intVal) {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(intVal));
    }
}
