package by.makei.array.observer.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.entity.CustomArrayStatistics;
import by.makei.array.entity.Warehouse;
import by.makei.array.observer.CustomArrayObserver;
import by.makei.array.repository.CustomArrayRepository;
import by.makei.array.service.CustomMath;
import by.makei.array.service.impl.CustomMathImpl;

public class CustomArrayObserverImpl implements CustomArrayObserver {

    CustomMath customMath = CustomMathImpl.getInstance();

    @Override
    public void changeElement(CustomArray customArray) {
        int max = customMath.findMax(customArray);
        int min = customMath.findMin(customArray);
        double average = customMath.findAverage(customArray);
        //int sum = customMath.sumArray(customArray);//как обрабатывать исключение по переполнению? Может сумму в long или BigInteger?
        CustomArrayStatistics customArrayStatistics = new CustomArrayStatistics(min,max,average);
        String arrayId = customArray.getId();
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.replace(arrayId, customArrayStatistics);
        CustomArrayRepository repository = CustomArrayRepository.getInstance();
        repository.addCustomArray(customArray);

    }
}