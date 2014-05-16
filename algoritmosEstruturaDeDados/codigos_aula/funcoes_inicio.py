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

imprimir_nome()
idade(1989)
dobro = dobro_de_pi()
print(dobro)
numero = quadrado(3)
print(numero)
