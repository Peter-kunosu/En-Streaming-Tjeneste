import java.util.ArrayList;

import entity.User;
import util.FileIO;
import util.TextUI;

public class StartMenu{
    private static ArrayList<String> options = new ArrayList<>();
    static FileIO io = new FileIO();
    static TextUI ui = new TextUI();
    private static String username;
    private static String password;

    public static void start() {
        options.add("Vil du logge ind eller lave et nyt login");
        options.add("1: Login");
        options.add("2: nyt Login");

        //læser bruger intastning
        int userChoice = ui.readInputNum(options.get(0)+"\n"+options.get(1)+"\n"+options.get(2));
        try {
            if (userChoice == 1) {
                username = ui.readInputText("Indtast username: ");
                password = ui.readInputText("Indtast password: ");
                ArrayList<String> data = io.readFile("src/Data/Bruger/"+username+".txt");
                ui.displayMsg("Du er nu logget ind som "+username);

            } else if (userChoice == 2) {
                ui.displayMsg("Du skal nu lave et nyt login!");
                username = ui.readInputText("Indtast username: ");
                password = ui.readInputText("Indtast password: ");
                User user = new User(username, password);
                user.CreateUserFile("src/Data/Bruger/"+ StartMenu.getUsername());
                ui.displayMsg("Ny user er lavet, samt logget ind som " + username);

            }
        } catch (Exception e) {
            ui.displayMsg("input ikke 1 eller 2!");
        }

    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

}
