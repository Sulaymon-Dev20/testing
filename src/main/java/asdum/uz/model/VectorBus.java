package asdum.uz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Mirjalol
 * Date: 28.12.13
 * Time: 18:00
 * To change this template use File | Settings | File Templates.
 */
public class VectorBus implements Serializable {
    private String input_time;
    private Date time;
    private Long busID;
    private Integer reyscount;
    private String gos_no;
    private Integer side;
    private Integer prosent;
    private Integer onoff;
    private Long m;
    private Double int_km;
    private Integer int_min;
    private Double mileage;
    private Integer polygonType;
    private long prostoy;
    private String stationName;
    private Integer speed;
    private String model;
    private String modelNameInUz;
    private Integer stopType;

    /**
     * Gets stop type.
     *
     * @return the stop type
     */
    public Integer getStopType() {
        return stopType;
    }

    /**
     * Sets stop type.
     *
     * @param stopType the stop type
     */
    public void setStopType(Integer stopType) {
        this.stopType = stopType;
    }

    /**
     * Gets input time.
     *
     * @return the input time
     */
    public String getInput_time() {
        return input_time;
    }

    /**
     * Sets input time.
     *
     * @param input_time the input time
     */
    public void setInput_time(String input_time) {
        this.input_time = input_time;
    }

    /**
     * Gets bus id.
     *
     * @return the bus id
     */
    public Long getBusID() {
        return busID;
    }

    /**
     * Sets bus id.
     *
     * @param busID the bus id
     */
    public void setBusID(Long busID) {
        this.busID = busID;
    }

    /**
     * Gets reyscount.
     *
     * @return the reyscount
     */
    public Integer getReyscount() {
        return reyscount;
    }

    /**
     * Sets reyscount.
     *
     * @param reyscount the reyscount
     */
    public void setReyscount(Integer reyscount) {
        this.reyscount = reyscount;
    }

    /**
     * Gets gos no.
     *
     * @return the gos no
     */
    public String getGos_no() {
        return gos_no;
    }

    /**
     * Sets gos no.
     *
     * @param gos_no the gos no
     */
    public void setGos_no(String gos_no) {
        this.gos_no = gos_no;
    }

    /**
     * Gets side.
     *
     * @return the side
     */
    public Integer getSide() {
        return side;
    }

    /**
     * Sets side.
     *
     * @param side the side
     */
    public void setSide(Integer side) {
        this.side = side;
    }

    /**
     * Gets prosent.
     *
     * @return the prosent
     */
    public Integer getProsent() {
        return prosent;
    }

    /**
     * Sets prosent.
     *
     * @param prosent the prosent
     */
    public void setProsent(Integer prosent) {
        this.prosent = prosent;
    }

    /**
     * Gets onoff.
     *
     * @return the onoff
     */
    public Integer getOnoff() {
        return onoff;
    }

    /**
     * Sets onoff.
     *
     * @param onoff the onoff
     */
    public void setOnoff(Integer onoff) {
        this.onoff = onoff;
    }

    /**
     * Gets m.
     *
     * @return the m
     */
    public Long getM() {
        return m;
    }

    /**
     * Sets m.
     *
     * @param m the m
     */
    public void setM(Long m) {
        this.m = m;
    }

    /**
     * Gets int km.
     *
     * @return the int km
     */
    public Double getInt_km() {
        return int_km;
    }

    /**
     * Sets int km.
     *
     * @param int_km the int km
     */
    public void setInt_km(Double int_km) {
        this.int_km = int_km;
    }

    /**
     * Gets int min.
     *
     * @return the int min
     */
    public Integer getInt_min() {
        return int_min;
    }

    /**
     * Sets int min.
     *
     * @param int_min the int min
     */
    public void setInt_min(Integer int_min) {
        this.int_min = int_min;
    }

    /**
     * Gets mileage.
     *
     * @return the mileage
     */
    public Double getMileage() {
        return mileage;
    }

    /**
     * Sets mileage.
     *
     * @param mileage the mileage
     */
    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    /**
     * Sets polygon type.
     *
     * @param polygonType the polygon type
     */
    public void setPolygonType(Integer polygonType) {
        this.polygonType = polygonType;
    }

    /**
     * Gets polygon type.
     *
     * @return the polygon type
     */
    public Integer getPolygonType() {
        return polygonType;
    }

    /**
     * Sets prostoy.
     *
     * @param prostoy the prostoy
     */
    public void setProstoy(long prostoy) {
        this.prostoy = prostoy;
    }

    /**
     * Gets prostoy.
     *
     * @return the prostoy
     */
    public long getProstoy() {
        return prostoy;
    }

    /**
     * Sets station name.
     *
     * @param stationName the station name
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * Gets station name.
     *
     * @return the station name
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public Integer getSpeed() {
        return speed;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model name in uz.
     *
     * @param modelNameInUz the model name in uz
     */
    public void setModelNameInUz(String modelNameInUz) {
        this.modelNameInUz = modelNameInUz;
    }

    /**
     * Gets model name in uz.
     *
     * @return the model name in uz
     */
    public String getModelNameInUz() {
        return modelNameInUz;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Date time) {
        this.time = time;
    }
}
