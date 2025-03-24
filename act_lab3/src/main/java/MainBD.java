import ro.mpp2024.Car;
import ro.mpp2024.CarRepository;
import ro.mpp2024.CarsDBRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainBD {
    public static void main(String[] args) {

        Properties props=new Properties();
        try {
            props.load( MainBD.class.getClassLoader().getResourceAsStream("bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }

        CarRepository carRepo=new CarsDBRepository(props);
        carRepo.add(new Car("Tesla","Model S", 2019));
        System.out.println("Toate masinile din db");
        for(Car car:carRepo.findAll())
            System.out.println(car);
       String manufacturer="Tesla";
        System.out.println("Masinile produse de "+manufacturer);
        for(Car car:carRepo.findByManufacturer(manufacturer))
            System.out.println(car);
        System.out.println("Mașina e actualizată");
        Car updatedCar = new Car("Nissan", "nou", 2018);
        carRepo.update(3, updatedCar);
        System.out.println("Dupa:");
        for (Car car : carRepo.findAll())
            System.out.println(car);
    }
}
