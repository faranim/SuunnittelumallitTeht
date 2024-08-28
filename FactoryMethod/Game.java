package FactoryMethod;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();

        Map cityMap = game.createMap("city");
        System.out.println("City Map:");
        cityMap.display(5, 5);

        Map wildernessMap = game.createMap("wilderness");
        System.out.println("Wilderness Map:");
        wildernessMap.display(5, 5);
    }

    public Map createMap(String type) {
        switch (type.toLowerCase()) {
            case "city":
                return new CityMap();
            case "wilderness":
                return new WildernessMap();
            default:
                throw new IllegalArgumentException("Unknown map type: " + type);
        }
    }
}
