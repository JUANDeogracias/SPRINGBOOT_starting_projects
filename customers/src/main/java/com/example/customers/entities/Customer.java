package com.example.customers.entities;

import lombok.*;

import java.util.Objects;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
//@ToString
//@Builder

/*Si sustituimos todo lo anterior por @Data sería exactamente igual*/
@Data
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
