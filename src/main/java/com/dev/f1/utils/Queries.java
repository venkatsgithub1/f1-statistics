package com.dev.f1.utils;

public enum Queries {
    WORLD_DRIVER_CHAMPIONS_QUERY("select c.driverId driverId, b.year as year, concat(c.forename, ' ', c.surname) as driverName " +
            "             from driverstandings a inner join (select max(raceId) raceId, year " +
            "             from races group by year order by year) b on " +
            "             a.raceId=b.raceId inner join drivers c on a.driverId=c.driverId where " +
            "             a.position=1 order by b.year desc"),
    DRIVER_STANDINGS_OVER_THE_YEARS_QUERY("select c.year year, b.position position, " +
            " b.points points from drivers a join driverstandings b on " +
            " a.driverId=b.driverId join (select max(raceId) raceId, year from races group by year) " +
            " c on c.raceId=b.raceId where a.driverId=:driverId order by 1"),
    DRIVERS_WITH_ID_AND_NAMES_QUERY("select new com.dev.f1.model.DriverWithIdAndNameVO(a.driverId, " +
            " concat(a.forename,' ',a.surname)) " +
            " from Driver a where " +
            " concat(a.forename, ' ', a.surname) like :token " +
            " or concat(a.forename, a.surname) like :token "),
    DRIVERS_POSITIONS_IN_ALL_RACES("select '1' as position, " +
            " count(r.position) as times from " +
            " results r " +
            " where r.driverId=:driverId and r.position=1" +
            " union " +
            " select '2' as position, count(r.position) as times from " +
            " results r where r.driverId=:driverId and r.position=2 " +
            " union " +
            " select '3' as position, count(r.position) as times from " +
            " results r where r.driverId=:driverId and r.position=3 " +
            " union " +
            " select 'Non Podium Results' as position, count(r.position) as times from " +
            " results r " +
            " where r.driverId=:driverId and r.position>3"),
    DRIVER_WINS_QUERY("select concat(c.year, '') as year, c.wins from (" +
            " select b.year, a.wins from driverstandings a " +
            " inner join " +
            " (select max(raceId) raceId, year from races group by 2) b on " +
            " a.raceId=b.raceId " +
            " where a.driverId=:driverId " +
            " group by 1 order by 1) c"),
    DRIVER_CONSTRUCTORS_QUERY("select min(a.raceYear) startYear, max(a.raceYear) endYear, " +
            " a.constructorId,a.name constructorName from " +
            " (select max(a.date) raceDateMax, min(a.date)raceDateMin, a.year raceYear, " +
            " b.constructorId, c.name from races a " +
            " inner join results b on " +
            " a.raceId=b.raceId " +
            " inner join constructors c on " +
            " c.constructorId=b.constructorId " +
            " where b.driverId=:driverId " +
            " group by 3,4,5 " +
            " order by 3) a " +
            " group by 3 " +
            " order by 1"),
    DRIVER_CHAMPIONSHIP_YEARS(" select b.year as year " +
            "  from driverstandings a inner join (select max(raceId) raceId, year " +
            "  from races group by year order by year) b on " +
            "  a.raceId=b.raceId inner join drivers c on a.driverId=c.driverId where " +
            "  a.position=1 and a.driverId=:driverId order by b.year ");

    public String query;

    Queries(String query) {
        this.query = query;
    }
}
