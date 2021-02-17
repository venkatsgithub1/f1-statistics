import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DriverComponent } from './driver/driver.component';

const routes: Routes = [{ component: DashboardComponent, path: 'dashboard' },
{ path: 'driversInfo', component: DriverComponent, pathMatch: 'full' },
{ pathMatch: 'full', redirectTo: '/dashboard', path: '' }];

@NgModule({
  imports: [RouterModule.forRoot(routes, {})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
