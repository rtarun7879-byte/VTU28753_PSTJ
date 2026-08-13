import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dow = date.getDayOfWeek();

        String name = dow.toString(); // e.g. "SATURDAY"
        return name.charAt(0) + name.substring(1).toLowerCase(); // "Saturday"
    }
}