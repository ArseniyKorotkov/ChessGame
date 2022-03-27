package Chesses;

import Main.Color;
import Main.TableForGame;

public class Bishop extends Piece {

    public Bishop(String name, int numAddress, int stringAddress, Color color, String addressFaceWhite, String addressFaceBlack) {
        super(name, numAddress, stringAddress, color, addressFaceWhite, addressFaceBlack);
    }

    @Override
    public boolean move(int numNewAddress, int charNewAddress) {
        boolean stop = false;

        if(     ((Math.abs(numAddress - numNewAddress) == Math.abs(charAddress - charNewAddress)) &&
                numAddress - numNewAddress != 0))
        {
            if(numAddress > numNewAddress && charAddress > charNewAddress) {
                int w = charNewAddress + 1;
                for(int q = numNewAddress + 1; q < numAddress; q++) {
                    if(TableForGame.table[q][w] != null) {
                        stop = true;
                        break;
                    }
                    w++;
                }
            }

            if(numAddress > numNewAddress && charAddress < charNewAddress) {
                int w = charNewAddress - 1;
                for(int q = numNewAddress + 1; q < numAddress; q++) {
                    if(TableForGame.table[q][w] != null) {
                        stop = true;
                        break;
                    }
                    w--;
                }
            }

            if(numAddress < numNewAddress && charAddress > charNewAddress) {
                int w = charAddress - 1;
                for(int q = numAddress + 1; q < numNewAddress; q++) {
                    if(TableForGame.table[q][w] != null) {
                        stop = true;
                        break;
                    }
                    w--;
                }
            }

            if(numAddress < numNewAddress && charAddress < charNewAddress) {
                int w = charAddress + 1;
                for(int q = numAddress + 1; q < numNewAddress; q++) {
                    if(TableForGame.table[q][w] != null) {
                        stop = true;
                        break;
                    }
                    w++;
                }
            }

            return !stop;
        } else {
            return false;
        }
    }
}
