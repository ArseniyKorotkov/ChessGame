package Main;

import Chesses.*;
import java.util.ArrayList;

public class CreateArrayChess {

    public static ArrayList <Piece> chessArrayList = new ArrayList<>();
    public static ArrayList <Piece> deathList = new ArrayList<>();

    static ArrayList <Piece> create() {

        /*
         * WhiteArmy
         */
        Pawn p1w = new Pawn("p1w", 1,0, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p2w = new Pawn("p2w", 1,1, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p3w = new Pawn("p3w", 1,2, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p4w = new Pawn("p4w", 1,3, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p5w = new Pawn("p5w", 1,4, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p6w = new Pawn("p6w", 1,5, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p7w = new Pawn("p7w", 1,6, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Pawn p8w = new Pawn("p8w", 1,7, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/pawn.png",
                "Images/WhiteArmy/InBlackSquare/pawn.png");
        Knight h1w = new Knight("h1w", 0,1,Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/knight.png",
                "Images/WhiteArmy/InBlackSquare/knight.png");
        Knight h2w = new Knight("h2w", 0,6,Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/knight.png",
                "Images/WhiteArmy/InBlackSquare/knight.png");
        Bishop l1w = new Bishop("l1w", 0,2,Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/bishop.png",
                "Images/WhiteArmy/InBlackSquare/bishop.png");
        Bishop l2w = new Bishop("l2w", 0,5,Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/bishop.png",
                "Images/WhiteArmy/InBlackSquare/bishop.png");
        Rook t1w = new Rook("t1w", 0,0,Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/rook.png",
                "Images/WhiteArmy/InBlackSquare/rook.png");
        Rook t2w = new Rook("t2w", 0,7,Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/rook.png",
                "Images/WhiteArmy/InBlackSquare/rook.png");
        King KKW = new King("KKW", 0,3, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/king.png",
                "Images/WhiteArmy/InBlackSquare/king.png");
        Queen QQW = new Queen("QQW", 0,4, Color.WHITE,
                "Images/WhiteArmy/InWhiteSquare/queen.png",
                "Images/WhiteArmy/InBlackSquare/queen.png");

        /*
         * BlackArmy
         */
        Pawn p1b = new Pawn("p1b", TableForGame.table.length - 2,0, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p2b = new Pawn("p2b", TableForGame.table.length - 2,1, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p3b = new Pawn("p3b", TableForGame.table.length - 2,2, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p4b = new Pawn("p4b", TableForGame.table.length - 2,3, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p5b = new Pawn("p5b", TableForGame.table.length - 2,4, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p6b = new Pawn("p6b", TableForGame.table.length - 2,5, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p7b = new Pawn("p7b", TableForGame.table.length - 2,6, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Pawn p8b = new Pawn("p8b", TableForGame.table.length - 2,7, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/pawn.png",
                "Images/BlackArmy/InBlackSquare/pawn.png");
        Knight h1b = new Knight("h1b", TableForGame.table.length - 1,1,Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/knight.png",
                "Images/BlackArmy/InBlackSquare/knight.png");
        Knight h2b = new Knight("h2b", TableForGame.table.length - 1,6,Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/knight.png",
                "Images/BlackArmy/InBlackSquare/knight.png");
        Bishop l1b = new Bishop("l1b", TableForGame.table.length - 1,2,Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/bishop.png",
                "Images/BlackArmy/InBlackSquare/bishop.png");
        Bishop l2b = new Bishop("l2b", TableForGame.table.length - 1,5,Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/bishop.png",
                "Images/BlackArmy/InBlackSquare/bishop.png");
        Rook t1b = new Rook("t1b", TableForGame.table.length - 1,0,Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/rook.png",
                "Images/BlackArmy/InBlackSquare/rook.png");
        Rook t2b = new Rook("t2b", TableForGame.table.length - 1,7,Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/rook.png",
                "Images/BlackArmy/InBlackSquare/rook.png");
        King KKB = new King("KKB", TableForGame.table.length - 1,3, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/king.png",
                "Images/BlackArmy/InBlackSquare/king.png");
        Queen QQB = new Queen("QQB", TableForGame.table.length - 1,4, Color.BLACK,
                "Images/BlackArmy/InWhiteSquare/queen.png",
                "Images/BlackArmy/InBlackSquare/queen.png");

        //add white
        chessArrayList.add(p1w);
        chessArrayList.add(p2w);
        chessArrayList.add(p3w);
        chessArrayList.add(p4w);
        chessArrayList.add(p5w);
        chessArrayList.add(p6w);
        chessArrayList.add(p7w);
        chessArrayList.add(p8w);
        chessArrayList.add(h1w);
        chessArrayList.add(h2w);
        chessArrayList.add(l1w);
        chessArrayList.add(l2w);
        chessArrayList.add(t1w);
        chessArrayList.add(t2w);
        chessArrayList.add(KKW);
        chessArrayList.add(QQW);

        //add black
        chessArrayList.add(p1b);
        chessArrayList.add(p2b);
        chessArrayList.add(p3b);
        chessArrayList.add(p4b);
        chessArrayList.add(p5b);
        chessArrayList.add(p6b);
        chessArrayList.add(p7b);
        chessArrayList.add(p8b);
        chessArrayList.add(h1b);
        chessArrayList.add(h2b);
        chessArrayList.add(l1b);
        chessArrayList.add(l2b);
        chessArrayList.add(t1b);
        chessArrayList.add(t2b);
        chessArrayList.add(KKB);
        chessArrayList.add(QQB);

        return chessArrayList;
    }
}
