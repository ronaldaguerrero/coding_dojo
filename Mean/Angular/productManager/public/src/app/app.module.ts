import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { HttpService } from './http.service';
import { HttpClientModule } from '@angular/common/http';
import { TaskComponent } from './task/task.component';
import { FirstRouteComponent } from './first-route/first-route.component';
import { SecondRouteComponent } from './second-route/second-route.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ThirdRouteComponent } from './third-route/third-route.component';
import { FourthRouteComponent } from './fourth-route/fourth-route.component';
import { EditProductComponent } from './first-route/edit-product/edit-product.component';
import { NewProductComponent } from './first-route/new-product/new-product.component';

@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    FirstRouteComponent,
    SecondRouteComponent,
    PageNotFoundComponent,
    ThirdRouteComponent,
    FourthRouteComponent,
    EditProductComponent,
    NewProductComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
