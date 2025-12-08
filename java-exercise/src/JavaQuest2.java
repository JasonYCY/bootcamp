import java.math.BigDecimal;

public class JavaQuest2 {
  public static void main(String[] args) {
    int a = 10;
    if (a == 9) {
      System.out.println("a is equals to 9");
    }
    // add condition to print "a is between 0 and 8"
    // how about a > 9?
    if (a >= 0 && a <= 8) {
      System.out.println("a is between 0 and 8");
    }
    if (a > 9) {
      System.out.println("a is larger than 9");
    }

    // Take a character and check whether it is:
    // 1. Vowel (a, e, i, o, u – both lowercase and uppercase)
    // 2. Consonant
    // 3. Not an alphabet
    char ch = 'i';
    boolean isVowel = Character.toString(ch).matches("[aeiouAEIOU]");
    boolean isConsonant = !isVowel;
    boolean isNotAlphabet = !((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
    System.out.println("The character is vowel: " + isVowel);
    System.out.println("The character is consonant: " + isConsonant);
    System.out.println("The character is not alphabet: " + isNotAlphabet);

    // Take salary and years of experience, then calculate bonus
    // Experience ≥ 10 years → 20% bonus
    // 5–9 years → 10% bonus
    // < 5 years → 5% bonus
    // Also, if salary > 100000, reduce bonus by half
    int exp = 12;
    int salary = 110_000;
    double bonus = 0;
    boolean reduceBonusByHalf = salary > 100000;
    if (exp >= 10) {
      bonus += 20;
    } else if (exp < 5) {
      bonus += 5;
    } else {
      bonus += 10;
    }
    if (reduceBonusByHalf == true) {
      bonus = bonus / 2;
    }
    BigDecimal newSalary = BigDecimal.valueOf(salary).multiply(BigDecimal.valueOf(1 + bonus / 100));
    System.out.println("Bonus: " + bonus + "%");
    System.out.println("Old Salary: $" + salary);
    System.out.println("New Salary: $" + newSalary);
  }
}