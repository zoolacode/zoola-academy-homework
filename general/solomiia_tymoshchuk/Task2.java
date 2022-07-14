package general.solomiia_tymoshchuk;

import java.util.Scanner;

/**
 * Write a program that accepts a distance in meters and time in seconds and outputs a speed in meters/second and kilometers/hour.
 * The result should be a floating point number.
 **/
public class Task2 {
    double distance;
    double time;

    public Double convertSpeedValuetoMs(double distance, double time) {
        double convertedDistance = distance / time;
        return convertedDistance;
    }

    public Double convertSpeedValuetoKh(double distance, double time) {
        int secondsInHour = 3600;
        int metersInKm = 1000;
        double hours = time / secondsInHour;
        double kms = distance / metersInKm;
        double calculatedValue = kms / hours;
        return calculatedValue;
    }

    public double calculatedDistanceValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the distance, please");
        distance = sc.nextDouble();
        System.out.println("Enter the time, please");
        time = sc.nextDouble();
        System.out.println("Meters per second:" + convertSpeedValuetoMs(distance, time));
        System.out.println("Kms per hour:" + convertSpeedValuetoKh(distance, time));
        return distance;
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.calculatedDistanceValue();
    }
}
