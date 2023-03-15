public class Produto {
	private String descricao;
	private float precoCusto;
	private int margemLucro;
	private int quantidadeMinima;
	private int quantidade;

	public Produto(String descricao, float precoCusto, int margemLucro, int quantidade, int quantidadeMinima) {
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.quantidade = quantidade;
		if (margemLucro < 30 ) {
			this.margemLucro = 30;
		} else if (margemLucro  > 80) {
			this.margemLucro = 80;
		} else {
			this.margemLucro = margemLucro;
		}
		this.quantidadeMinima = quantidadeMinima;
	}
	public Produto(String descricao, float precoCusto, int margemLucro, int quantidade) {
		this(descricao, precoCusto, margemLucro, quantidade, 0);
	}

	public Produto(String descricao, float precoCusto, int margemLucro) {
		this(descricao, precoCusto, margemLucro, 0);
	}

	public Produto(String descricao, float precoCusto) {
		this(descricao, precoCusto, 30);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public int getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(int margemLucro) {
		if (margemLucro < 30 ) {
			this.margemLucro = 30;
		} else if (margemLucro  > 80) {
			this.margemLucro = 80;
		} else {
			this.margemLucro = margemLucro;
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public float getPrecoVenda() {
		return ((margemLucro / 100.0f) + 1) * precoCusto + this.getImposto();
	}

	public float getImposto() {
		return ((margemLucro / 100.0f) + 1) * precoCusto * 0.18f;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public boolean temSuficiente() {
		return quantidade > quantidadeMinima;
	}

	@Override
	public String toString() {
		return descricao + "\t" + quantidade + "\t" + quantidadeMinima;
	}
}
