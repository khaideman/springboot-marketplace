package comp.finalproject.admin.repository;

import comp.finalproject.admin.entity.Item;
import comp.finalproject.admin.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAll();

    Item findById(long id);

    /*void deleteById(long id);


    void update(Item item);

    int deleteById(int id);

    void save(Item item);

    */

}
