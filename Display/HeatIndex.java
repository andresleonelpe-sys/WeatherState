/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Display;

import weatherstation.observer.Observer;
import weatherstation.subject.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private float heatIndex = 0.0f;
    private Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float t, float rh, float pressure) {
        heatIndex = computeHeatIndex(t, rh);
        display();
    }

    private float computeHeatIndex(float T, float R) {
        return (float) (
            -8.78469475556 +
            1.61139411 * T +
            2.33854883889 * R +
            -0.14611605 * T * R +
            -0.012308094 * Math.pow(T, 2) +
            -0.0164248277778 * Math.pow(R, 2) +
            0.002211732 * Math.pow(T, 2) * R +
            0.00072546 * T * Math.pow(R, 2) +
            -0.000003582 * Math.pow(T, 2) * Math.pow(R, 2)
        );
    }

    @Override
    public void display() {
        System.out.println("Índice de calor: " + heatIndex);
    }
}
