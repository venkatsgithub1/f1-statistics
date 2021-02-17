import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { DriverStandingsService } from 'src/app/driver-standings.service';
import { DriverNameWithId } from 'src/app/structures/dirver-name-id';
import { DriverConstructors } from 'src/app/structures/driver-constructors';

@Component({
  selector: 'app-driver-constructors',
  templateUrl: './driver-constructors.component.html',
  styleUrls: ['./driver-constructors.component.scss']
})
export class DriverConstructorsComponent implements OnInit, OnChanges {

  @Input("driverId") driverDetail: DriverNameWithId;
  @Input("driverName") driverName: string;
  dataSource: DriverConstructors[];
  displayedColumns = ['Constructor', 'From', 'Till'];

  constructor(private driverStandingsService: DriverStandingsService) { }

  ngOnInit(): void {
  }
  ngOnChanges(): void {
    if (this.driverDetail) {
      this.driverStandingsService.getDriverConstructors(this.driverDetail.driverId).subscribe(
        resultsArray => {
          this.dataSource = resultsArray;
        }
      );
    }
  }

}
