package com.toygoon;

import java.util.ArrayList;

public class BinaryGenerator {
    private ArrayList<String> input = new ArrayList<>();
    private String[] inst;
    private String op_code = "";
    private String[] regs;

    public boolean isItype = false;
    private OpCodes ocInstance = new OpCodes();
    private Registers regInstance = new Registers();
    private OffsetCalculator offsetCalculator = new OffsetCalculator();

    public BinaryGenerator(ArrayList<String> input) {
        this.input = input;

        op_code = this.input.get(0);

        int reg_counts;
        isItype = ocInstance.isItype(op_code);
        if(isItype) {
            inst = new String[4];
            reg_counts = 2;
        } else {
            inst = new String[6];
            reg_counts = 3;
        }

        regs = new String[reg_counts];
        for(int i=0; i<reg_counts; i++)
           regs[i] = this.input.get(1+i);
    }

    public String generateBin() {
        String binary = "";
        inst[0] = ocInstance.getOpBinary(op_code);

        if(isItype) {
            String baseStr, offsetStr;
            String[] regOffsets = offsetCalculator.splitOffset(regs[1]);
            baseStr = regOffsets[1];
            offsetStr = regOffsets[0];

            inst[1] = regInstance.getRegBin(baseStr);
            inst[2] = regInstance.getRegBin(regs[0]);
            inst[3] = offsetCalculator.hexToBin(offsetStr);
        } else {
        }

        for(int i=0; i<inst.length; i++)
            binary += inst[i];

        return binary;
    }
}
