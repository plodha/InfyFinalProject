import { Component, OnInit, Input } from '@angular/core';
import { Boat } from '../boat';
import { BoatService } from '../boat.service';

@Component({
  selector: 'update-boat',
  templateUrl: './boat-update.component.html',
  styleUrls: ['./boat-update.component.css']
})
export class BoatUpdateComponent implements OnInit {
  @Input()
  private receivedBoat: Boat;
  private boatToUpdate:Boat;
  private locations:string[];
  private boatTypes: string[];
  
  constructor(private boatService:BoatService) {
  
 
  }

  ngOnInit() 
  {
    this.boatToUpdate = new Boat();  
  this.boatToUpdate.allowedDays = this.receivedBoat.allowedDays;  
  this.boatToUpdate.basePrice = this.receivedBoat.basePrice;  
  this.boatToUpdate.boatId = this.receivedBoat.boatId;  
  this.boatToUpdate.boatType = this.receivedBoat.boatType;  
  this.boatToUpdate.bookingStart = this.receivedBoat.bookingStart;  
  this.boatToUpdate.description = this.receivedBoat.description;  
  this.boatToUpdate.discount = this.receivedBoat.discount;  
  this.boatToUpdate.location = this.receivedBoat.location;  
  this.boatToUpdate.message = this.receivedBoat.message;
  this.boatService.getLocations().subscribe(locationData=>this.locations=locationData)
  this.boatService.getBoatTypes().subscribe(boats=>this.boatTypes=boats)
  
  }

  updateBoatDetails() {    
   // alert(JSON.stringify(this.boatToUpdate)); //Line 1 
   this.boatService.updateBoat(this.boatToUpdate).subscribe(response=>this.boatToUpdate=response)   
}
}
