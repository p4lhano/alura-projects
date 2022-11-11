import { Exclude, Expose } from "class-transformer";
import { IsEmail, IsNotEmpty, IsString } from "class-validator";

export class Usuario {
    id: number;

    @IsNotEmpty()
    @IsString()
    login: string;

    @IsEmail()
    email: string;

    @IsNotEmpty()
    @Exclude({toPlainOnly:true})
    @Expose({name: 'password'})
    senha: string;
    nomeCompleto: string;
}