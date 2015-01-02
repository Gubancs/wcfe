package hu.mortoff.wcfe.ws;

import hu.mortoff.wcfe.domain.Client;
import hu.mortoff.wcfe.domain.filter.ClientFilter;
import hu.mortoff.wcfe.repository.ClientRepository;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Gabor Kokeny
 *
 */
@Component
@WebService(serviceName = "clientService")
public class ClientServiceImpl implements ClientService {

	protected final ClientRepository clientRepository;

	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	@Override
	@WebMethod
	public List<Client> findClients(@WebParam() ClientFilter filter) {
		return clientRepository.findClients(filter);
	}

}
