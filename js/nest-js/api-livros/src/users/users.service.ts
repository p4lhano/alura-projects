import { Injectable } from '@nestjs/common';
import { CreateUserDto } from './dto/create-user.dto';
import { UpdateUserDto } from './dto/update-user.dto';

@Injectable()
export class UsersService {
  create(createUserDto: CreateUserDto) {
    return 'This action adds a new user';
  }

  findAll() {
    return `This action returns all users`;
  }

  findById(id: number) {
    return `This action returns a #${id} user`;
  }

  findOne(where: any) {
    return `Não implementado logica para busca generica com diversos campos`;
  }

  async hasExits(where: any): Promise<boolean> {
    let response =  new Promise<boolean>((resolve, reject) =>  {resolve(true)});
    
    return response;
  }

  update(id: number, updateUserDto: UpdateUserDto) {
    return `This action updates a #${id} user`;
  }

  remove(id: number) {
    return `This action removes a #${id} user`;
  }
}
