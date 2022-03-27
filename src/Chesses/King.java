package Chesses;

import Main.Color;
import Main.TableForGame;

public class King extends Piece {
    public King(String name, int numAddress, int stringAddress, Color color, String addressFaceWhite, String addressFaceBlack) {
        super(name, numAddress, stringAddress, color, addressFaceWhite, addressFaceBlack);
    }

    @Override
    public boolean move(int numNewAddress, int charNewAddress) {

        return (numAddress == numNewAddress + 1 && charAddress == charNewAddress + 1) ||
                (numAddress == numNewAddress + 1 && charAddress == charNewAddress - 1) ||
                (numAddress == numNewAddress + 1 && charAddress == charNewAddress) ||
                (numAddress == numNewAddress && charAddress == charNewAddress + 1) ||
                (numAddress == numNewAddress && charAddress == charNewAddress - 1) ||
                (numAddress == numNewAddress - 1 && charAddress == charNewAddress + 1) ||
                (numAddress == numNewAddress - 1 && charAddress == charNewAddress - 1) ||
                (numAddress == numNewAddress - 1 && charAddress == charNewAddress) ||

                (numAddress == numNewAddress && charAddress == charNewAddress + 2 && this.stepCount == 0 &&
                        TableForGame.table[numAddress][0] instanceof Rook && TableForGame.table[numAddress][0].stepCount == 0 &&
                        TableForGame.table[numAddress][0].move(numAddress, charAddress) &&
                        TableForGame.table[numAddress][charAddress - 1] == null) ||

                (numAddress == numNewAddress && charAddress == charNewAddress - 2 && this.stepCount == 0 &&
                        TableForGame.table[numAddress][7] instanceof Rook && TableForGame.table[numAddress][7].stepCount == 0 &&
                        TableForGame.table[numAddress][7].move(numAddress, charAddress + 1) &&
                        TableForGame.table[numAddress][charAddress + 1] == null);
    }
}
