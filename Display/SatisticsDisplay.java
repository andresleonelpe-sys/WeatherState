/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import weatherstation.observer.Observer;
import weatherstation.subject.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) maxTemp = temp;
        if (temp < minTemp) minTemp = temp;

        display();
    }

    @Override
    public void display() {
        System.out.println("Promedio/Max/Min = " 
            + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}
