import javax.swing.*;

public class EnemySpaceship {
    public int health;
    public int minAttack;
    public int maxAttack;
    public JLabel healthLabel, minAttackLabel, maxAttackLabel;

    public EnemySpaceship(int level) {
        calcStats(level);
    }

    public int attack() {
        return (int) (Math.random() * (maxAttack - minAttack) + minAttack);
    }

    public void removeHealth(int a) throws InterruptedException {
        health -= a;
        this.healthLabel.setText("Health: " + health);
        Thread.sleep(1000);
    }

    public void calcStats(int level) {
        health = 10 + level ^ 2;
        minAttack = level;
        maxAttack = level * 3;
    }

    public boolean isDead() {
        if (health <= 0) {
            return true;
        }
        return false;
    }

    public void displayHealth() throws InterruptedException {
        this.healthLabel.setText("Health: " + health);
        this.minAttackLabel.setText("    Min attack: " + minAttack);
        this.maxAttackLabel.setText("    Max attack: " + maxAttack);
        Thread.sleep(1000);
    }

    public void setHealthLabel(JLabel healthLabel) {
        this.healthLabel = healthLabel;
    }

    public void setMinAttackLabel(JLabel minAttackLabel) {
        this.minAttackLabel = minAttackLabel;
    }

    public void setMaxAttackLabel(JLabel maxAttackLabel) {
        this.maxAttackLabel = maxAttackLabel;
    }
}