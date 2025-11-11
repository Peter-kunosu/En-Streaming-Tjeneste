import util.*;

public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI();
        TemuNetflix netflix = new TemuNetflix();

        StartMenu startMenu = new StartMenu();

        StartMenu.start();

        //options til at kunne vælge imellem film, serier, sete film, sete serier.
        netflix.menuChoices();

    }
}