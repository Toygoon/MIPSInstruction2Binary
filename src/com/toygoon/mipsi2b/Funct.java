package com.toygoon.mipsi2b;

public class Funct {
    private static final String[] FUNCT_INSTS = {"add", "and", "or", "sub", "slt"};
    private static final String[] FUNCT_VALUES = {"100000", "100100", "100101", "100010", "101010"};

    /* getFunctBin returns its binary code from the funct.*/
    public static String getFunctBin(String funct) {
        for(int i=0; i<FUNCT_INSTS.length; i++) {
            if(funct.equals(FUNCT_INSTS[i]))
                return FUNCT_VALUES[i];
        }

        return null;
    }

    /* getAllFuncts returns all supported R type instructions from this application. */
    public static String[] getAllFuncts() {
        return FUNCT_INSTS;
    }
}
