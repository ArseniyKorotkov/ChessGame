package Chesses;

import Main.Color;

public class Knight extends Piece {

    public Knight(String name, int numAddress, int stringAddress, Color color, String addressFaceWhite, String addressFaceBlack) {
        super(name, numAddress, stringAddress, color, addressFaceWhite, addressFaceBlack);
    }

    @Override
    public boolean move(int numNewAddress, int charNewAddress) {
        return (numAddress == numNewAddress + 2 && charAddress == charNewAddress + 1) ||
                (numAddress == numNewAddress + 2 && charAddress == charNewAddress - 1) ||
                (numAddress == numNewAddress + 1 && charAddress == charNewAddress + 2) ||
                (numAddress == numNewAddress - 1 && charAddress == charNewAddress + 2) ||
                (numAddress == numNewAddress - 2 && charAddress == charNewAddress + 1) ||
                (numAddress == numNewAddress - 2 && charAddress == charNewAddress - 1) ||
                (numAddress == numNewAddress + 1 && charAddress == charNewAddress - 2) ||
                (numAddress == numNewAddress - 1 && charAddress == charNewAddress - 2);
    }
}
