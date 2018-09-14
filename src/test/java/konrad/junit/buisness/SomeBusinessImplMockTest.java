package konrad.junit.buisness;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplMockTest {

    private SomeBusinessImpl someBusiness = new SomeBusinessImpl();
    private SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Test
    public void shouldReturn6() {
        //given
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        someBusiness.setSomeDataService(dataServiceMock);
        //when
        int actualResult = someBusiness.calculateSumUsingSomeDataService();
        int expectedResult = 6;
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void ShouldReturn0() {
        //given
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{0});
        someBusiness.setSomeDataService(dataServiceMock);
        //when
        int actualResult = someBusiness.calculateSumUsingSomeDataService();
        int expectedResult = 0;
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn16() {
        //given
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3, 10});
        someBusiness.setSomeDataService(dataServiceMock);
        //when
        int actualResult = someBusiness.calculateSumUsingSomeDataService();
        int expectedResult = 16;
        //then
        assertEquals(expectedResult, actualResult);
    }
}