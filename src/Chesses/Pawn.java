package Chesses;

import Main.Color;
import Main.TableForGame;

public class Pawn extends Piece {

    public boolean enPassantDanger = false;

    public Pawn(String name, int numAddress, int stringAddress, Color color, String addressFaceWhite, String addressFaceBlack) {
        super(name, numAddress, stringAddress, color, addressFaceWhite, addressFaceBlack);
    }

    @Override
    public boolean move(int numNewAddress, int charNewAddress) {

        return color == Color.WHITE &&
                (numAddress == 1 && numNewAddress == numAddress + 2 && charAddress == charNewAddress && TableForGame.table[numAddress + 1][charAddress] == null && TableForGame.table[numAddress + 2][charAddress] == null ||
                        numNewAddress == numAddress + 1 && charAddress == charNewAddress && TableForGame.table[numNewAddress][charNewAddress] == null ||
                        numNewAddress == numAddress + 1 && (charAddress == charNewAddress + 1 || charAddress == charNewAddress - 1)
                                && TableForGame.table[numNewAddress][charNewAddress] != null ||

                        numNewAddress == numAddress + 1 && (charAddress == charNewAddress - 1 || charAddress == charNewAddress + 1)
                                && TableForGame.table[numAddress][charNewAddress] != null && TableForGame.table[numAddress][charNewAddress] instanceof Pawn
                                && ((Pawn) TableForGame.table[numAddress][charNewAddress]).enPassantDanger) ||


                color == Color.BLACK &&
                        (numAddress == TableForGame.table.length - 2 && numNewAddress == numAddress - 2 && charAddress == charNewAddress && TableForGame.table[numAddress - 1][charAddress] == null && TableForGame.table[numAddress - 2][charAddress] == null ||
                                numNewAddress == numAddress - 1 && charAddress == charNewAddress && TableForGame.table[numNewAddress][charNewAddress] == null ||
                                numNewAddress == numAddress - 1 && (charAddress == charNewAddress + 1 || charAddress == charNewAddress - 1)
                                        && TableForGame.table[numNewAddress][charNewAddress] != null ||

                                numNewAddress == numAddress - 1 && (charAddress == charNewAddress - 1 || charAddress == charNewAddress + 1)
                                        && TableForGame.table[numAddress][charNewAddress] != null && TableForGame.table[numAddress][charNewAddress] instanceof Pawn
                                        && ((Pawn) TableForGame.table[numAddress][charNewAddress]).enPassantDanger);

    }
}
