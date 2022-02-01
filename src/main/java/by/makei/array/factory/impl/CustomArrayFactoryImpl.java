package by.makei.array.factory.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.entity.CustomArrayStatistics;
import by.makei.array.entity.Warehouse;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.factory.CustomArrayFactory;
import by.makei.array.observer.CustomArrayObserver;
import by.makei.array.observer.impl.CustomArrayObserverImpl;
import by.makei.array.repository.CustomArrayRepository;
import by.makei.array.service.CustomMath;
import by.makei.array.service.impl.CustomMathImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayFactoryImpl implements CustomArrayFactory {
    private static final Logger logger = LogManager.getLogger();
    private static final CustomArrayFactoryImpl instance = new CustomArrayFactoryImpl();

    private CustomArrayFactoryImpl (){}

    public static CustomArrayFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public CustomArray createCustomArray(int[] intArray) throws CustomArrayException {
        CustomArray customArray;
        if(intArray!= null && intArray.length>0){
            customArray = new CustomArray(intArray);
            logger.log(Level.INFO, "New CustomArray is created");
            addToRepository(customArray);
            addToWarehouse(customArray);
            addObserverToNewCustomArray(customArray);
            return customArray;
        }else {
            throw new CustomArrayException("IntArray = null, or intArray length < 1");
        }
    }

    private void addObserverToNewCustomArray(CustomArray customArray) {
        CustomArrayObserver observer = new CustomArrayObserverImpl();
        customArray.attach(observer);
        logger.log(Level.INFO, "Observer is added to new CustomArray");
    }

    private void addToWarehouse(CustomArray customArray) {
        CustomMath customMath = CustomMathImpl.getInstance();
        int max = customMath.findMax(customArray);
        int min = customMath.findMin(customArray);
        double average = customMath.findAverage(customArray);
        //int sum = customMath.sumArray(customArray);//как обрабатывать исключение по переполнению? Может сумму в long или BigInteger?
        CustomArrayStatistics customArrayStatistics = new CustomArrayStatistics(min,max,average);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(customArray.getId(), customArrayStatistics);
        logger.log(Level.INFO, "New CustomArrayStatistics is added to warehouse");
    }

    private void addToRepository(CustomArray customArray) {
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        repository.addCustomArray(customArray);
        logger.log(Level.INFO, "New CustomArray is added to repository");
    }
}
