import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Produto from 'src/app/core/model/produto.model';
import { API_URL } from 'src/environments/environment.development';
@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  
  constructor(private http: HttpClient) { }
  getListProduto( form:any ): Observable<any[]> {
    console.log(API_URL + '/product?'+ new URLSearchParams(form).toString())
    return this.http.get<any[]>(API_URL + '/product?'+ new URLSearchParams(form).toString());
  }
  createOrUpdate(entity:Produto):Observable<Produto> {
    return this.http.put<Produto>(API_URL+"/product/create-or-update",entity);
  }
}
