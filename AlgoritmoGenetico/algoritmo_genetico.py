# -*- coding: utf-8 -*-
import random

# Carga máxima que a mochila suporta
CAPACIDADE_MOCHILA 	= 10.0
# Qtd de livros disponíveis
TAM_CROMOSSOMO 		= 5
# Número de indivíduos da população
POPULACAO 			= 20
# Condição de parada. Número máxima de ciclos.
GERACOES 			= 100
# Percentual de ocorrências de mutações.
MUTACAO 			= 6
# Percentual de indivíduos selecionados por elitismo.
ELITISMO	 		= 10 

# Objeto que representa a população atual.
populacao = {}
# Objeto que representa a população auxiliar.
populacao_aux = {}

def populacao_inicial():
	for gene in range(0, TAM_CROMOSSOMO):
		for meliante in range(0, POPULACAO):
			populacao[meliante, gene] = random.randint(0,1)

def mostra_populacao(posicao):
	for gene in range(0, TAM_CROMOSSOMO):
		print(populacao[posicao, gene], end=" ")
	print(" ")

def mostra_populacao_aux(posicao):
	for gene in range(0, TAM_CROMOSSOMO):
		print(populacao_aux[posicao, gene], end=" ")
	print(" ")

# Métodos de seleção
def selecao_simples():
	return random.randint(0, POPULACAO)

# Operadores Genéticos
# Mutação
def mutacao(posicao):
	gene_mutacao = random.randint(0, TAM_CROMOSSOMO)
	tam_pop_aux = int(len(populacao_aux)/TAM_CROMOSSOMO)
	for gene in range(0, TAM_CROMOSSOMO):
		if gene != gene_mutacao:
			populacao_aux[tam_pop_aux, gene] = populacao[posicao, gene]
		else:
			if populacao[posicao, gene] == 1:
				populacao_aux[tam_pop_aux, posicao] = 0	
			else:
				populacao_aux[tam_pop_aux, gene] = 1

# Cruzamento simples
def cruzamento_simples():
	metade = TAM_CROMOSSOMO/2
	pai_1 = selecao_simples()
	pai_2 = selecao_simples()

	d1 = []
	d2 = []

	while pai_1 == pai_2:
		pai_2 = selecao_simples()

	i = 0
	while i < TAM_CROMOSSOMO:
		if i < TAM_CROMOSSOMO/2:
			d1.append(populacao[pai_1, i])
			d2.append(populacao[pai_2, i])
		else:
			d1.append(populacao[pai_2, i])
			d2.append(populacao[pai_1, i])
		i = i + 1

	#populacao_aux[tam_pop_aux] = d1
	#populacao_aux[tam_pop_aux + 1] = d2


populacao_inicial()
cruzamento_simples()
#quem = selecao_simples()
#mutacao(quem)
#mostra_populacao(quem)
#mostra_populacao_aux()
