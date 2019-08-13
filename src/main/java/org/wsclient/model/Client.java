package org.wsclient.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.wsclient.util.Consts;

import com.fasterxml.jackson.annotation.JsonFormat;;

/**
 * 
 * Entidade Cliente
 *
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 */
@Entity
@Table(name = "client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8572560996118833263L;

	/** Identificador da Tabela */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/** Nome de cliente **/
	@Column(name = "name", nullable = false, length = 128)
	private String name;

	/** CPF de cliente **/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Consts.CPF)
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	/** Data Nascimento de cliente **/
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Consts.DATE)
	@Column(name = "birthdate", nullable = false)
	private Date birthDate;
	
	/** Cep do endereço de cliente **/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Consts.CEP)
	@Column(name = "address_cep")
    private String addressCep;
	
	/** Número do endereço de cliente **/
	@Column(name = "address_number")
	private int addressNumber;

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
	public String getAddressCep() {
		return addressCep;
	}
	public void setAddressCep(String addressCep) {
		this.addressCep = addressCep;
	}
	public int getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(int addressNumber) {
		this.addressNumber = addressNumber;
	}
}
