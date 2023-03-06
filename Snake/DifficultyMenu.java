import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DifficultyMenu extends JFrame {

    JList difficultyList;

    private String[] difficultyNameArray = {"EASY", "NORMAL", "HARD", "EXPERT", "GOD MODE"};
    private int[] difficultyClassArray = {200, 150, 120, 80, 40};

    JPanel diff_panel = new JPanel();

    DifficultyMenu() {

        JLabel label = new JLabel();
        label.setText("DIFFICULTY MENU");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label);

        difficultyList = new JList(difficultyNameArray);

        difficultyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        difficultyList.setFont(new Font("Game Over Regular", Font.PLAIN, 70));

        this.add(difficultyList);
        EventHandler handler = new EventHandler();
        difficultyList.addListSelectionListener(handler);

        this.setLayout(new FlowLayout());
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100,800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(237,241,214));
    }

    private class EventHandler implements ListSelectionListener{
        
        public void valueChanged(ListSelectionEvent e) {
            
            Board gp = new Board();
            
            gp.DELAY = difficultyClassArray[difficultyList.getSelectedIndex()];
        
            new ColorMenu();
            dispose();
        }
    }
}

