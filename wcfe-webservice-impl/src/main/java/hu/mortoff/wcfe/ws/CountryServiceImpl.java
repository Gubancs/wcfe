package hu.mortoff.wcfe.ws;

import hu.mortoff.wcfe.domain.Country;
import hu.mortoff.wcfe.repository.CountryRepository;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 
 * @author Gabor Kokeny
 *
 */
@Component
@WebService(serviceName = "countryService")
public class CountryServiceImpl implements CountryService {

	protected final CountryRepository countryRepository;

	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}

	@Override
	@WebMethod
	public Country getCountry(@WebParam Long countryId) {
		Assert.notNull(countryId);

		return countryRepository.find(countryId);
	}
}
