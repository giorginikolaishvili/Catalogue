import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Book} from '../models/book.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
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

  constructor(private http: HttpClient) {
    this.http.get<any>('http://localhost:8080/api/getBook', {headers: this.headers}).subscribe(
      (data) => {
        this.Books = data;
      },
      error => {
        console.error(error);
      }
    );
  }

  ngOnInit() {
  }

  addFavorites(book: Book) {
    var jsonstr = {'bookid': book.bookid, 'bookname': book.name, 'bookauthor': book.author, 'bookyear': book.year};
    this.http.post('http://localhost:8080/api/addtoFav', jsonstr).subscribe(
      (data) => {
      },
      error => {
        console.error(error);
      }
    );
  }

}
