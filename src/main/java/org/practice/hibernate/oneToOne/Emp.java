package org.practice.hibernate.oneToOne;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "Emp")
@Getter
@Setter
@ToString
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="empId")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name="salary")
    private double salary;
    //UniDirectional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parkingSlotId")
    private ParkingSlot parkingSlot;
    //Bidirectional
  //  @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
   // private ParkingSlot parkingSlot;

}
