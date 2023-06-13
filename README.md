[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10129336)
# Gestão de Estoque
Uma mercearia está informatizando seus processos e vai começar a modernização pela gestão de estoque, visando melhorar e tornar mais rápido a manutenção da mesma.
O dono da loja passou diversos tópicos que queria acrescentar para melhorar as vendas do seu comercio. Nosso grupo fará todos os tópicos informados pelo cliente e também a documentação de tudo para deixar tudo bem informado e distribuído. 


## Nota base do grupo: 9

A nota final, que é individual, se dará pela nota acima, multiplicada por um peso entre 0 e 1 relativo ao acompanhamento semanal do projeto. Lembre-se: não é só a entrega do produto finalizado que importa, é todo o processo de sua construção e as entregas parciais para o “cliente”.

## Comentários
 - Deveriam criar pacotes para separar os casos de teste

### Diagrama + aderência das classes ao diagrama:  1,5 /2 pontos 

Inconsistencia classe Estoque - setQuantidadeMin(), não forneceram os parâmetros



### Requisitos corretamente implementados:  4/6 pontos 
	- produto (preço, estoque) -  1,5 / 2
	Se já existe a validação no método setMargemLucro(), no construtor, poderia apenas fazer a chamada desse método
	Não verificaram a quantidade mínima de caracteres para a descrição



	- estoque (valor, abaixo do estoque) - 1,5 / 2
	getValorTotal() não está funcionando da maneira esperada
	Cuidado em não armazenar valores, será necessário sempre computar todos os valores



	- sistema (vender, comprar, consultas) - 1 / 2
	Parabéns por terem usado o JOptionPane
	Nessa classe, vocês deveriam apenas possuir elementos para viabilizar o manuseio da sistema, o restante deveria vir por interação das operações presentes nas classes de negócio. Sendo assim, o relatório do estoque não está condizente, a realidade disso está presente ao criarem as variáveis valorGasto e valorVendido
	getValorTotal() não está funcionando da maneira esperada
	As operações de repor produto, adicionar produto no estoque, vender produto, etc deveriam fazer parte do submenu do estoque



### Documentação de código:  0,5 pontos 
 - Documentação inexistente
 - Apenas documentaram os casos de teste do Produto

	
### Testes (quantidade e qualidade): 3/4 pontos 
	Preencheram o plano de teste

	- produto: 1/2 pontos
	Poderiam explorar um pouco mais os testes
	Poderiam testar os casos de insucesso


	
	- estoque: 2/2 pontos



## Alunos integrantes da equipe

* Diogo Chaves Torres
* Gustavo Henrique de Lima e Silva
* João Francisco Carvalho Soares de Oliveira Queiroga
* Philippe Roberto Dutra Chaves Vieira
* Saulo Pereira Vasconcelos



## Professores responsáveis

* Cleiton Silva Tavares


