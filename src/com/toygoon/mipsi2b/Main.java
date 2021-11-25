package com.toygoon.mipsi2b;

public class Main {

    public static void main(String[] args) {
        InputManager im = new InputManager();
        BinaryGenerator bg = new BinaryGenerator(im.inputText());
        System.out.println(bg.generateBin());
    }
}
