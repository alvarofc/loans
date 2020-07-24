import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';
import { DataService } from '../services/data.service';
@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
projects = [];
projectId: number;

  constructor(private service: RequestService, private data: DataService) { }

  ngOnInit(): void {
    this.service.getRequest('projects').subscribe((pr) => {
      this.projects = pr;
    }, (err) => {
      console.log(err);
    })
  }

  setProjectId(num: number){
    this.data.setProjectId(num);
    console.log(num);
  }

}
