package hu.mortoff.wcfe.ws;

import hu.mortoff.wcfe.domain.Client;
import hu.mortoff.wcfe.domain.filter.ClientFilter;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 * @author Gabor Kokeny
 *
 */
@WebService
public interface ClientService {

	@WebMethod
	public List<Client> findClients(@WebParam ClientFilter filter);
}
