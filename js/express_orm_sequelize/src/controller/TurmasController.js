const db = require('../models')

class TurmasController {
    static async findAll(req,res) {
        try {
            const turmas = await db.Turmas.findAll()
            return res.status(200).json(turmas)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async findById(req,res) {
        try {
            const {id} = req.params
            const p = await db.Turmas.findOne({where:{id:Number(id)}})
            return res.status(200).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async create(req,res) {
        try {
            const pessoa = req.body
            const p = await db.Turmas.create(pessoa)
            return res.status(201).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async update(req,res) {
        try {
            const {id} = req.params
            const nivelI = req.body
            const isUpdated = await db.Turmas.update(nivelI,{where:{id:Number(id)}})
            return res.status(200).json({msg:`is atualized: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async delete(req,res) {
        try {
            const {id} = req.params
            const isUpdated = await db.Turmas.destroy({where:{id:Number(id)}})
            return res.status(200).json({msg:`is delete: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
}

module.exports = TurmasController