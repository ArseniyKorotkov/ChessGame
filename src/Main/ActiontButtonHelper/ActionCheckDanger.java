package Main.ActiontButtonHelper;

import Chesses.Piece;
import Main.CreateArrayChess;
import Main.GoColorControl;
import Main.TableForGame;

public class ActionCheckDanger {
    public static void goGo(int[] addresses, boolean killNow) {
        String checkDanger = Check.check();
        try {
            if(checkDanger.equals("errorStepKingDanger")) {
                for(Piece chess : CreateArrayChess.chessArrayList) {
                    if(chess.numAddress == addresses[2] && chess.charAddress == addresses[3]) {
                        chess.numAddress = addresses[0];
                        chess.charAddress = addresses[1];
                        GoColorControl.goColor = chess.color;
                        TableForGame.visionGUI.attackIs.setText("go" + GoColorControl.goColor.name());
                        TableForGame.table[chess.numAddress][chess.charAddress] = chess;
                        if(killNow) {
                            TableForGame.table[CreateArrayChess.deathList.get(0).numAddress]
                                    [CreateArrayChess.deathList.get(0).charAddress] = CreateArrayChess.deathList.get(0);
                            CreateArrayChess.chessArrayList.add(CreateArrayChess.deathList.get(0));
                            CreateArrayChess.deathList.remove(0);
                        } else {
                            TableForGame.table[addresses[2]][addresses[3]] = null;
                        }
                        break;
                    }
                }
                TableForGame.visionGUI.squareMassage.setText("danStep");
            } else {
                TableForGame.visionGUI.squareMassage.setText("check" + checkDanger);
            }
        } catch (Exception exception) {
            if(TableForGame.visionGUI.squareMassage.getText().equals("check" + checkDanger)) {
                TableForGame.visionGUI.squareMassage.setText("");
            }
        }
    }
}
