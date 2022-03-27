package Main.ActiontButtonHelper;

import Chesses.*;
import Main.*;
import java.util.ArrayList;

public class Check {
    public static String check() {
        String danger = null;
        Color originalGoColor = GoColorControl.goColor;

        ArrayList<Piece> chessArrayListCopy = new ArrayList<>(CreateArrayChess.chessArrayList);

        OUT:
        for(Piece chess : chessArrayListCopy) {
            for(int q = 0; q < TableForGame.table.length; q++) {
                for(int w = 0; w < TableForGame.table[q].length; w++) {

                    if (chess.color == Color.WHITE) {
                        GoColorControl.goColor = Color.WHITE;
                    } else {
                        GoColorControl.goColor = Color.BLACK;
                    }

                    if(ActionGo.canGo(chess.numAddress, chess.charAddress, q, w)) {
                        for(Piece chess2 : CreateArrayChess.chessArrayList) {
                            if(chess2.numAddress == q && chess2.charAddress == w &&
                                    chess2 instanceof King && chess2.color != chess.color)
                            {

                                if (originalGoColor != chess2.color) {
                                    danger = "errorStepKingDanger";
                                    break OUT;
                                } else {
                                    danger = chess2.color.toString();
                                }
                            }
                        }
                    }
                }
            }
        }

        GoColorControl.goColor = originalGoColor;
        return danger;
    }
}
