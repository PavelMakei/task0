package by.makei.array.repository;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryTest {
    public int[] array = {1,2,3,4,5};
    public CustomArray customArray= new CustomArray(array);
    public CustomArrayRepository repository = CustomArrayRepository.getInstance();

    CustomArrayRepositoryTest() throws CustomArrayException {
    }

    @Test
    public void addCustomArrayPositiveTest() {
        CustomArray expected = customArray;
        repository.addCustomArray(customArray);
        CustomArray actual = repository.get(0);
        assert(actual.equals(expected));
    }
    @Test
    public void addCustomArrayNegativeTest() throws CustomArrayException {
        CustomArray expected = new CustomArray(array);
        repository.addCustomArray(customArray);
        CustomArray actual = repository.get(0);
        assertFalse(actual.equals(expected));
    }

    @Test
    void query() {
    }

    @Test
    void sort() {
    }
}