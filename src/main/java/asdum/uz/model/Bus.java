package asdum.uz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mirjalol
 * Date: 17.12.13
 * Time: 2:25
 * To change this template use File | Settings | File Templates.
 */
public class Bus implements Serializable {
    private Integer id;
    private String gostNo;
    private String parkNo;
    private String trackerID;
    private String route;
    private Integer routeId;
    private String model;
    private String modelNameInUz;
    private Integer modelId;
    private String licenseNumber;
    private String remark;
    private String lastUserName;
    private String lastDate;
    private String driver_short;
    private String driver;
    private String parkName;
    private String routeName;
    private String gos;
    private Date fromTime;

    public String getDriver_short() {
        return driver_short;
    }

    public void setDriver_short(String driver_short) {
        this.driver_short = driver_short;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    private Integer parkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGostNo() {
        return gostNo;
    }

    public void setGostNo(String gostNo) {
        this.gostNo = gostNo;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }

    public String getTrackerID() {
        return trackerID;
    }

    public void setTrackerID(String trackerID) {
        this.trackerID = trackerID;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModelNameInUz(String modelNameInUz) {
        this.modelNameInUz = modelNameInUz;
    }

    public String getModelNameInUz() {
        return modelNameInUz;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLastUserName() {
        return lastUserName;
    }

    public void setLastUserName(String lastUserName) {
        this.lastUserName = lastUserName;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkName() {
        return parkName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setGos(String gos) {
        this.gos = gos;
    }

    public String getGos() {
        return gos;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getFromTime() {
        return fromTime;
    }
}
