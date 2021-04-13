package pl.edu.pg;

import pl.edu.pg.functions.DueDate;
import pl.edu.pg.functions.InfoReader;
import pl.edu.pg.functions.StageOfPregnancy;

import java.time.LocalDate;
import java.util.Scanner;

public class Calculator {

    private boolean exitCalculator = false;

    StageOfPregnancy stageOfPregnancy = new StageOfPregnancy();
    DueDate dueDate = new DueDate();
    Scanner scanner = new Scanner(System.in);
    InfoReader infoReader = new InfoReader();
    LocalDate firstDayOfTheLastMenstrual;

    public void start() {
        Menu menu = new Menu();
        while (exitCalculator == false) {
            menu.showMenu();
            actionMenu();
        }
    }

    public void actionMenu() {
        System.out.println("\nWybierz opcję: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                showStageOfPregnancy();
                break;
            case 2:
                dueDate.calculateDateOfBirth(firstDayOfTheLastMenstrual);
                dueDate.calculateDayOfWeek();
                break;
            case 3:
                showPregnancyInfo();
                break;
            case 0:
                exitCalculator = true;
                break;
            default:
                System.out.println("Błędny wybór");
        }
    }

    private void showStageOfPregnancy() {
        firstDayOfTheLastMenstrualQuestion();
        if (checkIfTheDateIsCorrect()) {
            stageOfPregnancy.showWeekMonthTrimestrInfo(firstDayOfTheLastMenstrual);
        } else {
            return;
        }
    }

    private void firstDayOfTheLastMenstrualQuestion() {
        System.out.println("Podaj datę pierwszego dnia ostatniej miesiączki (yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        firstDayOfTheLastMenstrual = LocalDate.parse(date);
    }

    private boolean checkIfTheDateIsCorrect() {
        if (firstDayOfTheLastMenstrual.isBefore(LocalDate.now())) {
            return true;
        }
        System.out.println("Błędna data, spróbuj jeszcze raz.\n");
        return false;
    }

    private void showPregnancyInfo() {
        if (firstDayOfTheLastMenstrual == null) {
            infoReader.askAboutTheMonthOfPregnancyAndShowInfo();
        } else {
            if (firstDayOfTheLastMenstrual.plusDays(280).isAfter(LocalDate.now())) {
                infoReader.calculatePregnancyMonthAndShowInfo(firstDayOfTheLastMenstrual, LocalDate.now());
            } else {
                System.out.println("Błędne dane");
            }
        }
    }
}
