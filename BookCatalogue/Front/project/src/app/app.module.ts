import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { BooksComponent } from './books/books.component';
import { FavoritesComponent } from './favorites/favorites.component';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {HttpClientModule} from '@angular/common/http';

const appRoutes: Routes = [
  {path: 'loggedIn', component: BooksComponent },
  {path: '', component: LoginComponent },
  {path: 'favorites', component: FavoritesComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    BooksComponent,
    FavoritesComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
