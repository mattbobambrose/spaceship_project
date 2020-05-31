import javax.swing.*;

public class MySwingTest {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("BoxLayout Example X_AXIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        panel.setLayout(boxlayout);

        //panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        JButton jb1 = new JButton("Button 1");
        JLabel jl1 = new JLabel("Level");
        JButton jb3 = new JButton("Button 3");

        panel.add(jb1);
        panel.add(jl1);
        panel.add(jb3);

        /*JLabel player = new JLabel("Player:");
        JLabel pHealth = new JLabel("Health: " + p1.health);
        JLabel pMinAttack = new JLabel("Minimum Attack: " + p1.minAttack);
        JLabel pMaxAttack = new JLabel("Maximum Attack: " + p1.maxAttack);
        JLabel coins = new JLabel("Coins: " + p1.coins);
        JLabel enemy = new JLabel("Enemy:");
        JLabel eHealth = new JLabel("Health: " + e1.health);
        JLabel eMinAttack = new JLabel("Minimum Attack: " + e1.minAttack);
        JLabel eMaxAttack = new JLabel("Maximum Attack: " + e1.maxAttack);
        */
        int level = 1;
        /*JButton levelUp = new JButton("" + level);
        levelUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                level++;
            }
        });
        panel.add(levelUp);
        */
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        /*PlayerSpaceship p1 = new PlayerSpaceship(jb1);
        EnemySpaceship e1 = new EnemySpaceship(level);
        boolean done = false;
        while (done == false) {
            while (!p1.isDead() && !e1.isDead()) {
                e1.removeHealth(p1.attack());
                if (e1.isDead()) {
                    p1.addCoins(level);
                    p1.reset();
                    break;
                }
                p1.removeHealth(e1.attack());
                if (p1.isDead()) {
                    p1.reset();
                    break;
                }
            }
        }*/
    }
}