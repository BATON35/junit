package konrad.junit.service;

import konrad.junit.model.Item;
import konrad.junit.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.hasProperty;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void shouldRetrieveAllItems() {
        int valueOfItem1 = 10 * 100;
        int valueOFItem2 = 11 * 101;
        Item item1 = new Item(1, "name1", 10, 100);
        Item item2 = new Item(2, "name2", 11, 101);
        item1.setValue(valueOfItem1);
        item2.setValue(valueOFItem2);
        List<Item> fakeData = Arrays.asList(
                item1,
                item2);

        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                item1, item2));

        List<Item> items = itemBusinessService.retrieveAllItem();

        assertEquals(fakeData, items);
    }
}
