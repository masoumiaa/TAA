import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.istic.M2ILA.taaTP1.Location;
import fr.istic.M2ILA.taaTP1.Person;

public class PersonDao implements Dao<Person, Double> {

    private Session currentSession;
    private Transaction currentTransaction;
    
    public PersonDao() {}
    
    public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
    
	public void persist(Person entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(Person entity) {
		getCurrentSession().update(entity);
		
	}

	public Person findById(Double id) {
		Person person = (Person) getCurrentSession().get(Person.class, id);
		return person;
	}

	public void delete(Person entity) {
		getCurrentSession().delete(entity);
		
	}

	public List<Person> findAll() {
		List<Person> persons = (List<Person>) getCurrentSession().createQuery("from Person").list();
		return persons;
	}

	public void deleteAll() {
		List<Person> entityList = findAll();
		for (Person entity : entityList) {
			delete(entity);
		}
	}

}
