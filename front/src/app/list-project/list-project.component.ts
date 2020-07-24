import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-list-project',
  templateUrl: './list-project.component.html',
  styleUrls: ['./list-project.component.css']
})
export class ListProjectComponent implements OnInit {
  interestList = [
    {value:1},{value:2},{value:3},{value:4},{value:5}]
  projectForm: FormGroup;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.projectForm = this.formBuilder.group({
      title: ['',
        [Validators.required, Validators.maxLength(30)]
      ],
      summary: ['', [Validators.required, Validators.maxLength(100)]],
      description: ['', Validators.required],
      goal: ['', [Validators.required, Validators.pattern(/[0-9]+/), Validators.min(1)]],
      interest: ['', Validators.required]
    });
    this.projectForm.valueChanges.subscribe(console.log);
  }

  newProject() {

  }

  get title() {
    return this.projectForm.get('title');
  }

  get summary() {
    return this.projectForm.get('summary');
  }
  get description() {
    return this.projectForm.get('description');
  }
  get goal() {
    return this.projectForm.get('goal');
  }

  get interest() {
    return this.projectForm.get('interest');
  }
}
