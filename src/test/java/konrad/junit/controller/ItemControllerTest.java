package konrad.junit.controller;

import konrad.junit.model.Item;
import konrad.junit.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(businessService.retrieveHardcodeItem()).thenReturn(
                new Item(1, "Ball", 10, 100)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        //.contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json("{id:1,name:Ball,price:10,quantity:100}"))
                .andReturn();
    }

    @Test
    public void shouldReturnAllItems() throws Exception {
        when(businessService.retrieveAllItem()).thenReturn(
                Arrays.asList(
                        new Item(1, "Ball", 10, 100),
                        new Item(2, "Ball2", 11, 111))
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().is(200))
                .andExpect(content().json(
                        "[{id:1,name:Ball,price:10,quantity:100}," +
                        "{id:2,name:Ball2,price:11,quantity:111}]"))
                .andReturn();
    }
}