import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JobsComponent } from './jobs/jobs.component';
import { ProjectsComponent } from './projects/projects.component';
import { ProjectComponent } from './project/project.component';
import { UserComponent } from './user/user.component';
import { ListProjectComponent } from './list-project/list-project.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  {
    path: 'jobs',
    component: JobsComponent
  },
  {
    path: 'projects',
    component: ProjectsComponent
  },
  {
    path: 'project',
    component: ProjectComponent
  },
  {
    path: 'user',
    component: UserComponent,
    
  },
  {
    path: 'list-project',
    component: ListProjectComponent,
    
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    component: WelcomeComponent
    
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
