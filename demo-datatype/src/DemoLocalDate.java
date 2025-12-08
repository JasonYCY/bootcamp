import java.time.LocalDate;

public class DemoLocalDate {
  public static void main(String[] args) {
    // 2025 12 31
    // LocalDate ld1 = LocalDate.of(2025, 12, 31);

    // plus or minus
    // ld1 = ld1.plusDays(1);
    // System.out.println(ld1); // 2026-01-01

    // LocalDate afterThreeYear = ld1.plusYears(3L);
    // System.out.println(ld1); // 2026-01-01
    // System.out.println(afterThreeYear); // 2029-01-01
    // System.out.println(ld1.plusDays(200).getDayOfYear()); // 201

    // get
    // System.out.println(ld1.getDayOfMonth()); // 1
    // System.out.println(ld1.getMonthValue()); // 1
    // System.out.println(ld1.getMonth()); // JANUARY

    // compare
    // LocalDate joinDate = LocalDate.of(2023, 4, 28);
    // LocalDate probationEndDate = joinDate.plusMonths(3);
    // LocalDate currentDate = LocalDate.of(2023, 8, 1);
    // boolean passedProbation = currentDate.isAfter(probationEndDate);
    // System.out.println("passedProbation: " + passedProbation);

    // effective date 2026-01-01
    // LocalDate effectiveDate = LocalDate.of(2026, 1, 1);
    // currentDate = LocalDate.of(2026, 1, 1);
    // if (currentDate.isAfter(effectiveDate)
    // || currentDate.equals(effectiveDate)) {
    // System.out.println("Current date is taking effective today");
    // } else {
    // System.out.println("Current date is still not taking effective");
    // }

    // leap year
    // System.out.println("is leap year: " + ld1.isLeapYear()); // false

    // with year
    // System.out.println(ld1.withYear(2024)); // 2024-07-20

    // compare to
    LocalDate ld2 = LocalDate.of(2029, 1, 1);
    System.out.println(ld2.compareTo(LocalDate.of(2026, 7, 13)));
  }
}
