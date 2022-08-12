

public class Game {
    private static String last = "O";

    public static String next(){
        if(last.equals("O")){
            last = "X";
            GUI.label.setText("O ist am Zug");
        }
        else{
            last = "O";
            GUI.label.setText("X ist am Zug");
        }
        return last;
    }

    public static void winner(int index){
        //überpüfen der Spalte vom übergebenen Index
        if(GUI.buttons[index%3].getText().equals(GUI.buttons[index%3 + 3].getText()) && GUI.buttons[index%3].getText().equals(GUI.buttons[index%3 + 6].getText())){
            GUI.label.setText("Spieler " + last + " hat gewonnen");
            return;
        }

        //überprüfen der Zeile abhängig der Spaltenposition
        if(index%3 == 0){
            if(GUI.buttons[index].getText().equals(GUI.buttons[index+1].getText()) && GUI.buttons[index].getText().equals(GUI.buttons[index+2].getText())){
                GUI.label.setText("Spieler " + last + "  hat gewonnen");
                return;
            }
        }
        if(index%3 == 1){
            if(GUI.buttons[index].getText().equals(GUI.buttons[index-1].getText()) && GUI.buttons[index].getText().equals(GUI.buttons[index+1].getText())){
                GUI.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }
        if(index%3 == 2){
            if(GUI.buttons[index].getText().equals(GUI.buttons[index-1].getText()) && GUI.buttons[index].getText().equals(GUI.buttons[index-2].getText())){
                GUI.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }

        //Überprüfen der Diagonalen
        if(index==0 || index==4 || index==8) {
            if (GUI.buttons[0].getText().equals(GUI.buttons[4].getText()) && GUI.buttons[0].getText().equals(GUI.buttons[8].getText())) {
                GUI.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }

        if(index==2 || index==4 || index==6){
            if(GUI.buttons[2].getText().equals(GUI.buttons[4].getText()) && GUI.buttons[2].getText().equals(GUI.buttons[6].getText())){
                GUI.label.setText("Spieler " + last + " hat gewonnen");
                return;
            }
        }

        return;
    }
}
