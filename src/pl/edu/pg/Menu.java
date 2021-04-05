package pl.edu.pg;

public class Menu {

    public enum Options {
        EXIT("Wyjście"),
        STAGE_OF_PREGNANCY("Sprawdź na jakim etapie ciąży jesteś"),
        DUE_DATE("Wylicz termin porodu"),
        INFO("Informacje");

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
        for (int i = 1; i < options.length; i++) {
            System.out.println(i + ". " + options[i].getValue());
        }
        System.out.println(0 + ". " + Options.EXIT.getValue());
    }
}
