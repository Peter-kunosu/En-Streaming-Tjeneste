import util.*;

public class Main {
    public static void main(String[] args) {
        TextUI ui = new TextUI();

        StartMenu startMenu = new StartMenu();
        StartMenu.start();

        TemuNetflix netflix = new TemuNetflix();
        netflix.menuChoices();

    }
}