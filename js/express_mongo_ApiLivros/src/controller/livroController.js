import livros from "../model/Livro.js";

class LivroController {
    static listarLisbros = (req,res) => 
        livros
            .find()
            .populate('autor','nome')
            .exec((err,livros) =>
                res.status(200).json(livros)
            )

    static cadatrarLivro = (req,res) => {
        let livro = new livros(req.body)
        
        livro.save()
        .then(() => res.status(200).send({msg: livro}))
        .catch(err => res.status(500).send({msg: err.message}))
        
    }

    static atualizarLivro = (req,res) => {
        const {id} = req.params
        livros.findByIdAndUpdate(id,{$set: req.body},(err) => {
            
            if (err) res.status(400).send({msg:err.message})
            res.status(200).send({msg:"suscessful upedate"})
        })
    }

    static busquePorID = (req,res) => {
        const {id} = req.params

        livros.findById(id)
        .populate('autor')
        .exec((err,l) => {
            if (err) {
                res.status(404).send({msg: `não encotrado ${err.message}`})
                return
            }
            res.status(200).send(l)

        })
    }
    static excluirPorID = (req,res) => {
        const {id} = req.params

        livros.findByIdAndDelete(id,(err) => {
            if (err) {
                res.status(404).send({msg: `erro ${err.message}`})
                return
            }
            res.status(200).send({msg:`${id} exclude`})
        })
    }

    static listarPorEditora = (req,res) => {
        const editor = req.query.editora

        livros.find({'editora':editor},{},(err,result)=>{
            res.status(200).send(result)
        })
    }
}

export default LivroController