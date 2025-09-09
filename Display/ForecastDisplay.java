/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import weatherstation.observer.Observer;
import weatherstation.subject.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
    private float currentPressure = 1013.25f;  
    private float lastPressure;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.print("Pronóstico: ");
        if (currentPressure > lastPressure) {
            System.out.println("El clima mejorará!");
        } else if (currentPressure == lastPressure) {
            System.out.println("El mismo clima.");
        } else {
            System.out.println("Se acerca lluvia.");
        }
    }
}
