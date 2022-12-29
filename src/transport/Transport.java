package transport;

import driver.Driver;

public abstract class Transport implements Competing {
    private String brand;
    private String model;
    private double engineVolume;

    public Transport(String brand, String model, double engineVolume) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
        if (engineVolume <= 0) {
            this.engineVolume = 0.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) {
            System.out.println("Вы задали неверное значение! Попробуйте еще раз.");
        } else {
            this.brand = brand;
        }
    }

    public String getModel() {
        return model;
    }

    public final void setModel(String model) {
        if (model == null || model.isEmpty() || model.isBlank()) {
            this.model = "default";
        } else {
            this.model = model;
        }
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public final void setEngineVolume(int engineVolume) {
        if (engineVolume > 0) {
            this.engineVolume =  1.5;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public abstract void printType();

    @Override
    public void getPitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public void getBestLapTime() {
        System.out.println("Лучшее время круга");
    }

    @Override
    public void getMaxSpeed() {
        System.out.println("Максимальная скорость");
    }

    public abstract void letsGo(Driver driver);

    public void getDiagnostics() {
        System.out.println("Транспортное средство не может пройти диагностику!!!");
    }

    @Override
    public String toString() {
        return
                "Марка: " + brand + "; " +
                "Модель: " + model + "; " +
                "Объем двигателя: " + engineVolume + ";";
    }
}