package entities.Items;

public class ItemBuilder {
    private Item item;


    public ItemBuilder() {
        this.item = new Item();
    }

    public ItemBuilder withName(String name) {
        this.item.setName(name);
        return this;
    }

    public ItemBuilder withStrengthBonus(long strengthBonus) {
        this.item.setStrengthBonus(strengthBonus);
        return this;
    }

    public ItemBuilder withAgilityBonus(long agilityBonus) {
        this.item.setAgilityBonus(agilityBonus);
        return this;
    }

    public ItemBuilder withIntelligenceBonus(long intelligenceBonus) {
        this.item.setIntelligenceBonus(intelligenceBonus);
        return this;
    }

    public ItemBuilder withHitPointsBonus(long hitPointsBonus) {
        this.item.setHitPointsBonus(hitPointsBonus);
        return this;
    }

    public ItemBuilder withDamageBonus(long damageBonus) {
        this.item.setDamageBonus(damageBonus);
        return this;
    }

    public Item build() {
        return this.item;
    }
}
