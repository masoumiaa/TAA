package fr.istic.M2ILA.taaTP1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sport {

	private Long id;
    private String name;
    

    public Sport() {}
    
    public Sport(String name) {
    	this.name = name;
    }

	/**
	 * @return the id
	 */
    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
    
}
