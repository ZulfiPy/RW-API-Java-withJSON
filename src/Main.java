import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {

    private static final ObjectMapper mapper = new ObjectMapper();
    public static List<Vehicle> vehicles;

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

//        String macminiM4Path = dotenv.get("MACMINI_M4_PATH");
        String macbookM4Path = dotenv.get("MACBOOK_M4_PATH");

        vehicles = getVehicles(macbookM4Path);

//        Vehicle sampleVehicle = new Vehicle("WP1ZZZ92ZGLA73050", "759PFY", "Porsche", "Cayenne GTS", 2015, "Petrol", "Automatic", "Red", "Universal", "four wheel drive");
//
//        addVehicle(sampleVehicle);
//
//        writeJson(macbookM4Path, vehicles);
    }

    public static List<Vehicle> getVehicles(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.canRead()) {
            throw new RuntimeException("the json file is not found or isn't readable");
        }

        try {
            return mapper.readValue(
                    new File(filePath),
                    new TypeReference<List<Vehicle>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read or parse the json file", e);
        }
    }

    public static boolean isDuplicatedVehicle(String vin, String reg_plate) {
        if (!vehicles.isEmpty()) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.vin.equals(vin) || vehicle.reg_plate.equals(reg_plate)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean addVehicle(Vehicle newVehicle) {
        if (isDuplicatedVehicle(newVehicle.vin, newVehicle.reg_plate)) {
            return false;
        }

        vehicles.add(newVehicle);

        return true;
    }

    public static <T> void writeJson(String filePath, T data) {
        try {
            File vehicleFile = new File(filePath);

            mapper.writeValue(vehicleFile, data);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write the json file", e);
        }
    }
}