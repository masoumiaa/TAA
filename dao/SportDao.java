import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.istic.M2ILA.taaTP1.Location;
import fr.istic.M2ILA.taaTP1.Sport;

public class SportDao implements Dao<Sport,Double> {

	private Session currentSession;
	private Transaction currentTransaction;

	public SportDao(){}

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

	public void persist(Sport entity) {
		getCurrentSession().save(entity);

	}

	public void update(Sport entity) {
		getCurrentSession().update(entity);
	}

	public Sport findById(Double id) {
		Sport sport = (Sport) getCurrentSession().get(Sport.class, id);
		return sport;
	}

	public void delete(Sport entity) {
		getCurrentSession().delete(entity);
	}

	public List<Sport> findAll() {
		List<Sport> sports = (List<Sport>) getCurrentSession().createQuery("from Sport").list();
		return sports;
	}

	public void deleteAll() {
		List<Sport> entityList = findAll();
		for (Sport entity : entityList) {
			delete(entity);
		}
	}

}
