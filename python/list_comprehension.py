# list comprehension

x = [1,2,3,4,5,6,7,8,9,10,11,12]
#obter o quadrado

# y = [valor_add laço condicao]
y = [i**2 for i in x]

print(y)

z_par = [i for i in x if i%2==1]



print(z_par)