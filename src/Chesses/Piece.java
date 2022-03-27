package Chesses;

import Main.Color;
import javax.swing.*;

public abstract class Piece {
    String name;
    public int numAddress;
    public int charAddress;
    public Color color;

    public ImageIcon faceWhite;
    public ImageIcon faceBlack;

    public int stepCount = 0;
    public int health = 100;
    int power;

    Piece(String name, int numAddress, int stringAddress, Color color, String addressFaceWhite, String addressFaceBlack) {
        this.name = name;
        this.numAddress = numAddress;
        this.charAddress = stringAddress;
        this.color = color;

        this.faceWhite = new ImageIcon(new ImageIcon(addressFaceWhite).getImage());
        this.faceBlack = new ImageIcon(new ImageIcon(addressFaceBlack).getImage());
    }

    public abstract boolean move(int numNewAddress, int charNewAddress);

    public String getName() {
        return name;
    }

    public int[] address() {
        int[] address = new int[2];
        address[0] = numAddress;
        address[1] = charAddress;
        return address;
    }
}