package vccss.service.api.util;

import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    public static Map<String, String> in(String propertiesFile) {
        try {
            Properties properties = new Properties();
            properties.load(PropertiesUtil.class.getResourceAsStream("/" + propertiesFile));
            return properties.entrySet()
                    .stream()
                    .collect(toMap(entry -> entry.getKey().toString(),
                            entry -> entry.getValue().toString()));
        } catch (IOException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
