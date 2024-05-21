#language: pt
#encoding: utf-8

@allure.label.epic:Testes_home
@Test
@TestHome
Funcionalidade: Cenarios de teste da página home

  Cenario: Achando a loja mais perto de um local
    Dado que estou na página inicial
    E clicar no botão encontre uma diniz
    E e inserir "Campos dos Goytacazes" no campo informe seu endereço
    Quando selecionar o primeiro resultado da lista
    Entao encontrará uma loja no local informado