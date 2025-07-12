package org.example;

import org.example.customer.Address;
import org.example.customer.Customer;
import org.example.customer.CustomerRepository;
import org.example.shop.LineItem;
import org.example.shop.Order;
import org.example.shop.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.geo.Point;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConfigurationTest {
    @Autowired
    ApplicationContext context;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository custumerRepository;

    @Test
    public void repositoriesAreAssignedToAppropriateStores() {

        var repositories = new Repositories(context);

        assertThat(repositories.getEntityInformationFor(Customer.class)).isInstanceOf(JpaEntityInformation.class);
        assertThat(repositories.getEntityInformationFor(Order.class)).isInstanceOf(MongoEntityInformation.class);
    }

    @Test
    public void cadastrarMongo() {
        LineItem itens = new LineItem("t1", 1);
        Order order = new Order("1", new Date().from(Instant.now()), List.of(itens));
        Order newOrder = orderRepository.save(order);

        assertNotNull(newOrder);
    }

    @Test
    public void cadastrarJpa() {
        Address address = new Address();
        Point point = new Point(1,2);
        address.setLocation(point);
        address.setStreet("Rua 3");
        address.setZipCode("11111000");

        Customer custumer = new Customer("Teste", "Rodrigo", address);
        custumerRepository.save(custumer);
    }
}
