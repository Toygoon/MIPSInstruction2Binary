package com.toygoon;

public class Main {

    public static void main(String[] args) {
        InputManager im = new InputManager();
        BinaryGenerator bg = new BinaryGenerator(im.inputText());
        bg.generateBin();
    }
}
