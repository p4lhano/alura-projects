const db = require('../models')
const Sequelize = require('sequelize')
const Op = Sequelize.Op

class TurmasController {
    static async findAll(req,res) {
        try {
            //uso de variveis para filtro
            const where = {}
            const {start,end} = req.query
            start || end ? where.data_inicio = {} : null
            start ? where.data_inicio[Op.gte] = start : null
            end ? where.data_inicio[Op.lte] = end : null

            const turmas = await db.Turmas.findAll({where})
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

    static async findByIdAndCountMatriculas(req,res) {
        try {
            const {id} = req.params
            const p = await db.Turmas.findOne({where:{id:Number(id)}})
            const t = await db.Matriculas.findAndCountAll({
                where:{
                    turma_id: Number(id),
                    status:'confirmado'
                }
            })
            p.totalAlunos = t
            return res.status(200).json({p,t})
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
    static async findLotadas(req,res) {
        try {
            const lotacao = 2
            const t = await db.Matriculas.findAndCountAll({
                where:{
                    status:'confirmado'
                },
                attributes: ['turma_id'],//SELECT "turma_id" FROM ...
                group: ['turma_id'], // ... GROUP BY "turma_id";
                having: Sequelize.literal(`count(turma_id) >= ${lotacao}`)
            })
            // const p = await db.Turmas.findOne({where:{id:Number(id)}})
            
            return res.status(200).json(t)
        } catch (error) {
            return res.status(500).json(error.message)
        }
    }
}

module.exports = TurmasController