#!/usr/bin/python3
# -*- coding: utf-8 -*-

m_dados = []

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
			m_dados.append(dados)
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
	pass

'''
A função demanda_media calcula a demanda média de
um intervalo fornecido. Caso não seja informado um
intervalo, todo o conteúdo em memória deve ser 
considerado.
'''
def demanda_media(dia_inicio = "", hora_inicio = "", dia_fim = "", hora_fim = ""):
	pass

'''
A função potencia efetua o cálculo da potencia A, B ou
C de um dia e hora especificado. Todos os parametros são
obrigatórios, sendo a 'data' a data, a 'hora' uma hora 
existente no arquivo ou a hora mais próxima superior, e 
abc a fase A, B ou C.
'''
def potencia(data, hora, abc):
	pass


'''
A função demanda_media_diaria_do_mes realiza o cálculo
da média diária da demanda de um mês informado. A função
retorna um array (vetor) contendo todas as médias diárias
calculadas.
'''
def demanda_media_diaria_do_mes(mes):
	pass

'''
A função calculo_desvio_padrao_demanda_diaria retorna o
desvio padrão de uma média diária da demanda (data fornecida)
em relação ao valor médio da demanda mensal. O desvio padrão
deve ser fornecido em porcentagem. 
'''
def calculo_desvio_padrao_demanda_diaria(data):
	pass

'''
A função print_campo exibe em tela todos os valores de 
uma coluna informada da matriz m_dados.
'''
def print_campo(campo):
	for linha in m_dados:
		print(linha[campo])


carregar_arquivo()
#print_campo(1)
# Exemplo de acesso direto a uma célula da matriz.
print(m_dados[3][1])

