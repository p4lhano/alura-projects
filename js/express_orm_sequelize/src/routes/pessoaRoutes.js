const {Router} = require('express')
const PessoaController = require('../controller/PessoaController.js')
const routerPessoa = Router()
const base_route = '/pessoas'

routerPessoa
    .get(`${base_route}`,PessoaController.findAll)
    .post(`${base_route}`,PessoaController.create)
    .post(`${base_route}/:id/matricula`,PessoaController.createMatricula)
    .get(`${base_route}/:id`,PessoaController.findById)
    .patch(`${base_route}/:id`,PessoaController.update)
    .delete(`${base_route}/:id`,PessoaController.delete)

module.exports = routerPessoa