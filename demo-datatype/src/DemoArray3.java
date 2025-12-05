import java.util.Arrays;

public class DemoArray3 {
  public static void main(String[] args) {
    // 10, 25, 3, 48, 57
    // print all numbers
    // int[] sampleIntArr = new int[] {10, 25, 3, 48, 57};
    // for (int element : sampleIntArr) {
    // System.out.print(element + " ");
    // }
    // System.out.println();

    // scores 23, 44, 67, 88, 91, 12
    // loop -> print all even numbers
    // int[] scores = new int[] {23, 44, 67, 88, 91, 12};
    // for (int i = 0; i < scores.length; i++) {
    // if (scores[i] % 2 == 0) {
    // System.out.println(i + " is a even number");
    // }
    // }

    // find the median, 34, 78, 12, 89, 45, 99, 23 -> answer = 45
    // int[] findMedianArr = new int[] {34, 78, 12, 89, 45, 99, 23};
    // int medianIndex = findMedianArr.length / 2;
    // System.out.println("The original array: " + Arrays.toString(findMedianArr));
    // Arrays.sort(findMedianArr);
    // System.out.println("The sorted array: " + Arrays.toString(findMedianArr));
    // System.out.println("The median is: " + findMedianArr[medianIndex]);

    // prices 99.9, 13.8, 9.9, 1200.0
    // quantities 3, 10, 12, 20
    // amounts (amount = price * quantity)
    // double[] prices = new double[] {99.9, 13.8, 9.9, 1200.0};
    // double[] quantities = new double[] {3, 10, 12, 20};
    // double[] amounts = new double[Math.max(prices.length, quantities.length)];
    // for (int i = 0; i < amounts.length; i++) {
    // amounts[i] = prices[i] * quantities[i];
    // }
    // System.out.println("Amounts: " + Arrays.toString(amounts));

    /**
     * Exercise - checking username and password
     * 
     * 3 possible outputs:
     * 
     * 1. Username is NOT found
     * 
     * 2. Password is WRONG
     * 
     * 3. Login success
     */
    // String[] usernames = new String[] {"johnwong", "stevenchan", "jennyng"};
    // String[] passwords = new String[] {"abcd1234", "ijk789", "xyz456"};

    // String usernameInput = "stevenchan";
    // String passwordInput = "ijk789";

    // int userID = -1;
    // for (int i = 0; i < usernames.length; i++) {
    // if (usernames[i].equals(usernameInput)) {
    // userID = i;
    // break;
    // }
    // }

    // if (userID == -1) {
    // System.out.println("Error: Username not found");
    // } else {
    // if (passwordInput != null && passwordInput.equals(passwords[userID])) {
    // System.out.println("Login success!");
    // } else {
    // System.out.println("Error: Password is wrong");
    // }
    // }

    /**
     * ages = [16, 66, 18, 37]
     * 
     * genders = ['M', 'F', 'M', 'F']
     * 
     * smokers = [false, true, true, false]
     * 
     * baseFee = 100
     * 
     * 1) smoker -> +20% fee
     * 
     * 2) age > 60 -> +30% fee
     * 
     * 3) genders == female -> +5% fee
     */
    // final int baseFee = 100;
    // int[] ages = new int[] {16, 66, 18, 37};
    // char[] genders = new char[] {'M', 'F', 'M', 'F'};
    // boolean[] smokers = new boolean[] {false, true, true, false};
    // double[] finalFee = new double[ages.length];

    // for (int i = 0; i < finalFee.length; i++) {
    // double currentPercentage = 0;
    // if (smokers[i] == true) {
    // currentPercentage += 20;
    // }
    // if (ages[i] > 60) {
    // currentPercentage += 30;
    // }
    // if (genders[i] == 'F') {
    // currentPercentage += 5;
    // }
    // finalFee[i] = baseFee * (1 + currentPercentage / 100);
    // }
    // System.out.println("Final fee: " + Arrays.toString(finalFee));

    // toCharArray()
    // String staff = "John";
    // char[] charArr = staff.toCharArray();
    // System.out.println(Arrays.toString(charArr));



  }
}
