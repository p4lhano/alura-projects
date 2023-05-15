var inicio = 1
var fim = 1000
var primos = []
var divisores

for (var count = inicio; count <= fim; count++) {
  divisores = 0
  for (var aux = 1; aux <= count; aux++) if (count % aux == 0) divisores++

  if (divisores == 2) primos.push(count)
}
return primos.reduce((ac, current) => ac + current, 0)
