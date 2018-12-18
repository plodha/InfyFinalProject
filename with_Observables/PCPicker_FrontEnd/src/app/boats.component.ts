import { Component, OnInit } from "@angular/core";
import { Boat } from "./boat";
import { BOATS } from "./mock-boat";
import { BoatService } from "./boat.service";

@Component({
    selector:'boats',
   /* template:`
    <h3 style="text-align:center">
                    Showing all the operational boats across India
                </h3>
    `
    */
   templateUrl:'./boats.component.html',
   styleUrls:['./boats.component.css']
})
export class BoatsComponent implements OnInit{
    ngOnInit(): void {
     this.boatService.getAllBoats().subscribe(boats=>this.boatData=boats)
    // this.boatService.getAllBoats().then(boats=>this.boatData=boats)
    }
    boat: Boat;
boatData:Boat[];
addBoatFlag = false; //Will be used to show or hide the add boat form    
showDetailFlag = false; //Will be used to show or hide the boat detail table
selectedBoat:Boat;
show: boolean = false;
    constructor(private boatService:BoatService) {}
    showBoat(boat:Boat) {
        this.selectedBoat=boat;
        this.showDetailFlag =this.showDetailFlag ? false:true;
      //  alert("Details of " + this.boat.boatType + "\n" + this.boat.description);
    }

    // Method is used to switch the value of variable to display add boat form

addBoat():void{
    this.addBoatFlag = true;
    this.showDetailFlag = false;
}
}