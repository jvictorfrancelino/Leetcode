package dates.currentdayoftheweek;


import java.time.*;

class Result {

    public static String findDay(int month, int day, int year) {

        LocalDate localDate = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
        return dayOfWeek.name();
    }

}


