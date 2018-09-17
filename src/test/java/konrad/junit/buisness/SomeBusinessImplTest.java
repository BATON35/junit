package konrad.junit.buisness;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessImplTest {

    @Test
    public void calculateSum() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum(1,2,3);
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void emptyArrayCalculateSum() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

//    @Test
//    public void calculateSumUsingSomeDataService() {
//        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
//        someBusiness.setSomeDataService(() -> new int[]{1, 2, 3});
//        int expectedResult = 6;
//        assertEquals(expectedResult, someBusiness.calculateSumUsingSomeDataService());
//    }
}