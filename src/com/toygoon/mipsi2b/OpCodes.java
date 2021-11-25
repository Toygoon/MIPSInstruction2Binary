package com.toygoon.mipsi2b;

public class OpCodes {
    // Opcode values are defined below.
    // The indexes of OP_CODES and OP_VALUES are matched each other.
    private static final String[] OP_CODES = {"lw", "sw", "addi", "andi"};
    private static final String[] OP_VALUES = {"100011", "101011", "001000", "001100"};
    private static final String R_TYPE_INST = "000000";

    /* isItype checks its opcode is I type. */
    public static boolean isItype(String op) {
        for(String s : OP_CODES) {
            if(s.equals(op))
                return true;
        }

        return false;
    }

    /* getOpBinary returns its binary code from the opcode.*/
    public static String getOpBin(String op) {
        for(int i=0; i<OP_CODES.length; i++) {
            if(op.equals(OP_CODES[i]))
                return OP_VALUES[i];
        }

        return R_TYPE_INST;
    }
}
