package org.practice.hibernate.oneToMany;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "Lecturer")
@Getter
@Setter
@ToString
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lid")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name="salary")
    private double salary;

}
