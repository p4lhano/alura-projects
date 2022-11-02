const db = require('../models')

class NivelController {
    static async findAll(req,res) {
        try {
            const nivel = await db.Niveis.findAll()
            return res.status(200).json(nivel)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async findById(req,res) {
        try {
            const {id} = req.params
            const p = await db.Niveis.findOne({where:{id:Number(id)}})
            return res.status(200).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async create(req,res) {
        try {
            const pessoa = req.body
            const p = await db.Niveis.create(pessoa)
            return res.status(201).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async update(req,res) {
        try {
            const {id} = req.params
            const nivelI = req.body
            const isUpdated = await db.Niveis.update(nivelI,{where:{id:Number(id)}})
            return res.status(200).json({msg:`is atualized: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async delete(req,res) {
        try {
            const {id} = req.params
            const isUpdated = await db.Niveis.destroy({where:{id:Number(id)}})
            return res.status(200).json({msg:`is delete: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
}

module.exports = NivelController