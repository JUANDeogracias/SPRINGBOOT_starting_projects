package com.example.demo.repository;

import com.example.demo.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Scanner;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Consulta por convención de nombres
    List<Client> findByNameAndSurname(String name, String surname);
    // Consulta con JPQL
    @Query("SELECT c.name FROM Client c WHERE c.name = :name")
    List<Client> findByNameJPQL(@Param("name") String name);

}