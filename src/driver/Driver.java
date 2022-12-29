package driver;

public class Driver {



    private String fullName;
    private boolean haveDriverLicense;
    private final int experience;
    public enum DriverLicense{B,C,D}
    private DriverLicense driverLicense;

    public Driver(String fullName, boolean haveDriverLicense, int experience) {
        if (fullName == null || fullName.isEmpty() || fullName.isBlank()) {
            this.fullName = "vodatel";
        } else {
            this.fullName = fullName;
        }
        this.haveDriverLicense = haveDriverLicense;
        this.experience = Math.max(experience, 0);
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty() || fullName.isBlank()) {
            this.fullName = "vodatel";
        } else {
            this.fullName = fullName;
        }
    }
    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    public boolean isHaveDriverLicense() {
        return haveDriverLicense;
    }
    public void setHaveDriverLicense(boolean haveDriverLicense) {
        this.haveDriverLicense = haveDriverLicense;
    }
    public int getExperience() {
        return experience;
    }

    public void startDriving() {
        System.out.println("Начало движения");
    }

    public void stopDriving() {
        System.out.println("Остановка");
    }

    public void refuelCar() {
        System.out.println("Заправка");
    }
    @Override
    public String toString() {
        return fullName;
    }
}