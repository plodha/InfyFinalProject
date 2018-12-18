import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BoatsComponent } from './boats.component';
import { BoatDetailsComponent } from './boat-details/boat-details.component';
import { BoatAddComponent } from './boat-add/boat-add.component';
import { AppComponent } from './app.component';

const routes: Routes = [
    
 { path: '', redirectTo: '/', pathMatch: 'full' },
  { path:'allBoats', component: BoatsComponent },
  { path: 'boat/:boatId', component: BoatDetailsComponent}, 
  { path: 'boatAdd', component: BoatAddComponent}
  
  
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
  

}