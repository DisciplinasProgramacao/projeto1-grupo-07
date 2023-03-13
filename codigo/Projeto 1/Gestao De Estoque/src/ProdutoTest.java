import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoTest {


	
	 @Test
	 public void testGetImposto() {
		 //Cria um produto
	        Produto p = new Produto("Produto de Teste", 100.0f, 70, 0);
	        
	        //Calcular o valor do imposto esperado
	        float impostoEsperado = 100.0f * 1.7f * 0.18f;
	        
	       //Verifica se o imposto calculado e igual o esperado.
	        assertEquals(impostoEsperado, p.getImposto(), 0.01);
	    }

	
	@Test
	public void testMargemLucro() {
		 //Cria um produto
		Produto p = new Produto("Teste" , 100.0f , 40);
		
		//Define uma margem de lucro de 20%
		p.setMargemLucro(20);
		
		
		//Espera que seja reajustado para 30%
		assertEquals(30, p.getMargemLucro());
		
		//Define uma margem de lucro de 90%
		p.setMargemLucro(90);
		
		//Espera que seja reajustado para 80%
		assertEquals(80, p.getMargemLucro());
		
	}
	
	 @Test
	    public void testGetPrecoVenda() {
	        
		//Cria um produto
	        Produto p = new Produto("Produto de Teste", 100.0f, 50, 0);
	        
	    //Calcular o valor do preco de venda esperado   
	        float precoVendaEsperado = 100.0f * 1.5f * 0.18f;
	        
	      //Verifica se o preço de venda calculado é igual ao esperado.    
	        assertEquals(precoVendaEsperado, p.getPrecoVenda(), 0.01);

		 
	 }

}
