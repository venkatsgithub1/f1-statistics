import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { DriverStandingsService } from '../driver-standings.service';
import { DriverService } from '../driver.service';
import { DriverDetails } from '../structures/driver-details';
import { DriverStandingsAcrossTheYears } from '../structures/driver-standings-over-the-years';

@Component({
  selector: 'app-world-champion-detail',
  templateUrl: './world-champion-detail.component.html',
  styleUrls: ['./world-champion-detail.component.scss']
})
export class WorldChampionDetailComponent implements OnInit, OnChanges {
  @Input("driverId") driverId: number;
  @Input("championshipSeason") championshipSeason: number;
  driverDetails: DriverDetails;
  driverStandingsOverTheYearsArray: any[];
  view: any[] = [700, 200];
  showXAxis: boolean = true;
  showYAxis: boolean = true;
  gradient: boolean = false;
  showLegend: boolean = false;
  showXAxisLabel: boolean = true;
  yAxisLabel: string = 'Points';
  showYAxisLabel: boolean = true;
  xAxisLabel: string = 'Years';
  maxRadius: number = 10;
  minRadius: number = 2;
  yScaleMin: number = 0;
  rotateXAxisTicks = true;
  yScaleMax: number = 500;
  xScaleMin: number = 0;
  xScaleMax: number = 2020;

  colorScheme = {
    domain: ['red']
  };


  constructor(private driverService: DriverService, private driverStandingsService: DriverStandingsService) {
    Object.assign(this, this.driverStandingsOverTheYearsArray);
  }
  ngOnChanges(changes: SimpleChanges): void {
    if (this.driverId) {
      this.driverService.getDriverDetailsById(this.driverId).subscribe((driverDetail: DriverDetails) => {
        this.driverDetails = driverDetail;
      });

      if (this.driverId) {
        this.driverStandingsService.getDriverStandingsAcrossTheYears(this.driverId)
          .subscribe((driverResultsArray: DriverStandingsAcrossTheYears[]) => {
            this.driverStandingsOverTheYearsArray = [{
              name: this.driverDetails.forename + " " + this.driverDetails.surname,
              series: []
            }];
            driverResultsArray.forEach(driverResult => {
              let object = { 'name': driverResult.year + "", 'x': driverResult.year + "", 'r': driverResult.position, 'y': driverResult.points };
              this.driverStandingsOverTheYearsArray[0]['series'].push(object);
            });

            console.log(this.driverStandingsOverTheYearsArray);
            console.log(this.colorScheme);
          });
      }
    }
  }

  ngOnInit(): void {
  }

}
