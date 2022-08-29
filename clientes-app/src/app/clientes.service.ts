import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente} from './clientes/cliente';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  constructor( private http: HttpClient) { }

  salvar( cliente: Cliente ): Observable<Cliente> {
    return this.http.post<Cliente>('http://localhost:8080/api/clientes', cliente)
  }

  atualizar( cliente: Cliente ): Observable<any> {
    return this.http.put<Cliente>(`http://localhost:8080/api/clientes/${cliente.id}`, cliente)
  }

  getClientes() : Observable<Cliente[]> {
    return this.http.get<Cliente[]>('http://localhost:8080/api/clientes');
  }

  getClenteById(id: number) : Observable<Cliente> {
    return this.http.get<any>(`http://localhost:8080/api/clientes/${id}`);
  }

  deletar( cliente: Cliente ): Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/clientes/${cliente.id}`);
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