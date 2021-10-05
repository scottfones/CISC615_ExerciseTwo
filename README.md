# CISC 650: Exercise Two - Code Coverage
[![Coverage](.github/badges/jacoco.svg)](https://github.com/scottfones/CISC615_ExerciseTwo/actions/workflows/gradle.yml)

## Test Criteria

We want to provide complete node and edge coverage for the provided `RomanConverter` implementation, `RomanConverterImpl`. To do so, we need to hit every line of code and follow every branch across an `enum`, `RomanSymbol`, a `Pattern`, `romanNumeralPattern`, and two methods, `fromRoman()` and `toRoman()`.

### `RomanSymbol`

We need to hit every element in a collection of values, call `RomanSymbol(int value)`, and call `RomanSymbol.value()`.

These cases can't be hit directly as the `enum` is `private`, so we need to rely on calls to `toRoman()` and `fromRoman()`.

### `romanNumeralPattern`

`romanNumeralPattern` is a `Pattern` used by `fromRoman()` and is itself `private`. Therefore, it should be covered through calls to `fromRoman()`.

### `toRoman()`

We need to hit two branches that check for invalid input.

| Invalid Input Condition | b1 | b2 |
|-------------------------|----|----|
| Value is <= 0           | T  | F  |
| Value is >= 4000        | T  | F  |

We need for the conditionals to be `True` to enter the branches, so we only need to test the `b1` blocks for each. Further, the cases within each conditional should be equivalent. Since we only need to test one value for each, it makes sense for those values to be at the boundary for valid values. Therefore, we need two tests and expect each instance to throw an `IllegalArgumentException`.

The remaining code constructs a Roman Numeral via the `RomanSymbol` `enum`. We want to create a test that exhausts the symbols enumerated in the `enum`. To ensure the `while` loop is covered, we need input values that are greater than the value of a given symbol. Therefore, we must test combinations of symbols.

To test `toRoman()` we need to create test suites for valid and invalid input. The invalid input suite should be comprised of two tests, one for each conditional. The valid input suite should test for combinations of valid Roman Numerals that cover the symbols in `RomanSymbol`.

### `fromRoman()`

We need to hit one branch that checks for invalid input. If the input is found not to match `romanNumeralPattern`, an `IllegalArgumentException` is thrown. Therefore, we need one test where the input does not match.

| Invalid Input Condition | b1 | b2 |
|-------------------------|----|----|
| Value matches pattern   | T  | F  |

The remaining code constructs a value from input. To test this we need valid Roman Numerals, and they should exhaust the values enumerated in `RomanSymbol` so that coverage of `RomanSymbol` is independent of the `toRoman()` tests.

To test `fromRoman()`, we need to create test suites for valid and invalid input. The invalid input test suite only requires one test, comprised of an anti-pattern to `romanNumeralPattern`. The valid input test suite requires combinations of valid Roman Numerals that cover the symbols in `RomanSymbol`.

## Test Results

### Interface Tests

| CLASS                            | INSTRUCTION_MISSED | INSTRUCTION_COVERED | BRANCH_MISSED | BRANCH_COVERED | LINE_MISSED | LINE_COVERED | METHOD_MISSED | METHOD_COVERED |
|----------------------------------|--------------------|---------------------|---------------|----------------|-------------|--------------|---------------|----------------|
| RomanConverterImplB.RomanNumeral | 0                  | 119                 | 0             | 0              | 0           | 8            | 0             | 5              |
| RomanConverterImplB              | 57                 | 47                  | 11            | 7              | 15          | 13           | 1             | 2              |
| RomanConverterImplA              | 21                 | 212                 | 8             | 16             | 9           | 27           | 0             | 4              |
| RomanConverterImpl               | 10                 | 126                 | 1             | 13             | 2           | 22           | 0             | 4              |
| RomanConverterImpl.RomanSymbol   | 0                  | 105                 | 0             | 0              | 0           | 18           | 0             | 3              |

### Functionality Tests

| CLASS                            | INSTRUCTION_MISSED | INSTRUCTION_COVERED | BRANCH_MISSED | BRANCH_COVERED | LINE_MISSED | LINE_COVERED | METHOD_MISSED | METHOD_COVERED |
|----------------------------------|--------------------|---------------------|---------------|----------------|-------------|--------------|---------------|----------------|
| RomanConverterImplB.RomanNumeral | 0                  | 119                 | 0             | 0              | 0           | 8            | 0             | 5              |
| RomanConverterImplB              | 12                 | 92                  | 5             | 13             | 2           | 26           | 0             | 3              |
| RomanConverterImplA              | 2                  | 231                 | 1             | 23             | 1           | 35           | 0             | 4              |
| RomanConverterImpl               | 0                  | 136                 | 0             | 14             | 0           | 24           | 0             | 4              |
| RomanConverterImpl.RomanSymbol   | 0                  | 105                 | 0             | 0              | 0           | 18           | 0             | 3              |

### Coverage Tests

| CLASS                            | INSTRUCTION_MISSED | INSTRUCTION_COVERED | BRANCH_MISSED | BRANCH_COVERED | LINE_MISSED | LINE_COVERED | METHOD_MISSED | METHOD_COVERED |
|----------------------------------|--------------------|---------------------|---------------|----------------|-------------|--------------|---------------|----------------|
| RomanConverterImplB.RomanNumeral | 0                  | 119                 | 0             | 0              | 0           | 8            | 0             | 5              |
| RomanConverterImplB              | 12                 | 92                  | 5             | 13             | 2           | 26           | 0             | 3              |
| RomanConverterImplA              | 2                  | 231                 | 1             | 23             | 1           | 35           | 0             | 4              |
| RomanConverterImpl               | 0                  | 136                 | 0             | 14             | 0           | 24           | 0             | 4              |
| RomanConverterImpl.RomanSymbol   | 0                  | 105                 | 0             | 0              | 0           | 18           | 0             | 3              |