import { NestResponse } from "./nest-response";

export class NestResponseBuilder {
    private response: NestResponse = {
        "status": 200,
        "headers": {},
        "body": {}
    }

    /**
     * name
     */
    public setStatus(status: number) {
        this.response.status = status
        return this;
    }
    public setHeaders(headers: Object) {
        this.response.headers = headers
        return this;
    }
    public setBody(body: Object) {
        this.response.body = body
        return this;
    }
    /**
     * name
     */
    public build(): NestResponse {
        return new NestResponse(this.response)
    }
}