#!/bin/sh
npm install typescript --save-dev

#para usar o compiler_TS
npx tsc

#ou gloalmente + é recomendado instalar tbm em cada proj
npm install -g typescript
    # Resulta em 'tsc' disponivel globalmente

tsc -w #compiler and watch

# Basic config for typescript in file tsconfig.json
# {
#     "compilerOptions": {
#         "outDir": "dist/js",
#         "target": "ES6"
#     },
#     "include": ["app/**/*"]
# }

# add restrição para não compilar se existir erros no projeto
# {
#     "compilerOptions": { ...
#       "noEmitOnError": true
#  },...
# }

