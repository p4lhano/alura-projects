import pegaArquivo from "./index.js";
import fs from 'fs';

let caminho = process.argv[2];
console.log(caminho);

if (fs.lstatSync(caminho).isFile()){
    let result = pegaArquivo(caminho)
    console.log(result);
    // result.forEach(l => {
    //     console.log(l);
    // })
    
} else if (fs.lstatSync(caminho).isDirectory()){
    const arquivos = await fs.promises.readdir(caminho)
    // if(caminho[caminho.length-1] === "/" ) caminho = caminho.substring(0,caminho.length-2)
    
    arquivos.forEach(f=>{
        console.log(`${caminho}/${f}`);
        const result = pegaArquivo(`${caminho}/${f}`)
    })
}

async function validaLink(link){
    console.log("Valida: "+link);
    const res = await fetch('link');
    console.log("Valida: "+link+" Response: "+res.status);
    return res.status
}