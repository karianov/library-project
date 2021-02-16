import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/services/api/book.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: [],
})
export class HomeComponent {
  searchField: FormControl;
  invalidInput: boolean;
  errorOnQuery: string;
  booksSearched: Book[];
  loadingQuery: boolean;

  constructor(private bookService: BookService) {
    this.invalidInput = false;
    this.loadingQuery = false;
    this.errorOnQuery = '';
    this.booksSearched = [];
    this.searchField = new FormControl(null);
  }

  searchBook(): void {
    if (!this.searchField.value || this.searchField.value.length === 0) {
      this.invalidInput = true;
    } else {
      this.invalidInput = false;
      this.loadingQuery = true;
      this.errorOnQuery = '';
      this.booksSearched = [];
      this.bookService.queryBook(this.searchField.value).subscribe(
        (result) => {
          this.loadingQuery = false;
          if (result.length > 0) {
            this.booksSearched = result;
          } else {
            this.errorOnQuery =
              'La consulta no trajó resultados.';
          }
        },
        () => {
          this.errorOnQuery =
            'Ocurrió un error interno con la consulta. Ponerse en contacto con el administrador.';
          this.loadingQuery = false;
        }
      );
    }
  }
}
