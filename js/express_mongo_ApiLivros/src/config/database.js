import mongoose from "mongoose";

mongoose.connect(`mongodb+srv://vitorAcessData:${process.env.NODE_MOONGOSE_PASSWORD}@vitorcluster.hdl5dhn.mongodb.net/alura`)
// mongoose.connect(`mongodb+srv://vitorAcessData:${process.env.NODE_MOONGOSE_PASSWORD}@vitorcluster.hdl5dhn.mongodb.net/alura?retryWrites=true&w=majority`)

let db = mongoose.connection;

export default db;