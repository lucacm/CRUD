package br.edu.insper.mvc.model;

import java.sql.Timestamp;

public class Tarefa {
	
	private Integer id;
	private Integer cadastroId;
	private String tarefa;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCadastroId() {
		return cadastroId;
	}
	public void setCadastroId(Integer cadastroId) {
		this.cadastroId = cadastroId;
	}
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
