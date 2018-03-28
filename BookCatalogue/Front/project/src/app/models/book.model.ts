export class Book {
  public bookid: number;
  public name: string;
  public author: string;
  public year: number;

  constructor(bookid: number, name: string, author: string, year: number) {
    this.bookid = bookid;
    this.name = name;
    this.author = author;
    this.year = year;
  }
}
