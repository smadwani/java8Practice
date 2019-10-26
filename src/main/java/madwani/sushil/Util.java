package madwani.sushil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Util {
    public static String loadFile(String filepath) throws IOException {

        Path file= Paths.get(ClassLoader.getSystemResource(filepath).getPath());
        return Files.lines(file).collect(Collectors.joining(" "));
    }
}
