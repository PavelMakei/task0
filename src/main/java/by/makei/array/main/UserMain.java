package by.makei.array.main;

import by.makei.array.entity.CustomArray;
import by.makei.array.entity.CustomArrayStatistics;
import by.makei.array.entity.Warehouse;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.factory.CustomArrayFactory;
import by.makei.array.factory.impl.CustomArrayFactoryImpl;
import by.makei.array.observer.CustomArrayObserver;
import by.makei.array.observer.impl.CustomArrayObserverImpl;
import by.makei.array.parser.impl.CustomArrayParserImpl;
import by.makei.array.reader.impl.CustomFileReaderImpl;
import by.makei.array.repository.CustomArrayRepository;
import by.makei.array.service.CustomMath;
import by.makei.array.service.CustomSort;
import by.makei.array.service.CustomUtil;
import by.makei.array.service.impl.CustomMathImpl;
import by.makei.array.service.impl.CustomSortImpl;
import by.makei.array.service.impl.CustomUtilImpl;
import by.makei.array.validator.FileValidator;
import by.makei.array.validator.impl.FileValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class UserMain {
    private static final Logger logger = LogManager.getLogger(UserMain.class);
    private static final CustomMath customMath = CustomMathImpl.getInstance();
    CustomFileReaderImpl customFileReaderImpl = CustomFileReaderImpl.getInstance();
    CustomArrayParserImpl customArrayParserImpl = CustomArrayParserImpl.getInstance();
    CustomSort customSort = CustomSortImpl.getInstance();
    CustomUtil customUtil = CustomUtilImpl.getInstance();
    //List<CustomArray> customArrays = new ArrayList<>();
    String fileName = "datafile/incomeData.txt";
    CustomArrayRepository repository = CustomArrayRepository.getInstance();
    CustomArrayObserver observer = new CustomArrayObserverImpl();

    public static void main(String[] args) throws CustomArrayException {
        UserMain userMain = new UserMain();
        userMain.run();
    }

    public void run() throws CustomArrayException {

        int a = Integer.MIN_VALUE;
        int b = -1;
        int c = a+b;
        //int d = 3000000000; - ошибка компиляции
        int d = 3000*1000*1000*1000*1000;
        long l = 3000000000l;
        int g = (int)l;



        FileValidator fileValidator = FileValidatorImpl.getInstance();
        List<String> strings = null;
        CustomArray customArray = null;
        if (!fileValidator.validateFile(fileName)) {
            logger.log(Level.ERROR, "file can't be read. Abort");
            System.exit(1);
        }

        try {
            strings = customFileReaderImpl.readLinesFromFile(fileName);
        } catch (CustomArrayException e) {
            logger.log(Level.ERROR, "file can't be read. Abort");
            System.exit(1);
        }
        CustomArrayFactory customArrayFactory = CustomArrayFactoryImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        for (String line : strings) {
            try {
                customArray = customArrayFactory.createCustomArray(customArrayParserImpl.convertStringToIntegersArray(line));
            } catch (CustomArrayException e) {
                logger.log(Level.ERROR, "Exception can't be thrown");
            }

            //int sum = customMath.sumArray(customArray);//как обрабатывать исключение по переполнению? Может сумму в long или BigInteger?
           // CustomArrayStatistics customArrayStatistics = new CustomArrayStatistics(min, max, average);
           // String arrayId = customArray.getId();
            //warehouse.put(arrayId, customArrayStatistics);// в лекции была ошибка и намеренно вставлен replace или добавлять иным способом, обсервером?
            //repository.addCustomArray(customArray);

            logger.log(Level.INFO, "New CustomArray was created and added to the customArrays list");
        }
        String id = repository.get(1).getId();
        customArray = repository.get(1);
        System.out.println("id = " + id);
        System.out.println(customArray.toString());
        System.out.println("statistics " + warehouse.get(id));

        customUtil.replace(customArray,1,7777777);
        System.out.println(repository.get(1));
        System.out.println("statistics " + warehouse.get(id));

        customSort.selectionSort(repository.get(1));
        System.out.println("statistics " + warehouse.get(id));
        System.out.println(repository.get(1));



    }
//
//        }
//
//
//        try {
//            lines = customFileReaderImpl.readLinesFromFile(fileName);
//            logger.log(Level.INFO, "File was successfully loaded. It has {} valid lines.", lines.size());
//
//
//        for (String line : lines) {
//            customArrays.add(new CustomArray(customArrayParserImpl.convert(line)));
//            logger.log(Level.INFO, "New CustomArray was created and added to the customArrays list");
//        }
//        for (CustomArray customArray : customArrays) {
//            int max = customMath.findMax(customArray);
//            logger.log(Level.INFO, "The max value in array {} = {} ",customArray.toString(), + max);
//
//        }
//        for (CustomArray customArray : customArrays) {
//            int min = customMath.findMinStream(customArray);
//            logger.log(Level.INFO, "The min value in array {} = {}" , customArray.toString(), min);
//        }
//        for (CustomArray customArray : customArrays) {
//            double average = customMath.findAverageStream(customArray);
//            logger.log(Level.INFO, "The average value in array {} = {} ", customArray.toString(), average);
//        }
////
//        customUtil.replaceStream(customArrays.get(0),0,888);
//        customSort.bubbleSort(customArrays.get(0));
//        System.out.println(customArrays.get(0).toString());


}
