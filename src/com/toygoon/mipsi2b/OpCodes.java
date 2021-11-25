package com.toygoon.mipsi2b;

public class OpCodes {
    private static final String[] OP_CODES = {"lw", "sw", "addi", "andi"};
    private static final String[] OP_VALUES = {"100011", "101011", "001000", "001100"};
    private static final String R_TYPE_INST = "000000";

    public static boolean isItype(String op) {
        for(String s : OP_CODES) {
            if(s.equals(op))
                return true;
        }

        return false;
    }

    public static String getOpBinary(String op) {
        for(int i=0; i<OP_CODES.length; i++) {
            if(op.equals(OP_CODES[i]))
                return OP_VALUES[i];
        }

        return R_TYPE_INST;
    }
}
