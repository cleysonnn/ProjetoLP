package projetoTeste;

public class ClientePJ extends Cliente {
	private String cnpj;
	
	public ClientePJ(String nome , String cnpj) {
		super(nome);
		this.cnpj = cnpj;
		
	}
public String getcnpj() {
	return this.cnpj;
}
public String getCodigo() {
	return  this.getcnpj();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	ClientePJ other = (ClientePJ) obj;
	if (cnpj == null) {
		if (other.cnpj != null)
			return false;
	} else if (!cnpj.equals(other.cnpj))
		return false;
	return true;
}
@Override
public String getNomeCodigo() {
		return "com o CNPJ:";
	}
}
