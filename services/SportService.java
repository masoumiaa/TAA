import java.util.List;

import fr.istic.M2ILA.taaTP1.Sport;

public class SportService {
	private static SportDao SportDao;

	public SportService() {
		SportDao = new SportDao();
	}

	public void persist(Sport entity) {
		SportDao.openCurrentSessionwithTransaction();
		SportDao.persist(entity);
		SportDao.closeCurrentSessionwithTransaction();
	}

	public void update(Sport entity) {
		SportDao.openCurrentSessionwithTransaction();
		SportDao.update(entity);
		SportDao.closeCurrentSessionwithTransaction();
	}

	public Sport findById(Double id) {
		SportDao.openCurrentSession();
		Sport Sport = SportDao.findById(id);
		SportDao.closeCurrentSession();
		return Sport;
	}

	public void delete(Double id) {
		SportDao.openCurrentSessionwithTransaction();
		Sport Sport = SportDao.findById(id);
		SportDao.delete(Sport);
		SportDao.closeCurrentSessionwithTransaction();
	}

	public List<Sport> findAll() {
		SportDao.openCurrentSession();
		List<Sport> Sports = SportDao.findAll();
		SportDao.closeCurrentSession();
		return Sports;
	}

	public void deleteAll() {
		SportDao.openCurrentSessionwithTransaction();
		SportDao.deleteAll();
		SportDao.closeCurrentSessionwithTransaction();
	}

	public SportDao SportDao() {
		return SportDao;
	}
}
