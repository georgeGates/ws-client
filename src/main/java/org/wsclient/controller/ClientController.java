package org.wsclient.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wsclient.dto.ClientDTO;
import org.wsclient.model.Client;
import org.wsclient.service.ClientService;

/**
 * 
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
@RestController
@RequestMapping("/api/")
public class ClientController {
	
	private final ClientService service;
	
	@Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }
	
	@PostMapping("/client")
	public ClientDTO create(@Valid @RequestBody Client client) {
		return this.service.create(client);
	}
	
	@PutMapping("/client")
	public ClientDTO update(@RequestBody Client client) {
		return this.service.edit(client);
	}
	
	@GetMapping("/client")
    public Page<Client> getAll(Pageable pageable) {
        return this.service.findAll(pageable);
    }
	
	@GetMapping("/client/{id}")
	public ClientDTO getById(@PathVariable Long id) {
		return this.service.findById(id);
	}

	@DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
