import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { ProdutosModule } from './produtos/produtos.module';
import { DatabaseModule } from './providers/database.module';
import { UsersModule } from './users/users.module';

@Module({
  imports: [
    ConfigModule.forRoot(),
    DatabaseModule,
    ProdutosModule,
    UsersModule
  ],
//   controllers: [AppController],
//   providers: [AppService],
})
export class AppModule {}
