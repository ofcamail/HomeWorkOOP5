package transport;

import driver.Driver;

public class Bus extends Transport {

    public enum PeopleCapacity {
        EXTRA_SMALL(null, 10),
        SMALL(null, 25),
        AVERAGE(40, 50),
        BIG(60, 80),
        EXTRA_BIG(100, 120);
        private final Integer minPeopleCapacity;
        private final Integer maxPeopleCapacity;
        PeopleCapacity(Integer minPeopleCapacity, Integer maxPeopleCapacity) {
            this.minPeopleCapacity = minPeopleCapacity;
            this.maxPeopleCapacity = maxPeopleCapacity;
        }
        public Integer getMinPeopleCapacity() {
            return minPeopleCapacity;
        }
        public Integer getMaxPeopleCapacity() {
            return maxPeopleCapacity;
        }
        @Override
        public String toString() {
            if (minPeopleCapacity == null) {
                return "Вместимость: до " + maxPeopleCapacity + " мест";
            } else {
                return "Вместимость: " + minPeopleCapacity + " - " + maxPeopleCapacity + " мест";
            }
        }
    }
    private PeopleCapacity peopleCapacity;
    public Bus(String brand, String model, double engineVolume, PeopleCapacity peopleCapacity) {
        super(brand, model, engineVolume);
        this.peopleCapacity = peopleCapacity;
    }
    public PeopleCapacity getPeopleCapacity() {
        return peopleCapacity;
    }
    public void setPeopleCapacity(PeopleCapacity peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }
    @Override
    public void printType() {
        if (peopleCapacity != null) {
            System.out.println(peopleCapacity);
        } else {
            System.out.println("Данных по транспортному средству недостаточно");
        }
    }

    private void checkDriver(Driver driver) throws RuntimeException{
        if (driver.getDriverLicense() == null) {
            throw new NullPointerException("Тип водительских прав не может быть пустым");
        }
        if (driver.getDriverLicense() != Driver.DriverLicense.D) {
            throw new WrongDriverException("Нужен водитель категории D");
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
        return super.toString() + " " + peopleCapacity;
    }
}