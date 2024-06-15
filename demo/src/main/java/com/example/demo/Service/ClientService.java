package com.example.demo.Service;
import com.example.demo.Client.*;

import java.util.List;

public interface ClientService {
    List<Client> getList();
    Client saveClient(Client client);
    void deleteClient(Long id);
    Client getClient(Long id);
}
