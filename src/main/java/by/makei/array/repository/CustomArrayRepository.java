package by.makei.array.repository;

import by.makei.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomArrayRepository {
    private static final Logger logger = LogManager.getLogger();
    private List<CustomArray> customArrayList = new ArrayList<>();
    private static final CustomArrayRepository instance = new CustomArrayRepository();

    private CustomArrayRepository() {}

    public static CustomArrayRepository getInstance() {
        return instance;
    }

    public void addCustomArray(CustomArray customArray) {
        customArrayList.add(customArray);
    }
//TODO есть ли здесь смысл делать и хранить копии принимаемых сущностей?
    public void removeCustomArray(CustomArray customArray) {
        this.customArrayList.remove(customArray);
    }

//    public boolean addAll(Collection<? extends CustomArray> c) {
//        return customArrayList.addAll(c);
//    }

    /* ковариантность. Массивы в Java ковариантны (принимают и наследников).
    Дженерики инвариантны (принимают только свой тип).
    Запись <? super - контрвариантность (принимают и родителей)
    Запись <? extends - ковариантность (принимает и наследников)
    */
//    public boolean removeAll(Collection<? extends CustomArray> c) {
//        return customArrayList.removeAll(c);
//    }

    public CustomArray get(int index) {
        return customArrayList.get(index);
    }

    //TODO если не раздаём/принимаем копии, то метод репласе не нужен

//    public void replace (CustomArray customArray) {
//    }

    /**
     *
     * @param specification
     * @return list of CustomArrays, filtered with specification
     */
    public List<CustomArray> query(Specification specification) {

        return customArrayList.stream().filter(o -> specification.specify(o))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param comparator
     * @return list new CustomArrays list sorted with comparator
     */
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {

        return customArrayList.stream().sorted(comparator)
                .collect(Collectors.toList());
    }

}
