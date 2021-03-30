package practiceAPI;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ObjectMapperPrac {

    public static void main(String[] args) throws IOException, JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "SUV");
        System.out.println(objectMapper.writeValueAsString(car));
        Object object = new Object();
        System.out.println("object" + object);
        System.out.println(object == null);
    }

}

class Car {
    public String color;
    public String type;

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }
}

