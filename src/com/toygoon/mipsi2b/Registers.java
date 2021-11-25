package com.toygoon.mipsi2b;

public class Registers {
    private static final String[] REG_NUMS = {"$0", "$1", "$2", "$3", "$4",
            "$5", "$6", "$7", "$8", "$9"};
    private static final String[] REG_BINS = {"00000", "00001", "00010", "00011", "00100",
            "00101", "00110", "00111", "01000", "01001"};
    private static final int[] INIT_VALS = {0, 9, 8, 7,
            1, 2, 3, 4, 5, 6};

    public static String getRegBin(String reg) {
        for(int i=0; i<REG_NUMS.length; i++) {
            if(reg.equals(REG_NUMS[i]))
                return REG_BINS[i];
        }

        return null;
    }

    public static String getRegNum(String reg) {
        for(int i=0; i<REG_BINS.length; i++) {
            if(reg.equals(REG_BINS[i]))
                return REG_NUMS[i];
        }

        return null;
    }

    public static int getInitVal(String reg) {
        for(int i=0; i<REG_BINS.length; i++) {
            if(reg.equals(REG_BINS[i]))
                return INIT_VALS[i];
        }

        for(int i=0; i<REG_NUMS.length; i++) {
            if(reg.equals(REG_NUMS[i]))
                return INIT_VALS[i];
        }

        return 0;
    }

}
