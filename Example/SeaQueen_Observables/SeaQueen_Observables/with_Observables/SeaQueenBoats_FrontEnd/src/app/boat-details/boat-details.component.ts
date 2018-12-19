import { Component, OnInit, Input } from '@angular/core';
import { Boat } from '../boat';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
import 'rxjs/add/operator/switchMap';
import { BoatService } from '../boat.service';

@Component({
  selector: 'boat-details',
  templateUrl: './boat-details.component.html',
  styleUrls: ['./boat-details.component.css']
})
export class BoatDetailsComponent implements OnInit {
  @Input()
  chosenBoat:Boat;
display:boolean=true;   
updateCheck:boolean=false;
constructor(private boatService: BoatService,private router: Router, 
  private route:ActivatedRoute) {      
}

  ngOnInit():void {
    this.chosenBoat = new Boat();
    this.route.paramMap
              .switchMap( (params: ParamMap) => this.boatService.getBoatDetails(params.get('boatId') ) )
              .subscribe(boat => {this.chosenBoat = boat; });              
}

  modifyVariablesOnClick(){
    this.display=false;
    this.updateCheck=true;
    }

}
