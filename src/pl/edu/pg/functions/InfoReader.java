package pl.edu.pg.functions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class InfoReader {

    int pregnancyMonth;

    public void askAboutTheMonthOfPregnancyAndShowInfo() {
        InfoReader infoReader = new InfoReader();
        System.out.println("Podaj miesiąc ciąży: ");
        Scanner scanner = new Scanner(System.in);
        int pregnancyMonth = scanner.nextInt();
        if (pregnancyMonth >= 1 && pregnancyMonth <= 9) {
            readPregnancyInfoFromFile(infoReader, pregnancyMonth);
        } else {
            System.out.println("Błędny numer miesiąca");
        }
    }

    public void calculatePregnancyMonthAndShowInfo(LocalDate firstDayOfTheLastMenstrual, LocalDate currentDate) {
        InfoReader infoReader = new InfoReader();
        Period period = Period.between(firstDayOfTheLastMenstrual, currentDate);
        pregnancyMonth = (period.getMonths() + 1);
        readPregnancyInfoFromFile(infoReader, pregnancyMonth);
    }

    private void readPregnancyInfoFromFile(InfoReader infoReader, int pregnancyMonth) {
        if (pregnancyMonth == 1) {
            infoReader.readFile("Miesiac1.txt");
        } else if (pregnancyMonth == 2) {
            infoReader.readFile("Miesiac2.txt");
        } else if (pregnancyMonth == 3) {
            infoReader.readFile("Miesiac3.txt");
        } else if (pregnancyMonth == 4) {
            infoReader.readFile("Miesiac4.txt");
        } else if (pregnancyMonth == 5) {
            infoReader.readFile("Miesiac5.txt");
        } else if (pregnancyMonth == 6) {
            infoReader.readFile("Miesiac6.txt");
        } else if (pregnancyMonth == 7) {
            infoReader.readFile("Miesiac7.txt");
        } else if (pregnancyMonth == 8) {
            infoReader.readFile("Miesiac8.txt");
        } else if (pregnancyMonth == 9) {
            infoReader.readFile("Miesiac9.txt");
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
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
