package Projeto;

import javax.swing.JOptionPane;

public class nomeComPrefixoExcption extends Exception {
	
	public nomeComPrefixoExcption(String msg ) {
		super(msg);
	}
	
	/*						if (usuarios == null) {
							JOptionPane.showMessageDialog(null, "nao existe usuario com este prefixo: " + prefixo);
						} else {
							String listaA = "";
							for (Usuario us : usuarios) {
								listaA += us.toString();
							}
							JOptionPane.showMessageDialog(null, listaA);

						}
*/

}
