package Main;

import Chesses.*;
import java.util.ArrayList;

public class PawnInPieceCreator {
    public static boolean checkAndCreate() {

        boolean create = false;
        Color pawnColor = null;
        int numAddressPawn = 8;
        int charAddressPawn = 8;
        String getMessage = TableForGame.visionGUI.squareMassage.getText();

        ArrayList<Piece> copyArrayChess = new ArrayList<>(CreateArrayChess.chessArrayList);

        for(Piece chess : copyArrayChess) {
            if(chess instanceof Pawn) {
                if(chess.color.equals(Color.WHITE) && chess.numAddress == 7) {
                    pawnColor = chess.color;
                    numAddressPawn = 7;
                    charAddressPawn = chess.charAddress;
                    break;

                } else if(chess.color.equals(Color.BLACK) && chess.numAddress == 0) {
                    pawnColor = chess.color;
                    charAddressPawn = chess.charAddress;
                    break;
                }
            }
        }

        ArrayList<Piece> deathListCopy = new ArrayList<>(CreateArrayChess.deathList);

        switch(TableForGame.visionGUI.addressThis.getText()) {
            case "9":
                for(Piece chess : deathListCopy) {
                    if(chess instanceof Queen && chess.color == pawnColor) {
                        TableForGame.visionGUI.squareMassage.setText(getMessage);
                        CreateArrayChess.chessArrayList.add(chess);
                        CreateArrayChess.deathList.remove(chess);
                        chess.numAddress = numAddressPawn;
                        chess.charAddress = charAddressPawn;
                        for(Piece chessPawn : copyArrayChess) {
                            if(chessPawn instanceof Pawn && chessPawn.numAddress == numAddressPawn &&
                            chessPawn.charAddress == charAddressPawn && chessPawn.color == pawnColor)
                            {
                                CreateArrayChess.chessArrayList.remove(chessPawn);
                            }
                        }
                        create = true;
                    }
                }
                break;
            case "5":
                for(Piece chess : deathListCopy) {
                    if(chess instanceof Bishop && chess.color == pawnColor) {
                        TableForGame.visionGUI.squareMassage.setText(getMessage);
                        CreateArrayChess.chessArrayList.add(chess);
                        CreateArrayChess.deathList.remove(chess);
                        chess.numAddress = numAddressPawn;
                        chess.charAddress = charAddressPawn;
                        for(Piece chessPawn : copyArrayChess) {
                            if(chessPawn instanceof Pawn && chessPawn.numAddress == numAddressPawn &&
                                    chessPawn.charAddress == charAddressPawn && chessPawn.color == pawnColor)
                            {
                                CreateArrayChess.chessArrayList.remove(chessPawn);
                            }
                        }
                        create = true;
                    }
                }
                break;
            case "3.5":
                for(Piece chess : deathListCopy) {
                    if(chess instanceof Rook && chess.color == pawnColor) {
                        TableForGame.visionGUI.squareMassage.setText(getMessage);
                        CreateArrayChess.chessArrayList.add(chess);
                        CreateArrayChess.deathList.remove(chess);
                        chess.numAddress = numAddressPawn;
                        chess.charAddress = charAddressPawn;
                        for(Piece chessPawn : copyArrayChess) {
                            if(chessPawn instanceof Pawn && chessPawn.numAddress == numAddressPawn &&
                                    chessPawn.charAddress == charAddressPawn && chessPawn.color == pawnColor)
                            {
                                CreateArrayChess.chessArrayList.remove(chessPawn);
                            }
                        }
                        create = true;
                    }
                }
                break;
            case "3":
                for(Piece chess : deathListCopy) {
                    if(chess instanceof Knight && chess.color == pawnColor) {
                        TableForGame.visionGUI.squareMassage.setText(getMessage);
                        CreateArrayChess.chessArrayList.add(chess);
                        CreateArrayChess.deathList.remove(chess);
                        chess.numAddress = numAddressPawn;
                        chess.charAddress = charAddressPawn;
                        for(Piece chessPawn : copyArrayChess) {
                            if(chessPawn instanceof Pawn && chessPawn.numAddress == numAddressPawn &&
                                    chessPawn.charAddress == charAddressPawn && chessPawn.color == pawnColor)
                            {
                                CreateArrayChess.chessArrayList.remove(chessPawn);
                            }
                        }
                        create = true;
                    }
                }
                break;
        }

        TableForGame.inputTable(CreateArrayChess.chessArrayList);
        InputForms.see(TableForGame.visionGUI, TableForGame.table);
        return create;
    }
}
