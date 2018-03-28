import {Component, EventEmitter, Injectable, OnInit, Output} from '@angular/core';
import {Book} from '../models/book.model';
import {HttpHeaders, HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
@Injectable()
export class FavoritesComponent implements OnInit {
  Favorites: Book [] = [];
  headers = new HttpHeaders({'Content-type': 'application/json; charset=utf-8'});

  constructor(private http: HttpClient) {
    this.http.get<any>('http://localhost:8080/api/getFav', {headers: this.headers}).subscribe(
      (data) => {
        this.Favorites = data;
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
