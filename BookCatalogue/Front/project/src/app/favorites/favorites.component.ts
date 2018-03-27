import {Component, EventEmitter, Injectable, OnInit, Output} from '@angular/core';
import {Http} from '@angular/http';
import {Book} from '../models/book.model';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
@Injectable()
export class FavoritesComponent implements OnInit {
  Favorites: Book [] = [];

  constructor(private http: Http) {
    this.http.get('http://localhost:8080/api/getFav').subscribe(
      (data) => {
        var json = data.json();
        for (let j of json) {
          this.Favorites.push(new Book(j.bookid, j.bookname, j.bookauthor, j.bookyear));
        }
      },
      error => {
        console.error(error);
      }
    );
  }

  ngOnInit() {
  }

  onRemove(favorite: Book) {
    this.http.post('http://localhost:8080/api/removeFav', favorite).subscribe(
      data => {
        for (let f = 0; f < this.Favorites.length; f++)
          if (this.Favorites[f] === favorite)
            this.Favorites.splice(f, 1);
      },
      error => {
        console.error(error);
      }
    );
  }

}
