package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "waypoint")
public class Waypoint extends AbstractEntity {

    @Column(name = "ele")
    private BigDecimal ele;

    @Column(name = "time")
    private LocalDateTime time;

    @Column(name = "name")
    private String name;

    @Column(name = "sym")
    private String sym;

    @Column(name = "lat")
    private BigDecimal lat;

    @Column(name = "lon")
    private BigDecimal lon;

    @ManyToOne
    @JoinColumn(name="gps_id", nullable=false)
    private GPS gpsWpt;

    public BigDecimal getEle() {
        return ele;
    }

    public void setEle(BigDecimal ele) {
        this.ele = ele;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSym() {
        return sym;
    }

    public void setSym(String sym) {
        this.sym = sym;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waypoint waypoint = (Waypoint) o;
        return Objects.equals(ele, waypoint.ele) && Objects.equals(time, waypoint.time) && Objects.equals(name, waypoint.name) && Objects.equals(sym, waypoint.sym) && Objects.equals(lat, waypoint.lat) && Objects.equals(lon, waypoint.lon) && Objects.equals(gpsWpt, waypoint.gpsWpt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ele, time, name, sym, lat, lon, gpsWpt);
    }
}
