package com.toygoon.mipsi2b;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    public static ArrayList<String> inputText() {
        Scanner s = new Scanner(System.in);
        System.out.print("> ");
        String input = s.nextLine();
        String[] splitInput = input.split(" ");

        ArrayList<String> separated = new ArrayList<>();
        for(int i=0; i<splitInput.length; i++) {
            splitInput[i] = splitInput[i].replaceAll(",", "");
            separated.add(splitInput[i]);
        }
        return separated;
    }
}
