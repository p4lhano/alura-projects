const bodyParse = require('body-parser')
const routerPessoa = require('./pessoaRoutes.js')
const routerNivel = require('./nivelRoutes.js')
const routerTurma = require('./turmaRoutes.js')

module.exports = app => {
    // app.use(express.json())
    // app.use(bodyParse.json())
    app.get('/',(req,res) => res.status(200).send({msg:"Isto é uma escola"}))
    app.use(
        bodyParse.json(),
        routerPessoa,
        routerNivel,
        routerTurma)
}