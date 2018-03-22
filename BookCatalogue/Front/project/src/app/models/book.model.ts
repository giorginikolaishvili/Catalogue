export class Book {
  public bookId: number;
  public bookName: string;
  public bookAuthor: string;
  public bookYear: number;

  constructor( bookId: number, bookName: string, bookAuthor: string, bookYear: number) {
    this.bookId = bookId;
    this.bookName = bookName;
    this.bookAuthor = bookAuthor;
    this.bookYear = bookYear;
  }
}
