import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class World {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger level = new AtomicInteger(1);
        final AtomicBoolean enabled = new AtomicBoolean(true);
        JFrame worldFrame = new JFrame("World");

        JPanel everythingPanel = new JPanel();
        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Level: " + level);

        JPanel levelPanel = new JPanel();
        JButton levelDown = new JButton("Down");
        levelDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label1.setText("Level: " + level.decrementAndGet());
                enabled.set(false);
            }
        });

        JButton levelUp = new JButton("Up");
        levelUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                label1.setText("Level: " + level.incrementAndGet());
                enabled.set(false);
            }
        });
        levelPanel.add(levelDown);
        levelPanel.add(label1);
        levelPanel.add(levelUp);
        everythingPanel.add(levelPanel);

        everythingPanel.add(new JLabel(" "));
        everythingPanel.add(new JLabel("Player Stats"));
        everythingPanel.add(new JLabel(" "));


        JPanel playerStatsPanel = new JPanel();
        playerStatsPanel.setLayout(new BoxLayout(playerStatsPanel, BoxLayout.X_AXIS));

        JPanel playerHealthPanel = new JPanel();
        playerHealthPanel.setLayout(new BoxLayout(playerHealthPanel, BoxLayout.Y_AXIS));
        JButton upgradeHealthButton = new JButton("Upgrade health for 4");
        playerHealthPanel.add(upgradeHealthButton);
        JLabel pHealth = new JLabel("health");
        playerHealthPanel.add(pHealth);
        playerStatsPanel.add(playerHealthPanel);

        JPanel playerMinAttackPanel = new JPanel();
        playerMinAttackPanel.setLayout(new BoxLayout(playerMinAttackPanel, BoxLayout.Y_AXIS));
        JButton upgradeMinAttackButton = new JButton("Upgrade min attack for 4");
        playerMinAttackPanel.add(upgradeMinAttackButton);
        JLabel pMinAttackLabel = new JLabel("MinAttack");
        playerMinAttackPanel.add(pMinAttackLabel);
        playerStatsPanel.add(playerMinAttackPanel);

        JPanel playerMaxAttackPanel = new JPanel();
        playerMaxAttackPanel.setLayout(new BoxLayout(playerMaxAttackPanel, BoxLayout.Y_AXIS));
        JButton upgradeMaxAttackButton = new JButton("Upgrade max attack for 4");
        playerMaxAttackPanel.add(upgradeMaxAttackButton);
        JLabel pMaxAttackLabel = new JLabel("MaxAttack");
        playerMaxAttackPanel.add(pMaxAttackLabel);
        playerStatsPanel.add(playerMaxAttackPanel);

        JLabel coinsLabel = new JLabel("Coins");
        playerStatsPanel.add(coinsLabel);

        everythingPanel.add(playerStatsPanel);

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

        everythingPanel.add(new JLabel(" "));

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
            System.out.println("Health: " + p1.battleHealth);
            System.out.println("Health: " + e1.health);

            ActionListener healthListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        p1.upgradeHealth();
                        enabled.set(false);
                        upgradeHealthButton.setText("Upgrade health for " + p1.healthUpgradePrice);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            };
            upgradeHealthButton.addActionListener(healthListener);

            ActionListener minAttackListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        p1.upgradeMinAttack();
                        upgradeMinAttackButton.setText("Upgrade min attack for " + p1.minAttackUpgradePrice);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            };
            upgradeMinAttackButton.addActionListener(minAttackListener);

            ActionListener maxAttackListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        p1.upgradeMaxAttack();
                        upgradeMaxAttackButton.setText("Upgrade max attack for " + p1.maxAttackUpgradePrice);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
            };
            upgradeMaxAttackButton.addActionListener(maxAttackListener);

            while (!p1.isDead() && !e1.isDead() && enabled.get()) {
                e1.removeHealth(p1.attack());
                if (!enabled.get()) {
                    p1.reset();
                    break;
                }
                System.out.println("Still running");
                if (e1.isDead()) {
                    p1.addCoins(level.get());
                    p1.reset();
                    break;
                }
                p1.removeHealth(e1.attack());
                if (!enabled.get()) {
                    p1.reset();
                    break;
                }
                System.out.println("Running");
                if (p1.isDead()) {
                    p1.reset();
                    break;
                }
            }
            upgradeHealthButton.removeActionListener(healthListener);
            upgradeHealthButton.removeActionListener(minAttackListener);
            upgradeHealthButton.removeActionListener(maxAttackListener);
            enabled.set(true);
        }
    }
}