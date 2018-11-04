package konrad.junit.controller;

import konrad.junit.model.Item;
import konrad.junit.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item getItemFromService() {
        return businessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items")
    public List<Item> getAllItem(){
        return businessService.retrieveAllItem();
    }
}
