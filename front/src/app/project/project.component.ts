import { Component, OnInit, Input } from '@angular/core';
import { RequestService } from '../services/request.service';
import {Project} from '../model/project.model';
import {Comment} from '../model/comment.model';
import { DataService } from '../services/data.service';
@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {
  projectId: number;
project: Project;
comments: Comment[];

  constructor(private service: RequestService, private data: DataService) { }

  ngOnInit(): void {
    this.projectId = this.data.getProjectId();
    this.service.getRequest('project/' + this.projectId).subscribe((pr) => {
      this.project = pr; console.log(pr); console.log("Id: " + this.projectId);
    }, (err) => {
      console.log(err);
    });

    this.service.getRequest('comments/' + this.projectId).subscribe((pr) => {
      this.comments = pr; console.log(pr); console.log("Id: " + this.projectId);
    }, (err) => {
      console.log(err);
    });
    
  }

}
