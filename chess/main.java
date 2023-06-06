package chess;

import chess.cli.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input '' -console '' to play using the console");
        System.out.println("Anything else inputted, and you play with the GUI");
        if (sc.nextLine() == "-console") {
            ChessConsole myGame = new ChessConsole();
            myGame.play();
        }else{
            new ChessUI();
        }
    }
}
