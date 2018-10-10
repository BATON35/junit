package konrad.junit.service;

import konrad.junit.model.Item;
import konrad.junit.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemBusinessService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item retrieveHardcodeItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItem() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getPrice());
        }
        return items;
    }
}
