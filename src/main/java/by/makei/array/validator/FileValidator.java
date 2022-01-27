package by.makei.array.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;


public class FileValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean validateFile(String fileName) {
        boolean isValid;
        if (fileName == null) {
            logger.log(Level.ERROR,"FileName is null");
            isValid = false;
        } else {
            fileName = fileName.replace("\\", "/");
            File file = null;
            URL url = getClass().getClassLoader().getResource(fileName);
            if(url == null){
                logger.log(Level.ERROR,"Wrong filename or syntax, \"/\" should be used");
                return  false;
            }
                file = new File(url.getFile());
            if (file.length() > 0) {
                logger.log(Level.INFO, "File is correct");
                isValid = true;
            } else {
                logger.log(Level.ERROR, "File {} is not exist or has size 0", fileName);
                isValid = false;
            }
        }
        return isValid;
    }
}
