package com.gmascb.cursonc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gmascb.cursonc.domain.Categoria;
import com.gmascb.cursonc.domain.Produto;
import com.gmascb.cursonc.repositories.CategoriaRepository;
import com.gmascb.cursonc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository catRep;
	@Autowired
	private ProdutoRepository proRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 200.00);
		Produto p3 = new Produto(null, "Mouse", 20.00);
		
	    cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
	    cat2.getProdutos().addAll(Arrays.asList(p2));
	    
	    p1.getCategorias().addAll(Arrays.asList(cat1));
	    p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
	    p3.getCategorias().addAll(Arrays.asList(cat1));
	    
	    
		catRep.saveAll(Arrays.asList(cat1, cat2));
		proRep.saveAll(Arrays.asList(p1, p2, p3));
	}
}
