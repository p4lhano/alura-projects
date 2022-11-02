const db = require('../models')

class MatriculaController {
    static async findAll(req,res) {
        try {
            const matriculas = await db.Matriculas.findAll()
            return res.status(200).json(matriculas)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async findById(req,res) {
        try {
            const {id} = req.params
            const p = await db.Matriculas.findOne({where:{id:Number(id)}})
            return res.status(200).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async create(req,res) {
        try {
            const pessoa = req.body
            const p = await db.Matriculas.create(pessoa)
            return res.status(201).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async update(req,res) {
        try {
            const {id} = req.params
            const nivelI = req.body
            const isUpdated = await db.Matriculas.update(nivelI,{where:{id:Number(id)}})
            return res.status(200).json({msg:`is atualized: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async delete(req,res) {
        try {
            const {id} = req.params
            const isUpdated = await db.Matriculas.destroy({where:{id:Number(id)}})
            return res.status(200).json({msg:`is delete: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
}

module.exports = MatriculaController