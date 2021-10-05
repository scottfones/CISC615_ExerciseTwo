package roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToRomanInvalid {
    private RomanConverter converter;

    @BeforeEach
    public void setUp() {
        converter = TestImplValue.getImplValue();
    }

   @ParameterizedTest
    @ValueSource(ints = { 0, 4000 })
    public void testToRomanInvalid(int intVal) {
        assertThrows(IllegalArgumentException.class, () -> converter.toRoman(intVal));
    }
}
