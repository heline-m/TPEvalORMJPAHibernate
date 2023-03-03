package org.epsi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.epsi.models.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------- Start -------------------");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address("10", "rue des Roses", "44200", "Nantes");
        em.persist(address);
        Address address2 = new Address("9", "place du muguet", "44130", "Le Gâvre");
        em.persist(address2);
        Address address3 = new Address("63", "rue de l'église", "86200", "Nice");
        em.persist(address3);

        Product product1 = new Product("EAERT21", "shampooing poils brillants", ProdType.CLEANING, 12.2);
        em.persist(product1);
        Product product2 = new Product("FDSFS32", "Croquettes proplan", ProdType.FOOD, 32.1);
        em.persist(product2);
        Product product3 = new Product("HJHKJ56", "shampooing poils brillants", ProdType.ACCESSORY, 20.5);
        em.persist(product3);

        Set<Product> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);

        PetStore petStore = new PetStore("Pet Shop", "Audrey Adde", productSet, address);
        em.persist(petStore);
        PetStore petStore2 = new PetStore("Shop and Pet", "Inès Boucard", productSet, address2);
        em.persist(petStore2);
        PetStore petStore3 = new PetStore("All for your pet", "Erwann Leducq", productSet, address3);
        em.persist(petStore3);

        Fish fish1 = new Fish(new Date(2023, 10, 12), "bleu", petStore, FishLivEnv.FRESH_WATER);
        em.persist(fish1);
        Fish fish2 = new Fish(new Date(2022, 11, 12), "vert",petStore2,  FishLivEnv.SEA_WATER);
        em.persist(fish2);
        Fish fish3 = new Fish(new Date(2023, 3, 2), "rouge",petStore3, FishLivEnv.FRESH_WATER);
        em.persist(fish3);


        Cat cat1 = new Cat(new Date(2023, 3, 2), "bleu", petStore, "GGHYTB21");
        em.persist(cat1);
        Cat cat2 = new Cat(new Date(2022, 6, 20), "bleu", petStore2, "DGRSGD23");
        em.persist(cat2);
        Cat cat3 = new Cat(new Date(2021, 9, 3), "bleu", petStore3, "FGFSSGH67");
        em.persist(cat3);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}