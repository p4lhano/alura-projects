import { OmitType, PartialType } from "@nestjs/mapped-types";
import { Produto } from "../entities/produto.entity";

export class CreateProdutoDto extends PartialType(OmitType(Produto,['id'] as const)) {}
