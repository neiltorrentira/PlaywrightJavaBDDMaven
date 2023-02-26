package webui.playwright.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();
            String propFileName = Constants.PROP_FILE_NAME;

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
                properties.load(inputStream);
            else
                throw new FileNotFoundException(Constants.FILE_NOT_FOUND_EXCEPTION_MESSAGE);

            this.result = properties.getProperty(key);

            /*String propertyValue = properties.getProperty(key);
            this.result = propertyValue;*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
