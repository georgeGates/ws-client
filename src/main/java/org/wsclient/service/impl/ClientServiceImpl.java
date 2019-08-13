package org.wsclient.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.wsclient.dto.ClientDTO;
import org.wsclient.exception.ResourceNotFoundException;
import org.wsclient.model.Address;
import org.wsclient.model.Client;
import org.wsclient.repository.AddressRepository;
import org.wsclient.repository.ClientRepository;
import org.wsclient.service.ClientService;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
@Service("clientService")
@Transactional
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	RestTemplate restTemplate;

	private static final String URL_CEP = "https://viacep.com.br/ws/{cep}/json/";

	
	@Override
	public ClientDTO create(Client client) {
		if (this.repository.findByCpf(client.getCpf()).isPresent())
			throw new RuntimeException("CPF já consta em nosso sistema!");
		ClientDTO clientDTO = new ModelMapper().map(this.add(client),ClientDTO.class);
		clientDTO.setAddress(getAddressByCep(client.getAddressCep()));
		return clientDTO;
	}

	@Override
	public ClientDTO edit(Client client) {
		return this.repository.findByIdAndCpf(client.getId(), client.getCpf()).map(entity -> {
			ClientDTO clientDTO = new ModelMapper().map(this.update(client),ClientDTO.class);
			clientDTO.setAddress(getAddressByCep(client.getAddressCep()));
			return clientDTO; 
		}).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
	}

	@Override
	public ResponseEntity delete(Long id) {
		return this.repository.findById(id).map(entity -> {
			this.repository.delete(entity);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));

	}

	@Override
	public Page<Client> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	@Override
	public ClientDTO findById(Long id) {
		return this.repository.findById(id).map(entity -> {
			ClientDTO clientDTO = new ModelMapper().map(entity,ClientDTO.class);
			clientDTO.setAddress(getAddressByCep(entity.getAddressCep()));
			return clientDTO;
		}).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado!"));
	}

	/********** Inicio - Funções Relacionado a entidade Endereço **********/
	/* Função 1 - Validar cep e salvar entidade Endereço  */
	private Address getAddressByCep(String cep) {
		Optional<Address> address = this.addressRepository.findByCep(cep); 
		if(address.isPresent())
			return address.get();
		return this.createAddress(cep);
	}
	
	/* Função 2 - Validar cep e salvar entidade Endereço  */
	private Address createAddress(String cep) {
		ResponseEntity<String> response = this.findByCep(cep);
		try {
			if (response.getStatusCodeValue() == 200) {
				Address address = new ObjectMapper().readValue(response.getBody().toString(), Address.class); 
				address.setCep(cep);		
				return this.addressRepository.save(address);
			}
		} catch (IOException e) {
			return null;
		}
		return null;
	}

	/* Função 3 - Obter Endereço atual no site via cep */
	private ResponseEntity<String> findByCep(String cep) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			Map<String, String> params = new HashMap<String, String>();
			params.put("cep", cep);
			return restTemplate.exchange(this.URL_CEP, HttpMethod.GET, entity, String.class, params);
		} catch (HttpStatusCodeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	/********** Fim - Funções Relacionado a entidade Endereço **********/ 
}
