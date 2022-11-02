import express from "express";
import LivroController from "../controller/livroController.js";

const routerLivros = express.Router();
const baseUriLivro = "/livros"

routerLivros
    .get(`${baseUriLivro}`,LivroController.listarLisbros)
    .post(`${baseUriLivro}`,LivroController.cadatrarLivro)
    .get(`${baseUriLivro}/busca`,LivroController.listarPorEditora)//busca com query params
    .put(`${baseUriLivro}/:id`,LivroController.atualizarLivro)
    .get(`${baseUriLivro}/:id`,LivroController.busquePorID)
    .delete(`${baseUriLivro}/:id`,LivroController.excluirPorID)

export default routerLivros