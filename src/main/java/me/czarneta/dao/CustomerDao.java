package me.czarneta.dao;

/**
 * Created by Dawid on 11.04.2017.
 */

import org.springframework.data.mongodb.repository.MongoRepository;
import me.czarneta.model.Customer;

public interface CustomerDao extends MongoRepository<Customer, String> {
}
