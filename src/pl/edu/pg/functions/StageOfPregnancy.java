package pl.edu.pg.functions;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class StageOfPregnancy {

    public void calculatePregnancyWeekMonthTrimestr(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        long weeksBetween = ChronoUnit.WEEKS.between(firstDayOfTheLastMenstrual, currentDate);
        long pregnancyWeek = (weeksBetween + 1);
        if (pregnancyWeek >= 3 && pregnancyWeek <= 42) {
            System.out.println(pregnancyWeek + " tydzień");
            calculatePrengancyMonth(firstDayOfTheLastMenstrual, LocalDate.now());
            calculatePrengancyTrimestr(firstDayOfTheLastMenstrual, LocalDate.now());
            System.out.println("Gratulacje!\n");
        } else {
            System.out.println("Nie jesteś w ciąży...\n");
        }
    }

    public void calculatePrengancyMonth(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        if (pregnancyMonth < 10) {
            System.out.println(pregnancyMonth + " miesiąc ciąży");
        }
    }

    public void calculatePrengancyTrimestr(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        if (pregnancyMonth > 9) {
            System.out.println("Nie jesteś w ciąży");
        } else if (pregnancyMonth < 4) {
            System.out.println("1 trymestr");
        } else if (pregnancyMonth >= 4 && pregnancyMonth < 7) {
            System.out.println("2 trymestr");
        } else if (pregnancyMonth >= 7 && pregnancyMonth <= 9) {
            System.out.println("3 trymestr");
        }
    }
}
