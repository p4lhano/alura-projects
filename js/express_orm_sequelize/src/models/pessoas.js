'use strict';
module.exports = (sequelize, DataTypes) => {
  const Pessoas = sequelize.define('Pessoas', {
    nome: {
      type: DataTypes.STRING,
      validate: {
        funcValidateNome: function(d){
          if (d.length < 3) throw new Error('nome dece termais que 3')
        }
      }
    },
    ativo: DataTypes.BOOLEAN,
    email: {
      type: DataTypes.STRING,
      validate: {
        isEmail: {
          args: true,
          msg: 'email invalido'
        }
      }
    },
    role: DataTypes.STRING
  }, { 
    paranoid: true,
    defaultScope:{
      where: { ativo: true }
    },
    scopes: {
      todosNoWhere: { where: {} }
    } });
  Pessoas.associate = function(models) {
    // associations can be defined here
    Pessoas.hasMany(models.Turmas,{foreignKey:'docente_id'})//PessoaId ->deafult
    Pessoas.hasMany(models.Matriculas,{
      foreignKey:'estudante_id',
      scope: {status:'confirmado'},
      as: 'aulasConfirmadas'
    })
  };
  return Pessoas;
};