

public class Game {
    private String last = "O";
    static GUI gui;


    public static void main(String[] args)
    {
        // Ein neues Objekt der Klasse BeispielListener wird erzeugt
        // und sichtbar gemacht
        gui = new GUI();
        gui.setVisible(true);
    }

    public String next(){
        if(last.equals("O")){
            last = "X";
            gui.label.setText("O ist am Zug");
        }
        else{
            last = "O";
            gui.label.setText("X ist am Zug");
        }
        return last;
    }

    public void winner(int index){
        //überpüfen der Spalte vom übergebenen Index
        if(gui.buttons[index%3].getText().equals(gui.buttons[index%3 + 3].getText()) && gui.buttons[index%3].getText().equals(gui.buttons[index%3 + 6].getText())){
            gui.label.setText("Spieler " + last + " hat gewonnen");
            return;
        }

        //überprüfen der Zeile abhängig der Spaltenposition
        if(index%3 == 0){
            if(gui.buttons[index].getText().equals(gui.buttons[index+1].getText()) && gui.buttons[index].getText().equals(gui.buttons[index+2].getText())){
                gui.label.setText("Spieler " + last + "  hat gewonnen");
                return;
            }
        }
        if(index%3 == 1){
            if(gui.buttons[index].getText().equals(gui.buttons[index-1].getText()) && gui.buttons[index].getText().equals(gui.buttons[index+1].getText())){
                gui.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }
        if(index%3 == 2){
            if(gui.buttons[index].getText().equals(gui.buttons[index-1].getText()) && gui.buttons[index].getText().equals(gui.buttons[index-2].getText())){
                gui.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }

        //Überprüfen der Diagonalen
        if(index==0 || index==4 || index==8) {
            if (gui.buttons[0].getText().equals(gui.buttons[4].getText()) && gui.buttons[0].getText().equals(gui.buttons[8].getText())) {
                gui.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }

        if(index==2 || index==4 || index==6){
            if(gui.buttons[2].getText().equals(gui.buttons[4].getText()) && gui.buttons[2].getText().equals(gui.buttons[6].getText())){
                gui.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }

        return;
    }
}
