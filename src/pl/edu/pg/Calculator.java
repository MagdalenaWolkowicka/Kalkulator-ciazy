package pl.edu.pg;

import pl.edu.pg.functions.DueDate;
import pl.edu.pg.functions.InfoReader;
import pl.edu.pg.functions.StageOfPregnancy;

import java.time.LocalDate;
import java.util.Scanner;

public class Calculator {

    StageOfPregnancy stageOfPregnancy = new StageOfPregnancy();
    DueDate dueDate = new DueDate();
    Scanner scanner = new Scanner(System.in);
    LocalDate firstDayOfTheLastMenstrual;
    InfoReader infoReader = new InfoReader();

    public void start() {
        Menu menu = new Menu();
        while (true) {
            menu.showMenu();
            actionMenu();
        }
    }

    public void questions() {
        System.out.println("Podaj datę pierwszego dnia ostatniej miesiączki (yyyy-MM-dd)");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        firstDayOfTheLastMenstrual = LocalDate.parse(date);
    }

    public boolean checkIfTheDateIsCorrect() {
        if (firstDayOfTheLastMenstrual.isAfter(LocalDate.now())) {
            System.out.println("Błędna data, spróbuj jeszcze raz.\n");
            return true;
        }
        return false;
    }

    public void actionMenu() {
        System.out.println("\nWybierz opcję: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                questions();
                if (checkIfTheDateIsCorrect()) break;
                StageOfPregnancy.calculatePregnancyWeekMonthTrimestr(stageOfPregnancy, firstDayOfTheLastMenstrual, LocalDate.now());
                break;
            case 2:
                dueDate.calculateDateOfBirth(firstDayOfTheLastMenstrual);
                dueDate.calculateDayOfWeek();
                break;
            case 3:
                if (firstDayOfTheLastMenstrual == null) {
                    infoReader.askAboutTheMonthOfPregnancyAndShowInfo();
                } else {
                    if (firstDayOfTheLastMenstrual.plusDays(280).isAfter(LocalDate.now())) {
                        infoReader.calculatePregnancyMonthAndShowInfo(firstDayOfTheLastMenstrual, LocalDate.now());
                    } else {
                        System.out.println("Błędne dane");
                    }
                }
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Błędny wybór");
        }
    }
}
