import java.util.*;
import java.time.*;
import java.time.format.TextStyle;

public class Solution {

    static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.toString(); // Already returns uppercase, e.g. "WEDNESDAY"
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int month, day, year;
        month = scan.nextInt();
        day = scan.nextInt();
        year = scan.nextInt();
        System.out.println(findDay(month, day, year));
        scan.close();
    }
}