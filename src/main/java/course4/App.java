package course4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import course4.entity.Climber;
import course4.entity.GroupList;
import course4.entity.Mountain;


public class App {
    public static void main(String[] args) {

        Mountain mountain1 = new Mountain("Everest", "China", 8848);
        Mountain mountain2 = new Mountain("Elbrus", "Russia", 5642);
        Mountain mountain3 = new Mountain("Ararat", "Turkey", 5137);

        GroupList groupList1 = new GroupList(mountain1);
        GroupList groupList2 = new GroupList(mountain2);
        GroupList groupList3 = new GroupList(mountain3);

        Climber climber1 = new Climber("Maxim", "New York");
        Climber climber2 = new Climber("Ivan", "Tokio");
        Climber climber3 = new Climber("Olga", "Bangladesh");
        Climber climber4 = new Climber("Yana", "Moscow");
        Climber climber5 = new Climber("Oleg", "Saint-Petersburg");
        Climber climber6 = new Climber("Alexandr", "Kazan");
        Climber climber7 = new Climber("Georgii", "Munich");

        groupList1.addClimber(climber1, climber2);
        groupList2.addClimber(climber3, climber5);
        groupList3.addClimber(climber4, climber7);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("orm");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(groupList1);
        manager.persist(groupList2);
        manager.persist(groupList3);
        manager.getTransaction().commit();

    }
}