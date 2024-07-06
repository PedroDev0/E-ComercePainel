import { ProdutoDTO } from './produto-dto.model';
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

  getProtudoDTO(idProduto: number): Observable<ProdutoDTO> {
    return this.http.get<ProdutoDTO>(API_URL + '/product/dto/' + idProduto);
  }
  getListProduto(form: any): Observable<any[]> {
    return this.http.get<any[]>(API_URL + '/product?' + new URLSearchParams(form).toString());
  }
  update(entity: ProdutoDTO): Observable<ProdutoDTO> {
    return this.http.put<ProdutoDTO>(API_URL + "/product/update", entity);
  }
  create(entity: ProdutoDTO): Observable<ProdutoDTO> {
    return this.http.post<ProdutoDTO>(API_URL + "/product/create", entity);
  }
}
