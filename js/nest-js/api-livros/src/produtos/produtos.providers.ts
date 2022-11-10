import { Produto } from "./entities/produto.entity";

export const produtosProviders =[
    {
        provide: 'PRODUTOS_REPOSITORY',
        useValue: Produto
    }
];