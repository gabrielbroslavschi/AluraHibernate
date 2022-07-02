package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity//como informar que a classe Produto é uma entidade
@Table(name = "categorias") //Informar o nome da tabela do banco de dados
public class Categoria {
	
	@Id //informar que o Long id é o "id" do BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) //informar como é gerado de forma automatica o ID no BD
	private Long id;
	private String nome;
	
	public Categoria() {
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
