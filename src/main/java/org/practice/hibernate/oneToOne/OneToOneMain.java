package org.practice.hibernate.oneToOne;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.practice.hibernate.util.HibernateUtil;

public class OneToOneMain {
    public static void main(String[] args) {
        OneToOneMain oneToOneMain = new OneToOneMain();
       oneToOneMain.createOneToOneMapping();
        //oneToOneMain.createOneToOneBiDirectionalMapping();

    }

    private void createOneToOneBiDirectionalMapping() {
        ParkingSlot p = new ParkingSlot();
        p.setCompanyName("PHOTON");
        p.setForTwoWheeler(Boolean.FALSE);

        Emp e = new Emp();
        e.setName("Senthil");
        e.setSalary(45612879);
        //Associate parking slot to emp
       // e.setParkingSlot(p);
        //Associate emp to parking slot
       // p.setEmployee(e);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //Saving only Employee since CascadeType.ALL in Emp
        session.save(e);
        session.getTransaction().commit();

        //Navigation in Bidirectional Relationship
        session.beginTransaction();
        e = session.get(Emp.class,1l);
       // p = e.getParkingSlot();
        System.out.println("Employee eid:"+e.getId()+" parking slot:"+p.getId());

        p = session.get(ParkingSlot.class,1l);
        //e = p.getEmployee();
        System.out.println("Employee eid:"+e.getId()+" parking slot:"+p.getId());
    }

    private void createOneToOneMapping() {
        try {

            ParkingSlot p = new ParkingSlot();
            p.setCompanyName("NTT");
            p.setForTwoWheeler(Boolean.TRUE);

            Emp e = new Emp();
            e.setName("Kuladeep");
            e.setSalary(321458795l);
            e.setParkingSlot(p);

            Session session = HibernateUtil.getSession();
            session.beginTransaction();

            //Saving only Employee since CascadeType.ALL in Emp
            Long empId = (Long) session.save(e);
            session.getTransaction().commit();

            System.out.println("OneToOne Association parking slot assigned for employee:"+empId);
        } catch (HibernateException hbe) {
            hbe.printStackTrace();
        }
    }
}
