import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AllRestsComponent } from './all-rests/all-rests.component'; // <-- import FormsModule.
import { NewRestComponent } from './new-rest/new-rest.component'; // <-- import FormsModule.
import { EditRestComponent } from './edit-rest/edit-rest.component'; // <-- import FormsModule.
import { ReviewsComponent } from './reviews/reviews.component'; // <-- import FormsModule.
import { NewReviewComponent } from './new-review/new-review.component'; // <-- import FormsModule.


const routes: Routes = [
{path: 'restaurants', component: AllRestsComponent}, // home
{path: 'restaurants/new', component: NewRestComponent}, // create restaurant
{path: 'restaurants/:id/edit', component: EditRestComponent}, // edit restaurant
{path: 'restaurants/:id', component: ReviewsComponent}, // reviews
{path: 'restaurants/:id/review', component: NewReviewComponent}, // new review
{path: '', pathMatch: 'full', redirectTo: '/restaurants' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
