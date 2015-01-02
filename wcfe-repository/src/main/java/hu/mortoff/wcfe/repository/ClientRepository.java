package hu.mortoff.wcfe.repository;

import static org.springframework.util.Assert.notNull;
import hu.mortoff.wcfe.domain.Client;
import hu.mortoff.wcfe.domain.embeddable.Name;
import hu.mortoff.wcfe.domain.filter.ClientFilter;
import hu.mortoff.wcfe.mapper.ClientMapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

	private List<Client> clients = new ArrayList<Client>();

	protected ClientMapper clientMapper;

	public ClientRepository() {
	}

	// TODO inject a mapper instance via spring
	public ClientRepository(ClientMapper clientMapper) {
		super();
		this.clientMapper = clientMapper;
	}

	@PostConstruct
	public void initRepository() {

		clients.add(new Client(new Name("Gabor", "Kokeny")));
		clients.add(new Client(new Name("Máté", "Csomós")));
		clients.add(new Client(new Name("Máté", "Délceg")));
		clients.add(new Client(new Name("Edit", "Vékony")));
		clients.add(new Client(new Name("Ákos", "Peer")));
	}

	public List<Client> findClients(ClientFilter filter) {
		notNull(filter);

		final List<Client> result = new ArrayList<Client>();
		for (Client client : clients) {
			if (client.getName().getFirstName() != null
					&& filter.getName().getFirstName() != null
					&& client.getName().getFirstName()
							.startsWith(filter.getName().getFirstName())) {
				result.add(client);
			}

		}

		return result;
	}
}
