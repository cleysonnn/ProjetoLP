package Projeto;

import java.io.IOException;
import java.util.List;

public interface SisMercado {
	public void cadastrarUSUario(Usuario u) throws UsuarioJaExisteException, IOException;
	public void cadastrarCliente(Cliente cliente) throws ClienteJaExisteException, IOException;
	public void cadrastarProduto(Produto prod) throws JaExisteProdutoException;
	public void cadastrarVenda(Vendas venda);
	public boolean verficarLogin(String login,String senha);
	public List<Usuario> pesquisarUsuariosComNomeComecandoCom(String prefixo) throws nomeComPrefixoExcption;
}
