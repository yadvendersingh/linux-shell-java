package utils;

import java.nio.file.Files;
import java.nio.file.Path;

public class Util {
    public static String getPath(String parameter) {
        for (String path : System.getenv("PATH").split(":")) {
          Path fullPath = Path.of(path, parameter);
          if (Files.isRegularFile(fullPath)) {
            return fullPath.toString();
          }
        }
        return null;
      }

    public static String getHome() {
        return System.getenv("HOME");
    }
}
