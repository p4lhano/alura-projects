import { Inject, Injectable } from '@nestjs/common';
import { CreateProdutoDto } from './dto/create-produto.dto';
import { UpdateProdutoDto } from './dto/update-produto.dto';
import { Produto } from './entities/produto.entity';

@Injectable()
export class ProdutosService {
  
  constructor(
    @Inject('PRODUTOS_REPOSITORY')
    private produtosRepository: typeof Produto
  ){}

  async create(createProdutoDto: CreateProdutoDto) {
    return 'This action adds a new produto';
  }

  async findAll(): Promise<Produto[]> {
    // return `This action returns all produtos`;
    return this.produtosRepository.findAll();
  }

  async findById(id: number) {
    return this.produtosRepository.findByPk(id);
  }

  async update(id: number, updateProdutoDto: UpdateProdutoDto) {
    return `This action updates a #${id} produto`;
  }

  async remove(id: number) {
    return `This action removes a #${id} produto`;
  }
}
