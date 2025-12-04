public class DemoLoop {
  public static void main(String[] args) {
    // for-loop
    // for (int i = 0; i < 3; i++) {
    // System.out.println("Hi, current i = " + i);
    // }

    // print "Hello!" 50 times
    // for (int i = 0; i < 50; i++) {
    // System.out.println("Hello!");
    // }

    // range 0 to 100, print even number
    // for (int i = 0; i < 101; i++) {
    // if (i % 2 == 0) {
    // System.out.println(i + "\tis even!");
    // }
    // }

    // range 0 to 20, print odd numbers and the number > 5
    // for (int i = 0; i < 21; i++) {
    // if (i > 5 && i % 2 == 1) {
    // System.out.println(i + "\tis odd!");
    // }
    // }

    // leap year
    // Rule 1: Divisible by 4
    // Rule 2: EXCEPT if divisible by 100
    // Rule 3: UNLESS also divisible by 400
    // for (int currentYear = 2000; currentYear <= 2200; currentYear++) {
    // boolean isLeapYear = false;

    // if (currentYear % 4 == 0) {
    // if (currentYear % 100 == 0) {
    // if (currentYear % 400 == 0) {
    // // is a leap year
    // isLeapYear = true;
    // } else {
    // // is not a leap year
    // }
    // } else {
    // // is a leap year
    // isLeapYear = true;
    // }
    // } else {
    // // is not a leap year
    // }

    // // Simple Implementation
    // // isLeapYear = (currentYear % 400 == 0)
    // // || (currentYear % 4 == 0 && currentYear % 100 != 0);

    // if (isLeapYear) {
    // System.out.println(currentYear + " is a leap year!");
    // }
    // }

    // sum up 1 to 100
    // int sum = 0;
    // for (int i = 1; i < 101; i++) {
    // sum += i;
    // }
    // System.out.println("The sum from 1 to 100 = " + sum);
    // System.out.println("(1 + 100) * 100 / 2 = " + ((1 + 100) * 100 / 2));

    // range 1 to 100, how many numbers are divisible by 6
    // sum = 0;
    // for (int i = 1; i < 101; i++) {
    // if (i % 6 == 0) {
    // sum += 1;
    // System.out.println(sum + ")\t" + i);
    // }
    // }
    // System.out.println("range 1 to 100, how many numbers are divisible by 6?");
    // System.out.println("Answer: " + sum);

    // convert 1 to 100 to char values, then concat them together
    // String str = "";
    // for (int i = 1; i < 101; i++) {
    // str = str + (char) i;
    // }
    // System.out.println("Concatenated string: \n" + str);

    // find the first number from 1 to 50 that is divisible by 7
    // for (int i = 1; i < 51; i++) {
    // if (i % 7 == 0) {
    // System.out.println(
    // i + " is the first number from 1 to 50 that is divisible by 7");
    // break;
    // }
    // }

    // find the largest number < 1000, divisible by 7
    // for (int i = 999;; i--) {
    // if (i % 7 == 0) {
    // System.out.println(
    // i + " is the largest number below 1000 that is divisible by 7");
    // break;
    // }
    // }

    // alternative ways to implement this:
    // int start = 999;
    // int remainder = start % 7; // 999 % 7 = 5
    // int result = start - remainder; // 999 - 5 = 994
    // System.out.println(
    // result + " is the largest number below 1000 that is divisible by 7");



    /*
     * Exercise - Update Time String
     */
    // String currentTime = "23:42:00";
    // int secondToAdd = 6500;

    // // split current time into a string array containing: [hour, minute, second]
    // String[] splitTime = currentTime.split(":");
    // int hour = Integer.parseInt(splitTime[0]);
    // int minute = Integer.parseInt(splitTime[1]);
    // int second = Integer.parseInt(splitTime[2]);
    // System.out.println(
    // "original hour:minute:second = " + hour + ":" + minute + ":" + second);

    // // add current time in second with the second to add, getting the new time in second
    // int currentTimeInSecond = hour * 60 * 60 + minute * 60 + second;
    // int newTimeInSecond = currentTimeInSecond + secondToAdd;
    // System.out.println("currentTimeInSecond: " + currentTimeInSecond);
    // System.out.println("newTimeInSecond: " + newTimeInSecond);

    // // using the new time in second, calculate the new hour, minute and second
    // int newHour = (newTimeInSecond / 3600) % 24;
    // int newMinute = (newTimeInSecond % 3600) / 60;
    // int newSecond = newTimeInSecond % 60;
    // System.out.println("new hour:minute:second = " + newHour + ":" + newMinute
    // + ":" + newSecond);

    // // update the string array's element
    // splitTime[0] = String.format("%02d", newHour);
    // splitTime[1] = String.format("%02d", newMinute);
    // splitTime[2] = String.format("%02d", newSecond);

    // // join the string array to get the new time in string
    // String newTimeString = String.join(":", splitTime);
    // System.out.println("newTimeString = " + newTimeString);



    /*
     * keep doubling a given number, until it just > 10000. what is the number?
     */
    // int givenNumber = 9;
    // while (givenNumber <= 10000) {
    // givenNumber = givenNumber * 2;
    // }
    // System.out.println("Final number (just > 10000): " + givenNumber);

    /**
     * Exercise - find the first index of 'X', -1 if not found
     */
    // String s10 = "HELLOXWORLD";
    // char targetChar = 'X';
    // int targetIndex = -1;
    // for (int i = 0; i < s10.length(); i++) {
    // char currentChar = s10.charAt(i);
    // if (currentChar == targetChar) {
    // targetIndex = i;
    // break;
    // }
    // }
    // if (targetIndex != -1) {
    // System.out.println("The first index of " + targetChar + " in " + s10
    // + " is " + targetIndex);
    // } else {
    // System.out.println(targetChar + " is not found in " + s10);
    // }

    /*
     * Exercise - prime numbers from 1 to 50
     */
    // for (int i = 2; i < 51; i++) {
    // boolean isPrime = true;
    // for (int j = 2; j < i; j++) {
    // if (i % j == 0) {
    // isPrime = false;
    // break;
    // }
    // }
    // if (isPrime)
    // System.out.println(i + " is a prime number!");
    // }

    // nested for-loop
    // for (int i = 0; i < 4; i++) {
    // System.out.println("i = " + i);
    // for (int j = 0; j < 4; j++) {
    // System.out.println("\tj = " + j);
    // }
    // }

    // print * triangle
    // *
    // **
    // ***
    // ****
    // System.out.println();
    // for (int i = 0; i < 4; i++) {
    // for (int j = 0; j <= i; j++) {
    // System.out.print("*");
    // }
    // System.out.println();
    // }

    // print * triangle
    // ****
    // ***
    // **
    // *
    // System.out.println();
    // for (int i = 0; i < 4; i++) {
    // for (int j = 0; j < 4 - i; j++) {
    // System.out.print("*");
    // }
    // System.out.println();
    // }

    // print * triangle
    // System.out.println();
    // for (int i = 0; i < 4; i++) {
    // for (int j = 0; j < 4 - i; j++) {
    // System.out.print(" ");
    // }
    // for (int j = 0; j <= i * 2; j++) {
    // System.out.print("*");
    // }
    // System.out.println();
    // }

    // print * triangle
    System.out.println();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < (4 - i) * 2 - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }
}
