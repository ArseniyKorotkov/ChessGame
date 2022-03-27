package Main;

import Chesses.Pawn;
import Chesses.Piece;
import Chesses.King;
import Main.ActiontButtonHelper.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoActionButton implements ActionListener {

    boolean checkWin = true;
    boolean killNow = false;

    @Override
    public void actionPerformed(ActionEvent e) {

        TableForGame.visionGUI.squareMassage.setText("");

        if(checkWin) {
            String oldAddress = TableForGame.visionGUI.addressThis.getText();
            String newAddress = TableForGame.visionGUI.addressNew.getText();

            int[] addresses = new int[4];

            //Action move Go!
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
            //end action move Go

            /*create Pawn in Queen
            *
            *
            */
            PawnInQueenCreator.checkAndCreate();
            //and create pawn


            //check death king
            if(KingCounter.countKing() == 1) {
                for(Piece chess : CreateArrayChess.chessArrayList) {
                    if(chess instanceof King) {
                        TableForGame.visionGUI.attackIs.setText("WINNER");
                        TableForGame.visionGUI.goWalk.setText("rest");
                        TableForGame.visionGUI.squareMassage.setText(chess.color.toString());

                        checkWin = false;
                        break;
                    }
                }
            } else {
                //check danger king step + shah
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
                //end check danger king step + shah
                TableForGame.inputTable(CreateArrayChess.chessArrayList);
                //check all can move
                if(!CheckAllCanMove.ifCan()) {
                    checkWin = false;
                }
                //end check all can move

            }

        } else {
            checkWin = true;
            TableForGame.visionGUI.goWalk.setText("Go!");
            CreateArrayChess.chessArrayList.clear();
            TableForGame.table = new Piece[8][8];
            GoColorControl.goColor = Color.WHITE;
            TableForGame.visionGUI.attackIs.setText("go" + GoColorControl.goColor.name());
            TableForGame.inputTable(CreateArrayChess.create());
        }

        if(CreateArrayChess.chessArrayList.size() == 2 &&
            CreateArrayChess.chessArrayList.get(0) instanceof King &&
            CreateArrayChess.chessArrayList.get(1) instanceof King)
        {
            TableForGame.visionGUI.attackIs.setText("    NO");
            TableForGame.visionGUI.goWalk.setText("rest");
            TableForGame.visionGUI.squareMassage.setText("WINNER");

            checkWin = false;
        }

        TableForGame.inputTable(CreateArrayChess.chessArrayList);
        InputForms.see(TableForGame.visionGUI, TableForGame.table);
    }
}
