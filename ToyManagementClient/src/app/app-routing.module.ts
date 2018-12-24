import { ToyEditComponent } from './toy-edit/toy-edit.component';
import { ToyListComponent } from './toy-list/toy-list.component';
import {ToyDeleteComponent} from './toy-delete/toy-delete.component';
import { ToyNewComponent } from './toy-new/toy-new.component';
import './toy-new/toy-new.component.css';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ToyUpdateComponent } from './toy-update/toy-update.component';
import { ToyFindComponent } from './toy-find/toy-find.component';


const routes: Routes = [
  {path: '', redirectTo: '/toy-list', pathMatch: 'full' },
  {
    path: 'toy-list',
    component: ToyListComponent
  },
  {
    path: 'toy-Add',
    component: ToyNewComponent
  },

{
    path: 'toy-edit',
    component: ToyEditComponent
  },

  {
    path: 'toy-delete/:id',
    component: ToyDeleteComponent
  },
  {
    path: 'toy-updateToy/:name',
    component: ToyUpdateComponent
  },
  {
    path: 'toy-update/:id',
    component: ToyNewComponent
  },
  {
    path: 'toy-find/:name',
    component: ToyFindComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
