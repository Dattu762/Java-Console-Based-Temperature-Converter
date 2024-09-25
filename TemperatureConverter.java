import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Celsius to Kelvin
    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Method to convert Fahrenheit to Kelvin
    public static double fahrenheitToKelvin(double fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9) + 273.15;
    }

    // Method to convert Kelvin to Celsius
    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Method to convert Kelvin to Fahrenheit
    public static double kelvinToFahrenheit(double kelvin) {
        return ((kelvin - 273.15) * 9 / 5) + 32;
    }

    // Method to display the conversion options
    public static void displayMenu() {
        System.out.println("Choose the source temperature scale:");
        System.out.println("1. Celsius (°C)");
        System.out.println("2. Fahrenheit (°F)");
        System.out.println("3. Kelvin (K)");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        while (continueConversion) {
            try {
                // Get temperature value from the user
                System.out.print("Enter the temperature value: ");
                double temperature = scanner.nextDouble();

                // Display source scale options
                displayMenu();
                System.out.print("Choose the source temperature scale (1-3): ");
                int sourceScale = scanner.nextInt();

                // Display target scale options
                displayMenu();
                System.out.print("Choose the target temperature scale (1-3): ");
                int targetScale = scanner.nextInt();

                double convertedTemperature = 0;
                boolean validConversion = true;

                // Perform the appropriate conversion
                switch (sourceScale) {
                    case 1: // Celsius as the source
                        if (targetScale == 1) {
                            convertedTemperature = temperature; // Celsius to Celsius
                        } else if (targetScale == 2) {
                            convertedTemperature = celsiusToFahrenheit(temperature);
                        } else if (targetScale == 3) {
                            convertedTemperature = celsiusToKelvin(temperature);
                        } else {
                            validConversion = false;
                        }
                        break;
                    case 2: // Fahrenheit as the source
                        if (targetScale == 1) {
                            convertedTemperature = fahrenheitToCelsius(temperature);
                        } else if (targetScale == 2) {
                            convertedTemperature = temperature; // Fahrenheit to Fahrenheit
                        } else if (targetScale == 3) {
                            convertedTemperature = fahrenheitToKelvin(temperature);
                        } else {
                            validConversion = false;
                        }
                        break;
                    case 3: // Kelvin as the source
                        if (targetScale == 1) {
                            convertedTemperature = kelvinToCelsius(temperature);
                        } else if (targetScale == 2) {
                            convertedTemperature = kelvinToFahrenheit(temperature);
                        } else if (targetScale == 3) {
                            convertedTemperature = temperature; // Kelvin to Kelvin
                        } else {
                            validConversion = false;
                        }
                        break;
                    default:
                        validConversion = false;
                        break;
                }

                if (validConversion) {
                    System.out.println("Converted Temperature: " + convertedTemperature);
                } else {
                    System.out.println("Invalid conversion selection.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid temperature value.");
                scanner.next(); // clear invalid input
            }

            System.out.print("Do you want to perform another conversion? (yes/no): ");
            String userResponse = scanner.next();
            continueConversion = userResponse.equalsIgnoreCase("yes");

            System.out.println(); // for formatting
        }

        System.out.println("Exiting the converter. Goodbye!");
        scanner.close();
    }
}
