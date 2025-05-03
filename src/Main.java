import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static final String FILE_PATH = "/Users/eesti_zulf/IdeaProjects/RW_API_Java_withJSON/src/vehicles.json";

    public static void main(String[] args) {

        try {
            var test = Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't read the file", e);
        }
    }
}