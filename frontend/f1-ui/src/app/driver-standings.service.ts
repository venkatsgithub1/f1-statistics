import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DriverConstructors } from './structures/driver-constructors';
import { DriverStandingsAcrossTheYears } from './structures/driver-standings-over-the-years';
import { WorldDriversChampions } from './structures/world-drivers-champions';

@Injectable({
  providedIn: 'root'
})

export class DriverStandingsService {

  COMMON_URL = 'http://' + window.location.hostname + ':4200/';
  API = 'f1/api/';
  worldChampionsUrl = this.COMMON_URL + 'f1/api/worldDriverChampions';
  driverStandingsAcrossTheYearsUrl = this.COMMON_URL + 'f1/api/driverStandingsOverTheYears';
  driverConstructorsUrl = this.COMMON_URL + this.API + 'driverConstructors';
  driverChampionshipYearsUrl = this.COMMON_URL + this.API + 'driverChampionshipYears/';

  constructor(private http: HttpClient) { }

  getWorldDriversChampions(): Observable<WorldDriversChampions[]> {
    return this.http.get<WorldDriversChampions[]>(this.worldChampionsUrl);
  }

  getDriverStandingsAcrossTheYears(driverId: number): Observable<DriverStandingsAcrossTheYears[]> {
    return this.http.get<DriverStandingsAcrossTheYears[]>(this.driverStandingsAcrossTheYearsUrl + "/" + driverId);
  }

  getDriverConstructors(driverId: number): Observable<DriverConstructors[]> {
    return this.http.get<DriverConstructors[]>(this.driverConstructorsUrl + "/" + driverId);
  }

  getDriverChampionshipYears(driverId: number): Observable<number[]> {
    return this.http.get<number[]>(this.driverChampionshipYearsUrl + "/" + driverId);
  }
}
