#language: pt
#encoding: utf-8

@allure.label.epic:Testes_carrinho
@Test
@TestCart
Funcionalidade: Cenarios de teste da página de carrinho

  Cenario: Adicionando um produto ao carrinho com sucesso pela barra de busca
    Dado que estou na página inicial
    E inserir no campo de busca "Lacoste"
    E clicar no primeiro resultado da busca
    E inserir o CEP "28010272"
    Quando clicar no botão comprar
    E selecionar o a opção de sem grau e confirmar
    Entao o produto será adicionado ao carrinho

  @critical
  @allure.label.jira:AE-2
  Cenario: Adicionando um produto ao carrinho com sucesso pelos hovers
    Dado que estou na página inicial
    E passo o mouse por cima de Óculos de Grau
    E clicar na opção Emporio Armani
    E clicar no primeiro resultado da busca
    E inserir o CEP "28010272"
    Quando clicar no botão comprar
    E selecionar o a opção de sem grau e confirmar
    Entao o produto será adicionado ao carrinho