package Main;

public class Main {
    public static void main(String[] args) {

        TableForGame.inputTable(CreateArrayChess.create());
        TableForGame.visionGUI.attackIs.setText("go" + GoColorControl.goColor.name());
        InputForms.see(TableForGame.visionGUI, TableForGame.table);

    }
}
