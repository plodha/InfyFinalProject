import { AbstractControl, ValidationErrors } from "@angular/forms";


export class AddBoatValidators{
    static allowedDaysValue(control : AbstractControl):ValidationErrors|null{        
        let inputValue:number=control.value as number;        
        if(inputValue<1 || inputValue>7){        
            return {"allowedDaysValue":true};        
        }
        return null;
    }
}