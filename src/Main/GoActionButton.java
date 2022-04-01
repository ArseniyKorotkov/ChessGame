package Main;

import Chesses.*;
import Main.ActiontButtonHelper.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GoActionButton implements ActionListener {

    boolean checkWin = true;
    boolean createFromPawn = false;
    boolean killNow = false;
    int[] addresses = new int[4];

    @Override
    public void actionPerformed(ActionEvent e) {

        TableForGame.visionGUI.squareMassage.setText("");

        if (checkWin) {
            String oldAddress = TableForGame.visionGUI.addressThis.getText();
            String newAddress = TableForGame.visionGUI.addressNew.getText();

            //Action move Go!
            killNow = ActionMoveGo.goGo(addresses, oldAddress, newAddress, killNow);
            //end action move Go

            //Check create pawn
            ArrayList<Piece> copyArrayChess = new ArrayList<>(CreateArrayChess.chessArrayList);
            String getMessage = TableForGame.visionGUI.squareMassage.getText();
            for (Piece chess : copyArrayChess) {

                if (chess instanceof Pawn && ((chess.color.equals(Color.WHITE) && chess.numAddress == 7) ||
                                                    chess.color.equals(Color.BLACK) && chess.numAddress == 0))
                {
                    TableForGame.visionGUI.squareMassage.setText("no item");
                    for (Piece chess2 : CreateArrayChess.deathList) {
                        if (chess2.color == chess.color && (chess2 instanceof Queen || chess2 instanceof Bishop ||
                                chess2 instanceof Knight || chess2 instanceof Rook))
                        {
                            checkWin = false;
                            createFromPawn = true;
                            TableForGame.visionGUI.squareMassage.setText(getMessage);
                            break;
                        }
                    }

                    if(TableForGame.visionGUI.squareMassage.getText().equals("no item") && !getMessage.equals(""))
                    {
                        TableForGame.visionGUI.squareMassage.setText(getMessage);
                    }
                }

            }
            //and check create pawn

            //check death king
            if (KingCounter.countKing() == 1) {
                for (Piece chess : CreateArrayChess.chessArrayList) {
                    if (chess instanceof King) {
                        TableForGame.visionGUI.attackIs.setText("WINNER");
                        TableForGame.visionGUI.goWalk.setText("rest");
                        TableForGame.visionGUI.squareMassage.setText(chess.color.toString());

                        checkWin = false;
                        break;
                    }
                }
            } else {
                //check danger king step + shah
                ActionCheckDanger.goGo(addresses, killNow);
                //end check danger king step + shah

                TableForGame.inputTable(CreateArrayChess.chessArrayList);

                //check all can move
                if (!CheckAllCanMove.ifCan()) {
                    checkWin = false;
                }
                //end check all can move


                if (createFromPawn) {
                    TableForGame.visionGUI.attackIs.setText("Pawn In...");
                    TableForGame.visionGUI.goWalk.setText("Yes");
                }

            }

        } else {
            if (createFromPawn) {

                if (PawnInPieceCreator.checkAndCreate()) {
                    createFromPawn = false;
                    checkWin = true;
                    TableForGame.visionGUI.goWalk.setText("Go!");
                    TableForGame.visionGUI.attackIs.setText("go" + GoColorControl.goColor.name());

                    ActionCheckDanger.goGo(addresses, killNow);

                    if (!CheckAllCanMove.ifCan()) {
                        checkWin = false;
                    }


                } else {
                    TableForGame.visionGUI.squareMassage.setText("Not is");
                }

            } else {
                checkWin = true;
                TableForGame.visionGUI.goWalk.setText("Go!");
                CreateArrayChess.chessArrayList.clear();
                CreateArrayChess.deathList.clear();
                TableForGame.table = new Piece[8][8];
                GoColorControl.goColor = Color.WHITE;
                TableForGame.visionGUI.attackIs.setText("go" + GoColorControl.goColor.name());
                TableForGame.inputTable(CreateArrayChess.create());
            }
        }

        if (CreateArrayChess.chessArrayList.size() == 2 &&
                CreateArrayChess.chessArrayList.get(0) instanceof King &&
                CreateArrayChess.chessArrayList.get(1) instanceof King) {
            TableForGame.visionGUI.attackIs.setText("    NO");
            TableForGame.visionGUI.goWalk.setText("rest");
            TableForGame.visionGUI.squareMassage.setText("WINNER");

            checkWin = false;
        }

        TableForGame.inputTable(CreateArrayChess.chessArrayList);
        InputForms.see(TableForGame.visionGUI, TableForGame.table);
    }
}
