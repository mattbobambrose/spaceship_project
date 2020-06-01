import javax.swing.*;

public class PlayerSpaceship {
    public int health = 20;
    public int battleHealth = health;
    public int minAttack = 1;
    public int maxAttack = 5;
    public int coins = 0;
    public int healthUpgradePrice = 4;
    public int minAttackUpgradePrice = 4;
    public int maxAttackUpgradePrice = 4;
    public JLabel healthLabel, minAttackLabel, maxAttackLabel, coinsLabel;
    public JButton upHealthButton, upMinAttackButton, upMaxAttackButton;

    public int attack() {
        return (int) (Math.random() * (maxAttack - minAttack) + minAttack);
    }

    public void removeHealth(int a) throws InterruptedException {
        battleHealth -= a;
        this.healthLabel.setText("Health: " + battleHealth);
        this.minAttackLabel.setText("Min attack: " + minAttack);
        this.maxAttackLabel.setText("Max attack: " + maxAttack);
        this.coinsLabel.setText("Coins: " + coins);
        Thread.sleep(250);
    }

    public void reset() throws InterruptedException {
        battleHealth = health;
        this.healthLabel.setText("Health: " + battleHealth);
        Thread.sleep(500);
    }

    public void addCoins(int level) throws InterruptedException {
        coins += (level * 2) + (int) (level * 0.1) * 5;
        this.coinsLabel.setText("Coins: " + coins);
    }

    public void upgradeHealth() throws InterruptedException {
        if (coins >= healthUpgradePrice) {
            coins -= healthUpgradePrice;
            healthUpgradePrice = healthUpgradePrice + (int) (healthUpgradePrice * 0.5);
            health = health + (int) (health * 0.25);
            this.coinsLabel.setText("Coins: " + coins);
            Thread.sleep(100);
            this.healthLabel.setText("Health: " + battleHealth);
            Thread.sleep(100);
        }
    }

    public void upgradeMinAttack() throws InterruptedException {
        if (minAttack < maxAttack && coins >= minAttackUpgradePrice) {
            coins -= minAttackUpgradePrice;
            minAttackUpgradePrice = maxAttackUpgradePrice + (int) (maxAttackUpgradePrice * 0.35);
            minAttack += 1 + (int) (minAttack * 0.1);
            ;
            this.coinsLabel.setText("Coins: " + coins);
            Thread.sleep(250);
            this.minAttackLabel.setText("Min attack: " + minAttack);
            Thread.sleep(250);
        }
    }

    public void upgradeMaxAttack() throws InterruptedException {
        if (coins >= maxAttackUpgradePrice) {
            coins -= maxAttackUpgradePrice;
            maxAttackUpgradePrice = maxAttackUpgradePrice + (int) (maxAttackUpgradePrice * 0.25);
            maxAttack += 1 + (int) (maxAttack * 0.1);
            this.coinsLabel.setText("Coins: " + coins);
            Thread.sleep(250);
            this.maxAttackLabel.setText("Max attack: " + maxAttack);
            Thread.sleep(250);
        }
    }

    public void setUpHealthButton(JButton upHealthButton) {
        this.upHealthButton = upHealthButton;
    }

    public void setUpMinAttackButton(JButton upMinAttackButton) {
        this.upMinAttackButton = upMinAttackButton;
    }

    public void setUpMaxAttackButton(JButton upMaxAttackButton) {
        this.upMaxAttackButton = upMaxAttackButton;
    }

    public void setHealthLabel(JLabel health) {
        this.healthLabel = health;
    }

    public void setMinAttackLabel(JLabel minAttack) {
        this.minAttackLabel = minAttack;
    }

    public void setMaxAttackLabel(JLabel maxAttack) {
        this.maxAttackLabel = maxAttack;
    }

    public void setCoinsLabel(JLabel coins) {
        this.coinsLabel = coins;
    }

    public boolean isDead() {
        if (battleHealth <= 0) {
            return true;
        }
        return false;
    }
}