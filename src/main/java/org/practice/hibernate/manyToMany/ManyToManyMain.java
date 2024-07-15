package org.practice.hibernate.manyToMany;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.practice.hibernate.util.HibernateUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ManyToManyMain {

    public static void main(String[] args) {
        ManyToManyMain manyToManyMain = new ManyToManyMain();
        manyToManyMain.createManyToManyAssociation();
    }

    private void createManyToManyAssociation() {
        try {
            Person p1 = new Person();
            p1.setName("Heera");

            Pincode pincode = new Pincode();
            pincode.setPincode("516227");
            pincode.setPoName("Kamalakur");

            Pincode pincode1 = new Pincode();
            pincode1.setPincode("600113");
            pincode1.setPoName("TTTI Taramani");

            Set<Pincode> pincodeSet = new HashSet<>();
            pincodeSet.add(pincode);
            pincodeSet.add(pincode1);

            p1.setPincodes(pincodeSet);

            Session session = HibernateUtil.getSession();
            session.beginTransaction();
            session.save(p1);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
