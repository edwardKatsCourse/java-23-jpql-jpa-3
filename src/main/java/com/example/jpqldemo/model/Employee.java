package com.example.jpqldemo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "COMPANY_ID")
    @ManyToOne
    private Company company;
}
