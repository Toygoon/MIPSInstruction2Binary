package com.toygoon.mipsi2b;

import java.util.ArrayList;

public class InputArrayType {
    private ArrayList<String> inputList;
    private String[] inputArray;
    private String extraStatus;
    private boolean isBinaryInst;

    public InputArrayType() {
        this.inputList = null;
        this.inputArray = null;
        this.extraStatus = null;
        this.isBinaryInst = false;
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

    public void setBinaryInst(boolean b) {
        this.isBinaryInst = b;
    }

    public boolean isBinaryInst() {
        return this.isBinaryInst;
    }
}
