package Chesses;

import Main.Color;
import Main.TableForGame;

public class Rook extends Piece {
    public Rook(String name, int numAddress, int stringAddress, Color color, String addressFaceWhite, String addressFaceBlack) {
        super(name, numAddress, stringAddress, color, addressFaceWhite, addressFaceBlack);
    }

    @Override
    public boolean move(int numNewAddress, int charNewAddress) {
        boolean stop = false;

        if(numAddress - numNewAddress == 0 && charAddress - charNewAddress != 0 ||
                numAddress - numNewAddress != 0 && charAddress - charNewAddress == 0)
        {
            if(numAddress - numNewAddress == 0 && charAddress > charNewAddress) {
                for(int q = charNewAddress + 1; q < charAddress; q++) {
                    if(TableForGame.table[numAddress][q] != null) {
                        stop = true;
                        break;
                    }
                }
            }

            if(numAddress - numNewAddress == 0 && charAddress < charNewAddress) {
                for(int q = charAddress + 1; q < charNewAddress; q++) {
                    if(TableForGame.table[numAddress][q] != null) {
                        stop = true;
                        break;
                    }
                }
            }

            if(numAddress - numNewAddress != 0 && numAddress > numNewAddress) {
                for(int q = numNewAddress + 1; q < numAddress; q++) {
                    if(TableForGame.table[q][charAddress] != null) {
                        stop = true;
                        break;
                    }
                }
            }

            if(numAddress - numNewAddress != 0 && numAddress < numNewAddress) {
                for(int q = numAddress + 1; q < numNewAddress; q++) {
                    if(TableForGame.table[q][charAddress] != null) {
                        stop = true;
                        break;
                    }
                }
            }

            return !stop;
        } else {
            return false;
        }
    }
}
