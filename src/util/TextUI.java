package util;
import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private static Scanner scan;

    public void displayMsg(String msg) {
        System.out.println();
    }

    public int readInputNum(String msg) {
        this.displayMsg(msg);
        String input = scan.nextLine();
        int numInput = Integer.parseInt(input);
        return numInput;
    }

    public String readInputText(String msg) {
        this.displayMsg(msg);
        String input = scan.nextLine();
        return input;
    }

    public boolean choiceYN(String msg) {
        this.displayMsg(msg);
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return input.equalsIgnoreCase("N") ? false : this.choiceYN(msg);
        }
    }
}
