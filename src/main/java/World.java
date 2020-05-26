import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class World {
    public static void main(String[] args) {
        JFrame frame = new JFrame("World");

        JPanel level = new JPanel();
        JButton levelUp = new JButton("Up");
        levelUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            }
        });
        level.add(levelUp);
        JLabel label1 = new JLabel("Level");
        frame.add(label1);
        JButton levelDown = new JButton("Down");
        levelDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            }
        });
        level.add(levelDown);
        frame.add(level);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 300);

        frame.setVisible(true);
    }
}