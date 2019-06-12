package projetoTeste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class gravadorARQS {
	// separar os clientes
	public void cadastrarClientes(List<Cliente> clientes , String Arqcliente) throws IOException{
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(Arqcliente )); 
		for(Cliente c : clientes ) {
			gravador.write(c+"\n");
		}
		
		}finally {
			if(gravador != null) {
				gravador.close();
			}
		}
		
	}

}
