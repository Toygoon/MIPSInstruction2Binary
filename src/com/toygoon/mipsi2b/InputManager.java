package com.toygoon.mipsi2b;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    public static boolean isSaving() {
        Scanner s = new Scanner(System.in);
        System.out.println(">> Do you want to save to the file? (y or n)");
        System.out.print("> ");
        String input = s.nextLine();
        input.toLowerCase();

        if(input.contains("y"))
            return true;

        return false;
    }

    public static ArrayList<String> inputText() {
        Scanner s = new Scanner(System.in);

        System.out.print("> ");
        // User input from here.
        String input = s.nextLine();

        if(input.equals("exit"))
            return null;

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
