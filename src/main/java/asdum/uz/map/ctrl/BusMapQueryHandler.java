package asdum.uz.map.ctrl;

import asdum.uz.config.CacheConfig;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.Root2;
import asdum.uz.map.model.enums.BusStopStatusEnum;
import asdum.uz.map.test.Test2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusMapQueryHandler {

    @Autowired
    CacheConfig cacheConfig;

    private static BusMapQueryHandler INSTANCE = new BusMapQueryHandler();

    private BusMapQueryHandler() {
    }

    public static BusMapQueryHandler getInstance() {
        return INSTANCE;
    }

    public List<BusStop> getBusStop(Double latitudeStr, Double longitudeStr) {
        List<BusStop> queryResult = BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL);
        List<BusStop> response = new ArrayList<>();
        if (latitudeStr != null && longitudeStr != null) {
            try {
                double radius = 0.3;
                do {
                    response = getBusMapInsideCircle(queryResult, latitudeStr, longitudeStr, radius);
                    radius = radius + 0.3;
                } while (response.size() <= 10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    public Root2 toAtoB(double aPointLat, double aPointLng, double bPointLat, double bPointLng) {
        List<BusStop> allBusStop = BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL);
        if (aPointLng != 0 && aPointLat != 0 && bPointLng != 0 && bPointLat != 0) {
            try {
                List<BusStop> aPointQueryResult;
                List<BusStop> bPointQueryResult;
                double v = 0.5;
                do {
                    aPointQueryResult = getBusMapInsideCircle(allBusStop, aPointLat, aPointLng, v);
                    bPointQueryResult = getBusMapInsideCircle(allBusStop, bPointLat, bPointLng, v);
                    v = v + 0.3;
                } while (aPointQueryResult.size() <= 5 || bPointQueryResult.size() <= 5);
                BusStop aPoint = aPointQueryResult.get(0);
                BusStop bPoint = bPointQueryResult.get(0);
                if (aPoint.getStatusEnum().hashCode() == bPoint.getStatusEnum().hashCode()) {
                    return new Root2(aPoint, bPoint, null, distance(aPointLat, aPointLng, aPoint.getLat(), aPoint.getLng(), 'M'), distance(aPoint.getLat(), aPoint.getLng(), bPoint.getLat(), bPoint.getLng(), 'M'), distance(bPoint.getLat(), bPoint.getLng(), bPointLat, bPointLng, 'M'));
                } else {
                    for (BusStop a : aPointQueryResult) {
                        for (BusStop b : bPointQueryResult) {
                            if (a.getStatusEnum().hashCode() == b.getStatusEnum().hashCode()) {
                                return new Root2(a, b, null, distance(aPointLat, aPointLng, a.getLat(), a.getLng(), 'M'), distance(a.getLat(), a.getLng(), b.getLat(), b.getLng(), 'M'), distance(b.getLat(), b.getLng(), bPointLat, bPointLng, 'M'));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public Test2 test(double aPointLat, double aPointLng, double bPointLat, double bPointLng) {
        List<BusStop> allBusStop = BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL);
        if (aPointLng != 0 && aPointLat != 0 && bPointLng != 0 && bPointLat != 0) {
            try {
                List<BusStop> aPointQueryResult;
                List<BusStop> bPointQueryResult;
                double v = 0.5;
                do {
                    aPointQueryResult = getBusMapInsideCircle(allBusStop, aPointLat, aPointLng, v);
                    bPointQueryResult = getBusMapInsideCircle(allBusStop, bPointLat, bPointLng, v);
                    v = v + 0.3;
                } while (aPointQueryResult.size() <= 5 || bPointQueryResult.size() <= 5);
                return new Test2(aPointQueryResult.subList(0, 5), bPointQueryResult.subList(0, 5));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public List<BusStop> getBusMapInsideCircle(List<BusStop> busStops, double latitude, double longitude, double radius) {
        List<BusStop> busMapInsideCircle = new ArrayList<BusStop>();
        for (BusStop busStop : busStops) {
            if (distance(busStop.getLat(), busStop.getLng(), latitude, longitude, 'K') < radius) {
                busMapInsideCircle.add(busStop);
            }
        }
        return busMapInsideCircle;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(lon1 - lon2));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = unit == 'M' ? dist * 1.609344 * 1000 : dist * 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Response {
    private BusStop busStop;
    private Double radius;
}
