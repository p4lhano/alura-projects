var lista = [10,1, 5, 9, 8, 12, 15];
console.log(lista.sort()); // [1, 10, 12, 15, 5, 8, 9] -> por padrão utiliza a ordenação via tabela unicode
//pode corrigir isso mandando uma funcão de callback para dizer como realiza a comparação

function comparaNumeros(a,b) {
    return a > b ? 1 : a < b ? -1 : 0
    // if (a < b) return -1;
    // if (a == b) return 0;
}

console.log(lista.sort(comparaNumeros));