package roman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FromRomanEmpty {
    private RomanConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @Test
    public void testFromRomanEmpty() {
        assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(""));
    }
}
