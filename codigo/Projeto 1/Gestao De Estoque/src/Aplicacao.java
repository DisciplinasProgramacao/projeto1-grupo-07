import javax.swing.JOptionPane;

public final class Aplicacao {
	static Estoque estoque = new Estoque();

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
		}while(rodando);
	}
	
	public static void menuProdutos(boolean running) {
		int opProduto;
		JOptionPane.showMessageDialog(null,"Vc esta no menu de produtos" , "Menu Produto", JOptionPane.INFORMATION_MESSAGE);
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
			switch(opProduto){
				case 0:				//Consultar Estoque 
					rMP = false;
					break;
				case 1:				//Cadastrar Produto
					String nome = JOptionPane.showInputDialog(null, "Digite o nome do novo produto: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION);
					float preco = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o preco do novo produto: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					int margem = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a margem de lucro do novo produto: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens a ser adicionada: ", "Cadastrar Produto", JOptionPane.OK_CANCEL_OPTION));
					Produto p = new Produto(nome,preco,margem,qtd);
					estoque.cadastraProduto(p);
					JOptionPane.showMessageDialog(null,"Produto Cadastrado" , "Cadastrar Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:				//Vender Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser vendido", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens vendida", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					estoque.reporProduto(idP,qtd);
					Produto p = estoque.getProduto(idP);
					JOptionPane.showMessageDialog(null, p , "Vender Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				case 3:				//Excluir Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser vendido", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens vendida", "Vender Produto", JOptionPane.OK_CANCEL_OPTION));
					estoque.reporProduto(idP,qtd);
					Produto p = estoque.getProduto(idP);
					JOptionPane.showMessageDialog(null, p , "Vender Produto", JOptionPane.INFORMATION_MESSAGE); 
					break;
				case 4:				//Repor Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser reposto", "Repor Produto", JOptionPane.OK_CANCEL_OPTION));
					int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de itens à serem repostos", "Repor Produto", JOptionPane.OK_CANCEL_OPTION));
					estoque.reporProduto(idP,qtd);
					Produto p = estoque.getProduto(idP);
					JOptionPane.showMessageDialog(null, p , "Repor Produto", JOptionPane.INFORMATION_MESSAGE); 
					break;
				case 5:				//Consultar Produto
					idP = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID do produto a ser consultado", "Consultar Produto", JOptionPane.OK_CANCEL_OPTION));
					Produto p = estoque.getProduto(idP);
					JOptionPane.showMessageDialog(null, p , "Consultar Produto", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					rMP = true;
			}

				
		}while(rMP);
		menuPrincipal(true);
	}
	
	public static void menuEstoque(boolean running) {
		int opEstoque;
		JOptionPane.showMessageDialog(null,"Vc esta no menu de estoque" , "Menu Estoque", JOptionPane.INFORMATION_MESSAGE);
		boolean rME = running; 
		// Loop Menu Estoque
		do {
			opEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, 
						"[1]Consultar Estoque "
					+ "\n[0]Voltar", 
					"Menu Estoque", JOptionPane.OK_CANCEL_OPTION));
			switch(opProduto){
				case 0:				//Voltar
					rME = false;
					break;
				case 1:				//Consultar Estoque
					String meuEstoque = estoque.mostraProdutos();
					JOptionPane.showMessageDialog(null,"Estoque\n" + meuEstoque , "Consultar Estoque", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					rME = true;
			}	
		}while(rME);
		menuPrincipal(true);
	}
	
	public static void main(String[] args) {
		menuPrincipal(true);
	}

}
