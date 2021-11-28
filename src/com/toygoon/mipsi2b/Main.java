package com.toygoon.mipsi2b;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        InputManager im = new InputManager();
        SaveManager sm = new SaveManager();

        while(true) {
            InputArrayType iat = im.inputText();

            if(iat.getExtraStatus().equals("exit")) {
                break;
            } else if (iat.getExtraStatus().equals("invalid")) {
                System.out.println("* Invalid Command.");
            } else {
                BinaryGenerator bg = new BinaryGenerator(iat.getInputList());
                String generated = bg.generateBin();

                if (generated.contains("null")) {
                    System.out.println("* Invalid Register(s).");
                } else {
                    System.out.println(generated);
                    sm.appendData(generated);
                }
            }
        }
    }
}
