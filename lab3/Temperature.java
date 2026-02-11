package lab3;

public class Temperature {
    private double celsius;

    public Temperature() {
        this.celsius = 0.0;
    }

    public Temperature(double celsius) {
        setCelsius(celsius);
    }

    public Temperature(double celsius, double fahrenheit) {
        double expectedF = celsiusToFahrenheit(celsius);
        if (Math.abs(expectedF - fahrenheit) > 0.01) {
            System.out.println("Warning: Fahrenheit does not match Celsius, correcting Fahrenheit.");
        }
        setCelsius(celsius);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsiusToFahrenheit(celsius);
    }

    public void setCelsius(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException("Temperature cannot be below absolute zero!");
        }
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        double c = fahrenheitToCelsius(fahrenheit);
        setCelsius(c);
    }

    public double celsiusToFahrenheit(double c) {
        return c * 9.0 / 5.0 + 32.0;
    }

    public double fahrenheitToCelsius(double f) {
        return (f - 32.0) * 5.0 / 9.0;
    }

    public boolean isWithinRange(double minC, double maxC) {
        return celsius >= minC && celsius <= maxC;
    }

    @Override
    public String toString() {
        return String.format("Temperature: %.2f°C / %.2f°F", celsius, getFahrenheit());
    }

    public static void lookTemp(){
        Temperature t1 = new Temperature();
        System.out.println(t1);

        Temperature t2 = new Temperature(25);
        System.out.println(t2);

        Temperature t3 = new Temperature(100, 212);
        System.out.println(t3);

        t3.setFahrenheit(32);
        System.out.println(t3);

        System.out.println(t3.isWithinRange(0, 50));
    }
}
