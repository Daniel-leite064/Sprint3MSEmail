package com.emailMS3.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_email")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_email")
	private long idEmail;	
	
	@Column(name="dt_envio")
	private Date dtEnvio;	
	
	@Column(name="assunto")
	private String assunto;
	
	@Column(name="corpo_email")
	private String corpoEmail;
	
	@Column(name="remetente")
	private String remetente;
	
	@Column(name="destinatario")
	private String destinatario;
	
	@Column(name="html_corpo")
	private String htmlCorpo;
	
	@Column(name="sucesso")
	private boolean sucesso;
	
	private List<String> listaCopias;

	public boolean isSucesso() {
		return sucesso;
	}

	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getHtmlCorpo() {
		return htmlCorpo;
	}

	public void setHtmlCorpo(String htmlCorpo) {
		this.htmlCorpo = htmlCorpo;
	}

	public long getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(long idEmail) {
		this.idEmail = idEmail;
	}

	public Date getDtEnvio() {
		return dtEnvio;
	}

	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCorpoEmail() {
		return corpoEmail;
	}

	public void setCorpoEmail(String corpoEmail) {
		this.corpoEmail = corpoEmail;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public List<String> getListaCopias() {
		return listaCopias;
	}

	public void setListaCopias(List<String> listaCopias) {
		this.listaCopias = listaCopias;
	}
	
	
	
	
}
