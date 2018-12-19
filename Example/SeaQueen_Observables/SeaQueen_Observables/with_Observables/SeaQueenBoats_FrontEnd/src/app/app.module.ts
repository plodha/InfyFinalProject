import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BoatsComponent } from './boats.component';
import { BoatDetailsComponent } from './boat-details/boat-details.component';
import { DaysPipe } from './boat-details/days.pipe';
import { BoatService } from './boat.service';
import { HttpModule } from '@angular/http';
import { BoatUpdateComponent } from './boat-update/boat-update.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { BoatAddComponent } from './boat-add/boat-add.component'
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,BoatsComponent, BoatDetailsComponent, DaysPipe, BoatUpdateComponent, BoatAddComponent
  ],
  imports: [
    BrowserModule,HttpModule,FormsModule,ReactiveFormsModule,AppRoutingModule
  ],
  providers: [BoatService],
  bootstrap: [AppComponent]
})
export class AppModule { }
