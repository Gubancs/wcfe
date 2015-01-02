package hu.mortoff.wcfe.mapper;

import hu.mortoff.wcfe.domain.Client;
import hu.mortoff.wcfe.domain.filter.ClientFilter;

import java.util.List;

/**
 * MyBatis Mapper interface for Client POJO
 * 
 * @author Gabor Kokeny
 *
 */
public interface ClientMapper {

	/**
	 * Search clients by a filter object
	 * 
	 * @param filter
	 * @return
	 */
	public List<Client> findClients(ClientFilter filter);
}
