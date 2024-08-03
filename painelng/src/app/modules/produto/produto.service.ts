import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from 'src/environments/environment.development';
import Produto from 'src/app/core/model/produto.model';
@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  getProtudoDTO(pk: number): Observable<Produto> {
    return this.http.get<Produto>(API_URL + '/product/dto/' + pk);
  }
  getListProduto(form: any): Observable<any[]> {
    return this.http.get<any[]>(API_URL + '/product?' + new URLSearchParams(form).toString());
  }
  update(entity: Produto): Observable<Produto> {
    return this.http.put<Produto>(API_URL + "/product/update", entity);
  }
  create(entity: Produto): Observable<Produto> {
    return this.http.post<Produto>(API_URL + "/product/create", entity);
  }
  delete(pk: number): Observable<boolean> {
    return this.http.delete<boolean>(API_URL + "/product/delete/" + pk);
  }
}
