package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;

public class JsonStore {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> List<T> loadList(String path, Class<T> clazz) {
        try {
            File f = new File(path);
            if (!f.exists()) return new java.util.ArrayList<>();
            return mapper.readValue(f, new TypeReference<List<T>>() {});
        } catch(Exception e){ e.printStackTrace(); return new java.util.ArrayList<>(); }
    }

    public static <T> void saveList(String path, List<T> data) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), data);
        } catch(Exception e){ e.printStackTrace(); }
    }
}
