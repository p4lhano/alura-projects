import { Module } from '@nestjs/common';
import { UsersService } from './users.service';
import { UsersController } from './users.controller';
import { EmailIsUniqueValidator } from 'src/validation/pipes/email-is-unique.validator';

@Module({
  controllers: [UsersController],
  providers: [UsersService,EmailIsUniqueValidator]
})
export class UsersModule {}
