package com.start.modernmvcspringboot.example1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 40)
    private String studentId;
    @Column(length = 30)
    private String name;
    @Column(length = 7)
    private String gender;
    @Column(length = 10)
    private String standard;
    @Column(length = 20)
    private String school;
    @Column(length = 4)
    private int age;


}
