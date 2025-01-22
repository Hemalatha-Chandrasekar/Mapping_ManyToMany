package com.hema;

import model.Address;
import model.Cohort;
import model.Department;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

//import static jdk.vm.ci.hotspot.riscv64.RISCV64HotSpotRegisterConfig.t2;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        manyToMany();
    }

    public static void manyToMany() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        org.hibernate.Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        //----Create Cohort/class Entity set one---
        Cohort Class1 = new Cohort("Java Developer", "14 weeks");
        Cohort Class2 = new Cohort("FullStack Developer", "7 Weeks");
        Cohort Class3 = new Cohort("Python Developer", "12 Weeks");

        //------ Store Cohort / Class
        session.persist(Class1);
        session.persist(Class2);
        session.persist(Class3);

        //-----Create Cohort one / Class one
        Set<Cohort> ClassSet1 = new HashSet<>();
        ClassSet1.add(Class1);
        ClassSet1.add(Class2);
        ClassSet1.add(Class3);

        //-----Create Cohort two / Class two
        Set<Cohort> ClassSet2 = new HashSet<>();
        ClassSet2.add(Class2);
        ClassSet2.add(Class3);
        ClassSet2.add(Class1);

        //-----Create Cohort Three / Class Three
        Set<Cohort> ClassSet3 = new HashSet<>();
        ClassSet3.add(Class3);
        ClassSet3.add(Class1);
        ClassSet3.add(Class2);


        Teacher t1 = new Teacher("100", "Haseeb", ClassSet1);
        Teacher t2 = new Teacher("200", "Jenny", ClassSet2);
        Teacher t3 = new Teacher("200", "Charlie", ClassSet3);

        session.persist(t1);
        session.persist(t2);
        session.persist(t3);
        t.commit();
    }
}
