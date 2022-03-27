package Main;

import Chesses.Piece;
import java.util.ArrayList;

public class TableForGame {
    public static GUI visionGUI = new GUI();
    public static Piece[][] table = new Piece[8][8];

    public static void inputTable(ArrayList<Piece> chessArrayList) {

        for(Piece chess : chessArrayList) {
            table[chess.address()[0]][chess.address()[1]] = chess;
        }
    }
}
