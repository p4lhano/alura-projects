const notas = [10, 9.5, 8, 7, 6];

const n = notas.map(obj => obj+1 > 10 ? 10 : obj+1 );

console.log(n)

const nomes = ["ana Julia", "Caio vinicius", "BIA silva"];

const nomesPadronizados = nomes.map(nome => nome.toUpperCase());

console.log(nomesPadronizados);