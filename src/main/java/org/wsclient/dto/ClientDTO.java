package org.wsclient.dto;

import java.util.Date;

import org.wsclient.model.Address;

/**
 * 
 * Classe Client DTO (Data Transfer Object)
 *
 * Responsável por retornar os dados referente: Cliente e Endereço associado
 *
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 *
 */
public class ClientDTO {

	private Long id;
	private String name;
	private String cpf;
	private Date birthDate;
	private int AddressNumber;
	private Address address;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getAddressNumber() {
		return AddressNumber;
	}
	public void setAddressNumber(int addressNumber) {
		AddressNumber = addressNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
