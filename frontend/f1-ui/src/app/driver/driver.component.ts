import { Component, OnInit } from '@angular/core';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';
import { Observable, Observer, of } from 'rxjs';
import { switchMap, map, debounceTime } from 'rxjs/operators';
import { DriverService } from '../driver.service';
import { Chart1 } from '../structures/chart1';
import { DriverNameWithId } from '../structures/dirver-name-id';
import { DriverPodiumPositions } from '../structures/driver-podium-positions';

@Component({
  selector: 'app-driver',
  templateUrl: './driver.component.html',
  styleUrls: ['./driver.component.scss']
})
export class DriverComponent implements OnInit {

  textBeingWritten: string;
  driverIdInContext: DriverNameWithId;
  results: DriverNameWithId[];
  dataSource$: Observable<DriverNameWithId[]>;
  pieChartAttributes: any = {
    'view': [500, 400],
    'colorScheme': {
      'domain': ['#FFD700', '#C0C0C0', '#CD7F32', 'blue']
    },
    'data': [],
    'loading': true,
    'loadSpinner': false,
    'gradient': true,
    'showLegend': true,
    'showLabels': true,
    'isDoughnut': false,
    'explodeSlices': false,
    'animations': true
  };

  verticalBarChartAttributes: any = {
    'view': [800, 400],
    'colorScheme': {
      'domain': ['red']
    },
    'data': [],
    'loading': true,
    'loadSpinner': false,
    'gradient': true,
    'showLegend': false,
    'showXAxis': true,
    'showYAxis': true,
    'showXAxisLabel': true,
    'showYAxisLabel': true,
    'xAxisLabel': 'Years',
    'noBarWhenZero': false,
    'numberWins': 0,
    'yAxisLabel': 'Wins',
    'animations': true,
    'rotateXAxisTicks': true
  };

  constructor(private driverService: DriverService) { }
  ngOnInit(): void {
    this.dataSource$ = new Observable((observer: Observer<string>) => {
      observer.next(this.textBeingWritten);
    }).pipe(
      switchMap((query: string) => {
        if (query) {
          return this.driverService.getAllDriversForAutoComplete(query).pipe(
            debounceTime(200),
            map(temp => {
              this.results = temp;
              if (temp.length == 0) {
                return [];
              }
              return this.results;
            })
          )
        }
        return of([]);
      })
    );
  }

  onSelect(data: TypeaheadMatch) {
    console.log("on select here");
    console.log(data.item);
    this.pieChartAttributes['loading'] = true;
    this.pieChartAttributes['loadSpinner'] = true;
    this.driverIdInContext = data.item;
    this.driverService.getDriverPodiumPositions(data.item['driverId']).subscribe((temp: DriverPodiumPositions[]) => {
      this.pieChartAttributes['data'] = temp;
      this.pieChartAttributes['loading'] = false;
      this.pieChartAttributes['loadSpinner'] = false;
    });

    this.verticalBarChartAttributes['loading'] = true;
    this.verticalBarChartAttributes['loadSpinner'] = true;
    this.verticalBarChartAttributes['numberWins'] = 0;
    this.driverService.getDriverWins(data.item['driverId']).subscribe((temp: Chart1[]) => {
      this.verticalBarChartAttributes['data'] = temp;
      temp.forEach(data => this.verticalBarChartAttributes.numberWins += data.value);
      this.verticalBarChartAttributes['loading'] = false;
      this.verticalBarChartAttributes['loadSpinner'] = false;
    });
  }

}
