# -*- coding: utf-8 -*-

#Crie uma função para imprimir seu nome.
def imprimir_nome():
	print("seu nome")

#Crie uma função para imprimir sua idade ao informar seu ano de nascimento.
def idade(ano_de_nascimento):
	ano_atual = 2014
	sua_idade = ano_atual - ano_de_nascimento 
	print("Sua idade atual: ", sua_idade)

#Crie uma função que retorna o valor de pi * 2. 
def dobro_de_pi():
	pi = 3.14159
	return pi * 2
#Crie uma função que retorna o quadrado de um número informado.
def quadrado(numero):
	quadro = numero ** 2
	return quadro

#Crie uma função que receba 3 números inteiros e retorna a soma dos dois menores divididos pelo maior.
def menores_divididos_pelo_maior(numero1, numero2, numero3):
	if numero1 > numero2 and numero1 > numero3:
		return (numero2 + numero3) / numero1
	if numero2 > numero1 and numero2 > numero3:
		return (numero1 + numero3) / numero2
	if numero3 > numero2 and numero3 > numero1:
		return (numero1 + numero2) / numero3

#Crie uma função que recebe dia, mês e ano e informa se é uma data válida.
def data_valida(dia, mes, ano):
	if (0 < dia < 32) and (0 < mes < 13) and (1499 < ano < 2100):
		print("Data Válida")
	else:
		print("Data INVÁLIDA")










imprimir_nome()
idade(1989)
dobro = dobro_de_pi()
print(dobro)
numero = quadrado(3)
print(numero)
b = menores_divididos_pelo_maior(3, 4, 5)
print(b)
data_valida(21, 12, 2014)