package asdum.uz.map.server;

import asdum.uz.config.CacheConfig;
import asdum.uz.controller.MarshrutController;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.metro.MetroRepository;
import asdum.uz.map.metro.MetroStop;
import asdum.uz.map.model.BusStop;
import asdum.uz.map.model.Root;
import asdum.uz.map.model.Root2;
import asdum.uz.map.model.enums.BusStopStatusEnum;
import asdum.uz.payload.ResStations;
import com.hazelcast.core.IFunction;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class BusStopService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CacheConfig cacheConfig;

    @Autowired
    MarshrutController marshrutController;

    @Autowired
    MetroRepository metroRepository;

    public Root filter(Root2 root2) {
        try {
            List<Object> objects = new ArrayList<>();
            List<MetroStop> metroStops = new ArrayList<>();
            if (root2.getBPoint().getStatus() == null && root2.getAPoint().getStatus() == null) {
                IMap<Long, List<Long>> stationRoutes = cacheConfig.getRoutes().getMap("stationRoutes");
                IMap<Long, Object> routeProps = cacheConfig.getRoutes().getMap("routeProps");
                List<Long> listA = stationRoutes.get(root2.getAPoint().getId());
                List<Long> listB = stationRoutes.get(root2.getBPoint().getId());
                if (listA != null && listB != null) {
                    for (Long aLong : new HashSet<>(listA)) {
                        Object o = routeProps.get(aLong);
                        for (Long bLong : new HashSet<>(listB)) {
                            if (aLong.hashCode() == bLong.hashCode()) {
                                objects.add(o);
                            }
                        }
                    }
                }
            } else {
                List<MetroStop> all = root2.getAPoint().getId() < root2.getBPoint().getId() ? metroRepository.findAllByRoute(root2.getAPoint().getRoute()) : metroRepository.findAllByRoute2(root2.getAPoint().getRoute());
                if (root2.getAPoint().getRoute().hashCode() == root2.getBPoint().getRoute().hashCode()) {
                    boolean status = false;
                    if (root2.getAPoint().getRoute().hashCode() == root2.getBPoint().getRoute().hashCode()) {
                        objects.add(root2.getAPoint().getRoute());
                        for (MetroStop metroStop : all) {
                            if (metroStop.getTunnels().contains(String.valueOf(root2.getAPoint().getId()))) {
                                status = true;
                            }
                            if (status) {
                                metroStops.add(metroStop);
                            }
                            if (metroStop.getTunnels().contains(String.valueOf(root2.getBPoint().getId()))) {
                                status = false;
                            }
                        }
                    } else if (root2.getAPoint().getRoute().hashCode() != root2.getBPoint().getRoute().hashCode()) {
                        objects.add(root2.getAPoint().getRoute());
                        objects.add(root2.getBPoint().getRoute());
                        if (root2.getAPoint().getRoute().hashCode() == "chilonzor".hashCode()) {
                            Optional<MetroStop> metroStop = metroRepository.selectStations("${first}");
                            if (metroStop.isPresent()) {
                                for (MetroStop chilonzor : all) {
                                    if (chilonzor.getTunnels().contains(String.valueOf(root2.getAPoint().getId()))) {
                                        status = true;
                                    }
                                    if (status) {
                                        metroStops.add(chilonzor);
                                    }
                                    if (chilonzor.getId().hashCode() == metroStop.get().getId().hashCode()) {
                                        status = false;
                                    }
                                }
                            }
                        } else if (root2.getAPoint().getRoute().hashCode() == "O`zbekiston".hashCode()) {

                        } else if (root2.getAPoint().getRoute().hashCode() == "yunusobod".hashCode()) {

                        }
                        if (root2.getAPoint().getRoute().hashCode() == "yer_usti_halqa_yo`li".hashCode() || root2.getBPoint().getRoute().hashCode() == "yer_usti_halqa_yo`li".hashCode()) {
                            objects.add("O`zbekiston");
                        }
                    }
                }
            }
            return new Root(root2.getAPoint().getStatus().hashCode() == "METRO".hashCode() ? "METRO" : "BUS_STOP", root2.getAPoint(), root2.getBPoint(), metroStops, objects, root2.getDistanceA(), root2.getDistance(), root2.getDistanceB());
        } catch (Exception e) {
            return new Root("Bus null", root2.getAPoint(), root2.getBPoint(), null, null, root2.getDistanceA(), root2.getDistance(), root2.getDistanceB());
        }
    }

    public Object getRoot(Long aPointId, Long bPointId, String busId) {
        List<Object> objects = new ArrayList<>();
        if (busId.hashCode() != "METRO".hashCode()) {
            ResStations stationsBySort = marshrutController.getStationsBySort(Long.parseLong(busId));
            boolean status = false;
            for (Object o : stationsBySort.getKpp1()) {
                if (o.toString().substring(3, 10).contains(aPointId.toString())) {
                    System.out.println(o.toString().substring(3, 8));
                    status = true;
                }
                if (status) {
                    objects.add(o.toString().substring(3, 8));
                }
                if (o.toString().substring(0, 10).contains(bPointId.toString())) {
                    status = false;
                }
            }
        } else {
            for (BusStop busStop : BusMapAccessor.getInstance().getBusStops(BusStopStatusEnum.ALL)) {
                if (busStop.getId() < 100) {
                    objects.add(busStop);
                }
            }
        }
        return objects;
    }

