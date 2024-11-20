package FactoryMethod;

class CityMap extends Map {
    @Override
    protected Tile createTile() {
        int choice = random.nextInt(3); // 0, 1, 2
        switch (choice) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                return null;
        }
    }
}
