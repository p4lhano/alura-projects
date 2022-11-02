import express from "express";
import AutorController from "../controller/autorController.js";

const routerAutores = express.Router();
const baseUriAutor = "/autores"

routerAutores
    .get(`${baseUriAutor}`,AutorController.listarAutor)
    .post(`${baseUriAutor}`,AutorController.cadatrarAutor)
    .put(`${baseUriAutor}/:id`,AutorController.atualizarAutor)
    .get(`${baseUriAutor}/:id`,AutorController.busquePorID)
    .delete(`${baseUriAutor}/:id`,AutorController.excluirPorID)

export default routerAutores