/*    public List<MetroStop> metro() {
        List<BusStop> busStopList = new ArrayList<>();

        List<Long> dost2 = new ArrayList<>();
        dost2.add(1041L);

        List<Long> b2 = new ArrayList<>();
        b2.add(1042L);
        b2.add(1043L);

        List<Long> b3 = new ArrayList<>();
        b3.add(1044L);
        b3.add(1045L);

        List<Long> b4 = new ArrayList<>();
        b4.add(1046L);
        b4.add(1047L);

        List<Long> b5 = new ArrayList<>();
        b5.add(1048L);
        b5.add(1049L);

        List<Long> b6 = new ArrayList<>();
        b6.add(1050L);
        b6.add(1051L);


        List<Long> b7 = new ArrayList<>();
        b7.add(1052L);
        b7.add(1053L);
        b7.add(1054L);

        List<MetroStop> metroStops = new ArrayList<>();
        metroStops.add(new MetroStop("Do`stlik 2 Bekati", "metroUz", dost2.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("2 Bekati", "metroUz", b2.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("3 Bekati", "metroUz", b3.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("4 Bekati", "metroUz", b4.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("5 Bekati", "metroUz", b5.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("6 Bekati", "metroUz", b6.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("7 Bekati", "metroUz", b7.toString(), "METRO", "yer_usti_halqa_yo`li"));
        return metroStops;
    }

    public List<MetroStop> chilonzor() {
        List<Long> bIY = new ArrayList<>();
        bIY.add(1094L);
        bIY.add(1095L);
        bIY.add(1096L);
        bIY.add(1097L);
        bIY.add(1098L);
        bIY.add(1099L);

        List<Long> atb = new ArrayList<>();
        atb.add(1106L);
        atb.add(1107L);
        atb.add(1108L);
        atb.add(1109L);
        atb.add(1110L);

        List<Long> bch2 = new ArrayList<>();
        bch2.add(1156L);
        bch2.add(1157L);

        List<Long> bch3 = new ArrayList<>();
        bch3.add(1158L);
        bch3.add(1159L);

        List<Long> bch4 = new ArrayList<>();
        bch4.add(1161L);
        bch4.add(1160L);

        List<Long> bch5 = new ArrayList<>();
        bch5.add(1162L);
        bch5.add(1163L);

        List<Long> mub = new ArrayList<>();
        mub.add(1134L);
        mub.add(1135L);
        mub.add(1136L);
        mub.add(1137L);
        mub.add(1138L);
        mub.add(1139L);
        mub.add(1140L);
        mub.add(1141L);

        List<Long> chb = new ArrayList<>();
        chb.add(1142L);
        chb.add(1143L);
        chb.add(1144L);
        chb.add(1145L);
        chb.add(1146L);
        chb.add(1147L);
        chb.add(1148L);
        chb.add(1149L);

        List<Long> musB = new ArrayList<>();
        musB.add(1111L);
        musB.add(1112L);
        musB.add(1113L);

        List<Long> pah = new ArrayList<>();
        pah.add(1114L);
        pah.add(1115L);
        pah.add(1116L);

        List<Long> pushB = new ArrayList<>();
        pushB.add(1100L);
        pushB.add(1101L);

        List<Long> xalq = new ArrayList<>();
        xalq.add(1118L);
        xalq.add(1119L);
        xalq.add(1120L);
        xalq.add(1121L);

        List<Long> mb = new ArrayList<>();
        mb.add(1122L);
        mb.add(1123L);
        mb.add(1124L);
        mb.add(1125L);

        List<Long> bch1 = new ArrayList<>();
        bch1.add(1155L);

        List<Long> ob = new ArrayList<>();
        ob.add(1150L);
        ob.add(1151L);
        ob.add(1152L);
        ob.add(1153L);
        ob.add(1154L);

        List<Long> nb = new ArrayList<>();
        nb.add(1126L);
        nb.add(1127L);
        nb.add(1128L);
        nb.add(1129L);
        nb.add(1130L);
        nb.add(1131L);
        nb.add(1132L);
        nb.add(1133L);

        List<Long> xob = new ArrayList<>();
        xob.add(1102L);
        xob.add(1103L);
        xob.add(1104L);
        xob.add(1105L);

        List<MetroStop> metroStops = new ArrayList<>();
//        chilonzor
        metroStops.add(new MetroStop(1, "Buyuk ipak yo`li Bekati", "metroUz", bIY.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(2, "Purshkin Bekati", "metroUz", pushB.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(3, "Xamid Olimjon Bekati", "metroUz", xob.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(4, "Amir Temur Bekati", "metroUz", atb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(5, "Mustaqillik Bekati", "metroUz", musB.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(6, "Paxtakor Bekati", "metroUz", pah.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(7, "Xalqlar do`stligi Bekati", "metroUz", xalq.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(8, "Milliy bog` Bekati", "metroUz", mb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(9, "Novza Bekati", "metroUz", nb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(10, "Chilonzor Bekati", "metroUz", chb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(11, "Mirzo Ulug`bek Bekati", "metroUz", mub.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(12, "Olmazor Bekati", "metroUz", ob.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(13, "1 Bekati (chilonzor)", "metroUz", bch1.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(14, "2 Bekati (chilonzor)", "metroUz", bch2.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(15, "3 Bekati (chilonzor)", "metroUz", bch3.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(16, "4 Bekati (chilonzor)", "metroUz", bch4.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop(17, "5 Bekati (chilonzor)", "metroUz", bch5.toString(), "METRO", "chilonzor"));
        return metroStops;
    }

    public List<MetroStop> ozbekiston() {
        List<Long> bb = new ArrayList<>();
        bb.add(1001L);
        bb.add(1002L);
        bb.add(1003L);

        List<Long> tb = new ArrayList<>();
        tb.add(1004L);
        tb.add(1005L);
        tb.add(1006L);
        tb.add(1007L);
        tb.add(1008L);
        tb.add(1009L);

        List<Long> chob = new ArrayList<>();
        chob.add(1010L);
        chob.add(1011L);

        List<Long> ggb = new ArrayList<>();
        ggb.add(1012L);
        ggb.add(1013L);

        List<Long> anb = new ArrayList<>();
        anb.add(1014L);
        anb.add(1015L);

        List<Long> ozb = new ArrayList<>();
        ozb.add(1016L);
        ozb.add(1017L);
        ozb.add(1018L);
        ozb.add(1019L);

        List<Long> kasB = new ArrayList<>();
        kasB.add(1020L);
        kasB.add(1021L);
        kasB.add(1022L);

        List<Long> oybek = new ArrayList<>();
        oybek.add(1023L);
        oybek.add(1024L);
        oybek.add(1025L);
        oybek.add(1026L);
        oybek.add(1027L);
        oybek.add(1028L);

        List<Long> tosh = new ArrayList<>();
        tosh.add(1029L);
        tosh.add(1030L);
        tosh.add(1031L);
        tosh.add(1032L);
        tosh.add(1033L);
        tosh.add(1034L);
        tosh.add(1035L);

        List<Long> mash = new ArrayList<>();
        mash.add(1036L);
        mash.add(1037L);

        List<Long> dost = new ArrayList<>();
        dost.add(1038L);
        dost.add(1039L);
        dost.add(1040L);

        List<MetroStop> metroStops = new ArrayList<>();
        metroStops.add(new MetroStop(18, "Do`stlik Bekati", "metroUz", dost.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(19, "Mashinasozlar Bekati", "metroUz", mash.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(20, "Toshkent Bekati", "metroUz", tosh.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(21, "Oybek Bekati", "metroUz", oybek.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(22, "Kasmanaftlar Bekati", "metroUz", kasB.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(23, "O`zbekiston Bekati", "metroUz", ozb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(24, "Alisher Navoiy Bekati", "metroUz", anb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(25, "G`ofur G`ulom Bekati", "metroUz", ggb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(26, "Chorsu Bekati", "metroUz", chob.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(27, "Tinchlik Bekati", "metroUz", tb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop(28, "Beruniy Bekati", "metroUz", bb.toString(), "METRO", "O`zbekiston"));
        return metroStops;
    }

    public List<MetroStop> yunusobod() {
        List<Long> bodom = new ArrayList<>();
        bodom.add(1077L);
        bodom.add(1078L);
        bodom.add(1079L);

        List<Long> minor = new ArrayList<>();
        minor.add(1080L);
        minor.add(1081L);

        List<Long> aqb = new ArrayList<>();
        aqb.add(1082L);
        aqb.add(1083L);
        aqb.add(1084L);
        aqb.add(1085L);
        aqb.add(1086L);
        aqb.add(1087L);
        aqb.add(1088L);

        List<Long> yrb = new ArrayList<>();
        yrb.add(1089L);

        List<Long> turk = new ArrayList<>();
        turk.add(1055L);
        turk.add(1056L);
        turk.add(1057L);
        turk.add(1058L);

        List<Long> yb = new ArrayList<>();
        yb.add(1059L);
        yb.add(1070L);
        yb.add(1071L);
        yb.add(1072L);

        List<Long> shb = new ArrayList<>();
        shb.add(1073L);
        shb.add(1074L);
        shb.add(1075L);
        shb.add(1076L);

        List<Long> mob = new ArrayList<>();
        mob.add(1090L);
        mob.add(1091L);
        mob.add(1092L);
        mob.add(1093L);

        List<MetroStop> metroStops = new ArrayList<>();
        metroStops.add(new MetroStop("Turkiston Bekati", "metroUz", turk.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Yunusobod Bekati", "metroUz", yb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Shaxriston Bekati", "metroUz", shb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Bodomzor Bekati", "metroUz", bodom.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Minor Bekati", "metroUz", minor.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Abdulla Qodiriy Bekati", "metroUz", aqb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Yunus Rajabiy Bekati", "metroUz", yrb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Ming o`rik Bekati", "metroUz", mob.toString(), "METRO", "yunusobod"));
        return metroStops;
    }*/
}
