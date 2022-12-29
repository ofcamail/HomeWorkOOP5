package transport;

import driver.Driver;

public class Car extends Transport {
    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");
        private final String russianName;
        BodyType(String russianName) {
            this.russianName = russianName;
        }
        public String getRussianName() {
            return russianName;
        }
        @Override
        public String toString() {
            return "Тип кузова: " + russianName;
        }
    }
    private BodyType bodyType;
    public Car(String brand, String model, double engineVolume, BodyType bodyType) {
        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }
    public BodyType getBodyType() {
        return bodyType;
    }
    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
    @Override
    public void getDiagnostics() {
        System.out.println(getBrand() + " " + getModel() + " отправляется на диагностику");
    }
    @Override
    public void printType() {
        if (bodyType != null) {
            System.out.println(bodyType);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }
    private void checkDriver(Driver driver) throws RuntimeException {
        if (driver.getDriverLicense() == null) {
            throw new NullPointerException("Тип водительских прав не может быть пустым");
        }
        if (driver.getDriverLicense() != Driver.DriverLicense.B) {
            throw new WrongDriverException("Нужен водитель категории B");
        }
    }
    @Override
    public void letsGo(Driver driver) {
        try {
            checkDriver(driver);
        } catch (NullPointerException | WrongDriverException e ) {
            e.printStackTrace();
        }
        System.out.println("Водитель " + driver.getFullName() + " управляет автомобилем " + getBrand() + " и будет участвовать в заезде");
    }

    @Override
    public String toString() {
        return super.toString() + " " + bodyType;
    }
}