import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import org.junit.jupiter.api.Test;

public class EstoqueTest {
	
	private Estoque estoque;
	
	@Before
	public void setUp() {
		estoque = new Estoque();
		estoque.setQuantidadeMin(10);
		
		Produto produto1 = new Produto("Produto 1", 10.0f, 50, 20);
		Produto produto2 = new Produto("Produto 2", 20.0f, 30, 5);
		Produto produto3 = new Produto("Produto 3", 30.0f, 70, 15);
		
		estoque.cadastraProduto(produto1);
		estoque.cadastraProduto(produto2);
		estoque.cadastraProduto(produto3);
	}
	
	

	@Test
	public void testCadastraProduto() {
		Produto produto4 = new Produto("Produto 4", 40.0f, 40, 25);
		estoque.cadastraProduto(produto4);
		
		assertEquals(produto4, estoque.getProduto(3));
	}
	
	@Test
	public void testAddProduto() {
		estoque.addProduto(0, 5);
		
		assertEquals(25, estoque.getProduto(0).getQuantidade());
	}
	
	@Test
	public void testTiraProduto() {
		assertFalse(estoque.tiraProduto(1, 10)); // Quantidade maior que a disponível
		assertTrue(estoque.tiraProduto(2, 10)); // Quantidade menor ou igual à disponível
		
		assertEquals(5, estoque.getProduto(2).getQuantidade());
	}
	
	@Test
	public void testGetAbaixoDoMinimo() {
		Produto produto5 = new Produto("Produto 5", 50.0f, 50, 5);
		estoque.cadastraProduto(produto5);
		
		assertEquals(2, estoque.getAbaixoDoMinimo().size());
	}
	
	@Test
	public void testRetiraDeEstoque() {
		estoque.retiraDeEstoque(1);
		
		assertEquals(2, estoque.getProduto(1).getId());
	}
	
	@Test
	public void testMostraProdutos() {
		String expected = "0\tProduto 1\t20\n1\tProduto 2\t5\n2\tProduto 3\t15\n";
		
		assertEquals(expected, estoque.mostraProdutos());
	}
	
	@Test
	public void testGetValorTotal() {
		assertEquals(1050.0, estoque.getValorTotal(), 0.1);
	}
}