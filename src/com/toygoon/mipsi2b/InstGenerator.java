package com.toygoon.mipsi2b;

import static com.toygoon.mipsi2b.Funct.*;
import static com.toygoon.mipsi2b.OpCodes.*;
import static com.toygoon.mipsi2b.Registers.*;

public class InstGenerator {
    private InputArrayType iat;
    private boolean isItype;

    public InstGenerator(InputArrayType iat) {
        this.iat = iat;
        this.isItype = false;
    }

    /* generateInst generates binary instruction to ASM instruction sequence. */
    public String generateInst() {
        String inst = "";
        String bin = iat.getExtraStatus();
        String op_code = bin.substring(0, 6);
        isItype = isBinaryItype(op_code);

        if(isItype) {
            // Retrieving op_code
            op_code = getOpStr(op_code);
            inst += op_code + " ";
            // Adding rs
            inst += getRegStr(bin.substring(11, 16)) + ", ";
            int offset = 0;

            // Parsing offset
            if(op_code.equals("lw") || op_code.equals("sw")) {
                try {
                    offset = Integer.parseInt(bin.substring(16, 32), 2);
                } catch (Exception e) {

                }
                if(offset != 0)
                    inst += "0x" + Integer.toHexString(offset) + "(";
            }

            // Adding rt
            inst += getRegStr(bin.substring(6, 11));

            // Close rparen if offset exists
            if(offset != 0)
                inst += ")";

            // Adding immediate constants if its instruction is 'addi' or 'andi'.
            if(op_code.equals("addi") || op_code.equals("andi"))
                inst += ", " + Integer.parseInt(bin.substring(16, 32), 2);
        } else {
            // Adding funct
            inst += getFunctStr(bin.substring(26, 32)) + " ";

            // Adding rd
            inst += getRegStr(bin.substring(16, 21)) + ", ";

            // Adding rs
            inst += getRegStr(bin.substring(6, 11)) + ", ";

            // Adding rt
            inst += getRegStr(bin.substring(11, 16));
        }

        return inst;
    }
}
