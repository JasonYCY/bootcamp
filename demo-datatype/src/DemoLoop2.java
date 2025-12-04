public class DemoLoop2 {
  public static void main(String[] args) {
    // print 3 hello
    // for (int i = 0; i < 3; i++) {
    // System.out.println("hello");
    // }

    // print 1 to 10
    // for (int i = 1; i < 11; i++) {
    // System.out.println(i);
    // }

    // name = "Mary", print every character of the name
    // String name = "Mary";
    // for (int i = 0; i < name.length(); i++) {
    // System.out.println(name.charAt(i));
    // }

    // principal = 1000.0, interest rate 3% per year, calculate the total amount after 3 years
    // double principal = 1000.0;
    // double interestRate = 0.03;
    // for (int i = 0; i < 3; i++) {
    // principal = principal * (1 + interestRate);
    // }
    // System.out.println("total amount = " + principal);

    // 1 to 20, sum up all odd numbers and sum up all even numbers separately, then find the product of them
    // int oddSum = 0;
    // int evenSum = 0;
    // for (int i = 1; i < 21; i++) {
    // if (i % 2 == 0) {
    // evenSum += i;
    // } else {
    // oddSum += i;
    // }
    // }
    // System.out.println("odd sum * even sum = " + (oddSum * evenSum));

    // print "1/2/3/4/5"
    // String finalString = "1";
    // for (int i = 2; i < 6; i++) {
    // finalString = finalString + "/" + i;
    // }
    // System.out.println(finalString);

    // string = "hello", count the number of l
    // String randomString = "Hello World";
    // int numberOfL = 0;
    // for (int i = 0; i < randomString.length(); i++) {
    // if (randomString.charAt(i) == 'l') {
    // numberOfL += 1;
    // }
    // }
    // System.out.println("Number of l = " + numberOfL);

    // "HeLLo", count the number of uppercase letter
    // String stringWithUppercase = "HeLLo";
    // int uppercaseCount = 0;
    // for (int i = 0; i < stringWithUppercase.length(); i++) {
    // char currentChar = stringWithUppercase.charAt(i);
    // if (Character.isUpperCase(currentChar)) {
    // uppercaseCount += 1;
    // }
    // }
    // System.out.println(uppercaseCount);

    // print 1 4 9 16 25... 100
    // for (int i = 1; i < 11; i++) {
    // System.out.print(i * i + " ");
    // }

    // given a string "apple", count the number of character a, e, i, o, u
    // String apple = "apple";
    // int charCount = 0;

    // for (int i = 0; i < apple.length(); i++) {
    // String currentChar = "" + apple.charAt(i);
    // if (currentChar.matches("[aeiou]")) {
    // charCount += 1;
    // }
    // }
    // System.out.println(charCount);

    // given a string "hello", print "hello", "hell", "hel", "he", "h"
    // String descendString = "hello";
    // int stringLength = descendString.length();
    // for (int i = 0; i < stringLength; i++) {
    // System.out.print(descendString.substring(0, stringLength - i) + " ");
    // }

    // given password = "abcd@1234XYZ"
    // check if the password is valid
    // 1. length >= 12
    // 2. with at least one capital letter
    // 3. with at least one special character @#$!
    // String password = "abcd@1234XYZ";
    // boolean isValidPassword = true;
    // boolean hasCapital = false;
    // boolean hasSpecialCharacter = false;
    // int passwordLength = password.length();

    // for (int i = 0; i < passwordLength; i++) {
    // char currentChar = password.charAt(i);
    // if (Character.isUpperCase(currentChar)) {
    // hasCapital = true;
    // }
    // if (currentChar == '@' || currentChar == '#' || currentChar == '$'
    // || currentChar == '!') {
    // hasSpecialCharacter = true;
    // }
    // if (hasCapital == true && hasSpecialCharacter == true) {
    // break;
    // }
    // }

    // if (passwordLength < 12 || hasCapital == false
    // || hasSpecialCharacter == false) {
    // isValidPassword = false;
    // }
    // System.out
    // .println("The password is: " + (isValidPassword ? "valid" : "invalid"));

    // given a string s1 = "abc5uk20fs", move all numbers to another string
    // s1 = "abc5uk20fs" -> s2 = "520"
    // String s1 = "abc5uk20fs";
    // String s2 = "";
    // for (int i = 0; i < s1.length(); i++) {
    // char currentChar = s1.charAt(i);
    // if (Character.isDigit(currentChar)) {
    // s2 = s2 + currentChar;
    // }
    // }
    // System.out.println(s2);

    // encrypt password, "abcd" -> algorithm: ASCII + 3 -> "defg"
    // String rawPassword = "abcd";
    // StringBuilder stringBuilder = new StringBuilder();
    // for (int i = 0; i < rawPassword.length(); i++) {
    // char currentChar = (char) (rawPassword.charAt(i) + 3);
    // stringBuilder = stringBuilder.append(currentChar);
    // }
    // System.out.println(stringBuilder.toString());

  }
}
