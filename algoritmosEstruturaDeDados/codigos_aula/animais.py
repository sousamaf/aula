#!/usr/bin/python3
# -*- coding: utf-8 -*-

arquivo = open('animais.txt')

animais = []

for animal in arquivo:
	animais.append(animal[:-1].lower())
arquivo.close()


animal = input("Me diga o nome de um animal: ")
animal = animal.lower()
while True:
	if animal == 'desisto':
		print("pra nada")
		break
	if animal not in animais:
		arquivo = open('animais.txt', 'a')
		arquivo.write(animal)
		arquivo.write('\n')
		arquivo.close()
		print("Legal, não conhecia esse animal.")
		break
	animal = input("Esse já conhecia, me diga outro: ")
	animal = animal.lower()	



