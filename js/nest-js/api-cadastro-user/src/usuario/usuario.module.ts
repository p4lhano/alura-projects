import { Module } from "@nestjs/common";
import { UserController } from "./user.controller";
import { UsuarioService } from "./usuario.service";

@Module({
    controllers: [UserController],
    providers: [UsuarioService]
})
export class UsuarioModule { }