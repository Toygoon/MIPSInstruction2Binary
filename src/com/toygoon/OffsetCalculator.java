package com.toygoon;

public class OffsetCalculator {
    public String[] splitOffset(String reg) {
        int lparen = reg.indexOf("(");
        int rparen = reg.indexOf(")");
        String[] offset = new String[2];

        if(lparen != -1) {
            for(int i=0; i<lparen; i++) {
                offset[0] += reg.charAt(i);
            }

            for(int i=lparen; i<rparen; i++) {
                offset[1] += reg.charAt(i);
            }

            return offset;
        }

        return null;
    }
}
