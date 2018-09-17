package konrad.junit.buisness;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    private List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("test");
        assertEquals("test", mock.get(0));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("test");//anyInt() - argument matcher
        assertEquals("test", mock.get(0));
        assertEquals("test", mock.get(4));
    }

    @Test
    public void verificationBasics() {
        //SUT
        String value = mock.get(0);
        String valueVer1 = mock.get(1);
        //Verify
        verify(mock).get(0);
        // verify(mock).get(anyInt());
        verify(mock, times(2)).get(anyInt());//check times of invocation
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atMost(3)).get(anyInt());
        verify(mock, never()).get(2);
    }
}
