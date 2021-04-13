package pl.edu.pg.functions;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class StageOfPregnancy {

    private long pregnancyWeek;


    public void showWeekMonthTrimestrInfo(LocalDate firstDayOfTheLastMenstrual) {
        calculatePregnancyWeek(firstDayOfTheLastMenstrual, LocalDate.now());
        if (pregnancyWeek >= 3 && pregnancyWeek <= 42) {
            showPregnancyWeek(pregnancyWeek);
            calculateAndShowPrengancyMonth(firstDayOfTheLastMenstrual, LocalDate.now());
            calculateAndShowPrengancyTrimestr(firstDayOfTheLastMenstrual, LocalDate.now());
            System.out.println("Gratulacje!\n");
        } else if (pregnancyWeek < 3 || pregnancyWeek > 42) {
            System.out.println("Nie jesteś w ciąży...\n");
        }
    }

    public LocalDate firstDayOfTheLastMenstrualQuestionReturnDay() {
        System.out.println("Podaj datę pierwszego dnia ostatniej miesiączki (yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        LocalDate firstDayOfTheLastMenstrual = LocalDate.parse(date);
        return firstDayOfTheLastMenstrual;
    }

    private void calculatePregnancyWeek(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        long weeksBetween = ChronoUnit.WEEKS.between(firstDayOfTheLastMenstrual, currentDate);
        pregnancyWeek = (weeksBetween + 1);
    }

    private void showPregnancyWeek(long pregnancyWeek) {
        System.out.println(pregnancyWeek + " tydzień");
    }

    private void calculateAndShowPrengancyMonth(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        if (pregnancyMonth < 10) {
            System.out.println(pregnancyMonth + " miesiąc");
        }
    }

    private void calculateAndShowPrengancyTrimestr(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        if (pregnancyMonth < 4) {
            System.out.println("1 trymestr");
        } else if (pregnancyMonth >= 4 && pregnancyMonth < 7) {
            System.out.println("2 trymestr");
        } else if (pregnancyMonth >= 7 && pregnancyMonth <= 9) {
            System.out.println("3 trymestr");
        }
    }
}
