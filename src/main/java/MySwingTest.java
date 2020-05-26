import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MySwingTest {

    public static void main(String[] args) throws InterruptedException {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("BoxLayout Example X_AXIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");

        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);

        JButton levelUp = new JButton("Up");
        levelUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

            }
        });
        panel.add(levelUp);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        PlayerSpaceship p1 = new PlayerSpaceship(levelUp);
        EnemySpaceship e1 = new EnemySpaceship();
        boolean done = false;
        while (done == false) {
            while (!p1.isDead() && !e1.isDead()) {
                e1.removeHealth(p1.attack());
                if (e1.isDead()) {
                    p1.addCoins(e1.level);
                    p1.reset();
                    break;
                }
                p1.removeHealth(e1.attack());
                if (p1.isDead()) {
                    p1.reset();
                    break;
                }
            }
        }
    }
}