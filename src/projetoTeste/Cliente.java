package projetoTeste;

public abstract class Cliente {
	private String nome;
	
	public Cliente(String nome) {
		this.nome = nome;
	}
	public abstract String getCodigo();
	public abstract String getNomeCodigo();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getCodigo() == null) ? 0 : this.getCodigo().hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (this.getCodigo() == null) {
			if (other.getCodigo() != null)
				return false;
		} else if (!this.getCodigo().equals(other.getCodigo()))
			return false;
		return true;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return  "Nome : " + this.nome + this.getNomeCodigo() +this.getCodigo() ;
	}

}
