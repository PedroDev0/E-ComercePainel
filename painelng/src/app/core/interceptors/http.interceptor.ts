import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class HttpFormatInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      map(event => {
        if (event instanceof HttpResponse) {
          // Chama a função que vai formatar as datas dentro da resposta
          const body = this.formatDates(event.body);
          return event.clone({ body });
        }
        return event;
      })
    );
  }

  // Função recursiva que percorre os objetos e formata datas
  private formatDates(body: any): any {
    if (body === null || body === undefined) {
      return body;
    }

    if (typeof body === 'string' && this.isIsoDate(body)) {
      return this.formatDate(body);
    }

    if (typeof body === 'object') {
      for (const key of Object.keys(body)) {
        body[key] = this.formatDates(body[key]);
      }
    }

    return body;
  }

  // Verifica se a string está no formato ISO 8601
  private isIsoDate(value: string): boolean {
    const isoDateRegex = /\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}.\d{3}Z?/;
    return isoDateRegex.test(value);
  }

  // Converte a data para o formato dd/MM/yyyy
  private formatDate(value: string): string {
    const date = new Date(value);
    const day = ('0' + date.getDate()).slice(-2);
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  }
}
