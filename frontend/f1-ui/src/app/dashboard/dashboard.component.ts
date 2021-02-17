import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { DriverStandingsService } from '../driver-standings.service';
import { WorldDriversChampions } from '../structures/world-drivers-champions';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit, AfterViewInit {

  worldChampions: WorldDriversChampions[];
  displayedColumns: string[] = ['Season', 'Driver Name'];
  @ViewChild(MatPaginator) paginator: MatPaginator;
  dataSource: MatTableDataSource<WorldDriversChampions>;
  driverIdSelected: number;
  championshipSeason: number;

  constructor(private driversStandingsService: DriverStandingsService) { }
  ngAfterViewInit(): void {

  }

  ngOnInit(): void {
    this.driversStandingsService.getWorldDriversChampions().subscribe((worldChampions: WorldDriversChampions[]) => {
      this.worldChampions = worldChampions;
      this.worldChampions.sort((a, b) => a.year - b.year);
      this.driverIdSelected = this.worldChampions[0].driverId;
      this.championshipSeason = this.worldChampions[0].year;
      for (var i = 0; i < this.worldChampions.length; i++) {
        this.worldChampions[i].position = i + 1;
      }
      this.dataSource = new MatTableDataSource<WorldDriversChampions>(this.worldChampions);
      this.dataSource.paginator = this.paginator;
    });
  }

  fixSelectedDriverId(data: WorldDriversChampions) {
    this.driverIdSelected = data.driverId;
    this.championshipSeason = data.year;
  }

}
