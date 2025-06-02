package assignment;

import java.util.*;

class Car {
    private String manufacturer;
    private String model;
    private String transmission;
    private String fuelType;
    private String color;
    private String location;

    public Car(String manufacturer, String model, String transmission, String fuelType, String color, String location) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.transmission = transmission;
        this.fuelType = fuelType;
        this.color = color;
        this.location = location;
    }

    public void displayOptions() {
        System.out.println("\n--- Car Customization Summary ---");
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Model: " + model);
        System.out.println("Transmission: " + transmission);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Color: " + color);
        System.out.println("Delivery Location: " + location);
    }
}

class ModelSelector {
    private static final Map<String, List<String>> modelsByManufacturer = new HashMap<>();

    static {
        modelsByManufacturer.put("Mahindra", Arrays.asList("Scorpio", "Thar", "Scorpio N", "XUV 700"));
        modelsByManufacturer.put("Tata", Arrays.asList("Nexon", "Harrier", "Safari", "Punch"));
        modelsByManufacturer.put("Maruti", Arrays.asList("Swift", "Baleno", "Brezza", "Dzire"));
    }

    public static List<String> getModels(String manufacturer) {
        return modelsByManufacturer.getOrDefault(manufacturer, Arrays.asList("Standard Model"));
    }

    public static boolean isValidModel(String manufacturer, String model) {
        List<String> validModels = getModels(manufacturer);
        return validModels.contains(model);
    }
}

public class CarCustomization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Car Manufacturer (Mahindra / Tata / Maruti): ");
        String manufacturer = scanner.nextLine();

        List<String> validModels = ModelSelector.getModels(manufacturer);
        System.out.println("Available models for " + manufacturer + ": " + validModels);
        System.out.println("Select Model: ");
        String model = scanner.nextLine();

        if (!ModelSelector.isValidModel(manufacturer, model)) {
            System.out.println("Invalid model selected. Assigning default model: " + validModels.get(0));
            model = validModels.get(0);
        }

        System.out.println("Select Transmission Variant (Manual / Automatic): ");
        String transmission = scanner.nextLine();

        System.out.println("Select Fuel Type (Diesel / Petrol / CNG): ");
        String fuelType = scanner.nextLine();

        System.out.println("Select Car Color (Silver / Blue / Yellow): ");
        String color = scanner.nextLine();

        System.out.println("Select Delivery Location (Delhi / Bangalore / Hyderabad / Chennai): ");
        String location = scanner.nextLine();

        Car customizedCar = new Car(manufacturer, model, transmission, fuelType, color, location);
        customizedCar.displayOptions();

        scanner.close();
    }
}
