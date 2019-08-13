package org.wsclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

/**
 * 
 * Entidade Endereço
 *
 * @author George Compton - george.compton@hotmail.com
 * @since 2019.08.12
 */
@Entity
@Table(name = "address")
public class Address {
	
	/** Identificador da Tabela */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	/** CEP de endereço */
	private String cep;
	/** Logradouro de endereço */
	private String logradouro;
	/** Complemento de endereço */
	private String complemento;
	/** Bairro de endereço */
	private String bairro;
	/** Localidade de endereço */
	private String localidade;
	/** UF de endereço */
	private String uf;
	
	/** Unidade de endereço */
	@Transient
	private String unidade;
	/** IBGE de endereço */
	@Transient
	private String ibge;
	/** GIA de endereço */
	@Transient
	private String gia;

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getIbge() {
		return ibge;
	}
	public void setIbge(String ibge) {
		this.ibge = ibge;
	}
	public String getGia() {
		return gia;
	}
	public void setGia(String gia) {
		this.gia = gia;
	}
}
