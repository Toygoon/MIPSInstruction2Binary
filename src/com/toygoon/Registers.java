package com.toygoon;

public class Registers {
    private static final String[] REG_NUMS = {"$0", "$1", "$2", "$3", "$4",
            "$5", "$6", "$7", "$8", "$9"};
    private static final String[] REG_BINS = {"00000", "00001", "00010", "00011",
            "00101", "00110", "00111", "01000", "01001"};

    public static String getRegBinary(String reg) {
        for(int i=0; i<REG_NUMS.length; i++) {
            if(reg.equals(REG_NUMS[i]))
                return REG_BINS[i];
        }

        return null;
    }
}
