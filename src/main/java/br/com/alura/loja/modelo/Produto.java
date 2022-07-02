package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //como informar que a classe Produto é uma entidade
@Table(name = "produtos") //Informar o nome da tabela do banco de dados
public class Produto { //nome da entidade
	
	@Id //informar que o Long id é o "id" do BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) //informar como é gerado de forma automatica o ID no BD
	private Long id; //coluna id
	private String nome; //coluna nome
	private String descricao; //coluna descrição
	private BigDecimal preco; //coluna preço
	private LocalDate dataCadastro = LocalDate.now(); // informando a coluna data
	
	
	@ManyToOne
	private Categoria categoria; //É uma classe tipo ENUM
	
	
	
	public Produto() {
	}
	
	
	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	
	
}
