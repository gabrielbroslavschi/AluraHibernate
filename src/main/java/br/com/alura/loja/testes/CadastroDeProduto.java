package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi");
		System.out.println("preço do produto: " + precoDoProduto);
		}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");

		Produto celular = new Produto("Xiaomi", "Muito legal, melhor que iphone", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em); // todo produto DAO que é inserido, tem que passar um EntityManager
		CategoriaDao categoriaDao = new CategoriaDao(em);// toda categoria DAO que é inserido, tem que passar um
															// EntityManager

		em.getTransaction().begin(); // abre as transações

		em.persist(celulares); // oque desejo realizar de operações

		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);

		celulares.setNome("1234");
		em.getTransaction().commit(); // relizo o commit das transações

		em.close(); // fecha as transações
	}
}