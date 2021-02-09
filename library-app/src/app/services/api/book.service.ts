import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from 'src/app/models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private endpoint: string;

  constructor(private httpClient: HttpClient) {
    this.endpoint = 'book';
  }

  queryBook(text: string): Observable<Book[]> {
    const service = environment.apiUrl + this.endpoint;
    return this.httpClient.post<Book[]>(service, text);
  }

}
