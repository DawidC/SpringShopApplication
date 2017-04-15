package me.czarneta.dao;

/**
 * Created by Dawid on 11.04.2017.
 */

import me.czarneta.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import me.czarneta.model.Customer;

public interface CustomerDao extends MongoRepository<Customer, String> {
    User findByEmail(String email);
}
