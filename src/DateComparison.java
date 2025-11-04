import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.ZoneId;

public class DateComparison {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2024, 1, 15);
        LocalDate date2 = LocalDate.of(2024, 2, 20);
        
        Date resultDate = compareDates(date1, date2);
        System.out.println("Result date: " + resultDate);
    }
    
    static Date compareDates(LocalDate date1, LocalDate date2) {
        long days = ChronoUnit.DAYS.between(date1, date2);
        return Date.from(date2.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}