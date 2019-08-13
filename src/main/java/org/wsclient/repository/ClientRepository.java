package org.wsclient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wsclient.model.Client;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
@Repository
public interface ClientRepository  extends JpaRepository<Client, Long>{
	Optional<Client> findByCpf(String cpf);
	Optional<Client> findByIdAndCpf(Long id, String cpf);
}
