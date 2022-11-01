import express from "express";
import routerLivros from "./livrosRoutes.js";

const routes = app => {
    app.route('/').get((req,res) => res.status(200).send({title:"Curso di node"}))
    app.use(express.json(),routerLivros)
}

export default routes