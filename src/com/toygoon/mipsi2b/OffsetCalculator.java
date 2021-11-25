package com.toygoon.mipsi2b;

import java.util.Arrays;

public class OffsetCalculator {

    /* hexToBin returns given offset to 16-bit extended binary value. */
    public String hexToBin(String offset) {
        offset = offset.toUpperCase();
        offset = offset.replaceAll("0X", "");
        String binary = Integer.toBinaryString(Integer.parseInt(offset, 16));

        int length = binary.length();

        if(length < 16) {
            for(int i=length; i<16; i++)
                binary = "0" + binary;
        }

        return binary;
    }

    /* splitOffset splits the offset and base register into the String array. */
    public String[] splitOffset(String reg) {
        int lparen = reg.indexOf("(");
        int rparen = reg.indexOf(")");

        String[] offset = new String[2];
        Arrays.fill(offset, "");

        // If lparen is not existed, it doesn't need to split the String.
        if(lparen != -1) {
            // Offset value is before the lparen.
            for(int i=0; i<lparen; i++) {
                offset[0] += reg.charAt(i);
            }

            // Base register is after the lparen.
            for(int i=lparen+1; i<rparen; i++) {
                offset[1] += reg.charAt(i);
            }

            return offset;
        }

        return null;
    }

}
