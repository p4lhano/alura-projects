import { Body, Controller, Get, HttpStatus, NotFoundException, Param, Post } from "@nestjs/common";
import { NestResponse } from "src/core/http/nest-response";
import { NestResponseBuilder } from "src/core/http/nest-response-builder";
import { Usuario } from "./usuario.entity";
import { UsuarioService } from "./usuario.service";

@Controller('users')
export class UserController {
    constructor(private userService: UsuarioService) {}

    @Get()
    getAll(){
        return this.userService.getAll();
    }

    @Get(':id')
    getById(@Param('id') id: number){
        const user = this.userService.getById(id);
        if(!user) throw new NotFoundException(`User id ${id} não encontrado`);
        return user;
    }


    @Post()
    create(@Body() u: Usuario): NestResponse {
        const criado = this.userService.create(u);
        return new NestResponseBuilder()
        .setStatus(HttpStatus.CREATED)
        .setHeaders({
            "Location":`/users/${criado.id}`
        })
        .setBody(criado)
        .build();
    }
}