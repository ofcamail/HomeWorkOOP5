import driver.*;
import transport.*;

public class Main {
    public static void main(String[] args) {


            Car car1 = new Car("Мазда", "М3", 1.3, Car.BodyType.CROSSOVER);
            Car car2 = new Car("Крайслер", "НР3", 2.3, Car.BodyType.COUPE);
            Car car3 = new Car("Исузу", "Трупер", 3.0, Car.BodyType.HATCHBACK);
            Car car4 = new Car("Тойота", "Крузак", 3.2, Car.BodyType.SUV);


            Bus bus1 = new Bus("Лиаз", "М", 1.0, Bus.PeopleCapacity.SMALL);
            Bus bus2 = new Bus("МАЗ", "М2", 1.0, Bus.PeopleCapacity.EXTRA_BIG);
            Bus bus3 = new Bus("Ситроен", "С6", 1.0, Bus.PeopleCapacity.BIG);
            Bus bus4 = new Bus("Печка", "Мь4", 1.0, Bus.PeopleCapacity.AVERAGE);

            Truck truck1 = new Truck("МАЗ", "МАЗ", 3.0, Truck.LoadCapacity.N1);
            Truck truck2 = new Truck("Грузовичок", "Грузовичок", 2.0, Truck.LoadCapacity.N2);
            Truck truck3 = new Truck("Грузовой", "Грузовик", 3.0, Truck.LoadCapacity.N2);
            Truck truck4 = new Truck("Грузовик", "Красивый", 2.0, Truck.LoadCapacity.N1);

            Driver driver1 = new Driver("Годзилова Годзила Годзиловна", true, 3);
            Driver driver2 = new Driver("Кротов Крот Кротович", true, 4);
            Driver driver3 = new Driver("Самуилов Самуил Самуилович", true, 5);



            driver1.setDriverLicense(Driver.DriverLicense.B);
            driver3.setDriverLicense(Driver.DriverLicense.D);
            System.out.println(car1);
        }
    }
