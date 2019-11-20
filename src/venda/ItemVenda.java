package venda;

public class ItemVenda {

	private String nome;
	private Integer quant;

	public ItemVenda(String nome, Integer quant) {
		this.nome = nome;
		this.quant = quant;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuant() {
		return quant;
	}

	public void setQuant(Integer quant) {
		this.quant = quant;
	}

}