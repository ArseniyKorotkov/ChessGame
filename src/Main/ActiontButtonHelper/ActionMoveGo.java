package Main.ActiontButtonHelper;

import Chesses.Pawn;
import Chesses.Piece;
import Main.CreateArrayChess;
import Main.GoColorControl;
import Main.TableForGame;

public class ActionMoveGo {
    public static boolean goGo(int[] addresses, String oldAddress, String newAddress, boolean killNow) {
        try {
            addresses = AddressConvertor.convert(oldAddress, newAddress);
            if(ActionGo.canGo(addresses[0], addresses[1], addresses[2], addresses[3])) {
                TableForGame.table[addresses[0]][addresses[1]].stepCount++;


                if(TableForGame.table[addresses[2]][addresses[3]] != null) {
                    CreateArrayChess.deathList.add(0, TableForGame.table[addresses[2]][addresses[3]]);
                    CreateArrayChess.chessArrayList.remove(TableForGame.table[addresses[2]][addresses[3]]);
                    killNow = true;
                } else if(TableForGame.table[addresses[2]][addresses[3]] == null &&
                        TableForGame.table[addresses[0]][addresses[3]] != null &&
                        TableForGame.table[addresses[0]][addresses[3]] instanceof Pawn &&
                        ((Pawn) TableForGame.table[addresses[0]][addresses[3]]).enPassantDanger &&
                        TableForGame.table[addresses[0]][addresses[1]] instanceof Pawn &&
                        Math.abs(addresses[0] - addresses[2]) == 1 && Math.abs(addresses[1] - addresses[3]) == 1) {

                    CreateArrayChess.deathList.add(0, TableForGame.table[addresses[0]][addresses[3]]);
                    CreateArrayChess.chessArrayList.remove(TableForGame.table[addresses[0]][addresses[3]]);
                    TableForGame.table[addresses[0]][addresses[3]] = null;

                    killNow = true;
                } else {
                    killNow = false;
                }

                //en passant helper
                for(Piece chess : CreateArrayChess.chessArrayList) {
                    if(chess instanceof Pawn && ((Pawn) chess).enPassantDanger) {
                        ((Pawn) chess).enPassantDanger = false;
                    }
                }
                if(TableForGame.table[addresses[0]][addresses[1]] instanceof Pawn &&
                        Math.abs(addresses[2] - addresses[0]) == 2)   {
                    ((Pawn) TableForGame.table[addresses[0]][addresses[1]]).enPassantDanger = true;
                }


                ActionGoHelper.help(addresses);

            } else {
                TableForGame.visionGUI.squareMassage.setText("not can");
            }

            TableForGame.visionGUI.attackIs.setText("go" + GoColorControl.goColor.name());
        } catch (Exception ex) {
            TableForGame.visionGUI.squareMassage.setText("input err");
            ex.printStackTrace();
        }
        return killNow;
    }
}
