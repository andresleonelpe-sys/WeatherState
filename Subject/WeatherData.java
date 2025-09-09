/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Subject;

import java.util.Arraylist;
import java.util.List;
import weatherstation.observer.Observer;

public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData() {
        observers = new ArrayList<>();
    }
    public void registerObserver (Observer o) {
        observers.add(o);
    }
      public void removeObserver (Observer o) {
        observers.remove(o);
    }
      public void notifyObserver () {
          
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
      }
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
    public float getTemperature(){
        return temperature;
    }
     public float getHumidity(){
        return Humidity;
    }
     public float getPressure(){
        return Pressure;
    }
}

