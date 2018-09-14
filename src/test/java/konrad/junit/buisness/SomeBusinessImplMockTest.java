package konrad.junit.buisness;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {
    @InjectMocks
    private SomeBusinessImpl someBusiness = new SomeBusinessImpl();
    @Mock
    //private SomeDataService dataServiceMock = mock(SomeDataService.class);
    private SomeDataService dataServiceMock;

//    @Before
//    public void before() {
//        someBusiness.setSomeDataService(dataServiceMock);
//    }

    @Test
    public void shouldReturn6() {
        //given
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        //when
        //then
        assertEquals(6, someBusiness.calculateSumUsingSomeDataService());
    }

    @Test
    public void ShouldReturn0() {
        //given
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{0});
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
        //when
        int actualResult = someBusiness.calculateSumUsingSomeDataService();
        int expectedResult = 16;
        //then
        assertEquals(expectedResult, actualResult);
    }
}