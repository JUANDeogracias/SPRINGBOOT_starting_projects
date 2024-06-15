package com.example.customers.services;

import com.example.customers.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    private List<Customer> list = new ArrayList<>();

    public CustomerServiceImp() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Juan");
        customer.setAddress("Cordoba");
        customer.setEmail("jdeomoya@gmail.com");
        customer.setLastName("Deogracias");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setFirstName("Fran");
        customer2.setAddress("Malaga");
        customer2.setEmail("jdeomoya@gmail.com");
        customer2.setLastName("Bermejo");

        /* Mediante list.add añadimos en el arraylist 'list' el customer de modo que pasamos
         * todo el customer en la lista comentada. */
        list.add(customer);
        list.add(customer2);
    }

//    @GetMapping("/customer/{id}")
    public Customer getCustomer(Integer id) {
        for(Customer customer : list) {
            if(customer.getId() == id){
                return customer;
            }else {
                System.out.println("El usuario con el id: " + id + " no existe");
            }
        }
        return null;
    }


//    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return list;
    }

    /*Ahora vamos a añadir un customer para ello utilizamos el método post para poder añadir
     * luego le pasamos en los parametros un customer pero necesitamos @RequestBody para poder
     * recibir a ese customer y más tarde añadirlo en la lista*/
    @PostMapping("/customer")
    public void addCustomer(Customer customer){
        list.add(customer);
    }

//    @PutMapping("/customer/{id}")
    public void updateCustomer(Customer updateCustomer, Integer id){
        for (Customer customer : list) {
            if (customer.getId() == id) {
                list.remove(customer);
                updateCustomer.setId(id);
                list.add(updateCustomer);
                break;
            }
        }
    }

//    @DeleteMapping("/customer/{id}")
    public void removeCustomer(Integer id) {
        for (Customer customer : list) {
            if (customer.getId() == id) {
                list.remove(customer);
                break;
            } else {
                System.out.println("El usuario no existe");
            }
        }
    }

//    @GetMapping("/customer/search")
    /*RequestParam es una query que lo que hace es el nombre de el String lo toma y le pone la siguiente estructura
     * nombreString = valor que se este buscando. En el siguiente ejemplo lo que buscamos hacer es mediante el email
     * filtrar por los que su atributo email sea igual a el contenido de el email correspondiente a ese atributo. Eg:
     * http://localhost:8080/customer/search?francesco=j va a buscar por el contenido de el email el cual tiene que
     * contener el valor introducido por el usuario que queda recogido en la variable francesco*/
    public List<Customer> searchCustomer(String francesco, String address){
        List<Customer> RestList = new ArrayList<Customer>();
        if(francesco!= null) {
            for (Customer customer : list) {
                if (customer.getEmail().contains(francesco)) {
                    RestList.add(customer);
                }
            }
        }

        if(address!= null) {
            for (Customer customer : list) {
                if (customer.getAddress().contains(address)) {
                    RestList.add(customer);
                }
            }
        }
        return RestList;
    }
}
