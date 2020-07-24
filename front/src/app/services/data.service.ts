import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  projectId: number;
  private authSource = new BehaviorSubject<boolean>(false);
  isLogged = this.authSource.asObservable();

  constructor() {}

  changeState(auth: boolean) {
    this.authSource.next(auth);
  }

  getLoggedValue(): boolean {
    return this.authSource.getValue();
  }

  setProjectId(num: number){
    this.projectId = num;
  }
  getProjectId(){
    return this.projectId;
  }
}
