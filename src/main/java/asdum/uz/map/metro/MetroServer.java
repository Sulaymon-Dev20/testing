/*
package asdum.uz.map.metro;
Chala
import asdum.uz.controller.MarshrutController;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@PropertySource("classpath:application.properties")
@PropertySource("classpath:metro.yml")
public class MetroServer implements CommandLineRunner {

    @Autowired
    MarshrutController marshrutController;

    @Autowired
    MetroRepository metroRepository;

    @Value("${first}")
    private String first;

    @Value("${first.second}")
    private String firstSecond;

    @Value("${first.third}")
    private String firstThird;

    @Value("${second}")
    private String second;

    @Value("${second.first}")
    private String secondFirst;

    @Value("${second.third}")
    private String secondThird;

    @Value("${second.fourth}")
    private String secondFourth;

    @Value("${third}")
    private String third;

    @Value("${third.first}")
    private String thirdFirst;

    @Value("${third.second}")
    private String thirdSecond;

    @Value("${fourth}")
    private String fourth;

    @Value("${fourth.second}")
    private String fourthSecond;

    @GetMapping("/api/metro")
    public HttpEntity<?> addMetro(List<BusStop> busStopList) {
        synchronized (MetroServer.class) {
            for (BusStop busStop : busStopList) {
                if (busStop != null) {
                    busStop.setStatus("METRO");
                    BusMapAccessor.getInstance().addBusStop(busStop);
                }
            }
        }
        return ResponseEntity.ok("ok 😁");
    }

    @GetMapping("/api/busStop")
    public HttpEntity<?> addBusStop(List<BusStop> busStopList) {
        for (BusStop busStop : busStopList) {
            BusMapAccessor.getInstance().addBusStop(busStop);
        }
        return ResponseEntity.ok("ok 😁");
    }

    @GetMapping("api/not-fount")
    public void saveMetro() {

    }

    @Override
    public void run(String... args) {
//***************************todo o`zbekiston linyasi *************************
        List<BusStop> busStopList = new ArrayList<>();
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

        List<Long> xob = new ArrayList<>();
        xob.add(1102L);
        xob.add(1103L);
        xob.add(1104L);
        xob.add(1105L);

        List<Long> b7 = new ArrayList<>();
        b7.add(1052L);
        b7.add(1053L);
        b7.add(1054L);

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

        String station = "Bekati";
        String routes = "metroUz";

        busStopList.add(new BusStop(1001, "Beruniy " + station, routes, 41.345314, 69.206074, "METRO", second));
        busStopList.add(new BusStop(1002, "Beruniy " + station, routes, 41.343979, 69.206275, "METRO", second));
        busStopList.add(new BusStop(1003, "Beruniy " + station, routes, 41.346064, 69.206733, "METRO", second));

        busStopList.add(new BusStop(1004, "Tinchlik " + station, routes, 41.332827, 69.217883, "METRO", second));
        busStopList.add(new BusStop(1005, "Tinchlik " + station, routes, 41.333099, 69.218270, "METRO", second));
        busStopList.add(new BusStop(1006, "Tinchlik " + station, routes, 41.332752, 69.218915, "METRO", second));
        busStopList.add(new BusStop(1007, "Tinchlik " + station, routes, 41.332304, 69.218741, "METRO", second));
        busStopList.add(new BusStop(1008, "Tinchlik " + station, routes, 41.331901, 69.220152, "METRO", second));
        busStopList.add(new BusStop(1009, "Tinchlik " + station, routes, 41.331712, 69.219893, "METRO", second));

        busStopList.add(new BusStop(1010, "Chorsu " + station, routes, 41.325250, 69.235887, "METRO", second));
        busStopList.add(new BusStop(1011, "Chorsu " + station, routes, 41.324601, 69.238127, "METRO", second));

        busStopList.add(new BusStop(1012, "G`ofur G`ulom " + station, routes, 41.327291, 69.245653, "METRO", second));
        busStopList.add(new BusStop(1013, "G`ofur G`ulom " + station, routes, 41.327670, 69.247550, "METRO", second));

        busStopList.add(new BusStop(1014, secondFirst + station, routes, 41.319979, 69.254192, "METRO", second));
        busStopList.add(new BusStop(1015, secondFirst + station, routes, 41.319996, 69.254590, "METRO", second));

        busStopList.add(new BusStop(1016, "O`zbekiston " + station, routes, 41.311662, 69.253002, "METRO", second));
        busStopList.add(new BusStop(1017, "O`zbekiston " + station, routes, 41.311624, 69.253632, "METRO", second));
        busStopList.add(new BusStop(1018, "O`zbekiston " + station, routes, 41.311016, 69.253144, "METRO", second));
        busStopList.add(new BusStop(1019, "O`zbekiston " + station, routes, 41.311028, 69.253581, "METRO", second));

        busStopList.add(new BusStop(1020, "Kasmanaftlar " + station, routes, 41.305726, 69.263709, "METRO", second));
        busStopList.add(new BusStop(1021, "Kasmanaftlar " + station, routes, 41.305260, 69.263902, "METRO", second));
        busStopList.add(new BusStop(1022, "Kasmanaftlar " + station, routes, 41.304956, 69.266224, "METRO", second));

        busStopList.add(new BusStop(1023, secondThird + station, routes, 41.298932, 69.272585, "METRO", second));
        busStopList.add(new BusStop(1024, secondThird + station, routes, 41.298651, 69.273664, "METRO", second));
        busStopList.add(new BusStop(1025, secondThird + station, routes, 41.298398, 69.273085, "METRO", second));
        busStopList.add(new BusStop(1026, secondThird + station, routes, 41.299175, 69.273172, "METRO", second));
        busStopList.add(new BusStop(1027, secondThird + station, routes, 41.297234, 69.274453, "METRO", second));
        busStopList.add(new BusStop(1028, secondThird + station, routes, 41.297530, 69.274911, "METRO", second));

        busStopList.add(new BusStop(1029, "Toshkent " + station, routes, 41.292095, 69.285569, "METRO", second));
        busStopList.add(new BusStop(1030, "Toshkent " + station, routes, 41.292712, 69.286506, "METRO", second));
        busStopList.add(new BusStop(1031, "Toshkent " + station, routes, 41.291824, 69.285769, "METRO", second));
        busStopList.add(new BusStop(1032, "Toshkent " + station, routes, 41.291607, 69.286097, "METRO", second));
        busStopList.add(new BusStop(1033, "Toshkent " + station, routes, 41.292120, 69.286966, "METRO", second));
        busStopList.add(new BusStop(1034, "Toshkent " + station, routes, 41.292412, 69.287418, "METRO", second));
        busStopList.add(new BusStop(1035, "Toshkent " + station, routes, 41.292481, 69.287036, "METRO", second));

        busStopList.add(new BusStop(1036, "Mashinasozlar " + station, routes, 41.299495, 69.304599, "METRO", second));
        busStopList.add(new BusStop(1037, "Mashinasozlar " + station, routes, 41.298982, 69.306408, "METRO", second));

        busStopList.add(new BusStop(1038, secondFourth + station, routes, 41.293713, 69.321456, "METRO", second));
        busStopList.add(new BusStop(1039, secondFourth + station, routes, 41.294132, 69.321717, "METRO", second));
        busStopList.add(new BusStop(1040, secondFourth + station, routes, 41.293496, 69.323708, "METRO", second));

//***************************todo yer usti xalqa yo`li linyasi *************************


        busStopList.add(new BusStop(1041, "Do`stlik 2 " + station, routes, 41.294379, 69.322695, "METRO", fourth));

        busStopList.add(new BusStop(1042, "2 " + station, routes, 41.298416, 69.348913, "METRO", fourth));
        busStopList.add(new BusStop(1043, "2 " + station, routes, 41.297767, 69.349847, "METRO", fourth));

        busStopList.add(new BusStop(1044, "3 " + station, routes, 41.291375, 69.356898, "METRO", fourth));
        busStopList.add(new BusStop(1045, "3 " + station, routes, 41.291975, 69.356399, "METRO", fourth));

        busStopList.add(new BusStop(1046, "4 " + station, routes, 41.282571, 69.360228, "METRO", fourth));
        busStopList.add(new BusStop(1047, "4 " + station, routes, 41.281907, 69.360401, "METRO", fourth));

        busStopList.add(new BusStop(1048, "5 " + station, routes, 41.244495, 69.262714, "METRO", fourth));
        busStopList.add(new BusStop(1049, "5 " + station, routes, 41.265467, 69.364665, "METRO", fourth));

        busStopList.add(new BusStop(1050, "6 " + station, routes, 41.256369, 69.358647, "METRO", fourth));
        busStopList.add(new BusStop(1051, "6 " + station, routes, 41.256542, 69.358165, "METRO", fourth));

        busStopList.add(new BusStop(1052, "7 " + station, routes, 41.294379, 69.322695, "METRO", fourth));
        busStopList.add(new BusStop(1053, "7 " + station, routes, 41.237596, 69.327412, "METRO", fourth));
        busStopList.add(new BusStop(1054, "7 " + station, routes, 41.237251, 69.326918, "METRO", fourth));

//***************************todo yunsobot linyasi *************************


        busStopList.add(new BusStop(1055, "Turkiston " + station, routes, 41.378337, 69.296712, "METRO", third));
        busStopList.add(new BusStop(1056, "Turkiston " + station, routes, 41.378220, 69.295758, "METRO", third));
        busStopList.add(new BusStop(1057, "Turkiston " + station, routes, 41.376367, 69.295209, "METRO", third));
        busStopList.add(new BusStop(1058, "Turkiston " + station, routes, 41.376360, 69.296061, "METRO", third));

        busStopList.add(new BusStop(1059, "Yunusobod " + station, routes, 41.367589, 69.292391, "METRO", third));
        busStopList.add(new BusStop(1070, "Yunusobod " + station, routes, 41.367227, 69.293108, "METRO", third));
        busStopList.add(new BusStop(1071, "Yunusobod " + station, routes, 41.366266, 69.291164, "METRO", third));
        busStopList.add(new BusStop(1072, "Yunusobod " + station, routes, 41.365893, 69.291836, "METRO", third));

        busStopList.add(new BusStop(1073, "Shaxriston " + station, routes, 41.354000, 69.288047, "METRO", third));
        busStopList.add(new BusStop(1074, "Shaxriston " + station, routes, 41.353983, 69.288503, "METRO", third));
        busStopList.add(new BusStop(1075, "Shaxriston " + station, routes, 41.352054, 69.287716, "METRO", third));
        busStopList.add(new BusStop(1076, "Shaxriston " + station, routes, 41.352024, 69.288155, "METRO", third));

        busStopList.add(new BusStop(1077, "Bodomzor " + station, routes, 41.337824, 69.284932, "METRO", third));
        busStopList.add(new BusStop(1078, "Bodomzor " + station, routes, 41.336542, 69.284275, "METRO", third));
        busStopList.add(new BusStop(1079, "Bodomzor " + station, routes, 41.336026, 69.284579, "METRO", third));

        busStopList.add(new BusStop(1080, "Minor " + station, routes, 41.327357, 69.283499, "METRO", third));
        busStopList.add(new BusStop(1081, "Minor " + station, routes, 41.326282, 69.283279, "METRO", third));

        busStopList.add(new BusStop(1082, "Abdulla Qodiriy " + station, routes, 41.321993, 69.282654, "METRO", third));
        busStopList.add(new BusStop(1083, "Abdulla Qodiriy " + station, routes, 41.321709, 69.281765, "METRO", third));
        busStopList.add(new BusStop(1084, "Abdulla Qodiriy " + station, routes, 41.321050, 69.282661, "METRO", third));
        busStopList.add(new BusStop(1085, "Abdulla Qodiriy " + station, routes, 41.321167, 69.281502, "METRO", third));
        busStopList.add(new BusStop(1086, "Abdulla Qodiriy " + station, routes, 41.319358, 69.281337, "METRO", third));
        busStopList.add(new BusStop(1087, "Abdulla Qodiriy " + station, routes, 41.319387, 69.282023, "METRO", third));
        busStopList.add(new BusStop(1088, "Abdulla Qodiriy " + station, routes, 41.319109, 69.281289, "METRO", third));


        busStopList.add(new BusStop(1089, "Yunus Rajabiy " + station, routes, 41.313302, 69.284303, "METRO", third));

        busStopList.add(new BusStop(1090, "Ming o`rik " + station, routes, 41.300322, 69.275174, "METRO", third));
        busStopList.add(new BusStop(1091, "Ming o`rik " + station, routes, 41.300098, 69.275372, "METRO", third));
        busStopList.add(new BusStop(1092, "Ming o`rik " + station, routes, 41.299250, 69.273226, "METRO", third));
        busStopList.add(new BusStop(1093, "Ming o`rik " + station, routes, 41.298741, 69.273803, "METRO", third));

//***************************todo Chilonzor linyasi *************************


        busStopList.add(new BusStop(1094, "Buyuk ipak yo`li " + station, routes, 41.326207, 69.327823, "METRO", first));
        busStopList.add(new BusStop(1095, "Buyuk ipak yo`li " + station, routes, 41.325812, 69.327538, "METRO", first));
        busStopList.add(new BusStop(1096, "Buyuk ipak yo`li " + station, routes, 41.326764, 69.326638, "METRO", first));
        busStopList.add(new BusStop(1097, "Buyuk ipak yo`li " + station, routes, 41.326571, 69.327007, "METRO", first));
        busStopList.add(new BusStop(1098, "Buyuk ipak yo`li " + station, routes, 41.326449, 69.330017, "METRO", first));
        busStopList.add(new BusStop(1099, "Buyuk ipak yo`li " + station, routes, 41.326123, 69.329891, "METRO", first));

        busStopList.add(new BusStop(1100, "Pushkin " + station, routes, 41.322214, 69.312307, "METRO", first));
        busStopList.add(new BusStop(1101, "Pushkin " + station, routes, 41.321469, 69.310041, "METRO", first));

        busStopList.add(new BusStop(1102, "Xamid Olimjon " + station, routes, 41.317858, 69.294565, "METRO", first));
        busStopList.add(new BusStop(1103, "Xamid Olimjon " + station, routes, 41.317592, 69.294911, "METRO", first));
        busStopList.add(new BusStop(1104, "Xamid Olimjon " + station, routes, 41.318822, 69.296726, "METRO", first));
        busStopList.add(new BusStop(1105, "Xamid Olimjon " + station, routes, 41.318561, 69.296921, "METRO", first));

        busStopList.add(new BusStop(1106, firstThird + station, routes, 41.313107, 69.284620, "METRO", first));
        busStopList.add(new BusStop(1107, firstThird + station, routes, 41.312285, 69.282074, "METRO", first));
        busStopList.add(new BusStop(1108, firstThird + station, routes, 41.312229, 69.282696, "METRO", first));
        busStopList.add(new BusStop(1109, firstThird + station, routes, 41.311777, 69.281138, "METRO", first));
        busStopList.add(new BusStop(1110, firstThird + station, routes, 41.311712, 69.281744, "METRO", first));

        busStopList.add(new BusStop(1111, "Mustaqillik " + station, routes, 41.314598, 69.272024, "METRO", first));
        busStopList.add(new BusStop(1112, "Mustaqillik " + station, routes, 41.315362, 69.270652, "METRO", first));
        busStopList.add(new BusStop(1113, "Mustaqillik " + station, routes, 41.315553, 69.269914, "METRO", first));

        busStopList.add(new BusStop(1114, firstSecond + station, routes, 41.317726, 69.255919, "METRO", first));
        busStopList.add(new BusStop(1115, firstSecond + station, routes, 41.317531, 69.254738, "METRO", first));
        busStopList.add(new BusStop(1116, firstSecond + station, routes, 41.317687, 69.253707, "METRO", first));

        busStopList.add(new BusStop(1117, "Xalqlar do`stligi " + station, routes, 41.311947, 69.243197, "METRO", first));
        busStopList.add(new BusStop(1118, "Xalqlar do`stligi " + station, routes, 41.311504, 69.243302, "METRO", first));
        busStopList.add(new BusStop(1119, "Xalqlar do`stligi " + station, routes, 41.311369, 69.243129, "METRO", first));
        busStopList.add(new BusStop(1120, "Xalqlar do`stligi " + station, routes, 41.311453, 69.241888, "METRO", first));
        busStopList.add(new BusStop(1121, "Xalqlar do`stligi " + station, routes, 41.310977, 69.242614, "METRO", first));

        busStopList.add(new BusStop(1122, "Milliy bog` " + station, routes, 41.304606, 69.235098, "METRO", first));
        busStopList.add(new BusStop(1123, "Milliy bog` " + station, routes, 41.304330, 69.234910, "METRO", first));
        busStopList.add(new BusStop(1124, "Milliy bog` " + station, routes, 41.304271, 69.236082, "METRO", first));
        busStopList.add(new BusStop(1125, "Milliy bog` " + station, routes, 41.303922, 69.235794, "METRO", first));

        busStopList.add(new BusStop(1126, "Novza " + station, routes, 41.293046, 69.223814, "METRO", first));
        busStopList.add(new BusStop(1127, "Novza " + station, routes, 41.292608, 69.224631, "METRO", first));
        busStopList.add(new BusStop(1128, "Novza " + station, routes, 41.291915, 69.222546, "METRO", first));
        busStopList.add(new BusStop(1129, "Novza " + station, routes, 41.291915, 69.222546, "METRO", first));
        busStopList.add(new BusStop(1130, "Novza " + station, routes, 41.292066, 69.224198, "METRO", first));
        busStopList.add(new BusStop(1131, "Novza " + station, routes, 41.291454, 69.223327, "METRO", first));
        busStopList.add(new BusStop(1132, "Novza " + station, routes, 41.291643, 69.222281, "METRO", first));
        busStopList.add(new BusStop(1133, "Novza " + station, routes, 41.291126, 69.223018, "METRO", first));

        busStopList.add(new BusStop(1134, "Mirzo Ulug`bek " + station, routes, 41.283130, 69.212826, "METRO", first));
        busStopList.add(new BusStop(1135, "Mirzo Ulug`bek " + station, routes, 41.282824, 69.212473, "METRO", first));
        busStopList.add(new BusStop(1136, "Mirzo Ulug`bek " + station, routes, 41.282549, 69.213552, "METRO", first));
        busStopList.add(new BusStop(1137, "Mirzo Ulug`bek " + station, routes, 41.282315, 69.213272, "METRO", first));
        busStopList.add(new BusStop(1138, "Mirzo Ulug`bek " + station, routes, 41.281914, 69.211499, "METRO", first));
        busStopList.add(new BusStop(1139, "Mirzo Ulug`bek " + station, routes, 41.281626, 69.211163, "METRO", first));
        busStopList.add(new BusStop(1140, "Mirzo Ulug`bek " + station, routes, 41.281128, 69.211931, "METRO", first));
        busStopList.add(new BusStop(1141, "Mirzo Ulug`bek " + station, routes, 41.281446, 69.212285, "METRO", first));

        busStopList.add(new BusStop(1142, "Chilonzor " + station, routes, 41.275313, 69.204831, "METRO", first));
        busStopList.add(new BusStop(1143, "Chilonzor " + station, routes, 41.275032, 69.204611, "METRO", first));
        busStopList.add(new BusStop(1144, "Chilonzor " + station, routes, 41.274933, 69.205716, "METRO", first));
        busStopList.add(new BusStop(1145, "Chilonzor " + station, routes, 41.274655, 69.205505, "METRO", first));
        busStopList.add(new BusStop(1146, "Chilonzor " + station, routes, 41.273982, 69.203822, "METRO", first));
        busStopList.add(new BusStop(1147, "Chilonzor " + station, routes, 41.273667, 69.203577, "METRO", first));
        busStopList.add(new BusStop(1148, "Chilonzor " + station, routes, 41.273600, 69.204715, "METRO", first));
        busStopList.add(new BusStop(1149, "Chilonzor " + station, routes, 41.273307, 69.204449, "METRO", first));

        busStopList.add(new BusStop(1150, "Olmazor " + station, routes, 41.257341, 69.195366, "METRO", first));
        busStopList.add(new BusStop(1151, "Olmazor " + station, routes, 41.257591, 69.195953, "METRO", first));
        busStopList.add(new BusStop(1152, "Olmazor " + station, routes, 41.257234, 69.195964, "METRO", first));
        busStopList.add(new BusStop(1153, "Olmazor " + station, routes, 41.256049, 69.195918, "METRO", first));
        busStopList.add(new BusStop(1154, "Olmazor " + station, routes, 41.255678, 69.195920, "METRO", first));

        busStopList.add(new BusStop(1155, "1 " + station + "(Chilonzor)", routes, 41.238562, 69.195852, "METRO", first));

        busStopList.add(new BusStop(1156, "2 " + station + "(Chilonzor)", routes, 41.228199, 69.203396, "METRO", first));
        busStopList.add(new BusStop(1157, "2 " + station + "(Chilonzor)", routes, 41.221852, 69.208177, "METRO", first));

        busStopList.add(new BusStop(1158, "3 " + station + "(Chilonzor)", routes, 41.221494, 69.208288, "METRO", first));
        busStopList.add(new BusStop(1159, "3 " + station + "(Chilonzor)", routes, 41.220190, 69.209213, "METRO", first));

        busStopList.add(new BusStop(1160, "4 " + station + "(Chilonzor)", routes, 41.214645, 69.213196, "METRO", first));
        busStopList.add(new BusStop(1161, "4 " + station + "(Chilonzor)", routes, 41.213142, 69.214330, "METRO", first));

        busStopList.add(new BusStop(1162, "5 " + station + "(Chilonzor)", routes, 41.207018, 69.218746, "METRO", first));
        busStopList.add(new BusStop(1163, "5 " + station + "(Chilonzor)", routes, 41.205481, 69.219829, "METRO", first));

        for (BusStop busStop : busStopList) {
            BusMapAccessor.getInstance().addBusStop(busStop);
        }


        List<MetroStop> metroStops = new ArrayList<>();
//       first
        metroStops.add(new MetroStop("Buyuk ipak yo`li " + station, routes, bIY.toString(), "METRO", first));
        metroStops.add(new MetroStop("Purshkin " + station, routes, pushB.toString(), "METRO", first));
        metroStops.add(new MetroStop("Xamid Olimjon " + station, routes, xob.toString(), "METRO", first));
        metroStops.add(new MetroStop("Amir Temur " + station, routes, atb.toString(), "METRO", first));
        metroStops.add(new MetroStop("Mustaqillik " + station, routes, musB.toString(), "METRO", first));
        metroStops.add(new MetroStop("Paxtakor " + station, routes, pah.toString(), "METRO", first));
        metroStops.add(new MetroStop("Xalqlar do`stligi " + station, routes, xalq.toString(), "METRO", first));
        metroStops.add(new MetroStop("Milliy bog` " + station, routes, mb.toString(), "METRO", first));
        metroStops.add(new MetroStop("Novza " + station, routes, nb.toString(), "METRO", first));
        metroStops.add(new MetroStop("Chilonzor " + station, routes, chb.toString(), "METRO", first));
        metroStops.add(new MetroStop("Mirzo Ulug`bek " + station, routes, mub.toString(), "METRO", first));
        metroStops.add(new MetroStop("Olmazor " + station, routes, ob.toString(), "METRO", first));
        metroStops.add(new MetroStop("1  +station(" + first + ")", routes, bch1.toString(), "METRO", first));
        metroStops.add(new MetroStop("2  +station(" + first + ")", routes, bch2.toString(), "METRO", first));
        metroStops.add(new MetroStop("3  +station(" + first + ")", routes, bch3.toString(), "METRO", first));
        metroStops.add(new MetroStop("4  +station(" + first + ")", routes, bch4.toString(), "METRO", first));
        metroStops.add(new MetroStop("5  +station(" + first + ")", routes, bch5.toString(), "METRO", first));
//second
        metroStops.add(new MetroStop("Do`stlik " + station, routes, dost.toString(), "METRO", second));
        metroStops.add(new MetroStop("Mashinasozlar " + station, routes, mash.toString(), "METRO", second));
        metroStops.add(new MetroStop("Toshkent " + station, routes, tosh.toString(), "METRO", second));
        metroStops.add(new MetroStop(secondThird + station, routes, oybek.toString(), "METRO", second));
        metroStops.add(new MetroStop("Kasmanaftlar " + station, routes, kasB.toString(), "METRO", second));
        metroStops.add(new MetroStop("O`zbekiston " + station, routes, ozb.toString(), "METRO", second));
        metroStops.add(new MetroStop("Alisher Navoiy " + station, routes, anb.toString(), "METRO", second));
        metroStops.add(new MetroStop("G`ofur G`ulom " + station, routes, ggb.toString(), "METRO", second));
        metroStops.add(new MetroStop("Chorsu " + station, routes, chob.toString(), "METRO", second));
        metroStops.add(new MetroStop("Tinchlik " + station, routes, tb.toString(), "METRO", second));
        metroStops.add(new MetroStop("Beruniy " + station, routes, bb.toString(), "METRO", second));
//yer usti xalqa yo`li
        metroStops.add(new MetroStop("Do`stlik 2 " + station, routes, dost2.toString(), "METRO", fourth));
        metroStops.add(new MetroStop("2 " + station, routes, b2.toString(), "METRO", fourth));
        metroStops.add(new MetroStop("3 " + station, routes, b3.toString(), "METRO", fourth));
        metroStops.add(new MetroStop("4 " + station, routes, b4.toString(), "METRO", fourth));
        metroStops.add(new MetroStop("5 " + station, routes, b5.toString(), "METRO", fourth));
        metroStops.add(new MetroStop("6 " + station, routes, b6.toString(), "METRO", fourth));
        metroStops.add(new MetroStop("7 " + station, routes, b7.toString(), "METRO", fourth));

//yunsovot
        metroStops.add(new MetroStop("Turkiston " + station, routes, turk.toString(), "METRO", third));
        metroStops.add(new MetroStop("Yunusobod " + station, routes, yb.toString(), "METRO", third));
        metroStops.add(new MetroStop("Shaxriston " + station, routes, shb.toString(), "METRO", third));
        metroStops.add(new MetroStop("Bodomzor " + station, routes, bodom.toString(), "METRO", third));
        metroStops.add(new MetroStop("Minor " + station, routes, minor.toString(), "METRO", third));
        metroStops.add(new MetroStop("Abdulla Qodiriy " + station, routes, aqb.toString(), "METRO", third));
        metroStops.add(new MetroStop("Yunus Rajabiy " + station, routes, yrb.toString(), "METRO", third));
        metroStops.add(new MetroStop("Ming o`rik " + station, routes, mob.toString(), "METRO", third));

        metroRepository.deleteAll();
        for (MetroStop metro : metroStops) {
            metroRepository.save(metro);
        }
    }
}
*/
