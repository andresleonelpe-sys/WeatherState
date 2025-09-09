/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Display;

import weatherstation.observer.Observer;
import weatherstation.observer.Subject;

public class CurrentConditions implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditions(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
public void update(float temp, float humidity, float pressure) {
    this.temperature = temp;
    this.humidity = humidity;
    display();
}
    public void display() {
        System.out.println("Condiciones actuales:" + temperature + " °C y " + humidity + " % de humedad");
    }
}

