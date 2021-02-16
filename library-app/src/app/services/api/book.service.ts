import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from 'src/app/models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private endpoint: string;
  private httpOptions: any;

  constructor(private httpClient: HttpClient) {
    this.endpoint = 'book';
    this.httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    };
  }

  queryBook(text: string): Observable<any> {
    const service = environment.apiUrl + this.endpoint;
    return this.httpClient.post<any>(service, text, this.httpOptions);
  }

}
