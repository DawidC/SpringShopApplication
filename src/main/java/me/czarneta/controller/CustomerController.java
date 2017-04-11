package me.czarneta.controller;

import org.springframework.stereotype.Controller;
import me.czarneta.dao.CustomerDao;
import me.czarneta.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Dawid on 11.04.2017.
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/customers")
    public String getCustomerListPage(Model model) {
        model.addAttribute("customerList", customerDao.findAll());
        return "customers";
    }

    @RequestMapping("/customer/add/{firstName}/{lastName}")
    public String createCustomer(@PathVariable String firstName, @PathVariable String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerDao.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/addpost")
    public String createCustomer2(@RequestParam String firstName, @RequestParam String lastName) {
        Customer customer = new Customer(firstName, lastName);
        customerDao.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomersById(@PathVariable String id) {
        customerDao.delete(id);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/delete/all")
    public String deleteAllCustomers() {
        customerDao.deleteAll();
        return "redirect:/customers";
    }

}