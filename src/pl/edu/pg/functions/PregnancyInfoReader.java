package pl.edu.pg.functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class PregnancyInfoReader {

    public void askAboutTheMonthOfPregnancyAndShowInfo() {
        System.out.println("Podaj miesiąc ciąży: ");
        Scanner scanner = new Scanner(System.in);
        int pregnancyMonth = scanner.nextInt();
        if (pregnancyMonth >= 1 && pregnancyMonth <= 9) {
            readPregnancyInfoFromFile(pregnancyMonth);
        } else {
            System.out.println("Błędny numer miesiąca\n");
        }
    }

    public void calculatePregnancyMonthAndShowInfo(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        int pregnancyMonth = (period.getMonths() + 1);
        readPregnancyInfoFromFile(pregnancyMonth);
    }

    private void readPregnancyInfoFromFile(int pregnancyMonth) {
        if (pregnancyMonth == 1) {
            readFile("Miesiac1.txt");
        } else if (pregnancyMonth == 2) {
            readFile("Miesiac2.txt");
        } else if (pregnancyMonth == 3) {
            readFile("Miesiac3.txt");
        } else if (pregnancyMonth == 4) {
            readFile("Miesiac4.txt");
        } else if (pregnancyMonth == 5) {
            readFile("Miesiac5.txt");
        } else if (pregnancyMonth == 6) {
            readFile("Miesiac6.txt");
        } else if (pregnancyMonth == 7) {
            readFile("Miesiac7.txt");
        } else if (pregnancyMonth == 8) {
            readFile("Miesiac8.txt");
        } else if (pregnancyMonth == 9) {
            readFile("Miesiac9.txt");
        } else {
            System.out.println("Błędny numer miesiąca");
        }
    }

    private void readFile(String fileName) {
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read file: " + e.getMessage());
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
