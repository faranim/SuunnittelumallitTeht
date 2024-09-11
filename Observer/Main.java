package Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation("Station 1", -10, 35);

        WeatherObserver observer1 = new ConcreteObserver("Observer 1");
        WeatherObserver observer2 = new ConcreteObserver("Observer 2");
        WeatherObserver observer4 = new ConcreteObserver("Observer 3");

        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer4);

        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.removeObserver(observer2);
        System.out.println("Observer 2 removed.");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weatherStation.stop();
    }
}