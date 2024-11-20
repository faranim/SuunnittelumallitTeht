package FactoryMethod;

class WildernessMap extends Map {
    @Override
    protected Tile createTile() {
        int choice = random.nextInt(3); // 0, 1, 2
        switch (choice) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                return null;
        }
    }
}