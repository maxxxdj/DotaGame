package entities.Items;

import java.util.List;

public class RecipeBuilder {
    private Recipe recipe;

    public RecipeBuilder() {
        this.recipe = new Recipe();
    }

    public RecipeBuilder withName(String name) {
        this.recipe.setName(name);
        return this;
    }
    public RecipeBuilder withHeroAssignedTo(String name){
        this.recipe.setHeroAssignedTo(name);
        return this;
    }

    public RecipeBuilder withStrengthBonus(long strengthBonus) {
        this.recipe.setStrengthBonus(strengthBonus);
        return this;
    }

    public RecipeBuilder withAgilityBonus(long agilityBonus) {
        this.recipe.setAgilityBonus(agilityBonus);
        return this;
    }

    public RecipeBuilder withIntelligenceBonus(long intelligenceBonus) {
        this.recipe.setIntelligenceBonus(intelligenceBonus);
        return this;
    }

    public RecipeBuilder withHitPointsBonus(long hitPointsBonus) {
        this.recipe.setHitPointsBonus(hitPointsBonus);
        return this;
    }

    public RecipeBuilder withDamageBonus(long damageBonus) {
        this.recipe.setDamageBonus(damageBonus);
        return this;
    }
    public RecipeBuilder withRequiredItems(List<String> arguments){
        for (int i = 7; i < arguments.size(); i++) {
            this.recipe.addToRequiredItems(arguments.get(i));
        }
        return this;
    }
    public Recipe build() {
        return this.recipe;
    }

}
