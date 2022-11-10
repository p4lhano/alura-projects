import { Injectable } from "@nestjs/common";
import { registerDecorator, ValidationArguments, ValidationOptions, ValidatorConstraint, ValidatorConstraintInterface } from "class-validator";
import { UsersService } from "src/users/users.service";

@Injectable()
@ValidatorConstraint({async: true})
export class EmailIsUniqueValidator implements ValidatorConstraintInterface {
    
    constructor(private userService: UsersService){}
    
    async validate(value: any, validationArguments?: ValidationArguments): Promise<boolean> {
        const userExist = await this.userService.hasExits({email: value})
        return !userExist;
    }
    defaultMessage?(validationArguments?: ValidationArguments): string {
        return 'Email has cadastrade';
    }

}

export const EmailIsUnique = (option: ValidationOptions) => {
    return (obj: Object , prop:string) => {
        registerDecorator({
            target: obj.constructor,
            propertyName: prop,
            options: option,
            constraints: [],
            validator: EmailIsUniqueValidator
        });
    }
}