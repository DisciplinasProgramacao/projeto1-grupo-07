import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private final List<Produto> produtos = new ArrayList<>();

	public void cadastraProduto(Produto produto) {
		produtos.add(produto);
	}

	public void addProduto(int id, int quantidade) {
		Produto p = produtos.get(id);
		p.setQuantidade(p.getQuantidade() + quantidade);
	}
	
	public boolean tiraProduto(int id, int quantidade) {
		Produto p = produtos.get(id);
		if (quantidade > p.getQuantidade()) {
			return false;
		}
		p.setQuantidade(p.getQuantidade() - quantidade);
		return true;
	}

	public String getAbaixoDoMinimo() {
		String s = "Id - Descrição - Quantidade - Quantidade Mínima\n";
		for (int i = 0; i < produtos.size(); i++) {
			if (!produtos.get(i).temSuficiente())
				s += i + "\t" + produtos.get(i).toString() + "\n";
		}

		return s;
	}

	public Produto getProduto(int id) {
		return produtos.get(id);
	}

	public Produto retiraDeEstoque(int id) {
		Produto p = produtos.get(id);
		produtos.remove(id);
		return p;
	}

	public String mostraProdutos() {
		String s = "Id - Descrição - Quantidade - Quantidade Mínima\n";
		for (int i = 0; i < produtos.size(); i++) {
			s += i + "\t" + produtos.get(i).toString() + "\n";
		}
		return s;
	}

	public double getValorTotal() {
		return produtos.stream().mapToDouble(Produto::getPrecoVenda).sum();
	}
}
