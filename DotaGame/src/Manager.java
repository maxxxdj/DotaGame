import Heroes.Agility;
import Heroes.Strength;
import Heroes.Hero;
import Heroes.Intelligence;
import entities.Items.ItemBuilder;
import entities.Items.RecipeBuilder;
import entities.miscellaneous.HeroesContainer;

import java.util.List;

public class Manager implements interfaces.Manager {
    HeroesContainer heroes = HeroesContainer.getInstance();

    @Override
    public void addHero(List<String> arguments) {
        try {
            String heroName = arguments.get(0);
            String type = arguments.get(1);
            if (!    ( type.equals("Strength")
                    || type.equals("Agility")
                    || type.equals("Intelligence"))) {
                throw new IllegalArgumentException("Wrong hero type!");
            }
            switch (type) {
                case "Strength":
                    HeroesContainer.add(new Strength(heroName));
                    break;
                case "Agility":
                    HeroesContainer.add(new Agility(heroName));
                    break;
                case "Intelligence":
                    HeroesContainer.add(new Intelligence(heroName));
                    break;
            }
            System.out.printf("A new %s hero is created - %s%n", type.toLowerCase(), heroName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Wrong command!");
        }
    }

    @Override
    public void addItem(List<String> arguments){
        try {
            String itemName = arguments.get(0);
            String heroName = arguments.get(1);
            if(HeroesContainer.isEmpty()){
                throw new IllegalArgumentException("No heroes found!");
            }
            Hero hero = HeroesContainer.getHeroByName(heroName);
            hero.addItem(
                    new ItemBuilder()
                            .withName(itemName)
                            .withStrengthBonus(Integer.parseInt(arguments.get(2)))
                            .withAgilityBonus(Integer.parseInt(arguments.get(3)))
                            .withIntelligenceBonus(Integer.parseInt(arguments.get(4)))
                            .withHitPointsBonus(Integer.parseInt(arguments.get(5)))
                            .withDamageBonus(Integer.parseInt(arguments.get(6)))
                            .build());
            System.out.printf("Added item - %s to Hero - %s%n", itemName, heroName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void addRecipe(List<String> arguments) {
        try {
            String recipeName = arguments.get(0);
            String heroName = arguments.get(1);
            if(HeroesContainer.isEmpty()){
                throw new IllegalArgumentException("No heroes found!");
            }
            Hero hero = HeroesContainer.getHeroByName(heroName);
            hero.addRecipe(
                    new RecipeBuilder()
                            .withName(recipeName)
                            .withHeroAssignedTo(heroName)
                            .withStrengthBonus(Integer.parseInt(arguments.get(2)))
                            .withAgilityBonus(Integer.parseInt(arguments.get(3)))
                            .withIntelligenceBonus(Integer.parseInt(arguments.get(4)))
                            .withHitPointsBonus(Integer.parseInt(arguments.get(5)))
                            .withDamageBonus(Integer.parseInt(arguments.get(6)))
                            .withRequiredItems(arguments)     //required items could be more than 1
                            .build());
            System.out.printf("Added recipe - %s to Hero - %s%n", recipeName, heroName);
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong recipe!");
        }
    }

    @Override
    public void attackHero(List<String> arguments) {
        try {
            if (HeroesContainer.isEmpty()){
                throw new NullPointerException("No heroes found!");
            } else if (arguments.get(0).equals(arguments.get(1))){
                throw new NullPointerException("Unsupported operation!");
            }
            Hero firstHero = HeroesContainer.getHeroByName(arguments.get(0));
            Hero secondHero = HeroesContainer.getHeroByName(arguments.get(1));
            firstHero.attackHero(secondHero);
            if(HeroesContainer.isHeroDead(secondHero.getName())){
                System.out.printf("%s was killed by %s.%n",secondHero.getName(),firstHero.getName());
            } else {
                System.out.printf("%s has hit %s and caused him %d damage.%n",firstHero.getName(),secondHero.getName(),firstHero.getDamage());
                System.out.printf("%s has more %d hitpoints left.%n",secondHero.getName(),secondHero.getHitPoints());
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public void getHeroInfo(List<String> arguments) {
        try {
            String heroName = arguments.get(0);
            Hero hero = HeroesContainer.getHeroByName(heroName);
            System.out.println(hero.toString());
        } catch (Exception e) {
            throw new IllegalArgumentException("No hero found!");
        }
    }

    @Override
    public void quit() {
        System.out.println("Thank you for playing DotaGame!");
    }
}
