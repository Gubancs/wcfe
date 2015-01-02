package hu.mortoff.wcfe.clients;

import hu.mortoff.wcfe.domain.Client;
import hu.mortoff.wcfe.domain.embeddable.Name;
import hu.mortoff.wcfe.domain.filter.ClientFilter;
import hu.mortoff.wcfe.ws.ClientService;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientConsumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"weatherConsumer.xml");
		ClientService clientService = applicationContext.getBean(
				"clientConsumer", ClientService.class);

		ClientFilter clientFilter = new ClientFilter();
		clientFilter.setName(new Name("Edit", "Vékony"));
		clientFilter.setIdentity("234234");
		
		List<Client> clients = clientService.findClients(clientFilter);

		for (Client client : clients) {
			System.out.println(client);
		}

		applicationContext.close();
	}

}
