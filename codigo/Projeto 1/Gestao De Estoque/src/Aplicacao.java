import javax.swing.JOptionPane;

public final class Aplicacao {
	static Estoque estoque = new Estoque();
	static double valorGasto = 0, valorVendido = 0;

	public static void menuPrincipal(boolean running) {
		int opPincipal;
		boolean rodando = running; 
		do {		
			opPincipal = Integer.parseInt(JOptionPane.showInputDialog(null, "[1]Menu Produto \n[2]Menu Estoque \n[0]Sair", "Menu Principal", JOptionPane.OK_CANCEL_OPTION));
			switch (opPincipal) {
				case 0:
					rodando = false;
					break;
				case 1:
					menuProdutos(rodando);
					break;
				case 2:
					menuEstoque(rodando);
					break;
				default:
					rodando = true;
			}
		} while(rodando);
	}
	
	public static void menuProdutos(boolean running) {
		int opProduto;
		boolean rMP = running;
		int idP;
		String nomeP;
	
		do {			// Loop Menu Produtos 
			opProduto = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"[1]Cadastrar Produto"
					+ "\n[2]Vender Produto "
					+ "\n[3]Excluir Produto "
					+ "\n[4]Repor Produto"
					+ "\n[5]Consultar Produto "
					+ "\n[0]Voltar",
			
					"Menu Produtos", JOptionPane.OK_CANCEL_OPTION));
			Produto p;
			int qtd;
			int min;
			switch(opProduto){
				case 0:				//Consultar Estoque 
					rMP = false;
					break;
				case 1:				//Cadastrar Produto
					String nome = JOptionPane.showInputDialog(null, "Digite o nome do novo produto: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION);
					float preco = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o preco de custo do novo produto: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					int margem = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a margem de lucro do novo produto: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens a ser adicionada: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					min = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade minima de itens no estoque", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					p = new Produto(nome, preco, margem, qtd, min);
					estoque.cadastraProduto(p);
					JOptionPane.showMessageDialog(null,"Produto Cadastrado" , "Cadastrar Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:				//Vender Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser vendido", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens vendida", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					p = estoque.getProduto(idP);
					if (estoque.tiraProduto(idP,qtd)) {
						valorVendido += p.getPrecoVenda();
						JOptionPane.showMessageDialog(null, "Descrição - Quantidade - Quantidade Mínima\n" + p , "Vender Produto", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Descrição - Quantidade - Quantidade Mínima\n" + p , "Quantidade Insuficiente", JOptionPane.ERROR_MESSAGE);
					}
					break;
				case 3:				//Excluir Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser vendido", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens vendida", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					estoque.addProduto(idP,qtd);
					p = estoque.getProduto(idP);
					JOptionPane.showMessageDialog(null, "Descrição - Quantidade - Quantidade Mínima\n" + p , "Vender Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 4:				//Repor Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser reposto", "Repor Produto", JOptionPane.OK_CANCEL_OPTION));
					qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens à serem repostos", "Repor Produto", JOptionPane.OK_CANCEL_OPTION));
					estoque.addProduto(idP,qtd);
					p = estoque.getProduto(idP);
					valorGasto += p.getPrecoCusto() * qtd;
					JOptionPane.showMessageDialog(null, "Descrição - Quantidade - Quantidade Mínima\n" + p , "Repor Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 5:				//Consultar Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser consultado", "Consultar Produto", JOptionPane.OK_CANCEL_OPTION));
					p = estoque.getProduto(idP);
					JOptionPane.showMessageDialog(null, "Descrição - Quantidade - Quantidade Mínima\n" + p, "Consultar Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					rMP = true;
			}

				
		}while(rMP);
	}
	
	public static void menuEstoque(boolean running) {
		int opEstoque;
		boolean rME = running;
		// Loop Menu Estoque
		do {
			opEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"[1] Consultar Estoque "
					+ "\n[2] Consultar produtos com estoque abaixo do mínimo"
					+ "\n[3] Fazer balanço do estoque"
					+ "\n[0] Voltar",
					"Menu Estoque", JOptionPane.OK_CANCEL_OPTION));
			switch(opEstoque){
				case 0:				//Voltar
					rME = false;
					break;
				case 1:				//Consultar Estoque
					JOptionPane.showMessageDialog(null,"Estoque\n" + estoque.mostraProdutos() , "Consultar Estoque", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					JOptionPane.showMessageDialog(null,"Estoque\n" + estoque.getAbaixoDoMinimo() , "Consultar Estoque", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 3:
					String balanco = "Gastos de reposição = " + valorGasto
							+ "\n Valor das vendas = " + valorVendido
							+ "\n Valor do estoque = " + estoque.getValorTotal();
					JOptionPane.showMessageDialog(null,balanco, "Consultar Estoque", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					rME = true;
			}	
		} while(rME);
	}
	
	public static void main(String[] args) {
		try {
			menuPrincipal(true);
		} catch (NumberFormatException e) {
			return;
		}
	}

}
