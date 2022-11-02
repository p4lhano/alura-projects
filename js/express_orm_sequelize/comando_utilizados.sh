#inicializar o projeto
npm init -y

# instalar dependencias
# body-parser não é extremamente necessario pois podemos utilizar configuração diretamente do express.json para configurações de body de requisições e respostas
npm i sequelize@5.21.7 sequelize-cli@5.5.1 path express body-parser@1.20.1

# Install nodemon como desenvolvimento
npm install nodemon -D

# Run projeto modo tradicional - lembrando que já criei o projeto no ./src
node src/index.js 

# apos criação de alias em package.json: "scripts": { "dev": "nodemon src/index.js",...} run com auto-reload
npm run dev

#install de dependencias para o Postgres
npm install --save pg pg-hstore

# Start configuration do sequelize,
# Caso altere os itens criado na inicialização para dentro de ./src
# lembrar de criar o arquivo '.sequelizerc' e add as config necessárias, vide https://sequelize.org/docs/v6/other-topics/migrations/#the-sequelizerc-file
# optei também por alterar o nome do config padrão do banco: config.json -> config_db.json
npx sequelize-cli init

# Criar table
npx sequelize-cli model:create \
--name Pessoas \
--attributes nome:string,\
ativo:boolean,\
email:string,\
role:string

# Rodar as migrations no banco
npx sequelize-cli db:migrate

# Desfazer uma migration(ultima)
npx sequelize-cli db:migrate:undo

# Desfazer todas as migrations a partir de uma determinada
npx sequelize-cli db:migrate:undo --name [data-hora]-create-[nome-da-tabela].js

# Gerar o arquivo seed, para sementes de pessoas no banco
npx sequelize-cli seed:generate --name demo-pessoas

# Para rodar o seed
npx sequelize-cli db:seed:all

#isso é apenas uma nota
#INSERT INTO "Pessoas" (id, nome, ativo, email, "role", "createdAt", "updatedAt") VALUES(1, 'Vitor', true, 'vitor@vitor', 'ALUNO', '2022-11-02 15:29:45.131', '2022-11-02 15:29:45.131');
