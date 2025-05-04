import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    private static final String FILE_PATH = "/Users/eesti_zulf/IdeaProjects/RW_API_Java_withJSON/src/vehicles.json";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Vehicle> vehicles = mapper.readValue(
                    new File(FILE_PATH),
                    new TypeReference<List<Vehicle>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read or parse the file", e);
        }
    }
}