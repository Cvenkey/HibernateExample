package org.practice.hibernate.oneToMany;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;


import java.util.List;
//Uni-directional One to Many mapping extra column 'deptno' will be
// created on the many side of the relationship i.e. in the Employee table
@Entity
@Table(name = "Dept")
@Getter
@Setter
@ToString
public class Dept {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="deptno")
    private long deptno;
    @Column(name="name")
    private String name;
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="deptno")
  //  @BatchSize(size = 2)
    private List<Lecturer> lecturers;

}
