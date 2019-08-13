package org.wsclient.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.wsclient.dto.ClientDTO;
import org.wsclient.model.Client;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
public interface ClientService extends GenericService<Client, Long> {

	ClientDTO create(Client client);
	ClientDTO edit(Client client);
	ResponseEntity delete(Long id);
	Page<Client> findAll(Pageable pageable);
	ClientDTO findById(Long id);
}
