/* MIPSInstruction2Binary
 *
 * @author Lim Jung Min,
 * Department of Computer Engineering, Yeungnam University.
 */

package com.toygoon.mipsi2b;

import java.util.ArrayList;

public class BinaryGenerator {
    /* String[] inst saves all 4~6 registers into the array.
    * inst[0] : opcode
    * inst[1] : rs
    * inst[2] : rt
    * inst[3] : rd
    * inst[4] : shamt
    * inst[5] : func */
    private String[] inst;

    // ArrayList<String> input gets the input from the user.
    private ArrayList<String> input;

    /* String[] regs saves rs, rt, rd registers.
    * regs[0] : rs
    * regs[1] : rt
    * regs[2] : rd */
    private String[] regs;

    private String op_code = "";
    private OpCodes ocInstance = new OpCodes();
    private Registers regInstance = new Registers();
    private Funct functInstance = new Funct();
    private OffsetCalculator offsetCalculator = new OffsetCalculator();
    private final String SHAMT = "00000";

    public boolean isItype = false;

    /* The constructor of BinaryGenerator initializes input, op_code, regs. */
    public BinaryGenerator(ArrayList<String> input) {
        this.input = input;

        // input[0] is always opcode.
        op_code = this.input.get(0);
        int reg_counts;
        isItype = ocInstance.isItype(op_code);

        // I type uses 4 fields, and R type uses 6 fields total.
        // I type doesn't need rd register, so reg_counts are -1
        if (op_code.equals("addi") || op_code.equals("andi")) {
            inst = new String[4];
            reg_counts = 3;
        } else if(isItype) {
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

    /* generateBin() returns full instruction sequence. */
    public String generateBin() {
        String binary = "";
        // Using getOpBinary method to convert the binary values of op_code.
        inst[0] = ocInstance.getOpBin(op_code);


        // Converting only I, R type instructions
        if (op_code.equals("addi") || op_code.equals("andi")) {
            /* addi, andi instructions have some differences with lw(sw).
            * regs[0] : rt
            * regs[1] : rs
            * regs[2] : Immediate constant values */
            inst[1] = regInstance.getRegBin(regs[1]);
            inst[2] = regInstance.getRegBin(regs[0]);
            inst[3] = offsetCalculator.signExtends(regs[2]);
        } else if (isItype) {
            String baseStr, offsetStr;
            /* regs[1] is from the MIPS code sequence.
            * It needs to be separated to two values, offset and base register.
            * regOffsets[0] : offset
            * regOffsets[1] : base register */
            String[] regOffsets = offsetCalculator.splitOffset(regs[1]);
            if(regOffsets == null) {
                // The case it doesn't include the offset values.
                baseStr = regs[1];
                offsetStr = "0";
            } else {
                baseStr = regOffsets[1];
                offsetStr = regOffsets[0];
            }

            // getRegBin returns the binary values which matches the given register.
            inst[1] = regInstance.getRegBin(baseStr);
            inst[2] = regInstance.getRegBin(regs[0]);
            // Because it's I type, immediate field is 16-bit binary code.
            inst[3] = offsetCalculator.hexToBin(offsetStr);
        } else {
            inst[1] = regInstance.getRegBin(regs[1]);
            inst[2] = regInstance.getRegBin(regs[2]);
            inst[3] = regInstance.getRegBin(regs[0]);
            // shamt is unused.
            inst[4] = SHAMT;
            inst[5] = functInstance.getFunctBin(op_code);
        }

        for(int i=0; i<inst.length; i++)
            binary += inst[i];

        return binary;
    }
}
