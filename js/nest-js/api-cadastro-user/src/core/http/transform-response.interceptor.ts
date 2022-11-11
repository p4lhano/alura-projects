import { CallHandler, ExecutionContext, Injectable, NestInterceptor } from "@nestjs/common";
import { AbstractHttpAdapter, HttpAdapterHost } from "@nestjs/core";
import { map, Observable } from "rxjs";
import { NestResponse } from "./nest-response";

@Injectable()
export class TransformResponseInterceptor implements NestInterceptor {
    private httpAdapter: AbstractHttpAdapter;
    constructor(adapterHost: HttpAdapterHost){
        this.httpAdapter = adapterHost.httpAdapter;
    }
    intercept(context: ExecutionContext, next: CallHandler<any>): Observable<any> | Promise<Observable<any>> {
        return next
        .handle()
        .pipe(map((resControler: NestResponse) => {
            if (resControler instanceof NestResponse){
                const contect = context.switchToHttp();
                const response = contect.getResponse();
                const {headers,status,body} = resControler;

                Object.entries(headers).forEach(keyValue => 
                    this.httpAdapter.setHeader(response,keyValue[0],keyValue[1]));

                this.httpAdapter.status(response,status);
                return body
            }
            return resControler;
        }));
    }

}