package bookshelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsersManager {
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {
		
		begin();
		
		create();
		
		//update();
		
		//find();
		
		//remove();;
				
		end();
	}
		
	private static void begin() {
		factory = Persistence.createEntityManagerFactory("Book");
		entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
	}
	
	private static void create() {
		Users newUsers = new Users();
		newUsers.setName("Luís");
		newUsers.setEmail("luisfcremasco@gmail.com");
		
		entityManager.persist(newUsers);
	}	
	
	private static void update() {
		Users existUsers = new Users();
		existUsers.setUserId(1);
		existUsers.setName("");
		existUsers.setEmail("");	
		
		entityManager.merge(existUsers);
	}
	
	private static void find() {
		Integer primaryKey = 2;
		Users user = entityManager.find(Users.class, primaryKey);
		
		System.out.println(user.getName());
		System.out.println(user.getEmail());
	}
	
	private static void remove() {
		Integer primaryKey = 3;
		Users reference = entityManager.getReference(Users.class, primaryKey);
		entityManager.remove(reference);
	}

	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}

