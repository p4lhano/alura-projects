import express from "express";
import db from "./config/database.js";
import routes from "./routes/index.js";

const app = express()

db.on("error",console.log.bind(console,"erro de conextor DB"))
db.once("open",() => 
    console.log("open conecton for database")
)
// app.use(express.json())
routes(app);


export default app