package Main.ActiontButtonHelper;

import Chesses.King;
import Chesses.Pawn;
import Chesses.Piece;
import Main.*;

public class ActionGoHelper {
    public static void help(int[] addresses) {
        TableForGame.table[addresses[0]][addresses[1]] = null;

        for(Piece chess : CreateArrayChess.chessArrayList) {
            if(chess.numAddress == addresses[0] && chess.charAddress == addresses[1]) {
                //step piece
                chess.numAddress = addresses[2];
                chess.charAddress = addresses[3];
                TableForGame.table[chess.numAddress][chess.charAddress] = chess;

                //rogue help step Rook
                if(chess instanceof King && addresses[1] == addresses[3] - 2) {
                    for(Piece chess2 : CreateArrayChess.chessArrayList) {
                        if(chess2.numAddress == chess.numAddress  && chess2.charAddress == 7) {
                            TableForGame.table[chess2.numAddress][7] = null;
                            chess2.charAddress = chess.charAddress - 1;
                            TableForGame.table[chess2.numAddress][chess2.charAddress] = chess2;
                        }
                    }
                } else if(chess instanceof King && addresses[1] == addresses[3] + 2) {
                    for(Piece chess2 : CreateArrayChess.chessArrayList) {
                        if(chess2.numAddress == chess.numAddress  && chess2.charAddress == 0) {
                            TableForGame.table[chess2.numAddress][0] = null;
                            chess2.charAddress = chess.charAddress + 1;
                            TableForGame.table[chess2.numAddress][chess2.charAddress] = chess2;
                        }
                    }
                }
                break;
            }
        }

        if (GoColorControl.goColor == Color.WHITE) {
            GoColorControl.goColor = Color.BLACK;
        } else {
            GoColorControl.goColor = Color.WHITE;
        }

        TableForGame.visionGUI.squareMassage.setText("");
        TableForGame.visionGUI.addressNew.setText("");
        TableForGame.visionGUI.addressThis.setText("");
    }
}
