#!/usr/bin/python3
# -*- coding: utf-8 -*-

#m_dados = 

'''
A função carregar_arquivo varre todo o arquivo 
subestacao.csv carregando seu conteúdo
organizadamente para a matriz m_dados.
'''
def carregar_arquivo():
	arquivo = open('subestacao.csv')
	linha_1 = 0
	for linha in arquivo:
		if linha_1 > 0:
			dados = linha.split(',')
			print(dados)
		else:
			linha_1 = linha_1 + 1


'''
A função demanda_maior localiza o dia e hora
da maior demanda de um intervalo fechado fornecido.
Caso não seja fornecido qualquer intervalo, todo
o conteúdo carregado para a memória será o intervalo.
É possível fornecer somente o dia, dia e hora ou
nenhum intervalo.
'''
def demanda_maior(dia_inicio = "", hora_inicio = "", dia_fim = "", hora_fim = ""):

'''
A função demanda_media calcula a demanda média de
um intervalo fornecido. Caso não seja informado um
intervalo, todo o conteúdo em memória deve ser 
considerado.
'''
def demanda_media(dia_inicio = "", hora_inicio = "", dia_fim = "", hora_fim = ""):


carregar_arquivo()

