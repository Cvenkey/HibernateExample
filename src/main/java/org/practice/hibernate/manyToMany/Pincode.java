package org.practice.hibernate.manyToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "Pins")
@Getter
@Setter
@ToString
public class Pincode {
    @Id
    @Column(name="poname")
    private String poName;

    @Column(name = "pincode")
    private String pincode;

}
