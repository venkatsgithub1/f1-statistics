import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDividerModule } from '@angular/material/divider';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { DriverStandingsService } from './driver-standings.service';
import { WorldChampionDetailComponent } from './world-champion-detail/world-champion-detail.component';
import { MatCardModule } from '@angular/material/card';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import { DriverComponent } from './driver/driver.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatInputModule } from '@angular/material/input';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { DriverConstructorsComponent } from './components/driver-constructors/driver-constructors.component';
import { DriverChampionshipsComponent } from './components/driver-championships/driver-championships.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    WorldChampionDetailComponent,
    DriverComponent,
    DriverConstructorsComponent,
    DriverChampionshipsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatDividerModule,
    HttpClientModule,
    MatTableModule,
    MatCardModule,
    MatPaginatorModule,
    FormsModule,
    NgxChartsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatAutocompleteModule,
    MatInputModule,
    TypeaheadModule.forRoot(),
    MatProgressSpinnerModule
  ],
  providers: [DriverStandingsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
