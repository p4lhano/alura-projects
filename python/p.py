print("olá mundo")

lista = [1,2] # Conjunto de dados
dicionario = { "chave1":"valor1",
                "chave2":"valor2"}
tupla = ('A','AMEIXA')


# Não existe for normal, apenas o forEach que percorre a lista
# range(n) gera um lista com n elementos 
print("for i in range(10):")
for i in range(10):
    print(i)

# range(i,e) gera um lista com n elementos que começaram em i e iram até e (i -> e) de 1 em 1 
print("for i in range(10,20):")
for i in range(10,20):
    print(i)

# range(i,e,c) gera um lista com 'n' elementos que começaram em 'i' e iram até 'e' (i -> e) de 'c' em 'c' 
print("for i in range(10,20,2):")
for i in range(10,20,2):
    print(i)

# tamanho da string
strin = "Vitor"
len(strin)


arquivo=open("arquivo.txt")

texto_completo = arquivo.read()

lista_com_linha_do_arquivo = arquivo.readline()


w = open("arquivo1.txt","w")
w.write("Este é um arquivo criado com pythin\n")
w.close

w = open("arquivo1.txt","a")
w.write("opsajustando")
w.close


##Lista
lista1=["fut","bol","bola"]
lista2=[True,1,"outra st"]

# add a lista
lista1.append("Volei")

# Verificar se elemento existe na lista
if 1 in lista2:
    print("1 esta na lista")

# Remover item
del lista2[2:]

#Ordernar lista

lista_para_ordernacao = [123,35,5,54,0,18,1,3,5,1258]

lista_para_ordernacao.sort()
lista_para_ordernacao.sort(reverse=True)

lista_para_ordernacao.reverse()