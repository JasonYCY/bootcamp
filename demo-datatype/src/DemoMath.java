public class DemoMath {
  public static void main(String[] args) {
    // operators
    int remainder = 10 % 3;
    System.out.println("remainder: " + remainder);

    // int + double
    double sum = 3 + 3.5;
    System.out.println("sum: " + sum);

    // Special Case: byte + short -> int
    byte b10 = 9;
    short s10 = 9;
    // short s20 = b10 + s10
    int i20 = b10 + s10;
    System.out.println("sum of byte and short: " + i20);

    // calculate average score
    int englishScore = 87;
    int mathScore = 72;
    int historyScore = 34;

    double averageScore =
        (double) (englishScore + mathScore + historyScore) / 3;

    System.out.println("averageScore: " + averageScore);

    // 0.1 + 0.2 = 0.30000000000000004 (Never use double variable for Math Operations -> use BigDecimal)
    System.out.println("0.1 + 0.2 = " + (0.1 + 0.2));


    // Overflow
    byte overflowByte = 127;
    overflowByte += 1;
    System.out.println("overflowByte: " + overflowByte);

    int i10 = 2_100_000_000;
    long l10 = i10 + 100_000_000L; // int + long -> long (no overflow)
    System.out.println("int + long -(auto cast int to long)-> long: " + l10);

    // cast char into int | cast int into char
    int a = 'a';
    System.out.println("cast char 'a' into int: " + a + "\n");

    System.out.println(
        "cast int (65620 - 65535) into char: " + (char) (65620 - 65535));
    System.out.println("cast int 65620 into char: " + (char) 65620);

    int zeroAsciiCode = '0';
    System.out.println("cast char '0' into int: " + zeroAsciiCode);
  }
}
