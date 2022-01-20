package by.makei.array.reader;

import by.makei.array.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static by.makei.array.validator.NumberValidator.fileValidator;

public class CustomFileReader {

    public static Logger logger = LogManager.getLogger(CustomFileReader.class);


    public static String readWholeFile(String fileName) throws CustomException {
        String line;
        List<String> list = new ArrayList<>();
        StringBuilder finalStr = new StringBuilder();
        BufferedReader bf = null;
        File file = new File(fileName);

        try {
            bf = new BufferedReader(new FileReader(fileName));
            while ((line = bf.readLine()) != null) {
                if (fileValidator(line)) {
                    list.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
            throw new CustomException("File \""+ file.getAbsolutePath() + "\" hasn't been found",e);
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new CustomException(e.getMessage());
        }finally {
            if(bf != null){
                try {
                    bf.close();
                } catch (IOException e) {
                    logger.error("File \""+ file.getAbsolutePath() + "\" hasn't been found",e.getMessage());
                    throw new CustomException(e.getMessage());
                }
            }
        }

        for (String str : list) {
            finalStr.append(str);
        }

        return finalStr.toString();
    }
}
