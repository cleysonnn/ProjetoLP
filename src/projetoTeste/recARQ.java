package projetoTeste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class recARQ {
	public List<Cliente> recuperarClientes(String Arqcliente)throws IOException {
		BufferedReader leitor = null;
		List<Cliente> clientelidos = new ArrayList<Cliente>();
		try {
			leitor = new BufferedReader(new FileReader(Arqcliente));
			String nome = null, codigo = null;
			do {
				nome = leitor.readLine();
				codigo = leitor.readLine();
				if (nome != null && codigo != null){
					ClientePF clientes = new ClientePF(nome, codigo);
					clientelidos.add(clientes);
					
				}
				
			}while(nome!= null && codigo != null ) ;
			
		}finally {
			if(leitor != null) {
				leitor.close();
			}
		}
		return clientelidos;
		
		
		
		
	}

}
