package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;


public class ConfigFileReader {

    private Properties properties;
    final private  String configRelative =  "Config/Common.properties";
    final private String commonConfigFilePath = System.getProperty("user.dir")+"/" + configRelative;



    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(configRelative));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + commonConfigFilePath);
        }
    }

    public String getBaseURL()  {
        if (System.getProperty("baseUrl") != null) {
            return (System.getProperty("baseUrl"));
        }else if(properties.getProperty("baseUrl")!=null) {
            return properties.getProperty("baseUrl");
        }
        else {
            throw new RuntimeException("baseUrl not specified.");
        }
    }


    public String getReportConfigPath() {
        String reportConfigPath = getValueFromPropertyFile(commonConfigFilePath, "reportConfigPath");
        System.out.println("Extent Report Path :" + reportConfigPath);
        if (reportConfigPath != null)
            return reportConfigPath;
        else
            throw new RuntimeException(
                    "Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public String getValueFromPropertyFile(String filePath, String key) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            properties = new Properties();
            try {
                properties.load(reader);
                String value = properties.getProperty(key);
                reader.close();
                return value;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("File not found at " + commonConfigFilePath);
        }
    }
}