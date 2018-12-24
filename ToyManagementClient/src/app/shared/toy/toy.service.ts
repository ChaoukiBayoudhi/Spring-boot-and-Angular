import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
// import { Toy } from '/src/app/toyClass/toy';

@Injectable({
  providedIn: 'root'
})
export class ToyService {
  public API = '//localhost:2020';
  public toy_API = this.API; // + '/toys';
  constructor(private https: HttpClient) {
  }
  getAll(): Observable<any> {
    return this.https.get(this.API + '/alltoys');
  }

  get (id: any): Observable<any> {
    // const url = '${this.toy_API}/toy/${id}';
    return this.https.get(this.API + '/toy/' + +id);
  }

  getByName (name: string): Observable<any> {
    // const url = '${this.toy_API}/toy/${id}';
    return this.https.get(this.API + '/toyByName/' + name);
  }

  // 2. GET a Toy from remote SpringBoot API <code>@GetMapping(value="/toy/{id}")
  // getToy(id: number): Observable<Customer> {
  // tslint:disable-next-line:indent
  // const url = `${this.customersUrl}/${id}`;
  // return this.http.get<Customer>(url);
  // }

  save(toy: any): Observable<any> {
    let result: Observable<Object>;
    if (toy['href']) {
      result = this.https.put(toy.href, toy);
    } else {
      result = this.https.post(this.toy_API + '/newToy', toy);
    }
    return result;
  }

  updateByName(toy: any, name: string): Observable<any> {
    let result: Observable<Object>;

      result = this.https.put(this.toy_API + '/updateByName/' + name, toy);

    return result;
  }

  remove(name: string) {
    // const name = typeof toy === 'string' ? toy : toy.name;
    const url = `${this.toy_API}/removeToy/${name}`;
    return this.https.delete(url);
  }
  // 4.DELETE a Customer from remote SpringBoot API <code>@DeleteMapping(value="/api/customers/{id}")
 /* deleteToy (toy: any | number): Observable<any> {
    const id = typeof toy === 'number' ? toy : toy.id;
    const url = `${this.toy_API}/${id}`;
    return this.https.delete(url);
  }*/

update(toy: any, id: number) {
    return this.https.put(this.toy_API + '/updatetoy/' + id, toy)
    .pipe(
      catchError(this.handleError)
    );
 }

 private handleError(error: HttpErrorResponse) {
  if (error.error instanceof ErrorEvent) {
    // A client-side or network error occurred. Handle it accordingly.
    console.error('An error occurred:', error.error.message);
  } else {
    // The backend returned an unsuccessful response code.
    // The response body may contain clues as to what went wrong,
    console.error(
      `Backend returned code ${error.status}, ` +
      `body was: ${error.error}`);
  }
  // return an observable with a user-facing error message
  return throwError(
    'Something bad happened; please try again later.');
}


}
