package pl.edu.pg;

import pl.edu.pg.functions.DueDate;
import pl.edu.pg.functions.PregnancyInfoReader;
import pl.edu.pg.functions.StageOfPregnancy;

import java.time.LocalDate;
import java.util.Scanner;

public class Calculator {

    private boolean exitCalculator = false;

    StageOfPregnancy stageOfPregnancy = new StageOfPregnancy();
    DueDate dueDate = new DueDate();
    Scanner scanner = new Scanner(System.in);
    PregnancyInfoReader pregnancyInfoReader = new PregnancyInfoReader();
    LocalDate firstDayOfTheLastMenstrual;

    public void start() {

        Menu menu = new Menu();
        while (!exitCalculator) {
            menu.showMenu();
            actionMenu();
        }
    }

    public void actionMenu() {
        System.out.println("\nWybierz opcję: ");
        String option = scanner.next();
        switch (option) {
            case "1":
                firstDayOfTheLastMenstrual = stageOfPregnancy.getFirstDayOfTheLastMenstrualReturnDay();
                showStageOfPregnancy();
                break;
            case "2":
                showDueDate();
                break;
            case "3":
                showPregnancyInfo();
                break;
            case "0":
                exitCalculator = true;
                break;
            default:
                System.out.println("Błędny wybór\n");
        }
    }

    private void showStageOfPregnancy() {
        if (checkIfTheDateIsCorrect()) {
            stageOfPregnancy.showWeekMonthTrimestrInfo(firstDayOfTheLastMenstrual);
        } else {
            System.out.println("Błędna data, spróbuj jeszcze raz.\n");
            return;
        }
    }

    private void showDueDate() {
        if (firstDayOfTheLastMenstrual == null) {
            firstDayOfTheLastMenstrual = stageOfPregnancy.getFirstDayOfTheLastMenstrualReturnDay();
        }
        dueDate.calculateDateOfBirth(firstDayOfTheLastMenstrual);
        dueDate.calculateDayOfWeek();
    }

    private void showPregnancyInfo() {
        if (firstDayOfTheLastMenstrual == null) {
            pregnancyInfoReader.askAboutTheMonthOfPregnancyAndShowInfo();
        } else {
            if (firstDayOfTheLastMenstrual.plusDays(280).isAfter(LocalDate.now())) {
                pregnancyInfoReader.calculatePregnancyMonthAndShowInfo(firstDayOfTheLastMenstrual, LocalDate.now());
            } else {
                System.out.println("Błędne dane\n");
            }
        }
    }

    private boolean checkIfTheDateIsCorrect() {
        return firstDayOfTheLastMenstrual.isBefore(LocalDate.now());
    }
}
