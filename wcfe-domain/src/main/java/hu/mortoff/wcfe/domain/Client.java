package hu.mortoff.wcfe.domain;

import hu.mortoff.wcfe.domain.embeddable.Address;
import hu.mortoff.wcfe.domain.embeddable.Name;
import hu.mortoff.wcfe.domain.embeddable.Place;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Gabor Kokeny
 *
 */
public class Client implements Serializable {

	private static final long serialVersionUID = 4726741441524532262L;

	private Name name = new Name();

	private Name mothersName = new Name();

	private String identity;

	private Date birthDate;

	private Place birthPlace;

	private Address address;

	public Client() {
	}

	public Client(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Name getMothersName() {
		return mothersName;
	}

	public void setMothersName(Name mothersName) {
		this.mothersName = mothersName;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Place getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Place birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", mothersName=" + mothersName
				+ ", identity=" + identity + ", birthDate=" + birthDate
				+ ", birthPlace=" + birthPlace + ", address=" + address + "]";
	}

}
