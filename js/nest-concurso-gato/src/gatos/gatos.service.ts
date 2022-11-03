import { Injectable } from '@nestjs/common';
import { CreateGatoDto } from './dto/create-gato.dto';
import { UpdateGatoDto } from './dto/update-gato.dto';
import { Gato } from './entities/gato.entity';

@Injectable()
export class GatosService {
  private readonly cats: Gato[] = [
    {
      name: "Nome do gato",
      age: 3,
      breed: "felino"
    },
    {
      name: "Nome do gato2",
      age: 4,
      breed: "felino"
    }
  ];

  create(createGatoDto: CreateGatoDto) {
    return 'This action adds a new gato';
  }

  findAll(): Gato[] {
    return this.cats;
  }

  findOne(id: number) {
    return `This action returns a #${id} gato`;
  }

  update(id: number, updateGatoDto: UpdateGatoDto) {
    return `This action updates a #${id} gato`;
  }

  remove(id: number) {
    return `This action removes a #${id} gato`;
  }
}
