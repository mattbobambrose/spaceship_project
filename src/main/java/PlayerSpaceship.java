import javax.swing.*;

public class PlayerSpaceship {
    public int health = 10;
    public int battleHealth = health;
    public int minAttack = 1;
    public int maxAttack = 5;
    public int coins = 0;
    JButton button;

    public PlayerSpaceship(JButton button) {
        this.button = button;
    }

    public int attack() throws InterruptedException {
        int temp = (int) (Math.random() * (maxAttack - minAttack) + minAttack);
        for (int i = 0; i < 100; i++) {
            temp = (int) (Math.random() * (maxAttack - minAttack) + minAttack);
            this.button.setText("" + temp);
            Thread.sleep(1000);
        }
        return temp;
    }

    public void removeHealth(int a) {
        battleHealth -= a;
    }

    public void reset() {
        battleHealth = health;
    }

    public void addCoins(int level) {
        coins += level * 2;
    }

    public void upgradeHealth() {
        if (coins >= 10) {
            health += 5;
            coins -= 10;
        }
    }

    public void upgradeMinAttack() {
        if (minAttack < maxAttack && coins >= 10) {
            minAttack += 1;
            coins -= 10;
        }
    }

    public void upgradeMaxAttack() {
        if (coins >= 10) {
            maxAttack += 1;
            coins -= 10;
        }
    }

    public boolean isDead() {
        if (battleHealth <= 0) {
            return true;
        }
        return false;
    }
}