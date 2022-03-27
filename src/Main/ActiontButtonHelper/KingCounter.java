package Main.ActiontButtonHelper;

import Chesses.Piece;
import Chesses.King;
import Main.CreateArrayChess;

public class KingCounter {
    public static int countKing() {
        int kingCount = 0;
        for(Piece chess : CreateArrayChess.chessArrayList) {
            if(chess instanceof King) {
                kingCount++;
            }
        }
        return kingCount;
    }
}
