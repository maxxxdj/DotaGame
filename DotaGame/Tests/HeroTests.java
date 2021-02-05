import Heroes.Strength;
import Heroes.Hero;
import Heroes.Intelligence;
import entities.Items.ItemBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HeroTests {
    private List<Hero> testHeroes;

    @Before
    public void setUp() {
        this.testHeroes = new ArrayList<>();
        this.testHeroes.add(new Strength("Vankata"));
        this.testHeroes.add(new Intelligence("Sorcerer"));
    }

    //Strength hero tests
    // Name - Vankata,
    // Strength - 90,
    // Agility - 25,
    // Intelligence - 10,
    // Hitpoints - 800,
    // Damage - 100;
    @Test
    public void testHeroName() {
        Assert.assertEquals("Vankata", testHeroes.get(0).getName());
    }

    @Test
    public void testHeroStrength() {
        Assert.assertEquals(90, testHeroes.get(0).getStrength());
    }

    @Test
    public void testHeroAgility() {
        Assert.assertEquals(25, testHeroes.get(0).getAgility());
    }

    @Test
    public void testHeroIntelligence() {
        Assert.assertEquals(10, testHeroes.get(0).getIntelligence());
    }

    @Test
    public void testHeroHitPoints() {
        Assert.assertEquals(800, testHeroes.get(0).getHitPoints());
    }

    @Test
    public void testHeroDamage() {
        Assert.assertEquals(100, testHeroes.get(0).getDamage());
    }

    //Adding an item with stats:
    @Test
    public void testHeroDamageAfterAddingAnItem() throws NoSuchFieldException, IllegalAccessException {
        testHeroes.get(0).addItem(new ItemBuilder()
                .withName("Eye Of Skadi")
                .withStrengthBonus(20)
                .withAgilityBonus(20)
                .withIntelligenceBonus(20)
                .withHitPointsBonus(300)
                .withDamageBonus(100)
                .build());
        Assert.assertEquals(110, testHeroes.get(0).getStrength()); // 90 + 20bonus
        Assert.assertEquals(45, testHeroes.get(0).getAgility()); //20 + 20bonus
        Assert.assertEquals(30, testHeroes.get(0).getIntelligence()); //10 + 20bonus
        Assert.assertEquals(1100, testHeroes.get(0).getHitPoints()); //800 + 300bonus
        Assert.assertEquals(200, testHeroes.get(0).getDamage()); //100 + 100bonus
    }

}

