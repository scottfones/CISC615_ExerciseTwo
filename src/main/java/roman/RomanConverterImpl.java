package roman;

import java.util.regex.Pattern;

public class RomanConverterImpl implements RomanConverter {

    private enum RomanSymbol {

        M(1000),
        CM(900),
        D(500),
        CD(400),
        C(100),
        XC(90),
        L(50),
        XL(40),
        X(10),
        IX(9),
        V(5),
        IV(4),
        I(1);

        private final int value;

        RomanSymbol(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }

    }

    private static final Pattern romanNumeralPattern = Pattern
            .compile("^M?M?M?(CM|CD|D?C?C?C?)(XC|XL|L?X?X?X?)(IX|IV|V?I?I?I?)$");

    public String toRoman(int arabicNumber) {

        if (arabicNumber <= 0) {
            throw new IllegalArgumentException("invalid arabic number %d, must be >= 1".formatted(arabicNumber));
        }

        if (arabicNumber >= 4000) {
            throw new IllegalArgumentException("invalid arabic number %d, must be <= 3999".formatted(arabicNumber));
        }

        var romanNumeral = new StringBuilder();

        for (var symbol : RomanSymbol.values()) {
            while (arabicNumber >= symbol.value()) {
                romanNumeral.append(symbol.name());
                arabicNumber -= symbol.value();
            }
        }

        return romanNumeral.toString();
    }

    public int fromRoman(String romanNumeral) {

        if (!romanNumeralPattern.matcher(romanNumeral).matches()) {
            throw new IllegalArgumentException("invalid roman numeral: %s".formatted(romanNumeral));
        }

        var arabicNumber = 0;
        var index = 0;

        for (var symbol : RomanSymbol.values()) {
            var name = symbol.name();
            var value = symbol.value();
            while (romanNumeral.startsWith(name, index)) {
                arabicNumber += value;
                index += name.length();
            }
        }

        return arabicNumber;
    }
}
