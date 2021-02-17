import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { DriverStandingsService } from 'src/app/driver-standings.service';
import { DriverNameWithId } from 'src/app/structures/dirver-name-id';

@Component({
  selector: 'app-driver-championships',
  templateUrl: './driver-championships.component.html',
  styleUrls: ['./driver-championships.component.scss']
})
export class DriverChampionshipsComponent implements OnInit, OnChanges {

  @Input("driverId") driverDetail: DriverNameWithId;
  years: number[];

  constructor(private driverStandingsService: DriverStandingsService) { }

  ngOnInit(): void {
  }

  ngOnChanges(): void {
    if (this.driverDetail) {
      this.driverStandingsService.getDriverChampionshipYears(this.driverDetail.driverId).subscribe(result => {
        this.years = result;
      })
    }
  }

}
