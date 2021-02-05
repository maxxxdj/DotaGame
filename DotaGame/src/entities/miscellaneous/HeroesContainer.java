package entities.miscellaneous;

import Heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroesContainer {
    private static List<Hero> heroes;
    private static HeroesContainer instance;

    public HeroesContainer() {
        heroes = new ArrayList<Hero>();
    }

    public static HeroesContainer getInstance() {
        if (instance != null) {
            return instance;
        }
        return new HeroesContainer();
    }

    public static void add(Hero hero) {
        heroes.add(hero);
    }

    public static Hero getHeroByName(String name) {
        Hero heroByName = null;
        for (Hero hero : heroes) {
            if (hero.getName().equals(name)) {
                heroByName = hero;
            }
        }
        return heroByName;
    }

    public static boolean isHeroDead(String name) {
        Hero hero = getHeroByName(name);
        if (hero.getHitPoints() <= 0) {
            heroes.remove(hero);
            return true;
        }
        return false;
    }

    public static boolean isEmpty() {
        if (heroes.size() == 0) {
            return true;
        }
        return false;
    }

    public static int size() {
        return heroes.size();
    }
}
