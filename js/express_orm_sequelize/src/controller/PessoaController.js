const db = require('../models')

class PessoasController {
    static async findAll(req,res) {
        try {
            const pessoas = await db.Pessoas.findAll()
            return res.status(200).json(pessoas)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async findById(req,res) {
        try {
            const {id} = req.params
            const p = await db.Pessoas.findOne({where:{id:Number(id)}})
            return res.status(200).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async create(req,res) {
        try {
            const pessoa = req.body
            const p = await db.Pessoas.create(pessoa)
            return res.status(201).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async update(req,res) {
        try {
            const {id} = req.params
            const pessoaI = req.body
            const isUpdated = await db.Pessoas.update(pessoaI,{where:{id:Number(id)}})
            return res.status(200).json({msg:`is atualized: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async delete(req,res) {
        try {
            const {id} = req.params
            const isUpdated = await db.Pessoas.destroy({where:{id:Number(id)}})
            return res.status(200).json({msg:`is delete: ${isUpdated}`})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async createMatricula(req,res) {
        try {
            const {id} = req.params
            const newMatri = {...req.body,estudante_id:Number(id)}
            const p = await db.Matriculas.create(newMatri)
            return res.status(200).json(p)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
}

module.exports = PessoasController