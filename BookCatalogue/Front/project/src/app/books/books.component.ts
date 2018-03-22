import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Book} from '../models/book.model';
import {HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
@Injectable()
export class BooksComponent implements OnInit {
  Books: Book[] = [];

  headers = new HttpHeaders({'Content-type': 'application/json; charset=utf-8'});

  constructor(private http: Http) {
    this.http.get('http://localhost:8080/api/getBook').subscribe(
      (data) => {
        var json = data.json();
        for (let j of json) {
          this.Books.push(new Book(j.bookid, j.bookname, j.bookauthor, j.bookyear));
        }
      },
      error => {
        console.error(error);
      }
    );
  }

  ngOnInit() {
  }

  addFavorites(book: Book) {
    var jsonstr = {'bookid': book.bookId, 'bookname': book.bookName, 'bookauthor': book.bookAuthor, 'bookyear': book.bookYear};
      this.http.post('http://localhost:8080/api/addtoFavorites', jsonstr).subscribe(
        (data) => {
        },
        error => {
          console.error(error);
        }
      );
  }

}
