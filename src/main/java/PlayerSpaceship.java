import javax.swing.*;

public class PlayerSpaceship {
    public int health = 20;
    public int battleHealth = health;
    public int minAttack = 1;
    public int maxAttack = 5;
    public int coins = 0;
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
        Thread.sleep(1000);
    }

    public void reset() throws InterruptedException {
        battleHealth = health;
        this.healthLabel.setText("Health: " + battleHealth);
        Thread.sleep(1000);
    }

    public void addCoins(int level) throws InterruptedException {
        coins += level * 2;
        this.coinsLabel.setText("Coins: " + coins);
        Thread.sleep(1000);
    }

    public void upgradeHealth() throws InterruptedException {
        if (coins >= 10) {
            health += 5;
            coins -= 10;
            this.coinsLabel.setText("Coins: " + coins);
            Thread.sleep(1000);
            this.healthLabel.setText("Coins: " + battleHealth);
            Thread.sleep(1000);
        }
    }

    public void upgradeMinAttack() throws InterruptedException {
        if (minAttack < maxAttack && coins >= 10) {
            minAttack += 1;
            coins -= 10;
            this.coinsLabel.setText("Coins: " + coins);
            Thread.sleep(1000);
            this.minAttackLabel.setText("Coins: " + minAttack);
            Thread.sleep(1000);
        }
    }

    public void upgradeMaxAttack() throws InterruptedException {
        if (coins >= 10) {
            maxAttack += 1;
            coins -= 10;
            this.coinsLabel.setText("Coins: " + coins);
            Thread.sleep(1000);
            this.maxAttackLabel.setText("Coins: " + maxAttack);
            Thread.sleep(1000);
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