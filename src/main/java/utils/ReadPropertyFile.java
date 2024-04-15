package utils;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import exceptions.InvalidFilePathException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertyFile {
    private ReadPropertyFile(){};
    private static Properties properties = new Properties();

    static {

        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilepath());) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static String getValue(ConfigProperties key){
        String value = "";
        value = properties.getProperty(key.name().toLowerCase());
        if(Objects.isNull(value)){
            throw new InvalidFilePathException("Property name " + key + " not found. Please check config.properties file");
        }
        return value;


    }


}
