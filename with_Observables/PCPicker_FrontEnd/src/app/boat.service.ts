import { Injectable } from '@angular/core';
import { Boat } from './boat';
import { Http } from '@angular/http';
import { Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/of';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

@Injectable()
export class BoatService {
  boatList: Boat[];
  private headers = new Headers({'Content-Type': 'application/json'} ); //Line 1
  
  constructor(private http:Http) {  
  }

  getAllBoats(): Observable<Boat[]> {    
    return this.http.get('http://localhost:1243/SeaQueenBoats/sqbBoats/boatsAll')                  
              .map(response => response.json() as Boat[])    
              .catch(this.errorHandler);    
  }
    getBoatDetails (boatId:string): Observable<Boat> {
      return this.http.get('http://localhost:1243/SeaQueenBoats/sqbBoats/boatDetail/'+boatId)
                      .map(response => (response.json() as Boat))
                      .catch(this.errorHandler);
    }
    addBoat(boatToAdd:Boat): Observable<Boat>{      
      const url='http://localhost:1243/SeaQueenBoats/sqbBoats/boatAdd';
      
      return this.http.post(url, JSON.stringify(boatToAdd), {headers:this.headers} )//Line 1      
                      .map((response)=> <Boat> response.json()) //Line 3      
                      .catch(this.errorHandler); //Line 4      
    }

    updateBoat(updatedBoat:Boat):Observable<Boat> {
      const url = 'http://localhost:1243/SeaQueenBoats/sqbBoats/boatUpdate'; //Line 2
      return this.http.put(url, JSON.stringify(updatedBoat), {headers: this.headers}) //Line 3
      .map((res) => res.json() as Boat
      ).catch(this.errorHandler);
  }
  
    
    private errorHandler(error:any):Observable<any> {    
    return Observable.throw(error.message || error);    
    }
    getLocations(): Observable<string[]> { 
      return Observable.of(['Allepey', 'Kumarkom', 'Srinagar', 'Goa', 'Kochi', 'Asan Barrage']);
    }

    getBoatTypes(): Observable<string[]> {      
      return Observable.of(['Houseboat', 'Cruiser', 'Bass Boat', 'Speed Boat', 'Power Catamaran']);
    }
}





// updateBoat() --> updateBoatDetails() --> BoatUpdateComponent <boat-update>
// addBoat() --> addBoatDetails() -- BoatAddComponent <boat-add>