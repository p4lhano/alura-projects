import { Sequelize } from 'sequelize-typescript';
import { Produto } from '../produtos/entities/produto.entity';

export const databaseProviders = [
  {
    provide: 'SEQUELIZE',
    useFactory: async () => {
      const sequelize = new Sequelize({
        dialect: 'postgres',
        host: 'localhost',
        port: 5432,
        username: process.env.DATABASE_USERNAME,
        password: 'alura',
        database: 'alura_projects',
      });
      sequelize.addModels([Produto]);
      await sequelize.sync();
      return sequelize;
    },
  },
];