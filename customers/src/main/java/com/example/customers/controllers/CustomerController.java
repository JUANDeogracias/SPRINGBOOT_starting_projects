package com.example.customers.controllers;

import com.example.customers.entities.Customer;
import com.example.customers.services.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceImp service;

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        return service.getCustomer(id);
    }


    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    /*Ahora vamos a añadir un customer para ello utilizamos el método post para poder añadir
    * luego le pasamos en los parametros un customer pero necesitamos @RequestBody para poder
    * recibir a ese customer y más tarde añadirlo en la lista*/
    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public void updateCustomer(@RequestBody Customer updateCustomer, @PathVariable Integer id){
        service.updateCustomer(updateCustomer, id);
    }

    @DeleteMapping("/customer/{id}")
    public void removeCustomer(@PathVariable Integer id) {
        service.removeCustomer(id);
    }

    @GetMapping("/customer/search")
    /*RequestParam es una query que lo que hace es el nombre de el String lo toma y le pone la siguiente estructura
    * nombreString = valor que se este buscando. En el siguiente ejemplo lo que buscamos hacer es mediante el email
    * filtrar por los que su atributo email sea igual a el contenido de el email correspondiente a ese atributo. Eg:
    * http://localhost:8080/customer/search?francesco=j va a buscar por el contenido de el email el cual tiene que
    * contener el valor introducido por el usuario que queda recogido en la variable francesco*/
    public List<Customer> searchCustomer(@RequestParam(name = "francesco" ,required = false)
                                             String francesco, @RequestParam(name= "address", required = false)
                                                String address){
        return searchCustomer(francesco, address);
    }


    /*
    @PostMapping("/customer/add/{id}")
    public void addCustomer(@PathVariable Integer id, @RequestBody Customer customerDetails) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName(customerDetails.getFirstName());
        customer.setLastName(customerDetails.getLastName());
        customer.setEmail(customerDetails.getEmail());
        customer.setAddress(customerDetails.getAddress());
        list.add(customer);
        System.out.println("User added: " + customer);
    }



    @GetMapping("/addCustomer")
    public void removeCustomer(Customer customer) {
        System.out.println("User removed");
    }

    @GetMapping("/addCustomer")
    public void updateCustomer(Customer customer) {
        System.out.println("User updated");
    }

    @GetMapping("/addCustomer")
    public List<Customer> searchCustomer(Customer customer) {
        return null;
    }*/


//    @GetMapping("/prueba2")
//    public List<String> prueba2() {
//        List<String> list = new ArrayList<>();
//        list.add("Lucas");
//        list.add("Maria");
//        list.add("Martin");
//        return list;
//    }
//
//    @GetMapping("/prueba3")
//    public Map<String, String> prueba3() {
//        Map<String, String> map = new HashMap<>();
//        map.put("Nombre", "Lucas");
//        map.put("Apellido", "Martin");
//        map.put("Email", "jdeomoya@gamail.com");
//        return map;
//    }

//    @GetMapping("/prueba4")
//    public List<Customer> prueba4() {
//        List<Customer> customers = new ArrayList<>();
//        Customer customer1 = new Customer("Santiago", "Deogracias", "jdeomoya@gamail.com", "14014");
//        Customer customer2 = new Customer("Fran", "Deogracias", "jdeomoya@gamail.com", "14014");
//
//        customers.add(customer1);
//        customers.add(customer2);
//        return customers;
//    }
    }
