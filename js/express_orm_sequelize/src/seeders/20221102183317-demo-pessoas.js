'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
    /*
      Add altering commands here.
      Return a promise to correctly handle asynchronicity.

      Example:
      */
      return queryInterface.bulkInsert('Pessoas', [{
        nome: "Vitor Araujo",
        ativo: true,
        email: "vitor@outo.com",
        role: "aluno",
        createdAt: new Date(),
        updatedAt: new Date()
      },{
        nome: "Pedro Henrique",
        ativo: true,
        email: "pedro@outo.com",
        role: "professor",
        createdAt: new Date(),
        updatedAt: new Date()
      },
      {
        nome: "Ana gabriela",
        ativo: true,
        email: "ana@outo.com",
        role: "aluno",
        createdAt: new Date(),
        updatedAt: new Date()
      }], {});
  },

  down: (queryInterface, Sequelize) => {
    /*
      Add reverting commands here.
      Return a promise to correctly handle asynchronicity.

      Example:
      */
      return queryInterface.bulkDelete('Pessoas', null, {});
  }
};
