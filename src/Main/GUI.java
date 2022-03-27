package Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {

    ArrayList <JLabel> square = new ArrayList<>();

    JLabel squareAddressVoid1 = new JLabel("");
    JLabel squareAddressVoid2 = new JLabel("");
    JLabel squareAddressVoid3 = new JLabel("");
    JLabel squareAddressVoid4 = new JLabel("");
    JLabel squareAddressVoid5 = new JLabel("");
    JLabel squareAddressNum1 = new JLabel("1|");
    JLabel squareAddressNum2 = new JLabel("2|");
    JLabel squareAddressNum3 = new JLabel("3|");
    JLabel squareAddressNum4 = new JLabel("4|");
    JLabel squareAddressNum5 = new JLabel("5|");
    JLabel squareAddressNum6 = new JLabel("6|");
    JLabel squareAddressNum7 = new JLabel("7|");
    JLabel squareAddressNum8 = new JLabel("8|");
    JLabel squareAddressChar1 = new JLabel("_A_");
    JLabel squareAddressChar2 = new JLabel("_B_");
    JLabel squareAddressChar3 = new JLabel("_C_");
    JLabel squareAddressChar4 = new JLabel("_D_");
    JLabel squareAddressChar5 = new JLabel("_E_");
    JLabel squareAddressChar6 = new JLabel("_F_");
    JLabel squareAddressChar7 = new JLabel("_G_");
    JLabel squareAddressChar8 = new JLabel("_H_");

    public JLabel squareMassage = new JLabel();


    public JLabel attackIs = new JLabel();
    public JButton goWalk = new JButton("Go!");

    public JTextField addressThis = new JTextField();
    public JTextField addressNew = new JTextField();


    public GUI() {
        super("NumbersChess");
        this.setVisible(true);
        this.setBounds(100, 100 , 580,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(9,10,0,0));

        GoActionButton goAction = new GoActionButton();
        goWalk.addActionListener(goAction);

        for(int q = 0; q < 64; q++) {
            square.add(new JLabel());
        }

        container.add(squareAddressVoid1);
        container.add(squareAddressChar1);
        container.add(squareAddressChar2);
        container.add(squareAddressChar3);
        container.add(squareAddressChar4);
        container.add(squareAddressChar5);
        container.add(squareAddressChar6);
        container.add(squareAddressChar7);
        container.add(squareAddressChar8);
        container.add(attackIs);



        container.add(squareAddressNum1);
        container.add(square.get(0));
        container.add(square.get(1));
        container.add(square.get(2));
        container.add(square.get(3));
        container.add(square.get(4));
        container.add(square.get(5));
        container.add(square.get(6));
        container.add(square.get(7));
        container.add(addressThis);

        container.add(squareAddressNum2);
        container.add(square.get(8));
        container.add(square.get(9));
        container.add(square.get(10));
        container.add(square.get(11));
        container.add(square.get(12));
        container.add(square.get(13));
        container.add(square.get(14));
        container.add(square.get(15));
        container.add(addressNew);

        container.add(squareAddressNum3);
        container.add(square.get(16));
        container.add(square.get(17));
        container.add(square.get(18));
        container.add(square.get(19));
        container.add(square.get(20));
        container.add(square.get(21));
        container.add(square.get(22));
        container.add(square.get(23));
        container.add(goWalk);

        container.add(squareAddressNum4);
        container.add(square.get(24));
        container.add(square.get(25));
        container.add(square.get(26));
        container.add(square.get(27));
        container.add(square.get(28));
        container.add(square.get(29));
        container.add(square.get(30));
        container.add(square.get(31));
        container.add(squareMassage);

        container.add(squareAddressNum5);
        container.add(square.get(32));
        container.add(square.get(33));
        container.add(square.get(34));
        container.add(square.get(35));
        container.add(square.get(36));
        container.add(square.get(37));
        container.add(square.get(38));
        container.add(square.get(39));
        container.add(squareAddressVoid2);

        container.add(squareAddressNum6);
        container.add(square.get(40));
        container.add(square.get(41));
        container.add(square.get(42));
        container.add(square.get(43));
        container.add(square.get(44));
        container.add(square.get(45));
        container.add(square.get(46));
        container.add(square.get(47));
        container.add(squareAddressVoid3);

        container.add(squareAddressNum7);
        container.add(square.get(48));
        container.add(square.get(49));
        container.add(square.get(50));
        container.add(square.get(51));
        container.add(square.get(52));
        container.add(square.get(53));
        container.add(square.get(54));
        container.add(square.get(55));
        container.add(squareAddressVoid4);

        container.add(squareAddressNum8);
        container.add(square.get(56));
        container.add(square.get(57));
        container.add(square.get(58));
        container.add(square.get(59));
        container.add(square.get(60));
        container.add(square.get(61));
        container.add(square.get(62));
        container.add(square.get(63));
        container.add(squareAddressVoid5);
    }
}
