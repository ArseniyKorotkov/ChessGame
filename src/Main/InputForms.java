package Main;

import Chesses.Piece;
import javax.swing.*;

public class InputForms {
    public static void see(GUI gui, Piece[][] tableForGame) {

        int countArraySquare = 0;

        Icon blackSquare = new ImageIcon("Images/blackSquare.png");
        Icon whiteSquare = new ImageIcon("Images/whiteSquare.png");

        for(int q = 0; q < tableForGame.length; q++) {
            for(int w = 0; w < tableForGame[q].length; w++ ) {
                if(tableForGame[q][w] ==  null) {
                    if((q - w) % 2 == 0) {
                        gui.square.get(countArraySquare).setIcon(whiteSquare);
                    } else {
                        gui.square.get(countArraySquare).setIcon(blackSquare);
                    }
                } else {
                    if((q - w) % 2 == 0) {
                        gui.square.get(countArraySquare).setIcon(tableForGame[q][w].faceWhite);
                    } else {
                        gui.square.get(countArraySquare).setIcon(tableForGame[q][w].faceBlack);
                    }
                }
                countArraySquare++;
            }
        }
    }
}
