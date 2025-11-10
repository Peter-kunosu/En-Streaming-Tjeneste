public class Main {
    public static void main(String[] args) {
        TemuNetflix netflix = new TemuNetflix();
        netflix.loadMediaData("src/Data/serier.txt");
        System.out.println(netflix.media.get(0));
        //netflix.ui.displayMsg(String.format(netflix.media.get(0).toString()));
    }
}