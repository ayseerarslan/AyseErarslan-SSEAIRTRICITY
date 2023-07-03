package com.sse.utilities;


//This class will be storing only the utility methods that can be used across the project.

public class BrowserUtils {

    public static int averageRate(String countryName) {

        int rate = 0;

        switch (countryName) {
            case "England":
                rate = 34;
                break;

            case "Scotland":
            case "Wales":
                rate = 67;
                break;

            case "Northern Ireland":
                rate = 0;
                System.err.println("The advice on this website doesn't cover Northern Ireland");
                break;

            default:
                throw new IllegalArgumentException("Please enter a valid country name");
        }

        return rate;

    }

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

}
