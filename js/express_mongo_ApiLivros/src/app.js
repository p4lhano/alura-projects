import express from "express";

const app = express()

app.use(express.json())

const livros = [{id:1,title:"senhor aneri"},{id:2,title:"OZ:Magico"}]

app.get('/',(req,res) => {
    res.status(200).send("Vai para o curso")
})

app.get('/livros',(req,res) => {
    res.status(200).json(livros)
})

app.post('/livros',(req,res)=>{
    console.log(req.body)
    livros.push(req.body)
    res.status(201).send("livros cadastrade")
})

app.put('/livros/:id',(req,res)=>{
    let i = findLibro(Number(req.params.id))
    
    livros[i].title = req.body.title

    res.status(200).json(livros[i])
})

app.get('/livros/:id',(req,res)=>{
    
    res.status(200).json(livros[findLibro(Number(req.params.id))])
})

app.delete('/livros/:id',(req,res)=>{
    let i = findLibro(Number(req.params.id))
    livros.splice(i,1)
    res.status(200).send("rev")
})

function findLibro(id){
    return livros.findIndex(l => l.id === id)
}

export default app