package Projeto;

public class ClientePF extends Cliente{
	
	private String cpf;
	
	public ClientePF(String nome,String cpf){
		super(nome);
		this.cpf = cpf;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		ClientePF other = (ClientePF) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public String getCpf() {
		return this.cpf;
	}
	public String getCodigo() {
		return  this.cpf;
	}

	@Override
	public String getNomeCodigo() {
		return "com o CPF:";
	}


}
