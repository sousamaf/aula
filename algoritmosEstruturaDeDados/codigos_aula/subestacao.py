#!/usr/bin/python3
# -*- coding: utf-8 -*-

def carregar_arquivo():
	arquivo = open('subestacao.csv')
	for linha in arquivo:
		dados = linha.split(',')
		if dados[0] == '3/12/14' and dados[1] == '19:00:00000':
			print(dados[2])


carregar_arquivo()