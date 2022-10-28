const nomes = ["Ana", "Clara", "Maria", "Maria", "João", "João", "João"];

const meuSet = new Set(nomes);

console.log(meuSet);
async function f(){
const res = await fetch('https://nodejs.org/api/documentation.json');
if (res.ok) {
    const data = await res.json();
    console.log(data);
}
console.log(res)
}

f()