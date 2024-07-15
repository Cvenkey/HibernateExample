package org.practice.hibernate.oneToOne;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="ParkingSlot")
@Getter
@Setter
@ToString
public class ParkingSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="slotId")
    private long id;
    @Column(name = "isForTwoWheeler")
    private boolean isForTwoWheeler;
    @Column(name="company")
    private String companyName;
    //only for Bidirectional mapping
//    @OneToOne
//    @JoinColumn(name="empId",nullable = false)
//    private Emp employee;
}
