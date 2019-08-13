package org.wsclient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wsclient.model.Address;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	Optional<Address> findByCep(String cep);
}
