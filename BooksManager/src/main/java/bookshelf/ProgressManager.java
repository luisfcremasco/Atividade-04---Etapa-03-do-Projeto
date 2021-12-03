package bookshelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProgressManager {
	
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
		Progress newProgress = new Progress();
		newProgress.setTitle("Atividade 03");
		newProgress.setSituation("Finished");
		
		entityManager.persist(newProgress);
	}	
	
	private static void update() {
		Progress existProgress = new Progress();
		existProgress.setBookId(1);
		existProgress.setTitle("");
		existProgress.setSituation("");	
		
		entityManager.merge(existProgress);
	}
	
	private static void find() {
		Integer primaryKey = 2;
		Progress progress = entityManager.find(Progress.class, primaryKey);
		
		System.out.println(progress.getTitle());
		System.out.println(progress.getSituation());
	}
	
	private static void remove() {
		Integer primaryKey = 3;
		Progress reference = entityManager.getReference(Progress.class, primaryKey);
		entityManager.remove(reference);
	}

	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}


