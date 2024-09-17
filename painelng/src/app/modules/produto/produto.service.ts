import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from 'src/environments/environment.development';
import Produto from 'src/app/core/model/produto.model';
import { HttpParamsService } from 'src/app/shared/services/http-params.service';
import { ProdutoUpdate } from 'src/app/core/model/produto-update.model';
@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient, private httpParamsService: HttpParamsService) { }

  getProtudo(pk: number): Observable<Produto> {
    return this.http.get<Produto>(API_URL + '/products/' + pk);
  }
  getListProduto(form: any): Observable<any[]> {

    const params = this.httpParamsService.toHttpParams(form);
    return this.http.get<any[]>(API_URL + '/products/all', { params });
  }
  update(entity: Produto): Observable<Produto> {
    return this.http.put<Produto>(API_URL + "/products/update", new ProdutoUpdate(entity));
  }
  create(entity: Produto): Observable<Produto> {

    return this.http.post<Produto>(API_URL + "/products/create", new ProdutoUpdate(entity));
  }
  delete(pk: number): Observable<void> {
    return this.http.delete<void>(API_URL + "/products/delete/" + pk);
  }
}
