package Projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeArquivo {
	public void gravarDadosEmArquivo(List<String> lista, String aqrname) throws IOException {
		BufferedWriter gravador = null;
		
		try {
			gravador = new BufferedWriter(new FileWriter(aqrname));
			for (String s : lista) {
				gravador.write(s + "\n");
			}
		} finally {
			if (gravador != null) {
				gravador.close();
			}
		}
	}

	public List<String> recuperaDadosDoArquivo(String aqrname) throws IOException {
		File arquivo = new File(aqrname) ;
		if(arquivo.exists()== false ) {
			arquivo.createNewFile();
		}
		BufferedReader leitor = null;
		List<String> users = new ArrayList<String>();
		try {
			leitor = new BufferedReader(new FileReader(aqrname));
			String textoLido = null;

			do {
				textoLido = leitor.readLine();
				if (textoLido != null) {
					users.add(textoLido);
				}

			} while (textoLido != null);
		} finally {
			if (leitor != null) {
				leitor.close();
			}
		}
		return users;

	}
	
	public void gravarUsuarios(List<Usuario> users) throws IOException {
		List<String> usuariostx = new ArrayList<String>();
		String linha = "";
		for(Usuario u : users) {
			linha = u.getLogin() + ";" + u.getNome() + ";" + u.getSenha();
			usuariostx.add(linha);
		}
		
		this.gravarDadosEmArquivo(usuariostx, "usuarios.txt");
	}

	
	public List<Usuario> recuperaUsuarios() throws IOException{
		List<String> usuariostx = this.recuperaDadosDoArquivo("usuarios.txt");
		List<Usuario> users = new ArrayList<Usuario>();
		for (String s : usuariostx) {
			String [] linha = s.split(";");
			Usuario u = new Usuario(linha[0],linha[1],linha[2]);
			users.add(u);
		}
		return users;
	}
	
	public void gravarClientesPF(List<Cliente> listaCLientes) throws IOException {
		List<String> Clientestx = new ArrayList<String>();
		String linha = "";
		for(Cliente c : listaCLientes) {
			if(c instanceof ClientePF) {
				linha = c.getNome() + ";"+ c.getCodigo();
				Clientestx.add(linha);
			}
		}
		
		gravarDadosEmArquivo(Clientestx , "ListaDeClientesPF.txt");
	}
	
	public List<Cliente> recuperarClientes() throws IOException{
		List<String> clientePF = this.recuperaDadosDoArquivo("ListaDeClientesPF.txt");
		List<Cliente> clientes = new ArrayList<Cliente>();
		for (String c : clientePF) {
			String [] linha = c.split(";");
			Cliente cliente = new ClientePF(linha[0],linha[1]);
			clientes.add(cliente);
			
		}
		List<String> clientetxPJ = this.recuperaDadosDoArquivo("ListaDeClientesPJ.txt");
		for (String c : clientetxPJ) {
			String [] linha = c.split(";");
			Cliente cliente = new ClientePJ(linha[0],linha[1]);
			clientes.add(cliente);
			
		}
		return clientes;
		
	}
	public void gravarClientesPJ(List<Cliente> listaCLientes) throws IOException {
		List<String> Clientestx = new ArrayList<String>();
		String linha = "";
		for(Cliente c : listaCLientes) {
			if(c   instanceof ClientePJ) {
				linha = c.getNome() + ";"+ c.getCodigo();
				Clientestx.add(linha);
			}
		}
		
		gravarDadosEmArquivo(Clientestx , "ListaDeClientesPJ.txt");
	}
	
	
	public void gravarProduto(List<Produto> listaDeProduto) throws IOException{
		List<String> Produtotx = new ArrayList<String>();
		String linha = "";
		for(Produto p : listaDeProduto) {
		linha = p.getNome() +";" + p.getCodigo() +";"+ Double.toString(p.getPrecoatacado())+";"+Double.toString(p.getPrecovarejo())+";"+Boolean.toString(p.isPerecivel());
		Produtotx.add(linha);
		}
		gravarDadosEmArquivo(Produtotx , "ListaDeProdutos.txt");
	}
	public List<Produto> recuperaProdutos() throws IOException{
		List<String> listaDeProdutostx = this.recuperaDadosDoArquivo("ListaDeProdutos.txt");
		List<Produto> produto = new ArrayList<Produto>();
		for (String p : listaDeProdutostx ) {
			String [] linha = p.split(";");
			Produto produtos = new Produto(linha[0],linha[1],Double.parseDouble(linha[2]),Double.parseDouble(linha[3]),Boolean.parseBoolean((linha[4])));
			produto.add(produtos);
		}
		return produto;
	}
	

}
