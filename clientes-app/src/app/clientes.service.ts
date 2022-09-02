import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente} from './clientes/cliente';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
/*
export class ClientesService {

  constructor( private http: HttpClient) { }

  salvar( cliente: Cliente ): Observable<Cliente> {
    return this.http.post<Cliente>('${environment.api}/clientes', cliente)
  }

  atualizar( cliente: Cliente ): Observable<any> {
    return this.http.put<Cliente>(`${environment.api}/clientes/${cliente.id}`, cliente)
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>('${environment.api}/clientes');
  }

  getClenteById(id: number) : Observable<Cliente> {
    return this.http.get<any>(`${environment.api}/clientes/${id}`);
  }

  deletar( cliente: Cliente ): Observable<any> {
    return this.http.delete<any>(`${environment.api}/clientes/${cliente.id}`);
  }
}
*/


export class ClientesService {

  apiURL: string = environment.apiURLBase + '/clientes';

  constructor( private http: HttpClient) { }

  salvar( cliente: Cliente ): Observable<Cliente> {
    return this.http.post<Cliente>(`${this.apiURL}`, cliente)
  }

  atualizar( cliente: Cliente ): Observable<any> {
    return this.http.put<Cliente>(`${this.apiURL}/${cliente.id}`, cliente)
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.apiURL);
  }

  getClenteById(id: number) : Observable<Cliente> {
    return this.http.get<any>(`${this.apiURL}/${id}`);
  }

  deletar( cliente: Cliente ): Observable<any> {
    return this.http.delete<any>(`${this.apiURL}/${cliente.id}`);
  }

}

/*  getClientes() : Cliente[] {
    let cliente = new Cliente();
    cliente.id = 1;
    cliente.nome = 'Jose Geraldo';
    cliente.cpf = '64050270668';
    cliente.dataCadastro = '18/04/2020';
    return [cliente];
  }
getClientes() : Observable<Cliente[]> {
  return of([]);
}*/