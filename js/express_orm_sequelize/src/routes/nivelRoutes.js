const {Router} = require('express')
const NivelController = require('../controller/NivelController.js')
const routerNivel = Router()
const base_route = '/nivel'

routerNivel
    .get(`${base_route}`,NivelController.findAll)
    .post(`${base_route}`,NivelController.create)
    .get(`${base_route}/:id`,NivelController.findById)
    .delete(`${base_route}/:id`,NivelController.delete)
    .patch(`${base_route}/:id`,NivelController.update)

module.exports = routerNivel