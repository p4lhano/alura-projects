import app from "./src/app.js";
const port = process.env.NODE_SERVER_PORT || 3000
const options = { hour: 'numeric',minute:'numeric',second:'numeric', year: 'numeric', month: 'numeric', day: 'numeric' }

app.listen(port,() =>
    console.log(`Server is running in port ${port} at ${new Date().toLocaleDateString("pt-BR", options)}`)
    );