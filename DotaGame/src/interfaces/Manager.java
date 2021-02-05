package interfaces;

import Heroes.Hero;

import java.util.List;

public interface Manager {
     void addHero(List<String> arguments);

     void addItem(List<String> arguments) throws NoSuchFieldException, IllegalAccessException;

     void addRecipe(List<String> arguments) throws NoSuchFieldException, IllegalAccessException;

    void attackHero(List<String> arguments);
    void getHeroInfo(List<String> arguments);

    void quit();
}
