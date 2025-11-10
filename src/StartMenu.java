import java.io.File;
import java.util.ArrayList;
import util.FileIO;
import util.TextUI;

public abstract class StartMenu{
    private ArrayList<String> options = new ArrayList<>();
    FileIO io = new FileIO();
    TextUI ui = new TextUI();

    public void start() {
        options.add("Vil du logge ind eller lave et nyt login");
        options.add("1: Login");
        options.add("2: nyt Login");
        String username;
        String password;

        //læser bruger intastning
        int userChoice = ui.readInputNum(options.get(0)+"\n"+options.get(1)+" "+options.get(2));
        try {
            if (userChoice == 1) {
                username = ui.readInputText("Indtast username: ");
                password = ui.readInputText("Indtast password: ");
                ArrayList<String> data = io.readFile("/Data/logins.txt");
                if (data.contains(data.contains(username+password))) {
                    ui.displayMsg("du er nu logget ind som " + username);

                }
            } else if (userChoice == 2) {
                ui.displayMsg("Du skal nu lave et nytlogin!");
                username = ui.readInputText("Indtast username: ");
                password = ui.readInputText("Indtast password: ");
                io.
            }
        } catch (Exception e) {
            ui.displayMsg("input ikke 1 eller 2!");
        }
    }

}
