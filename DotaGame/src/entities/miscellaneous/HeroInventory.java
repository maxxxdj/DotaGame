package entities.miscellaneous;


import Heroes.Hero;
import entities.Items.Item;
import entities.Items.ItemBuilder;
import entities.Items.ItemCollection;
import entities.Items.Recipe;

import java.lang.reflect.Field;
import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;
    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<String, Item>();
        this.recipeItems = new LinkedHashMap<String, Recipe>();
    }

    //Getters
    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getStrengthBonus).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getAgilityBonus).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getIntelligenceBonus).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getHitPointsBonus).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.values().stream().mapToLong(Item::getDamageBonus).sum();
    }

    public List<Item> getCommonItems() {
        return new ArrayList<>(this.commonItems.values());
    }

    public Item getItemByName(String name) {
        Item item = null;
        if (commonItems.containsKey(name)) {
            item = commonItems.get(name);
        }
        return item;
    }

    //Functional methods

    @Override
    public void addCommonItem(Item item) throws NoSuchFieldException, IllegalAccessException {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) throws NoSuchFieldException, IllegalAccessException {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    public void removeCommonItem(String item) {
        this.commonItems.remove(item);
    }

    private void checkRecipes() throws NoSuchFieldException, IllegalAccessException {
        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<String>(recipe.getRequiredItems());

            for (Item item : this.commonItems.values()) {
                if (requiredItems.contains(item.getName())) {
                    requiredItems.remove(item.getName());
                }
            }

            if (requiredItems.isEmpty()) {
                //combining the recipe item if the hero already have the required items
                this.combineRecipe(recipe);
                // adding the new stats
                HeroesContainer.getHeroByName(recipe.getHeroAssignedTo()).addStatsFromItem(recipe);
            } else {
                System.out.println("More items are needed for combining this recipe!");
            }
        }
    }


    private void combineRecipe(Recipe recipe) throws NoSuchFieldException, IllegalAccessException {

        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            if (commonItems.containsKey(item)) {
                Item currentItem = this.getItemByName(item);
                this.removeCommonItem(item);

                Hero hero = HeroesContainer.getHeroByName(recipe.getHeroAssignedTo());
                //Decreasing stats after item removal using Java Reflection Method
                decreaseStats(currentItem, hero);
                //Stats should be decreased
            }
        }

        //Creating a new item with the Builder Pattern
        Item newItem = new ItemBuilder()
                .withName(recipe.getName())
                .withStrengthBonus(recipe.getStrengthBonus())
                .withAgilityBonus(recipe.getAgilityBonus())
                .withIntelligenceBonus(recipe.getIntelligenceBonus())
                .withHitPointsBonus(recipe.getHitPointsBonus())
                .withDamageBonus(recipe.getDamageBonus())
                .build();


        //recipe is turned into new CommonItem which is giving bonus stats
        this.recipeItems.remove(recipe.getName(),recipe);
        this.addCommonItem(newItem);
    }


    private void decreaseStats(Item currentItem, Hero hero) throws NoSuchFieldException, IllegalAccessException {
        //Strength update
        Field heroStrength = hero.getClass()
                .getSuperclass().getDeclaredField("strength");
        heroStrength.setAccessible(true);
        heroStrength.setLong(hero, heroStrength.getLong(hero) - currentItem.getStrengthBonus());
        //Agility update
        Field heroAgility = hero.getClass()
                .getSuperclass().getDeclaredField("agility");
        heroAgility.setAccessible(true);
        heroAgility.setLong(hero, heroAgility.getLong(hero) - currentItem.getAgilityBonus());
        //Intelligence update
        Field heroIntelligence = hero.getClass()
                .getSuperclass().getDeclaredField("intelligence");
        heroIntelligence.setAccessible(true);
        heroIntelligence.setLong(hero, heroIntelligence.getLong(hero) - currentItem.getIntelligenceBonus());
        //Hitpoints update
        Field heroHitPoints = hero.getClass()
                .getSuperclass().getDeclaredField("hitPoints");
        heroHitPoints.setAccessible(true);
        heroHitPoints.setLong(hero, heroHitPoints.getLong(hero) - currentItem.getHitPointsBonus());
        //Damage update
        Field heroDamage = hero.getClass()
                .getSuperclass().getDeclaredField("damage");
        heroDamage.setAccessible(true);
        heroDamage.setLong(hero, heroDamage.getLong(hero) - currentItem.getDamageBonus());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (this.commonItems.isEmpty()) {
            return "None";
        } else {
            for (Item item : this.commonItems.values()) {
                builder.append(String.format(
                        "%n###Item: %s%n" +
                                "###+%d Strength%n" +
                                "###+%d Agility%n" +
                                "###+%d Intelligence%n" +
                                "###+%d Hitpoints%n" +
                                "###+%d Damage",
                        item.getName(),
                        item.getStrengthBonus(),
                        item.getAgilityBonus(),
                        item.getIntelligenceBonus(),
                        item.getHitPointsBonus(),
                        item.getDamageBonus()));
            }
            return builder.toString();
        }
    }
}
