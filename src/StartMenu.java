import java.util.ArrayList;

public abstract class StartMenu {
    private ArrayList<String> options = new ArrayList<>();

    public void start() {
        options.add("Vil du logge ind eller lave et nyt login");
        options.add("1: Login");
        options.add("2: nyt Login");

        //læser bruger intastning
        int userChoice = ui.readInputNum(options.get(0)+"\n"+options.get(1)+" "+options.get(2));
        try {
            if (userChoice == 1) {
                String username;
                String password;
                username = ui.readInputText("Indstast username: ");
                password = ui.readInputText("Indtast password: ");
                ArrayList<String> data = io.readFile("/Data/logins.txt");

            } else if (userChoice == 2) {

            }
        } catch (Exception e) {
            ui.displayMsg("input ikke 1 eller 2!");
        }
    }

}
