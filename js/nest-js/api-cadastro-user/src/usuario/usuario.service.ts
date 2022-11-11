import { Injectable } from '@nestjs/common';
import { Usuario } from './usuario.entity';

@Injectable()
export class UsuarioService {
    users: Usuario[] = [];
    
    getAll() {
        return this.users;
    }
    getById(id: number): Usuario {
        return this.users.find(user => user.id === id);
    }

    create(u: Usuario) {
        this.users.push(u);
        return u;
    }
}
