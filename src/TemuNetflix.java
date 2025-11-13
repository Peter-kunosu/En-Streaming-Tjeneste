import entity.Media;
import entity.Movie;
import entity.Series;
import entity.User;
import util.TextUI;
import util.FileIO;
import java.util.ArrayList;

public class TemuNetflix {
    public ArrayList<Media> movies = new ArrayList<>();;
    public ArrayList<Series> serier = new ArrayList<>();;
    private ArrayList<String> options;

    TextUI ui = new TextUI();
    FileIO io = new FileIO();
    User user = new User(StartMenu.getUsername(), StartMenu.getPassword());

    public void menuChoices() {
        boolean running = true;
        int userChoice;
        loadMediaData("src/Data/film.txt");
        loadMediaData("src/Data/serier.txt");

        while (running) {
            ui.displayMsg(
                    "\n=== Velkommen til TemuNetflix ===" +
                            "\n1. Film" +
                            "\n2. Serier" +
                            "\n3. Sete Film" +
                            "\n4. Sete Serier" +
                            "\n5. Gemte Film" +
                            "\n6. Gemte Serier" +
                            "\n0. Afslut"
            );

            int choice = ui.readInputNum("Vælg en mulighed:");
            int counter = 0;
            switch (choice) {
                case 1:
                    ui.displayMsg("Du valgte: Film");

                    for (Media s : movies) {
                        counter++;
                        ui.displayMsg(counter+":" +s.toString());
                    }
                    userChoice = ui.readInputNum("Vælg film fra listen ovenovre")-1;
                    ui.displayMsg("Du har valgt: "+movies.get(userChoice).toString());
                    int userChoice2 = ui.readInputNum("1. Vil du se filmen nu eller 2. gemme den?");
                    if (userChoice2 == 1) {
                        ui.displayMsg("Filmen afspilles nu!");
                        user.watchedMovies.add(movies.get(userChoice));
                    } else if (userChoice2 == 2) {
                        ui.displayMsg("Filmen gemmes!");
                        user.savedMovies.add(movies.get(userChoice));
                    }
                    break;
                case 2:
                    ui.displayMsg("Du valgte: Serier");
                    for (Media s : serier) {
                        counter++;
                        ui.displayMsg(counter+":" +s.toString());
                    }

                    userChoice = ui.readInputNum("Vælg en serie fra listen") - 1;
                    ui.displayMsg("Du har valgt: "+serier.get(userChoice).toString());
                    userChoice2 = ui.readInputNum("1. Vil du se serien nu eller 2. gemme den?");

                    if (userChoice2 == 1) {
                        ui.displayMsg("Serien afspilles nu!");
                        user.watchedSeries.add((Series) serier.get(userChoice));
                    } else if (userChoice2 == 2) {
                        ui.displayMsg("Serien gemmes!");
                        user.savedSeries.add((Series) serier.get(userChoice));
                    }

                    // Opdater brugerfil
                    user.updateUserFile("src/Data/Bruger/" + StartMenu.getUsername() + ".txt");
                    break;

                case 3:
                    ui.displayMsg("Du valgte: Sete Film");
                    user.showWatchedMovies();
                    userChoice = ui.readInputNum("Vælg film fra listen ovenovre")-1;
                    if (ui.choiceYN("du har nu valgt: "+user.watchedMovies.get(userChoice)+" er det korrekt? (Y/N)")){
                        //movies.get(counter).play
                        ui.displayMsg("ser nu "+user.watchedMovies.get(userChoice));
                    }
                    break;

                case 4:
                    ui.displayMsg("Du valgte: Sete Serier");
                    user.showWatchedSeries();
                    userChoice = ui.readInputNum("Vælg film fra listen ovenovre")-1;
                    if (ui.choiceYN("du har nu valgt: "+user.watchedSeries.get(userChoice)+" er det korrekt? (Y/N)")){
                        //movies.get(counter).play
                        ui.displayMsg("ser nu "+user.watchedSeries.get(userChoice));
                    }
                    break;

                case 5:
                    ui.displayMsg("Du valgte: Gemte Film");
                    user.showSavedMovies();
                    userChoice = ui.readInputNum("Vælg film fra listen ovenovre")-1;
                    if (ui.choiceYN("du har nu valgt: "+user.savedMovies.get(userChoice)+" er det korrekt? (Y/N)")){
                        //movies.get(counter).play
                        ui.displayMsg("ser nu "+user.savedMovies.get(userChoice));
                        user.watchedMovies.add(movies.get(userChoice));
                    }
                    break;

                case 6:
                    ui.displayMsg("Du valgte: Gemte Serier");
                    user.showSavedSeries();
                    userChoice = ui.readInputNum("Vælg film fra listen ovenovre")-1;
                    if (ui.choiceYN("du har nu valgt: "+user.savedSeries.get(userChoice)+" er det korrekt? (Y/N)")){
                        ui.displayMsg("ser nu "+user.savedSeries.get(userChoice));
                        user.savedSeries.add((Series) serier.get(userChoice));
                    }
                    break;

                case 0:
                    user.updateUserFile("src/Data/Bruger/"+ StartMenu.getUsername()+".txt");
                    ui.displayMsg("Farvel og tak for denne gang!");
                    running = false;
                    break;

                default:
                    ui.displayMsg("Ugyldigt valg – prøv igen!");
                    break;
            }
        }
    }

    public void startStartMenu(){

    }
    public void loadMediaData(String path) {
        ArrayList<String> data = io.readFile(path);


        for (String line : data) {
            // Fjern evt. whitespace
            line = line.trim();
            if (line.isEmpty()) continue;

            // Split linjen op på semikolon
            String[] parts = line.split(";");

            String title = parts[0].trim();
            String year = parts[1].trim();
            String category = parts[2].trim();
            String ratingStr = parts[3].trim().replace(",", ".");
            double rating = Double.parseDouble(ratingStr);

            // Hvis linjen indeholder episodeinformation, så er det en serie
            if (parts.length > 4 && parts[4].contains("-")) {
                String activeYears = year;
                String episodeInfo = parts[4].trim();
                String[][] episodes = parseEpisodeInfo(episodeInfo);

                Series series = new Series(title, rating, category, episodes, activeYears);
                serier.add(series);
            } else {
                int releaseYear = Integer.parseInt(year);
                Movie movie = new Movie(title, rating, category, 120, releaseYear);
                movies.add(movie);
            }
        }
    }
    private String[][] parseEpisodeInfo(String episodeInfo) {
        // Eksempel på format: "1-10, 2-10, 3-13"
        String[] seasons = episodeInfo.split(",");
        String[][] episodes = new String[seasons.length][];

        for (int i = 0; i < seasons.length; i++) {
            String s = seasons[i].trim();
            String[] parts = s.split("-");
            int seasonNumber = Integer.parseInt(parts[0]);
            int episodeCount = Integer.parseInt(parts[1]);
            episodes[i] = new String[episodeCount];
            for (int j = 0; j < episodeCount; j++) {
                episodes[i][j] = "S" + seasonNumber + "E" + (j + 1);
            }
        }

        return episodes;
    }
}
