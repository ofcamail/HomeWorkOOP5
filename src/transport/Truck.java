package transport;

import driver.Driver;

public class Truck extends Transport {

    public enum LoadCapacity {
        N1(null, 3.5f),
        N2(0f, 3.5f),
        N3(12f, null);
        private final Float minLoadCapacity;
        private final Float maxLoadCapacity;
        LoadCapacity(Float minLoadCapacity, Float maxLoadCapacity) {
            this.minLoadCapacity = minLoadCapacity;
            this.maxLoadCapacity = maxLoadCapacity;
        }
        public Float getMinLoadCapacity() {
            return minLoadCapacity;
        }
        public Float getMaxLoadCapacity() {
            return maxLoadCapacity;
        }
        @Override
        public String toString() {
            if (minLoadCapacity == null) {
                return "Грузоподъемность: до " + maxLoadCapacity + " тонн";
            } else if (maxLoadCapacity == null) {
                return "Грузоподъемность: от " + minLoadCapacity + " тонн";
            } else {
                return "Грузоподъемность: от " + minLoadCapacity + " тонн до " + maxLoadCapacity + " тонн";
            }
        }
    }
    private LoadCapacity loadCapacity;
    public Truck(String brand, String model, double engineVolume, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume);
        this.loadCapacity = loadCapacity;
    }
    public LoadCapacity getLoadCapacityType() {
        return loadCapacity;
    }
    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
    @Override
    public void getDiagnostics() {
        System.out.println(getBrand() + " " + getModel() + " отправляется на диагностику");
    }
    @Override
    public void printType() {
        if (loadCapacity != null) {
            System.out.println(loadCapacity);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    private void checkDriver(Driver driver) throws RuntimeException {
        if (driver.getDriverLicense() == null) {
            throw new NullPointerException("Тип водительских прав не может быть пустым");
        }
        if (driver.getDriverLicense() != Driver.DriverLicense.C) {
            throw new WrongDriverException("Нужен водитель категории C");
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
        return super.toString() + " " + loadCapacity;
    }
}