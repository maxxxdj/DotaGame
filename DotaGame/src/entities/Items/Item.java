package entities.Items;

public class Item {
    private String name;
    private String heroAssignedTo;
    private long strengthBonus;
    private long agilityBonus;
    private long intelligenceBonus;
    private long hitPointsBonus;
    private long damageBonus;


    public Item() {
    }

//Getters & Setters

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getHeroAssignedTo() {
        return this.heroAssignedTo;
    }

    public void setHeroAssignedTo(String heroAssignedTo) {
        this.heroAssignedTo = heroAssignedTo;
    }

    public long getStrengthBonus() {
        return this.strengthBonus;
    }

    protected void setStrengthBonus(long strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public long getAgilityBonus() {
        return agilityBonus;
    }

    protected void setAgilityBonus(long agilityBonus) {
        this.agilityBonus = agilityBonus;
    }

    public long getIntelligenceBonus() {
        return this.intelligenceBonus;
    }

    protected void setIntelligenceBonus(long intelligenceBonus) {
        this.intelligenceBonus = intelligenceBonus;
    }

    public long getHitPointsBonus() {
        return this.hitPointsBonus;
    }

    protected void setHitPointsBonus(long hitPointsBonus) {
        this.hitPointsBonus = hitPointsBonus;
    }

    public long getDamageBonus() {
        return this.damageBonus;
    }

    protected void setDamageBonus(long damageBonus) {
        this.damageBonus = damageBonus;
    }

}


