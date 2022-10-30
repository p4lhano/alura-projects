import fs from 'fs';
import chalk from 'chalk';

function trataErro(erro) {
    console.log(erro);
    throw new Error(chalk.red(erro.code, 'não há arquivo no diretório'));
}

function pegaArquivo(caminhoDoArquivo) {
    const encoding = 'utf-8';
    fs.promises.readFile(caminhoDoArquivo, encoding)
    .then((texto) => {
        return extraiLinks(texto)
    })
    .catch(trataErro)
}

function extraiLinks(texto) {
    const regex = /\[([^[\]]*?)\]\((https?:\/\/[^\s?#.].[^\s]*)\)/gm;
    const capturas = [...texto.matchAll(regex)].map(a => {
        return {title: a[1],url: a[2]}
    });
    console.log(capturas);
    return capturas

}

async function validaLink(link){
    const res = await fetch('link');
    return res.status
}

//pegaArquivo('./arquivos/texto.md');
export default pegaArquivo;