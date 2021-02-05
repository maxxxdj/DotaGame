package Heroes;

public class Strength extends Hero {
    public Strength(String name) {
        super(name);
        super.setStrength(90);
        super.setAgility(25);
        super.setIntelligence(10);
        super.setHitPoints(800);
        super.setDamage(100);
    }
}
