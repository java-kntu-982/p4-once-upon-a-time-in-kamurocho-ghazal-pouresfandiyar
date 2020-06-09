package ir.ac.kntu;

public enum Item {
    CONTAINER("Container",3000),
    TRUCK("Truck",5000),
    POWERSHOVEL("PowerShovel",11000),
    VAN("Van",6000),
    STEELFRAMEWORK("SteelFramework",8500)
    ;

    Item( String name,double durability) {
        this.durability = durability;
        this.level=1;
    }

    @Override
    public String toString() {
        return "Name : "+name +
                ", Durability : " + durability +
                " , level : " + level ;
    }
    private String name;
    private double durability;
    private int level;

    public int getLevel() {
        return level;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
