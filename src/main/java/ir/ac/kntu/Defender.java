package ir.ac.kntu;

public class Defender extends Soldier {
    private int fieldOfView;

    public Defender(String name, double health, double attack, int fieldOfView, int attackRange,int speed) {
        super(name, health, attack, attackRange,speed);
        this.fieldOfView = fieldOfView;
    }

    @Override
    public String toString() {
        return "-Name : " +getName() +
                " , Health: "+getHealth() +
                " , Attack : "+getAttack()+
                " , Field of view : "+fieldOfView +
                " , Attack Range : "+getAttackRange()+
                " , Level : "+getLevel();
    }
}
