# -*- coding: utf-8 -*-

palavra = input("Informe uma palavra: ")
tam = len(palavra) - 1
cont = 0
palindromo = 1

while cont < len(palavra)/2:
	if palavra[cont] != palavra[tam]:
		palindromo = 0
		break
	cont = cont + 1
	tam = tam - 1

print(palavra, end="")
if palindromo == 1:
	print(" é palindromo.")
else: 
	print(" NÃO é palindromo.")

