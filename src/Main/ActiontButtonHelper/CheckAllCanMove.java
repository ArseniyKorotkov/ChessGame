package Main.ActiontButtonHelper;

import Chesses.Piece;
import Main.*;

import java.util.ArrayList;

public class CheckAllCanMove {
    public static boolean can = true;
    static String getMessage;
    static String getGoWalk;
    static String getGoColor;
    static boolean kill = false;

    public static boolean ifCan() {

        getMessage = TableForGame.visionGUI.squareMassage.getText();
        getGoWalk = TableForGame.visionGUI.goWalk.getText();
        getGoColor = "go" + GoColorControl.goColor.name();

        ArrayList<Piece> chessArrayListCopy = new ArrayList<>(CreateArrayChess.chessArrayList);

        OUT:
        for(Piece chess : chessArrayListCopy) {
            int reserveNumAddress = chess.numAddress;
            int reserveCharAddress = chess.charAddress;
            for (int q = 0; q < TableForGame.table.length; q++) {
                for (int w = 0; w < TableForGame.table[q].length; w++) {
                    if(ActionGo.canGo(chess.numAddress, chess.charAddress, q, w)) {

                        chess.numAddress = q;
                        chess.charAddress = w;

                        if(TableForGame.table[q][w] != null) {
                            kill = true;
                            CreateArrayChess.deathList.add(0, TableForGame.table[q][w]);
                            CreateArrayChess.chessArrayList.remove(TableForGame.table[q][w]);
                            TableForGame.table[q][w] = null;
                        }

                        if (GoColorControl.goColor == Color.WHITE) {
                            GoColorControl.goColor = Color.BLACK;
                        } else {
                            GoColorControl.goColor = Color.WHITE;
                        }

                        String check = Check.check();

                        if (GoColorControl.goColor == Color.WHITE) {
                            GoColorControl.goColor = Color.BLACK;
                        } else {
                            GoColorControl.goColor = Color.WHITE;
                        }

                        if(kill) {
                            kill = false;
                            TableForGame.table[q][w] = CreateArrayChess.deathList.get(0);
                            CreateArrayChess.chessArrayList.add(CreateArrayChess.deathList.get(0));
                            CreateArrayChess.deathList.remove(0);

                        }

                        if(check != null && check.equals("errorStepKingDanger")) {
                            can = false;
                            chess.numAddress = reserveNumAddress;
                            chess.charAddress = reserveCharAddress;
                            TableForGame.visionGUI.attackIs.setText(chess.color.toString());
                            TableForGame.visionGUI.goWalk.setText("rest");
                            TableForGame.visionGUI.squareMassage.setText("NoStep");
                        } else {
                            can = true;
                            chess.numAddress = reserveNumAddress;
                            chess.charAddress = reserveCharAddress;
                            TableForGame.visionGUI.attackIs.setText(getGoColor);
                            TableForGame.visionGUI.goWalk.setText(getGoWalk);
                            TableForGame.visionGUI.squareMassage.setText(getMessage);
                            break OUT;
                        }
                    }
                }
            }
        }
        return can;
    }
}

