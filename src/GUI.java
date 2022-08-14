import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GUI extends JFrame{
    public JButton button10;
    public JLabel label;
    JPanel panel;
    public JButton[] buttons = new JButton[9];
    public ArrayList<JButton> buttons2 = new ArrayList<>();
    private Game game;


    public GUI(){
        //erzeugen eines Game-Objekts
        game = new Game();

        this.setTitle("Tic-Tac-Toe");
        this.setSize(800, 400);
        panel = new JPanel();
        // Leeres JLabel-Objekt wird erzeugt
        label = new JLabel();

        //das Panel bekommt das 4x3-Gridlayout
        panel.setLayout(new java.awt.GridLayout(4,3));


        //Buttons werden erstellt
        for(int i=0; i<9; i++) {
            buttons[i] = new JButton("");
            //buttons[i].addActionListener(this);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton clickedButton = (JButton) e.getSource();
                    if(game.get_game_finished() == false){
                        if(clickedButton.getText().equals("")){
                            clickedButton.setText(game.next());
                            game.winner(buttons2.indexOf(clickedButton));
                        }
                        else{
                            label.setText("Wählen Sie ein anderes Feld!");
                        }
                    }
                    else{
                        label.setText("Starten Sie das Spiel neu");
                    }
                }
            });
            buttons2.add(buttons[i]);
            panel.add(buttons[i]);
        }

        button10 = new JButton("Neue Runde");

        //Buttons werden dem Listener zugeordnet
        //button10.addActionListener(this);
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int j=0; j<9; j++){
                    buttons[j].setText("");
                }
                label.setText("");
                game.set_game_finished(false);
            }
        });

        //Button 10 wird dem JPanel hinzugefügt
        panel.add(button10);

        //JLabel wird dem Panel hinzugefügt
        panel.add(label);
        this.add(panel);
    }
}

