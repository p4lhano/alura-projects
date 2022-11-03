const {Router} = require('express')
const TurmasController = require('../controller/TurmasController.js')
const routerTurma = Router()
const base_route = '/turma'

routerTurma
    .get(`${base_route}`,TurmasController.findAll)
    .post(`${base_route}`,TurmasController.create)
    .get(`${base_route}/lotadas`,TurmasController.findLotadas)
    .get(`${base_route}/:id/count`,TurmasController.findByIdAndCountMatriculas)
    .get(`${base_route}/:id`,TurmasController.findById)
    .delete(`${base_route}/:id`,TurmasController.delete)
    .patch(`${base_route}/:id`,TurmasController.update)

module.exports = routerTurma