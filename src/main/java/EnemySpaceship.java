public class EnemySpaceship {
    public int health;
    public int minAttack;
    public int maxAttack;
    public int level = 1;

    public EnemySpaceship() {
        calcStats();
    }

    public int attack() {
        return (int) (Math.random() * (maxAttack - minAttack) + minAttack);
    }

    public void removeHealth(int a) {
        health -= a;
    }

    public void calcStats() {
        health = 10 + this.level ^ 2;
        minAttack = this.level;
        maxAttack = this.level * 2;
    }

    public boolean isDead() {
        if (health <= 0) {
            return true;
        }
        return false;
    }
}