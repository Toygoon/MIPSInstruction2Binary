package com.toygoon;

import java.util.ArrayList;

public class BinaryGenerator {
    private ArrayList<String> input = new ArrayList<>();
    private String[] inst = new String[6];
    private String op_code = "";
    private String[] regs;

    public boolean isItype = false;
    private OpCodes ocInstance = new OpCodes();
    private Registers regInstance = new Registers();

    public BinaryGenerator(ArrayList<String> input) {
        this.input = input;

        op_code = this.input.get(0);

        int reg_counts;
        isItype = ocInstance.isItype(op_code);
        if(isItype)
            reg_counts = 2;
        else
            reg_counts = 3;

        regs = new String[reg_counts];
        for(int i=0; i<reg_counts; i++)
           regs[i] = this.input.get(1+i);
    }

    public void generateBin() {
        inst[0] = ocInstance.getOpBinary(op_code);

        if(isItype) {
            System.out.println(regs[2]);
        } else {
        }
    }
}
