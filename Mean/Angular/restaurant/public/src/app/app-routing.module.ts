import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FirstRouteComponent } from './first-route/first-route.component';
import { SecondRouteComponent } from './second-route/second-route.component';
import { ThirdRouteComponent } from './third-route/third-route.component';
import { FourthRouteComponent } from './fourth-route/fourth-route.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
// import { EditProductComponent } from './first-route/edit-product/edit-product.component';
import { NewProductComponent } from './first-route/new-product/new-product.component';

const routes: Routes = [
	{path: 'first-route', component: FirstRouteComponent}, // home
	{path: 'second-route', component: SecondRouteComponent}, // restaurant list
	// {path: 'second-route/edit/:id', component: EditProductComponent},
	{path: 'third-route', component: ThirdRouteComponent}, // restaurant creation
	// {path: 'fourth-route', component: FourthRouteComponent, children:[
	// {path:'edit/:id', component: EditProductComponent}]}, 
	// {path: '', pathMatch: 'full', redirectTo: '/first-route'},
	// {path: '**', redirectTo: '/first-route'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
