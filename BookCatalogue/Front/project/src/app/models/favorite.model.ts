export class Favorite {
  public bookid: number;
  public bookname: string;
  public bookauthor: string;
  public bookyear: number;

  constructor( bookId: number, bookName: string, bookAuthor: string, bookYear: number) {
    this.bookid = bookId;
    this.bookname = bookName;
    this.bookauthor = bookAuthor;
    this.bookyear = bookYear;
  }
}

