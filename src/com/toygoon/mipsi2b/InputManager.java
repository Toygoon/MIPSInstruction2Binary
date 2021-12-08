package com.toygoon.mipsi2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.toygoon.mipsi2b.Funct.*;
import static com.toygoon.mipsi2b.OpCodes.*;
import static com.toygoon.mipsi2b.Registers.*;

public class InputManager {
    /* splitNormal decodes the instruction sequence which isn't simple condition. */
    public static String[] splitNormal(String input) {
        String[] splitResult = null;
        String detectedInst = null;

        // Checks it has a opcode.
        for(String s : getAllOps()) {
            if (input.toLowerCase().contains(s))
                detectedInst = s;
        }

        // Checks it has a funct.
        for(String s : getAllFuncts()) {
            if (input.toLowerCase().contains(s))
                detectedInst = s;
        }

        String rimm = "";
        for(int i=0; i<4; i++)
            rimm += input.charAt(i);

        if(rimm.equals("addi"))
            detectedInst = "addi";
        if(rimm.equals("andi"))
            detectedInst = "andi";

        // If it's not detected, returns.
        if(detectedInst == null)
            return null;

        // Replace all texts into the lower case, and removes op or funct string from the full string.
        input = input.toLowerCase().replaceAll(detectedInst, "");
        input = input.replaceAll("\\s+", "");
        if (rimm.equals("addi") || rimm.equals("andi")) {
            // addi, subi uses 3 registers
            splitResult = new String[4];

            // The index in 0 is always funct
            splitResult[0] = detectedInst;

            // Checking it's valid instruction sequence.
            if(input.indexOf(",") == -1 && input.indexOf("$") == -1)
                return null;

            // Adding 3 registers.
            for(int i=1; i<4; i++) {
                if (i == 3) {
                    splitResult[3] = input;
                    break;
                }
                int commaIndex = input.indexOf(",");
                int cacheIndex = input.indexOf("$");

                String tmp = "";
                for (int j = cacheIndex; j < commaIndex; j++) {
                    tmp += input.charAt(j);
                }

                splitResult[i] = tmp;
                input = new StringBuilder(input).delete(cacheIndex, commaIndex + 1).toString();
            }
        } else if (isItype(detectedInst)) {
            // I type decoding
            splitResult = new String[3];

            // The index in 0 is always opcode
            splitResult[0] = detectedInst;
            int commaIndex = input.indexOf(",");
            int cacheIndex = input.indexOf("$");

            // Checking it's valid instruction sequence.
            if(commaIndex == -1 || cacheIndex == -1)
                return null;

            // First parameter matches the rt field.
            String tmp = "";
            for(int i=cacheIndex; i<commaIndex; i++)
                tmp += input.charAt(i);

            splitResult[1] = tmp;
            // Last strings matches the rs field.
            splitResult[2] = new StringBuilder(input).delete(0, splitResult[1].length()+1).toString();
        } else {
            // R type decoding.
            splitResult = new String[4];

            // The index in 0 is always funct
            splitResult[0] = detectedInst;

            // Checking it's valid instruction sequence.
            if(input.indexOf(",") == -1 && input.indexOf("$") == -1)
                return null;

            // Adding 3 registers.
            for(int i=1; i<4; i++) {
                if(i == 3) {
                    splitResult[3] = input;
                    break;
                }
                int commaIndex = input.indexOf(",");
                int cacheIndex = input.indexOf("$");

                String tmp = "";
                for(int j=cacheIndex; j<commaIndex; j++) {
                    tmp += input.charAt(j);
                }

                splitResult[i] = tmp;
                input = new StringBuilder(input).delete(cacheIndex, commaIndex+1).toString();
            }
        }

        return splitResult;
    }

    public static InputArrayType inputText() {
        InputArrayType iat = new InputArrayType();
        Scanner s = new Scanner(System.in);

        System.out.print("> ");
        // User input from here.
        String input = s.nextLine();
        iat.setExtraStatus(input);
        char binChecker = input.charAt(0);

        if(input.equals("exit"))
            return iat;

        // Checking if binary instructions
        if((binChecker == '0' || binChecker == '1') && input.length() == 32) {
            iat.setBinaryInst(true);
            return iat;
        }

        String[] splitInput = null;
        // Splits the String with space to the String array.
        try {
            splitInput = splitNormal(input);
        } catch (Exception e) {
        }

        if(splitInput == null) {
            iat.setExtraStatus("invalid");

            return iat;
        }

        ArrayList<String> separated = new ArrayList<>();
        for(int i=0; i<splitInput.length; i++) {
            // Comma should be deleted.
            splitInput[i] = splitInput[i].replaceAll(",", "");
            separated.add(splitInput[i]);
        }

        iat.setInputArray(splitInput);
        iat.setInputList(separated);
        return iat;
    }
}
