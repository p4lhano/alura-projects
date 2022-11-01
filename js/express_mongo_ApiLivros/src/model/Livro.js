import mongoose from "mongoose";

const livroSchema = new mongoose.Schema({
    id: {type: String},
    title: {type: String,require:true},
    autor: {type: String,require:false},
    editora: {type: String,require:false},
    nPaginas: {type: Number}
})

const livros = mongoose.model('livros',livroSchema)
export default livros