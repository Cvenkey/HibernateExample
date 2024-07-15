package org.practice.hibernate.oneToMany;

import org.hibernate.Session;
import org.practice.hibernate.model.Employee;
import org.practice.hibernate.util.HibernateUtil;

import javax.persistence.EntityGraph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneToManyMain {
    public static void main(String[] args) {
        OneToManyMain oneToManyMain = new OneToManyMain();
       // oneToManyMain.createOneToManyAssociation();
      //  oneToManyMain.createOneToManyAssociationBidirectional();
       // oneToManyMain.fetchDepartments();
      //  oneToManyMain.fetchDepartmentsWithBatchSize();
        oneToManyMain.fetchDepartmentsWithEntityGraph();
    }

    private void fetchDepartments() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //String hql = "FROM Dept d where d.deptno in (:depts)";
        String hql = "FROM Dept d left JOIN FETCH d.lecturers where d.deptno in (:depts)";
        List<Dept> departments =  session.createQuery(hql, Dept.class)
                .setParameter("depts", Arrays.asList(1l,2l)).list();
        for (Dept dept : departments) {
            List<Lecturer> lecturers = dept.getLecturers();// This can trigger an additional query for each department
            System.out.println("Department:"+dept.getName()+", Lecturers count:"+lecturers.size());
        }
        session.close();
    }

    private void fetchDepartmentsWithBatchSize() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        String hql = "FROM Dept d ";
        List<Dept> departments =  session.createQuery(hql, Dept.class).list();

        for (Dept dept : departments) {
            List<Lecturer> lecturers = dept.getLecturers();// This can trigger an additional query for each department
            System.out.println("Department:"+dept.getName()+", Lecturers count:"+lecturers.size());
        }
        session.close();
    }
    private void fetchDepartmentsWithEntityGraph() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        EntityGraph<Dept> graph = session.createEntityGraph(Dept.class);
        graph.addAttributeNodes("lecturers");

        List<Dept> departments = session.createQuery("SELECT d FROM Dept d", Dept.class)
                .setHint("javax.persistence.loadgraph", graph)
                .getResultList();
        session.close();
        for (Dept dept : departments) {
            List<Lecturer> lecturers = dept.getLecturers();// This can trigger an additional query for each department
            System.out.println("Department:"+dept.getName()+", Lecturers count:"+lecturers.size());
        }
        session.close();
    }
    private void createOneToManyAssociationBidirectional() {
        Post p = new Post();
        p.setType("Text");
        p.setPostedBy("Vinni");

        Comment c1 = new Comment();
        c1.setCreatedBy("Kushi");
        c1.setPost(p);

        Comment c2 = new Comment();
        c2.setCreatedBy("Sheetal");
        c2.setPost(p);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(c1);
        commentList.add(c2);
        p.setComments(commentList);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //Saving only Dept since CascadeType.ALL in Dept
        session.persist(p);
        session.getTransaction().commit();

        session = HibernateUtil.getSession();
        session.beginTransaction();
        p = session.load(Post.class,1);

        session.getTransaction().commit();
        System.out.println("OneToMany Association PostId"+p.getPostId()+" No.Of Comments:"+p.getComments().size());


    }

    private void createOneToManyAssociation() {
        Lecturer l1 = new Lecturer();
        l1.setName("Robin");
        l1.setSalary(9876543l);

        Lecturer l2 = new Lecturer();
        l2.setName("Kuladeep");
        l2.setSalary(98765438l);

        List<Lecturer> lecturerList = new ArrayList<>();
        lecturerList.add(l1);
        lecturerList.add(l2);

        Dept d= new Dept();
        d.setName("Arts");
        d.setLecturers(lecturerList);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        //Saving only Dept since CascadeType.ALL in Dept
        Long deptId = (Long) session.save(d);

        session.getTransaction().commit();
        System.out.println("OneToMany Association DepartmentId"+deptId);
    }
}
