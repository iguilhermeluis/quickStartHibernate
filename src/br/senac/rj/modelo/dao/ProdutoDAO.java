package br.senac.rj.modelo.dao;

import br.senac.rj.modelo.Produto;

public class ProdutoDAO extends DAOGenerico<Produto>{
	
	private static ProdutoDAO instancia;
	
	
	private ProdutoDAO(){
		super();
		classePersistente = Produto.class;
		
	}

	public static ProdutoDAO getInstancia(){
		if(instancia == null){
			instancia = new ProdutoDAO();
			return instancia;
		} else{
			return instancia;	
		}
		
	}
	
}
