package spring5;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Properties;

public class App {

	private static final String PROPERTY_FILE = "/book.properties";
	
	public static void main(String[] args) {
		App app = new App();
        Properties properties = app.loadProperties(PROPERTY_FILE);
        app.printProperties(properties);

	}
	
    protected Properties loadProperties(String file) {
        Properties properties = new Properties();
        try (Reader reader = new InputStreamReader(
                App.class.getResourceAsStream(file), StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    protected void printProperties(Properties properties) {
        if (properties != null) {
            Enumeration<?> names = properties.propertyNames();
            while (names.hasMoreElements()) {
                String name = String.valueOf(names.nextElement());
                String value = properties.getProperty(name);
                System.out.println(name + " : " + value);
            }
        }
    }

}
