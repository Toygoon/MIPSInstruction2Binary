package com.toygoon.mipsi2b;

import java.util.ArrayList;

public class InputArrayType {
    public static enum instType {I_TYPE, R_TYPE};
    private boolean isValidInst;
    private ArrayList<String> inputList;
    private String[] inputArray;
    private String extraStatus;

    public InputArrayType() {
        this.isValidInst = false;
        this.inputList = null;
        this.inputArray = null;
        this.extraStatus = null;
    }

    public void setValid(boolean set) {
        this.isValidInst = set;
    }

    public boolean getValid() {
        return this.isValidInst;
    }

    public void setInputArray(String[] input) {
        this.inputArray = input;
    }

    public String[] getInputArray() {
        return this.inputArray;
    }

    public void setInputList(ArrayList<String> input) {
        this.inputList = input;
    }

    public ArrayList<String> getInputList() {
        return this.inputList;
    }

    public void setExtraStatus(String stat) {
        this.extraStatus = stat;
    }

    public String getExtraStatus() {
        return this.extraStatus;
    }

    public void initList() {
        this.inputList = new ArrayList<>();
    }

    public void initArray(int n) {
        this.inputArray = new String[n];
    }
}
