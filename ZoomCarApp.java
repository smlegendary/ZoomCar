import java.util.ArrayList;
import java.util.Scanner;

class Car {
    private String carID;
    private String brand;
    private String model;
    private int year;
    private boolean available;
    private double rentalRate;

    public Car(String carID, String brand, String model, int year, boolean available, double rentalRate) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.available = available;
        this.rentalRate = rentalRate;
    }

    public String getCarID() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + year + ")";
    }
}

class Customer {
    private String customerID;
    private String name;
    private String email;

    public Customer(String customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}

class CarRentalSystem {
    private ArrayList<Car> carsList;
    private ArrayList<Customer> customersList;

    public CarRentalSystem() {
        this.carsList = new ArrayList<>();
        this.customersList = new ArrayList<>();
    }

    public void addCar(Car car) {
        carsList.add(car);
    }

    public void addCustomer(Customer customer) {
        customersList.add(customer);
    }

    public void rentCar(String carID, String customerID) {
        Car car = findCarById(carID);
        Customer customer = findCustomerById(customerID);

        if (car != null && customer != null && car.isAvailable()) {
            car.setAvailable(false);
            System.out.println(customer.getName() + " has rented " + car);
        } else {
            System.out.println("Invalid rental request. Please check the car and customer information.");
        }
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : carsList) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    public void displayRentedCars() {
        System.out.println("Rented Cars:");
        for (Car car : carsList) {
            if (!car.isAvailable()) {
                System.out.println(car);
            }
        }
    }

    private Car findCarById(String carID) {
        for (Car car : carsList) {
            if (car.getCarID().equals(carID)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerById(String customerID) {
        for (Customer customer : customersList) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }
}

public class ZoomCarApp {
    public static void main(String[] args) {
        CarRentalSystem zoomCar = new CarRentalSystem();

        // Add sample cars
        zoomCar.addCar(new Car("CAR001", "Toyota", "Camry", 2022, true, 50.0));
        zoomCar.addCar(new Car("CAR002", "Honda", "Accord", 2021, true, 55.0));

        // Add sample customers
        zoomCar.addCustomer(new Customer("CUST001", "John Doe", "john@example.com"));
        zoomCar.addCustomer(new Customer("CUST002", "Jane Smith", "jane@example.com"));

        // Display available cars
        zoomCar.displayAvailableCars();

        // Rent a car
        zoomCar.rentCar("CAR001", "CUST001");

        // Display rented cars
        zoomCar.displayRentedCars();
    }
}
