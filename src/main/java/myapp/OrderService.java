package myapp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository repository;

    protected JpaRepository<Order, Long> getRepository () {
        return repository;
    }

    public List<Order> findByBuyer ( final String buyer ) {
        return repository.findByBuyer( buyer );
    }
	
	public void save ( final Order obj ) {
        getRepository().saveAndFlush( obj );
    }

    public List<Order> findAll () {
        return getRepository().findAll();
    }

}
