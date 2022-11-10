#!/bin/bash
node -v # Estou utilizando o 18.12.0 
npm i -g @nestjs/cli
sudo npm i -g @nestjs/cli
nest new nestConcursoGato
cd ./nest-concurso-gato || exit
npm start
# para escutar mudanças em arquivos
npm run start:dev

# Crud generator
nest g resource
# CREATE src/gatos/gatos.controller.spec.ts (566 bytes)
# CREATE src/gatos/gatos.controller.ts (894 bytes)
# CREATE src/gatos/gatos.module.ts (247 bytes)
# CREATE src/gatos/gatos.service.spec.ts (453 bytes)
# CREATE src/gatos/gatos.service.ts (609 bytes)
# CREATE src/gatos/dto/create-gato.dto.ts (30 bytes)
# CREATE src/gatos/dto/update-gato.dto.ts (169 bytes)
# CREATE src/gatos/entities/gato.entity.ts (21 bytes)
# UPDATE package.json (2036 bytes)
# UPDATE src/app.module.ts (312 bytes)

# outer options
nest g controller cats
nest g service cats
