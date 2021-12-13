/* MIPSInstruction2Binary
 *
 * @author Lim Jung Min,
 * Department of Computer Engineering, Yeungnam University.
 */

package com.toygoon.mipsi2b;

public class Registers {
    // Register values are defined below.
    // The indexes of OP_CODES and OP_VALUES are matched each other.
    private static final String[] REG_NUMS = {"$0", "$1", "$2", "$3", "$4", "$5", "$6", "$7", "$8", "$9"};
    private static final String[] REG_BINS = {"00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000", "01001"};
    private static final int[] INIT_VALS = {0, 9, 8, 7, 1, 2, 3, 4, 5, 6};

    /* getRegBin returns its binary code from the register address.*/
    public static String getRegBin(String reg) {
        for(int i=0; i<REG_NUMS.length; i++) {
            if(reg.equals(REG_NUMS[i]))
                return REG_BINS[i];
        }

        return null;
    }

    /* getRegStr returns its register string from the binary code.*/
    public static String getRegStr(String reg) {
        for(int i=0; i<REG_BINS.length; i++) {
            if(reg.equals(REG_BINS[i]))
                return REG_NUMS[i];
        }

        return null;
    }

    /* getRegNum returns its register address from the binary code.*/
    public static String getRegNum(String reg) {
        for(int i=0; i<REG_BINS.length; i++) {
            if(reg.equals(REG_BINS[i]))
                return REG_NUMS[i];
        }

        return null;
    }

    /* getInitVal returns its initiated values of memory. */
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

    /* getAllRegs returns all supported registers from this application. */
    public static String[] getAllRegs() {
        return REG_NUMS;
    }

}
