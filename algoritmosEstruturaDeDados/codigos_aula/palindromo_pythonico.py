# -*- coding: utf-8 -*-

palavra = input("Informe uma palavra: ")

print(palavra, end="")
if palavra == palavra[::-1]:
	print(" é palindromo.")
else: 
	print(" NÃO é palindromo.")

