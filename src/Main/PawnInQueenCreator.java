package Main;

import Chesses.Pawn;
import Chesses.Piece;
import Chesses.Queen;

import java.util.ArrayList;

public class PawnInQueenCreator {
    public static void checkAndCreate() {

        ArrayList<Piece> copyArrayChess = new ArrayList<>(CreateArrayChess.chessArrayList);

        for(Piece chess : copyArrayChess) {
            if(chess instanceof Pawn) {
                if(chess.color.equals(Color.WHITE) && chess.numAddress == 7) {

                    CreateArrayChess.chessArrayList.add(new Queen("QQW2", 7,chess.charAddress, Color.WHITE,
                            "Images/WhiteArmy/InWhiteSquare/queen.png",
                            "Images/WhiteArmy/InBlackSquare/queen.png"));

                    for(int q = 0; q < CreateArrayChess.chessArrayList.size(); q++) {
                        if(CreateArrayChess.chessArrayList.get(q).numAddress == 7 &&
                                CreateArrayChess.chessArrayList.get(q) instanceof Pawn) {
                            CreateArrayChess.deathList.add(0, CreateArrayChess.chessArrayList.get(q));
                            CreateArrayChess.chessArrayList.remove(q);
                            break;
                        }
                    }
                } else if(chess.color.equals(Color.BLACK) && chess.numAddress == 0) {
                    for(int q = 0; q < CreateArrayChess.chessArrayList.size(); q++) {

                        CreateArrayChess.chessArrayList.add(new Queen("QQB2", 0,chess.charAddress, Color.BLACK,
                                "Images/BlackArmy/InWhiteSquare/queen.png",
                                "Images/BlackArmy/InBlackSquare/queen.png"));

                        if(CreateArrayChess.chessArrayList.get(q).numAddress == 0 &&
                                CreateArrayChess.chessArrayList.get(q) instanceof Pawn) {
                            CreateArrayChess.deathList.add(0, CreateArrayChess.chessArrayList.get(q));
                            CreateArrayChess.chessArrayList.remove(q);
                            break;
                        }
                    }


                }
            }
        }

    }
}
