import { Author } from "./author";
import { Editorial } from "./editorial";

export interface Book {
  idBook: number;
  title: string;
  year: number;
  genre: string;
  pages: number;
  author: Author;
  editorial: Editorial;
}
