package com.toygoon.mipsi2b;

import java.util.Arrays;

public class OffsetCalculator {

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

    public String[] splitOffset(String reg) {
        int lparen = reg.indexOf("(");
        int rparen = reg.indexOf(")");
        String[] offset = new String[2];
        Arrays.fill(offset, "");

        if(lparen != -1) {
            for(int i=0; i<lparen; i++) {
                offset[0] += reg.charAt(i);
            }

            for(int i=lparen+1; i<rparen; i++) {
                offset[1] += reg.charAt(i);
            }

            return offset;
        }

        return null;
    }

}
