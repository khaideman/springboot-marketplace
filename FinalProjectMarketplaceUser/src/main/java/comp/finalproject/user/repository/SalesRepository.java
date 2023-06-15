package comp.finalproject.user.repository;

import comp.finalproject.user.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAll();

    Sale findById(long id);

    /*int deleteById(int id);

    void save(Sale sale);

    void update(Sale sale);*/

}
