package Main.ActiontButtonHelper;

import Main.TableForGame;
import java.util.Locale;

public class AddressConvertor {
    public static int[] convert(String oldAddress, String newAddress) {
        int numOldAddress = Integer.parseInt(String.valueOf(oldAddress.charAt(0))) - 1;
        String stringOldAddress = String.valueOf(oldAddress.charAt(1)).toUpperCase(Locale.ROOT);
        int charOldAddress = switch (stringOldAddress) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            default -> TableForGame.table[0].length;
        };

        int numNewAddress = Integer.parseInt(String.valueOf(newAddress.charAt(0))) - 1;
        String stringNewAddress = String.valueOf(newAddress.charAt(1)).toUpperCase();
        int charNewAddress = switch (stringNewAddress) {
            case "A" -> 0;
            case "B" -> 1;
            case "C" -> 2;
            case "D" -> 3;
            case "E" -> 4;
            case "F" -> 5;
            case "G" -> 6;
            case "H" -> 7;
            default -> TableForGame.table.length;
        };

        return new int[]{numOldAddress, charOldAddress, numNewAddress, charNewAddress};
    }
}
