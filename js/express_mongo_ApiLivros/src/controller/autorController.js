import autores from "../model/Autor.js";

class AutorController {
    static listarAutor = (req,res) => 
        autores.find((err,autores) =>
            res.status(200).json(autores)
        )

    static cadatrarAutor = (req,res) => {
        let autor = new autores(req.body)
        
        autor.save()
        .then(() => res.status(200).send({msg: autor}))
        .catch(err => res.status(500).send({msg: err.message}))
        
    }

    static atualizarAutor = (req,res) => {
        const {id} = req.params
        autores.findByIdAndUpdate(id,{$set: req.body},(err) => {
            
            if (err) res.status(400).send({msg:err.message})
            res.status(200).send({msg:"suscessful upedate"})
        })
    }

    static busquePorID = (req,res) => {
        const {id} = req.params

        autores.findById(id,(err,l) => {
            if (err) {
                res.status(404).send({msg: `não encotrado ${err.message}`})
                return
            }
            res.status(200).send(l)

        })
    }
    static excluirPorID = (req,res) => {
        const {id} = req.params

        autores.findByIdAndDelete(id,(err) => {
            if (err) {
                res.status(404).send({msg: `erro ${err.message}`})
                return
            }
            res.status(200).send({msg:`${id} exclude`})
        })
    }
}

export default AutorController