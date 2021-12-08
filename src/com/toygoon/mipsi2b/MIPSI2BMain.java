package com.toygoon.mipsi2b;

public class MIPSI2BMain {
    public static void main(String[] args) throws Exception {
        InputManager im = new InputManager();
        SaveManager sm = new SaveManager();

        while(true) {
            InputArrayType iat = im.inputText();

            if(iat.getExtraStatus().equals("exit")) {
                break;
            } else if (iat.getExtraStatus().equals("invalid")) {
                System.out.println("* Invalid Command.");
            } else if (iat.isBinaryInst()) {
                // Binary to instruction sequence
                InstGenerator ig = new InstGenerator(iat);
                String generated = ig.generateInst();

                if (generated.contains("null"))
                    System.out.println("* Invalid Binary.");
                else
                    System.out.println(generated);
            } else {
                // Instruction sequence to binary
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
