const http = require("http")
const PORT = 3000
const options = { hour: 'numeric',minute:'numeric',second:'numeric', year: 'numeric', month: 'numeric', day: 'numeric' }

const routes = {
    "/":"Vo pro curso",
    "/livros":"Vo pro livro",
    "/autores":"Vo escrever o curso"
}

const server = http.createServer((req,res) => {
    res.writeHead(200,{'Content-Type':'text/plain'})
    res.end(routes[req.url])
})
Date.now()
server.listen(PORT,() => console.log(`Server is running in port ${PORT} at ${new Date().toLocaleDateString("pt-BR", options)}`));