import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Manager dotaGame = new Manager();
        String input = reader.readLine();
        while (!input.isEmpty()) {
            try {
                List<String> arguments =
                        Arrays.stream(input.split(" ")).collect(Collectors.toList());
                String command = arguments.get(0);
                if (
                                 !(command.equals("Hero")
                                || command.equals("Item")
                                || command.equals("Recipe")
                                || command.equals("Attack")
                                || command.equals("Info")
                                || command.equals("Quit"))) {
                    throw new IllegalArgumentException(String.format("Unknown command - '%s'.%nTry again:%n", command));
                }
                arguments.remove(0);
                if (command.equals("Quit")) {

                } else if (arguments.isEmpty()) {
                    throw new IllegalArgumentException("Please, enter your command line correctly!");
                }
                switch (command) {
                    case "Hero":
                        dotaGame.addHero(arguments);
                        break;
                    case "Item":
                        dotaGame.addItem(arguments);
                        break;
                    case "Recipe":
                        dotaGame.addRecipe(arguments);
                        break;
                    case "Attack":
                        dotaGame.attackHero(arguments);
                        break;
                    case "Info":
                        dotaGame.getHeroInfo(arguments);
                        break;
                    case "Quit":
                        dotaGame.quit();
                        System.exit(0);
                        break;
                }

                    input = reader.readLine();
                if(input.isEmpty()){
                    break;
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                input = reader.readLine();
            }
        }
    }
}