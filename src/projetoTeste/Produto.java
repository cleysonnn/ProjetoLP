package projetoTeste;

public class Produto {
	private String nome;
	private String codigo;
	private double precoatacado;
	private double precovarejo;
	private boolean perecivel;
	
	public Produto(String nome,String codigo,double precoatacado , double precovarejo,boolean perecivel) {
		this.nome = nome;
		this.codigo = codigo;
		this.precoatacado = precoatacado;
		this.precovarejo = precovarejo;
		this.perecivel = perecivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecoatacado() {
		return precoatacado;
	}

	public void setPrecoatacado(double precoatacado) {
		this.precoatacado = precoatacado;
	}

	public double getPrecovarejo() {
		return precovarejo;
	}

	public void setPrecovarejo(double precovarejo) {
		this.precovarejo = precovarejo;
	}

	public boolean isPerecivel() {
		return this.perecivel;
	}

	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}

	public String toString() {
		return "Nome do produto: " + this.nome + " com o codigo: "+this.codigo +"  "+(this.perecivel?"Perecivel":"Não Perecivel");
	}
	

}
