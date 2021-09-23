package roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FromRomanMalformedAntecedent {

    private RomanConverterImpl converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"MMMM", "DD", "CCCC", "LL", "XXXX", "VV", "IIII"})
    public void test(String numeral) {
        assertThrows(IllegalArgumentException.class, () -> converter.fromRoman(numeral));
    }

}
