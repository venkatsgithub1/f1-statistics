import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Chart1 } from './structures/chart1';
import { DriverNameWithId } from './structures/dirver-name-id';
import { DriverDetails } from './structures/driver-details';
import { DriverPodiumPositions } from './structures/driver-podium-positions';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  COMMON_URL = 'http://' + window.location.hostname + ':4200/';
  PREFIX = "f1/api/";

  constructor(private http: HttpClient) { }

  getDriverDetailsById(driverId: number): Observable<DriverDetails> {
    return this.http.get<DriverDetails>(this.COMMON_URL + "drivers/" + driverId);
  }

  getAllDriversForAutoComplete(token: string): Observable<DriverNameWithId[]> {
    return this.http.get<DriverNameWithId[]>(this.COMMON_URL + "getAllDriversByToken", {
      params: new HttpParams().append('token', token)
    });
  }

  getDriverPodiumPositions(driverId: number): Observable<DriverPodiumPositions[]> {
    return this.http.get<DriverPodiumPositions[]>(this.COMMON_URL + this.PREFIX + "driverPodiumPositions/" + driverId);
  }

  getDriverWins(driverId: number): Observable<Chart1[]> {
    return this.http.get<Chart1[]>(this.COMMON_URL + this.PREFIX + "driverWins/" + driverId);
  }
}
