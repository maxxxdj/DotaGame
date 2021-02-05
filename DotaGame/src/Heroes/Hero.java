package Heroes;

import entities.Items.Item;
import entities.miscellaneous.HeroInventory;
import entities.Items.Recipe;
import entities.miscellaneous.HeroesContainer;

import java.util.List;

public class Hero implements interfaces.Hero {
    private final HeroInventory inventory;
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;

    public Hero(String name) {
        this.inventory = new HeroInventory();
        this.setName(name);
    }

    //Getters from interface
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength;
    }

    @Override
    public long getAgility() {
        return this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.intelligence;

    }

    @Override
    public long getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.damage;
    }

    //Setters
    protected void setName(String name) {
        this.name = name;
    }

    protected void setStrength(long strength) {
        this.strength = strength;
    }

    protected void setAgility(long agility) {
        this.agility = agility;
    }

    protected void setIntelligence(long intelligence) {
        this.intelligence = intelligence;
    }

    protected void setHitPoints(long hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }
    //Interface methods

    @Override
    public List<entities.Items.Item> getItems() {
        return inventory.getCommonItems();
    }

    @Override
    public void addItem(Item item) throws NoSuchFieldException, IllegalAccessException {
        inventory.addCommonItem(item);
        addStatsFromItem(item);
    }

    public void addStatsFromItem(Item item) {
        this.strength += item.getStrengthBonus();
        this.agility += item.getAgilityBonus();
        this.intelligence += item.getIntelligenceBonus();
        this.hitPoints += item.getHitPointsBonus();
        this.damage += item.getDamageBonus();
    }

    @Override
    public void addRecipe(Recipe recipe) throws NoSuchFieldException, IllegalAccessException {
        inventory.addRecipeItem(recipe);
        
    }

    @Override
    public void attackHero(Hero hero) {
        long newHitpoints = hero.getHitPoints()-this.damage;
        hero.setHitPoints(newHitpoints);
    }

    public void removeItem(String itemName) {
        inventory.removeCommonItem(itemName);
    }

    @Override
    public String toString() {
        return String.format(
                "Hero: %s, Class: %s%n" +
                        "Hitpoints: %d, Damage: %d%n" +
                        "Strength: %d%n" +
                        "Agility: %d%n" +
                        "Intelligence: %d%n" +
                        "Items: " +
                        "%s"
                , this.name, this.getClass().getSimpleName(),
                this.hitPoints, this.damage,
                this.strength,
                this.agility,
                this.intelligence,
                inventory.toString());

    }
}
