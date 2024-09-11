package Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation implements Runnable {
    private String name;
    private int minimumTemperature;
    private int maximumTemperature;
    private int currentTemperature;
    private List<WeatherObserver> observers = new ArrayList<>();
    private Random random = new Random();
    private boolean running;

    public WeatherStation(String name, int minimumTemperature, int maximumTemperature) {
        this.name = name;
        this.minimumTemperature = minimumTemperature;
        this.maximumTemperature = maximumTemperature;
        this.currentTemperature = random.nextInt(minimumTemperature, maximumTemperature);
        this.running = true;
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void updateTemperature() {
        int temperatureChange = random.nextInt(3) - 1;
        int newTemperature = currentTemperature + temperatureChange;

        if (newTemperature < minimumTemperature) {
            currentTemperature = minimumTemperature;
        } else if (newTemperature > maximumTemperature) {
            currentTemperature = maximumTemperature;
        } else {
            currentTemperature = newTemperature;
        }
    }

    private void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(this.currentTemperature);
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            updateTemperature();
            notifyObservers();
            try {
                Thread.sleep(random.nextInt(4000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        running = false;
    }
}