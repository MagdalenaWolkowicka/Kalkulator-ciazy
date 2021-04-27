package pl.edu.pg.functions;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DueDate {

    private LocalDate dateOfDelivery;
    StageOfPregnancy stageOfPregnancy = new StageOfPregnancy();

    public void calculateDateOfBirth(LocalDate firstDayOfTheLastMenstrual) {
        String dueDate = "Twój orientacyjny termin porodu to: ";
        String dueDateInThePast = "Twój termin porodu wypadał: ";
        if (firstDayOfTheLastMenstrual == null) {
            firstDayOfTheLastMenstrual = stageOfPregnancy.getFirstDayOfTheLastMenstrualReturnDay();
            showDateOfBirth(firstDayOfTheLastMenstrual, dueDate, dueDateInThePast);
        } else {
            showDateOfBirth(firstDayOfTheLastMenstrual, dueDate, dueDateInThePast);
        }
    }

    private void showDateOfBirth(LocalDate firstDayOfTheLastMenstrual, String dueDate, String dueDateInThePast) {
        dateOfDelivery = firstDayOfTheLastMenstrual.plusDays(280);
        if (dateOfDelivery.isAfter(LocalDate.now())) {
            System.out.println(dueDate + dateOfDelivery);
        } else {
            System.out.println(dueDateInThePast + dateOfDelivery);
        }
    }

    public void calculateDayOfWeek() {
        if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.MONDAY))) {
            System.out.println("Poniedziałek\n");
        } else if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.TUESDAY))) {
            System.out.println("Wtorek\n");
        } else if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.WEDNESDAY))) {
            System.out.println("Środa\n");
        } else if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.THURSDAY))) {
            System.out.println("Czwartek\n");
        } else if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.FRIDAY))) {
            System.out.println("Piątek\n");
        } else if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.SATURDAY))) {
            System.out.println("Sobota\n");
        } else if (dateOfDelivery.getDayOfWeek().equals(DayOfWeek.from(DayOfWeek.SUNDAY))) {
            System.out.println("Niedziela\n");
        }
    }
}
