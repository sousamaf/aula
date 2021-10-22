import numpy as np
class AG():
    def __init__(self, TAM_POP, 
                 TAM_GENE, 
                 GERACAO = 100, 
                 TX_CRUZAMENTO = 70, 
                 TX_MUTACAO = 10, 
                 TX_ELITISMO = 20):
        
        self.TAM_POP = TAM_POP
        self.TAM_GENE = TAM_GENE
        self.GERACAO = GERACAO

        self.TX_CRUZAMENTO = TX_CRUZAMENTO
        self.TX_MUTACAO = TX_MUTACAO
        self.TX_ELITISMO = TX_ELITISMO

        self.pop = self.criar_pop_inicial(TAM_POP, TAM_GENE)
        self.pop_aux = self.criar_pop_inicial(TAM_POP, TAM_GENE)
        
        self.fitness = np.zeros(TAM_POP)
        self.fitness_p = np.zeros(TAM_POP)
        
        self.pesos = 0.0
        self.capacidade = 0.0
        
    def criar_pop_inicial(self, TAM_POP, TAM_GENE):
        return np.random.randint(0, 2, [TAM_POP, TAM_GENE])

    def selecao(self):
#         pai1 = np.random.randint(0, TAM_POP)
#         pai2 = np.random.randint(0, TAM_POP)
        pai1 = self.roleta()
        pai2 = self.roleta()
        while pai1 == pai2:
#             pai2 = np.random.randint(0, TAM_POP)
            pai2 = self.roleta()
        return [pai1, pai2]

    def mutacao(self, q):
        gene1 = np.random.randint(0, self.TAM_GENE)
        gene2 = np.random.randint(0, self.TAM_GENE)

        ind1 = self.pop[q[0]]
        ind2 = self.pop[q[1]]

        ind1[gene1] = 1 if ind1[gene1] == 0 else 0
        ind2[gene2] = 1 if ind2[gene2] == 0 else 0
        return [ind1, ind2]
    
    def elitismo(self, qtd_individuos, pos):
        qtd = qtd_individuos
        qtd = qtd * -1
        elite = self.fitness.argsort()[qtd:]
        inds_elite = self.pop[elite]

        for i in range(qtd_individuos):
            self.pop_aux[pos] = inds_elite[i]
            pos += 1

    def cruzamento_simples(self, q):
        pai1 = self.pop[q[0]]
        pai2 = self.pop[q[1]]
        desc1 = np.zeros(self.TAM_GENE, dtype=np.int32)
        desc2 = np.zeros(self.TAM_GENE, dtype=np.int32)

        meio = int(self.TAM_GENE/2)
        for i in range(self.TAM_GENE):
            if i < meio:
                desc1[i] = pai1[i]
                desc2[i] = pai2[i]
            else:
                desc1[i] = pai2[i]
                desc2[i] = pai1[i]
        return [desc1, desc2]

    """
    Método que implementa o cruzamento composto por dois
    pontos de corte.
    args:
        q: array com duas posições referente à posições de 
        elementos na matriz pop
    return:
        [] array contendo dois novos indivíduos.
    """
    def cruzamento_composto(self, q):
        pass

    """
    Método que implementa o cruzamento uniforme.
    args:
        q: array com duas posições referente à posições de 
        elementos na matriz pop
    return:
        [] array contendo dois novos indivíduos.
    """
    def cruzamento_mascara(self, q):
        pass

    def substituicao(self):
        self.pop = self.pop_aux

    def parada(self, g):

        if g > self.GERACAO:
            return True

        return False

    def qtd_individuos(self, TAM_POP, taxa):
        return int((TAM_POP * taxa) / 100)

    def roleta(self):
        sorteado = np.random.uniform(0, 100)
        area = 0.0
        
        for i in range(self.TAM_POP):
            area += self.fitness_p[i]
            if area > sorteado:
                return i
        return self.TAM_POP - 1
                
    def avaliacao(self):
        np.random.shuffle(self.pop) # Para evitar vícios no elitismo.
        for i in range(self.TAM_POP):
            peso = np.sum([self.pesos * self.pop[i]])
            self.fitness[i] = 0.0 if peso > self.capacidade else peso

        fitness_total = np.sum(self.fitness)
        
        for i in range(self.TAM_POP):
            self.fitness_p[i] = (self.fitness[i] * 100) / fitness_total

            
    def set_pesos(self, pesos):
        self.pesos = pesos

    def set_capacidade(self, carga_maxima):
        self.capacidade = carga_maxima

    def get_melhor(self):
        pos = self.fitness.argmax()
        return [self.fitness.max(), self.pop[pos]]
    
    def evolucao(self):
        melhores = []
        g = 1
        while True:
            self.avaliacao()
            
            melhores.append(self.get_melhor())
            if self.parada(g):
                break

            # Cruzamento
            qtd_ind_cruzamento = self.qtd_individuos(self.TAM_POP, self.TX_CRUZAMENTO)
            qtd_cruzamento = int(qtd_ind_cruzamento/2)

            for i in range(qtd_cruzamento):
                q = self.selecao()

                descendentes = self.cruzamento_simples(q)

                pos = (1 * i) + i
                self.pop_aux[pos] = descendentes[0]
                self.pop_aux[pos + 1] = descendentes[1]

            # Mutação
            qtd_ind_mutacao = self.qtd_individuos(self.TAM_POP, self.TX_MUTACAO)
            qtd_mutacao = int(np.ceil(qtd_ind_mutacao/2))
            
            for i in range(qtd_mutacao):
                q = self.selecao()
                mutantes = self.mutacao(q)

                pos = ((1 * i) + i) + qtd_ind_cruzamento
                self.pop_aux[pos] = mutantes[0]
                if (pos + 1) < self.TAM_POP:
                    self.pop_aux[pos + 1] = mutantes[1]
            
            # Elitismo 
            # Total de novos indivíduos gerados até o momento:
            ind_gerados = qtd_ind_cruzamento + qtd_ind_mutacao
            # Total de indivíduos para completar a população:  
            qtd_ind_elitismo = self.TAM_POP - ind_gerados 
            self.elitismo(qtd_ind_elitismo, ind_gerados)
            
            # Substituição populacional
            self.substituicao()
            g += 1
        return np.array(melhores, dtype=object)
