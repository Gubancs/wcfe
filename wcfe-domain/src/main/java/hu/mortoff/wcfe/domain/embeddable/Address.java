package hu.mortoff.wcfe.domain.embeddable;

import java.io.Serializable;

/**
 * 
 * @author Gabor Kokeny
 *
 */
public class Address implements Serializable {

	private static final long serialVersionUID = -3478026092005069899L;

	private String countryCode;

	private String country;

	private Place place;

	private String street;

	private String houseNumber;

	public Address() {
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	@Override
	public String toString() {
		return "Address [countryCode=" + countryCode + ", country=" + country
				+ ", place=" + place + ", street=" + street + ", houseNumber="
				+ houseNumber + "]";
	}

}
