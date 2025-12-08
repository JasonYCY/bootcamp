import java.time.LocalDate;

public class DemoLocalDate2 {
  public static void main(String[] args) {
    // 2024-10-01
    // 2023-01-31
    // 2025-06-30
    // array stores the dates, count the number of dates later than 2024
    // LocalDate[] dates = new LocalDate[3];
    // dates[0] = LocalDate.of(2024, 10, 1);
    // dates[1] = LocalDate.of(2023, 1, 31);
    // dates[2] = LocalDate.of(2025, 6, 30);
    // int numberOfDatesAfter2024 = 0;
    // for (int i = 0; i < dates.length; i++) {
    // if (dates[i].getYear() > 2024) {
    // numberOfDatesAfter2024 += 1;
    // }
    // }
    // System.out
    // .println("Number of dates later than 2024: " + numberOfDatesAfter2024);

    // find the max date from the date array
    LocalDate[] dates = new LocalDate[] {LocalDate.of(2024, 10, 1),
        LocalDate.of(2023, 1, 31), LocalDate.of(2025, 6, 30)};
    LocalDate maxDate = dates[0];
    for (int i = 1; i < dates.length; i++) {
      if (dates[i].isAfter(maxDate)) {
        maxDate = dates[i];
      }
    }
    System.out.println("Max date: " + maxDate);



  }
}
