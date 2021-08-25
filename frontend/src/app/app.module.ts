import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { PostsComponent } from './posts/posts.component';
import { PostsListComponent } from './posts-list/posts-list.component';
import { AlbumsListComponent } from './albums-list/albums-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PostsComponent,
    PostsListComponent,
    AlbumsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
