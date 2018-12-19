import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AddBoatValidators } from './boat-add.validator';
import { Boat } from '../boat';
import { BoatService } from '../boat.service';
import { Router } from '@angular/router';

@Component({
  selector: 'boat-add',
  templateUrl: './boat-add.component.html',
  styleUrls: ['./boat-add.component.css']
})
export class BoatAddComponent implements OnInit {

   boatAddForm:FormGroup;
   message:String;
   private locations: string[];
   private boatTypes: string[];
   constructor(private fb:FormBuilder, private boatService:BoatService, private router:Router){
    this.createForm();
  }

  addBoat(){ 
    let boatToAdd:Boat=this.boatAddForm.value as Boat; //Line 1
    this.boatService.addBoat(boatToAdd) //Line 2
    .subscribe( (response) => this.message= response.message+" with id: "+ response.boatId );
    
     //Line 3
   }
   gotoDetail():void{
    this.router.navigate(['/allBoats']);
   }
   

  createForm(){    
    this.boatAddForm=this.fb.group({    
      boatId:'',
      boatType: [null, Validators.required ],
      location: [null, Validators.required ],
      description: [null, Validators.compose([Validators.required, Validators.maxLength(300), Validators.pattern(".{1,300}.[^\r]") ])  ],
      basePrice: [null, Validators.compose( [ Validators.required, Validators.min(1000),Validators.max(100000)] ) ],
      allowedDays: [null, Validators.compose([Validators.required, Validators.min(1),Validators.max(7)]) ],
      discount: [null, Validators.compose([Validators.min(0.00),Validators.max(0.95)])],
      bookingStart:null    
    });    
 }
 

  ngOnInit() {
    this.boatService.getLocations().subscribe(    
      result => {    
      this.locations = result    
    });  
    this.boatService.getBoatTypes().subscribe(    
      result => {    
      this.boatTypes = result;    
    });
  }

}
