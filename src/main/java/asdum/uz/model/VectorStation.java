package asdum.uz.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Mirjalol
 * Date: 28.12.13
 * Time: 1:41
 * To change this template use File | Settings | File Templates.
 */
public class VectorStation implements Serializable{
    private String stop_name;
    private Integer side;
    private Integer prosent;
    private String timedif;
    private String routeId;
    private Integer stationId;
    private Double distance;
    private Integer stopType;
    private String park;

    public VectorStation(String stop_name, Integer side, Integer prosent, Integer stopType, String park, String routeId) {
        this.stop_name = stop_name;
        this.side = side;
        this.prosent = prosent;
        this.stopType = stopType;
        this.park = park;
        this.routeId = routeId;
    }

    public VectorStation() {

    }

    public String getStop_name() {
        return stop_name;
    }

    public void setStop_name(String stop_name) {
        this.stop_name = stop_name;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

    public Integer getProsent() {
        return prosent;
    }

    public void setProsent(Integer prosent) {
        this.prosent = prosent;
    }

    public String getTimedif() {
        return timedif;
    }

    public void setTimedif(String timedif) {
        this.timedif = timedif;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getStopType() {
        return stopType;
    }

    public void setStopType(Integer stopType) {
        this.stopType = stopType;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }
}
