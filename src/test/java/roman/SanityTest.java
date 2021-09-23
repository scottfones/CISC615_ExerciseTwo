package roman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SanityTest {

    private RomanConverterImpl converter;

    @BeforeEach
    public void setUp() {
        converter = new RomanConverterImpl();
    }

    static Stream<Arguments> valueProvider() {
        return IntStream.range(1, 4000)
                .mapToObj(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(int arabic) {
        String numeral = converter.toRoman(arabic);
        int result = converter.fromRoman(numeral);
        assertEquals(arabic, result);
    }
}
