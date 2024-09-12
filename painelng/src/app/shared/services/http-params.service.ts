import { HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpParamsService {

  constructor() { }
  toHttpParams(obj: any): HttpParams {
    let params = new HttpParams();

    for (const key in obj) {
      if (obj.hasOwnProperty(key) && obj[key] !== null && obj[key] !== undefined) {
        const value = obj[key] instanceof Date ? obj[key].toISOString().split('T')[0] : obj[key];
        params = params.append(key, value.toString());
      }
    }

    return params;
  }
}
