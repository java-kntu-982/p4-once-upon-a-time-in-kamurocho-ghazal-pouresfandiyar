package ir.ac.kntu;

public class Soldier {
    private String name;
    private double health;
    private double attack;
    private int attackRange;
    private int speed;
    private int level;
    private double x;
    private double y;

    public Soldier(String name, double health, double attack, int attackRange,int speed) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.attackRange = attackRange;
        this.level=1;
        this.speed=speed;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public int getLevel() {
        return level;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
