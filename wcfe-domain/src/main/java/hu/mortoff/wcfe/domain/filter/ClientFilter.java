package hu.mortoff.wcfe.domain.filter;

import hu.mortoff.wcfe.domain.embeddable.Name;

import java.io.Serializable;

/**
 * 
 * @author Gabor Kokeny
 *
 */
public class ClientFilter implements Serializable {

	private static final long serialVersionUID = -3285785348658989567L;

	private Name name;

	private Name mothersName;

	private String identity;

	public ClientFilter() {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identity == null) ? 0 : identity.hashCode());
		result = prime * result
				+ ((mothersName == null) ? 0 : mothersName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ClientFilter other = (ClientFilter) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		if (mothersName == null) {
			if (other.mothersName != null)
				return false;
		} else if (!mothersName.equals(other.mothersName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClientFilter [name=" + name + ", mothersName=" + mothersName
				+ ", identity=" + identity + "]";
	}

}
