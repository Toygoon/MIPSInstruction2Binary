package com.toygoon.mipsi2b;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        InputManager im = new InputManager();
        SaveManager sm = new SaveManager();

        while(true) {
            ArrayList<String> input = im.inputText();
            if(input == null)
                break;

            BinaryGenerator bg = new BinaryGenerator(input);

            String generated = bg.generateBin();

            System.out.println(generated);
            sm.appendData(generated);
        }
    }
}
