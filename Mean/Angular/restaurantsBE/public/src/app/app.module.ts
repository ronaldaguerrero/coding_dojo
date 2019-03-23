import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpService } from './http.service';
import { HttpClientModule } from '@angular/common/http';
import { TaskComponent } from './task/task.component';
import { FormsModule } from '@angular/forms';
import { AllRestsComponent } from './all-rests/all-rests.component';
import { NewRestComponent } from './new-rest/new-rest.component';
import { EditRestComponent } from './edit-rest/edit-rest.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { NewReviewComponent } from './new-review/new-review.component'; // <-- import FormsModule.

@NgModule({
  declarations: [
    AppComponent,
    TaskComponent,
    AllRestsComponent,
    NewRestComponent,
    EditRestComponent,
    ReviewsComponent,
    NewReviewComponent
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
