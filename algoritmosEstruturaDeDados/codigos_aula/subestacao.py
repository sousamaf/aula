#!/usr/bin/python3
# -*- coding: utf-8 -*-

def carregar_arquivo():
	maior_demanda = 0
	dia_hora_maior_demanda = " "
	arquivo = open('subestacao.csv')
	linha_1 = 0
	for linha in arquivo:
		if linha_1 > 0:
			dados = linha.split(',')
			kwh = int(dados[2])
			if kwh > maior_demanda:
				maior_demanda = kwh
				dia_hora_maior_demanda = dados[0] + " " +  dados[1]
		else:
			linha_1 = linha_1 + 1
	print(dia_hora_maior_demanda)

carregar_arquivo()