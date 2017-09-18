import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.istic.M2ILA.taaTP1.Location;
import fr.istic.M2ILA.taaTP1.Person;
import fr.istic.M2ILA.taaTP1.Sport;

public class LocationDao implements Dao<Location, Double>{
	
    private Session currentSession;
	private Transaction currentTransaction;
	
	public LocationDao(){}

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
	
	public void persist(Location entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(Location entity) {
		getCurrentSession().update(entity);
		
	}

	public Location findById(Double id) {
		Location location = (Location) getCurrentSession().get(Location.class, id);
		return location;
	}

	public void delete(Location entity) {
		getCurrentSession().delete(entity);
		
	}

	public List<Location> findAll() {
		List<Location> locations = (List<Location>) getCurrentSession().createQuery("from Location").list();
		return locations;
	}

	public void deleteAll() {
		List<Location> entityList = findAll();
		for (Location entity : entityList) {
			delete(entity);
		}
	}

}
