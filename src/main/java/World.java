import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class World {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger level = new AtomicInteger(2);
        JFrame worldFrame = new JFrame("World");

        JPanel everythingPanel = new JPanel();
        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Level: " + level);

        JPanel levelPanel = new JPanel();
        JButton levelDown = new JButton("Down");
        levelDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label1.setText("Level: " + level.decrementAndGet());
            }
        });

        JButton levelUp = new JButton("Up");
        levelUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label1.setText("Level: " + level.incrementAndGet());
            }
        });
        levelPanel.add(levelDown);
        levelPanel.add(label1);
        levelPanel.add(levelUp);
        everythingPanel.add(levelPanel);

        JPanel playerStatsPanel = new JPanel();
        playerStatsPanel.setLayout(new BoxLayout(playerStatsPanel, BoxLayout.X_AXIS));

        JPanel playerHealthPanel = new JPanel();
        playerHealthPanel.setLayout(new BoxLayout(playerHealthPanel, BoxLayout.Y_AXIS));
        JButton upgradeHealth = new JButton("Upgrade health");
        playerHealthPanel.add(upgradeHealth);
        JLabel pHealth = new JLabel("health");
        playerHealthPanel.add(pHealth);
        playerStatsPanel.add(playerHealthPanel);

        JPanel playerMinAttackPanel = new JPanel();
        playerMinAttackPanel.setLayout(new BoxLayout(playerMinAttackPanel, BoxLayout.Y_AXIS));
        JButton upgradeMinAttackButton = new JButton("Upgrade min attack");
        playerMinAttackPanel.add(upgradeMinAttackButton);
        JLabel pMinAttackLabel = new JLabel("MinAttack");
        playerMinAttackPanel.add(pMinAttackLabel);
        playerStatsPanel.add(playerMinAttackPanel);

        JPanel playerMaxAttackPanel = new JPanel();
        playerMaxAttackPanel.setLayout(new BoxLayout(playerMaxAttackPanel, BoxLayout.Y_AXIS));
        JButton upgradeMaxAttackButton = new JButton("Upgrade max attack");
        playerMaxAttackPanel.add(upgradeMaxAttackButton);
        JLabel pMaxAttackLabel = new JLabel("MaxAttack");
        playerMaxAttackPanel.add(pMaxAttackLabel);
        playerStatsPanel.add(playerMaxAttackPanel);

        JLabel coinsLabel = new JLabel("Coins");
        playerStatsPanel.add(coinsLabel);

        everythingPanel.add(playerStatsPanel);

        everythingPanel.add(new JLabel(" "));
        everythingPanel.add(new JLabel(" "));
        everythingPanel.add(new JLabel(" "));

        everythingPanel.add(new JLabel("Enemy Stats"));

        everythingPanel.add(new JLabel(" "));

        JPanel enemyStatsPanel = new JPanel();
        enemyStatsPanel.setLayout(new BoxLayout(enemyStatsPanel, BoxLayout.X_AXIS));
        JLabel eHealthLabel = new JLabel("Health");
        enemyStatsPanel.add(eHealthLabel);
        JLabel eMinAttackLabel = new JLabel("MinAttack");
        enemyStatsPanel.add(eMinAttackLabel);
        JLabel eMaxAttackLabel = new JLabel("MaxAttack");
        enemyStatsPanel.add(eMaxAttackLabel);
        everythingPanel.add(enemyStatsPanel);

        worldFrame.add(everythingPanel);

        worldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        worldFrame.setSize(750, 250);

        worldFrame.setVisible(true);

        PlayerSpaceship p1 = new PlayerSpaceship();
        p1.setHealthLabel(pHealth);
        p1.setMinAttackLabel(pMinAttackLabel);
        p1.setMaxAttackLabel(pMaxAttackLabel);
        p1.setCoinsLabel(coinsLabel);

        while (true) {
            EnemySpaceship e1 = new EnemySpaceship(level.get());
            e1.setHealthLabel(eHealthLabel);
            e1.setMinAttackLabel(eMinAttackLabel);
            e1.setMaxAttackLabel(eMaxAttackLabel);

            e1.displayHealth();

            while (!p1.isDead() && !e1.isDead()) {
                e1.removeHealth(p1.attack());
                if (e1.isDead()) {
                    p1.addCoins(level.get());
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
        /*ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        };

        upgradeHealth.addActionListener(listener);
        upgradeHealth.removeActionListener(listener);

         */
    }
}