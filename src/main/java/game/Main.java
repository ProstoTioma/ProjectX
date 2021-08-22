package game;

import graphics.Screen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        new Screen(1920, 1080).gameLoop();
    }
}
