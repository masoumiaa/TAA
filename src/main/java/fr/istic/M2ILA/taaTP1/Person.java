package fr.istic.M2ILA.taaTP1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	private Long id;
    private String name;
    private String surname;
    private String mail;
    
    private List<Sport> sports = new ArrayList<Sport>();
    private List<Location> locations = new ArrayList<Location>();
    
    public Person() {}
    
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the sports
	 */
	@OneToMany
	public List<Sport> getSports() {
		return sports;
	}

	/**
	 * @param sports the sports to set
	 */
	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
	
	/**
	 * @param add sport to sports list
	 */
	public void addSport(Sport sport) {
		this.sports.add(sport);
	}

	/**
	 * @return the locations
	 */
	@OneToMany
	public List<Location> getLocations() {
		return locations;
	}

	/**
	 * @param locations the locations to set
	 */
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	/**
	 * @param add location to list
	 */
	public void addLocation(Location location) {
		this.locations.add(location);
	}
    
    
}
