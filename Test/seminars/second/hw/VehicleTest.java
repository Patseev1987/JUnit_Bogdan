package seminars.second.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

//    В этом проекте, вы будете работать с проектом ""Vehicle"", который представляет собой иерархию классов,
//    включающую абстрактный базовый класс ""Vehicle"" и два его подкласса ""Car"" и ""Motorcycle"".
//
//    Базовый класс ""Vehicle"" содержит абстрактные методы ""testDrive()"" и ""park()"", а также поля
//    ""company"", ""model"", ""yearRelease"", ""numWheels"" и ""speed"".
//
//    Класс ""Car"" расширяет ""Vehicle"" и реализует его абстрактные методы. При создании объекта
//    ""Car"", число колес устанавливается в 4, а скорость в 0. В методе ""testDrive()"" скорость устанавливается на 60, а в методе ""park()"" - обратно в 0.
//
//    Класс ""Motorcycle"" также расширяет ""Vehicle"" и реализует его абстрактные методы.
//    При создании объекта ""Motorcycle"", число колес устанавливается в 2, а скорость в 0.
//    В методе ""testDrive()"" скорость устанавливается на 75,
//    а в методе ""park()"" - обратно в 0.



    Car car;
    Motorcycle moto;
//    - Проверить, что экземпляр объекта Car также является экземпляром транспортного средства
//            (используя оператор instanceof).
    @Test
    public void testCarIsInstanceOfVehicle() {
        Car car = new Car("Dodge", "Ram", 2010);
        assertTrue(car instanceof Vehicle);
    }

//            - Проверить, что объект Car создается с 4-мя колесами.
//
    @BeforeEach
    public void init(){
        car = new Car("Dodge", "Ram", 2010);
    }

    @Test
    public void testCarHasFourWheels (){

        assertEquals(car.getNumWheels(),4);
    }
//
//            - Проверить, что объект Motorcycle создается с 2-мя колесами.
//
    @BeforeEach
    public void initMoto(){
        moto = new Motorcycle("Kawasaki","Ninja",2021);
    }

    @Test
    public void testMotoHasTwoWheels (){

        assertEquals(moto.getNumWheels(),2);
    }

//            - Проверить, что объект Car развивает скорость 60 в режиме тестового вождения
//            (используя метод testDrive()).
//
    @Test
    public  void testCarSpeedInTestDriveMode(){
        car.testDrive();
        assertEquals(car.getSpeed(),60);
    }
//            - Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
//            (используя метод testDrive()).
//
    @Test
    public void testSpeedMotoSpeedInTestDriveMode(){
        moto.testDrive();
        assertEquals(moto.getSpeed(), 75);
    }
//            - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения
//                                                транспорта) машина останавливается (speed = 0).
//
    @BeforeEach
    public void initMercedes(){
        car = new Car("Mercedes","CLA 200", 2020);
    }
    @Test
    @DisplayName("We will test test drive and parking")
    public void testCarDrivingMode (){
        car.testDrive();
        car.park();
        assertEquals(car.getSpeed(),0);
    }
//            - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения
//                                                транспорта) мотоцикл останавливается (speed = 0).
//
@BeforeEach
public void initBMWMoto(){
    moto = new Motorcycle("BMW","M 1000 RR", 2020);
}
    @Test
    @DisplayName("We will test testdrive and parking")
    public void testMotoDrivingMode (){
        moto.testDrive();
        moto.park();
        assertEquals(moto.getSpeed(),0);
    }

/////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Подкрутил Ваш класс Vehicle (добавил абстрактный метод getSpeed())
     */

    @ParameterizedTest
    @MethodSource("vehicles")
    @DisplayName("We will test car and moto ")
    public void vehiclesDrivingMode(Vehicle vehicle){
        vehicle.testDrive();
        vehicle.park();
        assertEquals(vehicle.getSpeed(),0);
    }

    static Stream<Vehicle> vehicles(){
        return Stream.of(new Car("Mercedes","CLA 200",2020),
                new Motorcycle("Yamaha","RX5000",2023));
    }


}
