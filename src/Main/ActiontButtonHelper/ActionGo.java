package Main.ActiontButtonHelper;

import Chesses.Pawn;
import Chesses.Piece;
import Main.CreateArrayChess;
import Main.GoColorControl;
import Main.TableForGame;

public class ActionGo {
    static boolean ifGo;

    public static boolean canGo(int numOldAddress, int charOldAddress, int numNewAddress, int charNewAddress) {

        ifGo = false;

        if (TableForGame.table[numOldAddress][charOldAddress] != null &&
                GoColorControl.goColor == TableForGame.table[numOldAddress][charOldAddress].color &&
                (TableForGame.table[numNewAddress][charNewAddress] == null ||
                        GoColorControl.goColor != TableForGame.table[numNewAddress][charNewAddress].color) &&
                charNewAddress < TableForGame.table.length)
        {
            if (TableForGame.table[numOldAddress][charOldAddress].move(numNewAddress, charNewAddress)) {
                ifGo = true;
            }
        }
        return ifGo;
    }
}
