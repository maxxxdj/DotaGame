package Heroes;

public class Intelligence extends Hero {
    public Intelligence(String name) {
        super(name);
        super.setStrength(25);
        super.setAgility(25);
        super.setIntelligence(100);
        super.setHitPoints(450);
        super.setDamage(85);
    }
}
