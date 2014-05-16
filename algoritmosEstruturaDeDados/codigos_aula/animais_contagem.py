#!/usr/bin/python3
# -*- coding: utf-8 -*-

arquivo = open('animais.txt')

letras = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'á', 'é', 'í', 'ó', 'ú']
contagem = []

for l in letras:
	contagem.append(0)

animais = []

for animal in arquivo:
	animais.append(animal[:-1].lower())
arquivo.close()

for animal in animais:
	if animal[1] in letras:
		pos = letras.index(animal[1])

		if pos < 26:
			contagem[pos] += 1
		elif pos == 26: # á
			contagem[0] += 1
		elif pos == 27: # é
			contagem[4] += 1
		elif pos == 28: # í
			contagem[8] += 1
		elif pos == 28: # ó
			contagem[14] += 1
		elif pos == 28: # ú
			contagem[20] += 1

maior = 0
maior_pos = 0
i = 0
while i < len(contagem):
	if contagem[i] > maior:
		maior = contagem[i]
		maior_pos = i
	i += 1
print("Há mais animais inicidos com a letra: ", end="")
print(letras[maior_pos])