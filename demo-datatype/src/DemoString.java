public class DemoString {
  public static void main(String[] args) {
    // String
    String str = "Hello world!";
    System.out.println("\n\tstr: " + str + "\n");

    // 1. length()
    System.out.println("str.length(): " + str.length());

    // 2. charAt()
    System.out.println(
        "str.charAt(str.length() - 1): " + str.charAt(str.length() - 1));

    // 3. equals()
    boolean isSameString = str.equals("Hello world!");
    System.out.println("str.equals(): " + isSameString);

    // 4. contains()
    boolean containSubstring = str.contains("ll");
    System.out.println("str.contains(): " + containSubstring);

    // 5. isEmpty()
    String emptyString = "";
    System.out.println("str.isEmpty(): " + str.isEmpty());
    System.out.println("emptyString.isEmpty(): " + emptyString.isEmpty());

    // 6. isBlank()
    System.out.println("str.isBlank(): " + str.isBlank());
    System.out.println("\" \".isBlank(): " + " ".isBlank());

    // 7. replace()
    str = str.replace("Hello", "Goodbye");
    System.out.println("str = str.replace(\"Hello\", \"Goodbye\"): " + str);

    // 8. startsWith()
    boolean isStartsWithGoo = str.startsWith("Goo");
    System.out.println("str.startsWith(\"Goo\"): " + isStartsWithGoo);

    // 9. endsWith()
    boolean isEndsWithExclamation = str.endsWith("!");
    System.out.println("str.endsWith(\"!\"): " + isEndsWithExclamation);

    // 10. indexOf()
    System.out.println("str.indexOf('o'): " + str.indexOf('o'));
    System.out.println("str.indexOf(\"oo\"): " + str.indexOf("oo"));
    System.out.println("str.indexOf('O'): " + str.indexOf('O'));
    System.out.println("str.lastIndexOf('o'): " + str.lastIndexOf('o'));

    // 11. concat()
    System.out.println("\"str1\".concat(\"str2\"): " + "str1".concat("str2"));

    // 12. substring()
    System.out.println("str.substring(startIndex, stopBeforeIndex): "
        + str.substring(1, str.length() - 1));

    // 13. toLowerCase(), toUpperCase()
    System.out.println("str.toUpperCase(): " + str.toUpperCase());
    System.out.println("\"TEST\".toLowerCase(): " + "TEST".toLowerCase());

    // 14. trim()
    System.out.println("\"\\t\\n" + //
        " Java Python. \".trim(): " + "\t\n Java Python. ".trim());
    System.out.println("str.trim().length(): " + str.trim().length()
        + "\t\t\t\t <--- [Chain Method]");
  }
}
