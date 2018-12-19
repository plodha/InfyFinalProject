import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'days'
})
export class DaysPipe implements PipeTransform {

  transform(days:number): string {
    if(days==null)
    {
  return "No Limit"
    }
    else{
      return days+" consecutive days allowed"
    }
  }

}
