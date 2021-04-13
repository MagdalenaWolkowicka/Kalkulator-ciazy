package pl.edu.pg;

import java.util.ArrayList;

public class Menu {

    public enum Options {
        STAGE_OF_PREGNANCY("1. Sprawdź na jakim etapie ciąży jesteś"),
        DUE_DATE("2. Wylicz termin porodu"),
        INFO("3. Informacje"),
        EXIT("0. Wyjście");

        private String value;

        Options(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    Options[] options = Options.values();

    public void showMenu() {
        ArrayList<String> listMenu = new ArrayList<>();
        for (int i = 0; i < options.length; i++) {
            listMenu.add(options[i].getValue());
        }
        String optionsToChoose = String.join("\n", listMenu);
        System.out.println(optionsToChoose);
    }
}