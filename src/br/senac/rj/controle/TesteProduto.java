package br.senac.rj.controle;

import br.senac.rj.modelo.Produto;
import br.senac.rj.modelo.dao.ProdutoDAO;

public class TesteProduto {

	public static void main(String[] args) {
	
		ProdutoDAO dao = ProdutoDAO.getInstancia();
		Produto p = new Produto();
		p.setNome("Tijolo");
		p.setPreco(4.0);
		
		dao.gravar(p);
		dao.encerrar();
	}

}
