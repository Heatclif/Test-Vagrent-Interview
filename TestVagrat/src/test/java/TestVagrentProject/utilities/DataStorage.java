package TestVagrentProject.utilities;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {

    /***
     * This page acts as a simple storage for data
     * It uses a static map can be used anywhere in
     * automation using the given methods
     */
    private static Map<String, String> DataStore;

    DataStorage() {
        DataStore = new HashMap<>();
    }

    public static DataStorage getInstance() {
        return new DataStorage();
    }

    public static void rememberData(String key, String value) {
        DataStore.put(key, value);
    }

    public static String getData(String key) {
        return DataStore.get(key);
    }
}
