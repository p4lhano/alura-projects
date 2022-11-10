import { IsEmail, IsNotEmpty, MinLength } from "class-validator";
import { EmailIsUnique } from "src/validation/pipes/email-is-unique.validator";

export class CreateUserDto {
    @IsNotEmpty()
    nome: string;

    @IsEmail()
    @EmailIsUnique(undefined)
    email: string;

    @MinLength(6)
    password: string;
}
