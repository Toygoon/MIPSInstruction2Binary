package com.toygoon.mipsi2b;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    public static ArrayList<String> inputText() {
        Scanner s = new Scanner(System.in);

        System.out.print("> ");
        // User input from here.
        String input = s.nextLine();

        // Splits the String with space to the String array.
        String[] splitInput = input.split(" ");
        ArrayList<String> separated = new ArrayList<>();
        for(int i=0; i<splitInput.length; i++) {
            // Comma should be deleted.
            splitInput[i] = splitInput[i].replaceAll(",", "");
            separated.add(splitInput[i]);
        }
        return separated;
    }
}
