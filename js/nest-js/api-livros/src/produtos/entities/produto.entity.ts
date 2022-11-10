import { Table, Column, Model, DataType } from "sequelize-typescript";

@Table({tableName:'produtos_livra'})
export class Produto extends Model {
    // id:  number;
    @Column({
        allowNull: false,
        type: DataType.STRING(50)
    })
    codigo: string;
    
    @Column
    nome: string;
    
    @Column({
        type: DataType.DECIMAL
    })
    preco: number;
}