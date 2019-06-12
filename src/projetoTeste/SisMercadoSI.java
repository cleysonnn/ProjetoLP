package projetoTeste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class SisMercadoSI implements SisMercado {
	private List<Usuario> listaDeUsuario;
	private List<Produto> listaDeProduto;
	List<Cliente> lisstaDeClientes;
	private List<Vendas> vendas;
	private ManipuladorDeArquivo manipulador;

	public void gravarDadosEmArquivo() {
		
		try {
			manipulador.gravarUsuarios(this.listaDeUsuario);
			manipulador.gravarClientesPF(this.lisstaDeClientes);
			manipulador.gravarClientesPJ(this.lisstaDeClientes);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		try {
		manipulador.gravarProduto(this.listaDeProduto);
		}catch(IOException p) {
			System.out.println(p.getMessage());

		}
		
	}

	public SisMercadoSI() {
		this.manipulador = new ManipuladorDeArquivo();
		try {
			this.listaDeUsuario = this.manipulador.recuperaUsuarios();
			this.lisstaDeClientes = this.manipulador.recuperarClientes();
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		try {
		this.listaDeProduto = this.manipulador.recuperaProdutos();
		}catch(IOException p) {
			System.out.println(p.getMessage());

		}
		this.vendas = new ArrayList<Vendas>();

	}

	public void cadastrarUSUario(Usuario usuario) throws UsuarioJaExisteException {
		if (Existeusuario(usuario.getLogin()) == false) {
			this.listaDeUsuario.add(usuario);
		} else {
			throw new UsuarioJaExisteException("usuario ja cadastrado");
		}
	}

	public List<Usuario> getListaDeUsuario() {
		return listaDeUsuario;
	}

	public boolean Existeusuario(String login) {
		for (Usuario u : this.listaDeUsuario) {
			if (u.getLogin().equals(login)) {
				return true;
			}
		}
		return false;

	}

	public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException, IOException {
		if (ClienteJaExistente(cliente) == false) {
			this.lisstaDeClientes.add(cliente);
		} else {
			throw new ClienteJaExisteException("cliente ja cadastrado");
		}
	}

	public boolean ClienteJaExistente(Cliente cliente) {
		for (Cliente c : this.lisstaDeClientes) {
			if (c.equals(cliente)) {
				return true;

			}
		}
		return false;
	}

	public void cadrastarProduto(Produto p) throws JaExisteProdutoException {
		if(this.verificaProduto(p) == false) {
			this.listaDeProduto.add(p);
		
		}else {
			throw new JaExisteProdutoException("Produto ja cadastrado"); 
		}
		
		
	}

	public boolean verificaProduto(Produto produto) {
		for (Produto p : this.listaDeProduto) {
			if (p.equals(produto)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Produto> listarProdutos(){
		 return this.listaDeProduto;
	}
	
	public void cadastrarVenda(Vendas venda) {
		this.vendas.add(venda);
	}

	public boolean verficarLogin(String login, String senha) {
		for (Usuario u : this.listaDeUsuario) {
			if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	public List<Usuario> pesquisarUsuariosComNomeComecandoCom(String prefixo) throws nomeComPrefixoExcption {
		List<Usuario> user = new ArrayList<Usuario>();

		for (Usuario u : this.listaDeUsuario) {
			if (u.getNome().startsWith(prefixo)) {

				user.add(u);
			} else if (u.getNome() == null) {
				throw new nomeComPrefixoExcption("Nenhum prefixo foi digitado");
			}
		}

		return user;

	}

	public List<Cliente> listarClientes() {
		return this.lisstaDeClientes;
	}

}