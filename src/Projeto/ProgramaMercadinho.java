package Projeto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProgramaMercadinho {
	public static void main(String args[]) throws IOException {
		SisMercadoSI mercado = new SisMercadoSI();
		
		
		String resUser; // FEITO POR TEIXEIRA É VDD ESTE BILHETE
		boolean continuar = true;

		while (continuar) {
			resUser = JOptionPane.showInputDialog(
					" 1. para fazer o login \n 2.cadastar\n 3.para sair", "Digite aqui");
			if (resUser.equals("1")) {
				String login = JOptionPane.showInputDialog("Digite o login", "Digite seu login");
				String senha = JOptionPane.showInputDialog("Digite a senha", "Digite sua senha");
				boolean achou = mercado.verficarLogin(login, senha);

				while (achou == true) {
					String opcao = JOptionPane.showInputDialog(
							  "  1. para cadastrar clientePF \n"
							+ "  2. para cadastrar clientePJ \n"
							+ "  3 para obter lista de clientes\n"
							+ "  4. para obter a lista de cliente(Pessoa fisica)\n"
							+ "  5. para obter a lista de cliente(Pessoa juridica)\n"
							+ "  6. para Pesquisa usuários com nome começando com \n"
							+ "  7. para cadastrar um produto\n"
							+ "  8. para listar os produtos\n"
							+ "  9. para listar os produtos pereciveis\n"
							+ "  10. para listar os produtos não perecivel\n"
							+ "  0. para sair"
							,"Digite o numero da operação que desaja realizar");

					if (opcao.equals("1")) {
						String nome = JOptionPane.showInputDialog("Digite o nome","nome da pessoa fisica");
						String cpf = JOptionPane.showInputDialog("Digite o cpf","cpf da pessoa");
						ClientePF novoClientePF = new ClientePF(nome, cpf);
						try {
							mercado.cadastrarCliente(novoClientePF);
							JOptionPane.showMessageDialog(null, "Cliente cadastrado");
						} catch (ClienteJaExisteException bol) {
							JOptionPane.showMessageDialog(null, "erro  " + bol.getMessage());
						}

					} else if (opcao.equals("2")) {
						String nome = JOptionPane.showInputDialog("Digite o nome","nome da pessoa juridica");
						String cnpj = JOptionPane.showInputDialog("Digite o cnpj","cnpj da pessoa");
						ClientePJ novoClientePJ = new ClientePJ(nome, cnpj);
						try {
							mercado.cadastrarCliente(novoClientePJ);
							JOptionPane.showMessageDialog(null, "cliente cadastrado");
						} catch (ClienteJaExisteException e) {
							JOptionPane.showMessageDialog(null, "erro " + e.getMessage());
						}

					} else if (opcao.equals("3")) {
						String mensagem = "";
						for (Cliente s : mercado.listarClientes()) {
							mensagem += s + "\n";
						}
						JOptionPane.showMessageDialog(null, mensagem);
					} else if(opcao.equals("4")) {
						String mensagem = "";
						for (Cliente s : mercado.listarClientes()) {
							if(s instanceof ClientePF ) {
								mensagem += s + "\n";
								
							}
						}
						JOptionPane.showMessageDialog(null, mensagem);
						
					}else if (opcao.equals("5")) {
						String mensagem = "";
						for (Cliente s : mercado.listarClientes()) {
							if(s instanceof ClientePJ ) {
								mensagem += s + "\n";
								
							}
						}
						JOptionPane.showMessageDialog(null, mensagem);
					}
					else if (opcao.equals("6")) {
						String prefixo = JOptionPane.showInputDialog("Digite o prefixo");
						List<Usuario> usuarios = new ArrayList<Usuario>();
						try {
							usuarios = mercado.pesquisarUsuariosComNomeComecandoCom(prefixo);
							String linha = "";
							for (Usuario u : usuarios) {
								linha +=  u.toString();
								JOptionPane.showMessageDialog(null, linha);
							}

						} catch (nomeComPrefixoExcption e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}

					} else if (opcao.equals("7")) {
						String nome = JOptionPane.showInputDialog("Digite qual o produto", "nome do produto");
						String codigo = JOptionPane.showInputDialog("Digite o codigo do produto", "Codigo");
						double precovarejo = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do varejo", "preço varejo"));
						double Precoatacado = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do atacado", "preço atacado"));
						String perecivel = JOptionPane.showInputDialog("O produto e perecivel ?");
						boolean eperecivel = false;
						
						eperecivel = perecivel.equalsIgnoreCase("sim")?true:false;
						
						Produto novoProduto = new Produto(nome, codigo, precovarejo, Precoatacado, eperecivel);
						try {
							mercado.cadrastarProduto(novoProduto);
							JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
						} catch (JaExisteProdutoException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}else if(opcao.equals("8")) {
						String produtos = "";
						for(Produto p : mercado.listarProdutos() ) {
							produtos += p + "\n";
						}
						JOptionPane.showMessageDialog(null,produtos );
					}else if(opcao.equals("9")) {
						String linha = "";
						for(Produto p : mercado.listarProdutos()) {
							if (p.isPerecivel() == true) {
								linha += p.getNome() + "é perecivel \n";
							}
						}
						JOptionPane.showMessageDialog(null, linha);
					}else if(opcao.equals("10")) {
						String linha = "";
						for(Produto p : mercado.listarProdutos()) {
							if (p.isPerecivel() == false) {
								linha += p.getNome() + " não é perecivel \n";
							}
						}
						JOptionPane.showMessageDialog(null, linha);
					}

					else if (opcao.equals("0")) {
						achou = false;
					}
				}

			} else if (resUser.equals("2")) {
				String login = JOptionPane.showInputDialog("Digite o login","Digite um login valido");
				String nome = JOptionPane.showInputDialog("Digite o nome","Digite seu nome");
				String senha = JOptionPane.showInputDialog("Digite a senha","Digite uma senha");
				Usuario user = new Usuario(login, nome, senha);
				try {
					mercado.cadastrarUSUario(user);

					JOptionPane.showMessageDialog(null, "usuario cadastrado");
				} catch (UsuarioJaExisteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			} else if (resUser.equals("3")) {
				continuar = false;
			}

		}
		mercado.gravarDadosEmArquivo();

	}

}
