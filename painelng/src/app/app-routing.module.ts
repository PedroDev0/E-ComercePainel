import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DialogService } from 'primeng/dynamicdialog';

const routes: Routes = [

  {
    path: '',
    loadChildren: () => import("./modules/modules.module").then(m => m.ModulesModule),
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    DialogService
  ]
})
export class AppRoutingModule { }
