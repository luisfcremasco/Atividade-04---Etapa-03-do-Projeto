package bookshelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BooksManager {
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {
		
		begin();
		
		//create();
		
		//update();
		
		//find();
		
		remove();;
				
		end();
	}
		
	private static void begin() {
		factory = Persistence.createEntityManagerFactory("Book");
		entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
	}
	
	private static void create() {
		Book newBook = new Book();
		newBook.setTitle("Etapa 3");
		newBook.setAuthor("Luís");
		
		entityManager.persist(newBook);
	}	
	
	private static void update() {
		Book existBook = new Book();
		existBook.setBookId(1);
		existBook.setTitle("JPA - Java Persistence API");
		existBook.setAuthor("Luís");	
		
		entityManager.merge(existBook);
	}
	
	private static void find() {
		Integer primaryKey = 2;
		Book book = entityManager.find(Book.class, primaryKey);
		
		System.out.println(book.getTitle());
		System.out.println(book.getAuthor());
	}
	
	private static void remove() {
		Integer primaryKey = 3;
		Book reference = entityManager.getReference(Book.class, primaryKey);
		entityManager.remove(reference);
	}

	private static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

}
