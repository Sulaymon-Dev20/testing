/*
package asdum.uz.map.metro;

import asdum.uz.controller.MarshrutController;
import asdum.uz.map.dataaccess.BusMapAccessor;
import asdum.uz.map.model.BusStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MetroServer implements CommandLineRunner {

    @Autowired
    MarshrutController marshrutController;

    @Autowired
    MetroRepository metroRepository;

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
        */
/****************************todo o`zbekiston linyasi **************************//*


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

        busStopList.add(new BusStop(1001, "Beruniy Bekati", "metroUz", 41.345314, 69.206074, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1002, "Beruniy Bekati", "metroUz", 41.343979, 69.206275, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1003, "Beruniy Bekati", "metroUz", 41.346064, 69.206733, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1004, "Tinchlik Bekati", "metroUz", 41.332827, 69.217883, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1005, "Tinchlik Bekati", "metroUz", 41.333099, 69.218270, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1006, "Tinchlik Bekati", "metroUz", 41.332752, 69.218915, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1007, "Tinchlik Bekati", "metroUz", 41.332304, 69.218741, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1008, "Tinchlik Bekati", "metroUz", 41.331901, 69.220152, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1009, "Tinchlik Bekati", "metroUz", 41.331712, 69.219893, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1010, "Chorsu Bekati", "metroUz", 41.325250, 69.235887, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1011, "Chorsu Bekati", "metroUz", 41.324601, 69.238127, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1012, "G`ofur g`ulom Bekati", "metroUz", 41.327291, 69.245653, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1013, "G`ofur g`ulom Bekati", "metroUz", 41.327670, 69.247550, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1014, "Alisher Navoiy Bekati", "metroUz", 41.319979, 69.254192, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1015, "Alisher Navoiy Bekati", "metroUz", 41.319996, 69.254590, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1016, "O`zbekiston Bekati", "metroUz", 41.311662, 69.253002, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1017, "O`zbekiston Bekati", "metroUz", 41.311624, 69.253632, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1018, "O`zbekiston Bekati", "metroUz", 41.311016, 69.253144, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1019, "O`zbekiston Bekati", "metroUz", 41.311028, 69.253581, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1020, "Kasmanaftlar Bekati", "metroUz", 41.305726, 69.263709, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1021, "Kasmanaftlar Bekati", "metroUz", 41.305260, 69.263902, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1022, "Kasmanaftlar Bekati", "metroUz", 41.304956, 69.266224, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1023, "Oybek Bekati", "metroUz", 41.298932, 69.272585, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1024, "Oybek Bekati", "metroUz", 41.298651, 69.273664, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1025, "Oybek Bekati", "metroUz", 41.298398, 69.273085, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1026, "Oybek Bekati", "metroUz", 41.299175, 69.273172, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1027, "Oybek Bekati", "metroUz", 41.297234, 69.274453, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1028, "Oybek Bekati", "metroUz", 41.297530, 69.274911, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1029, "Toshkent Bekati", "metroUz", 41.292095, 69.285569, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1030, "Toshkent Bekati", "metroUz", 41.292712, 69.286506, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1031, "Toshkent Bekati", "metroUz", 41.291824, 69.285769, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1032, "Toshkent Bekati", "metroUz", 41.291607, 69.286097, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1033, "Toshkent Bekati", "metroUz", 41.292120, 69.286966, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1034, "Toshkent Bekati", "metroUz", 41.292412, 69.287418, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1035, "Toshkent Bekati", "metroUz", 41.292481, 69.287036, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1036, "Mashinasozlar Bekati", "metroUz", 41.299495, 69.304599, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1037, "Mashinasozlar Bekati", "metroUz", 41.298982, 69.306408, "METRO", "O`zbekiston"));

        busStopList.add(new BusStop(1038, "Do`stlik Bekati", "metroUz", 41.293713, 69.321456, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1039, "Do`stlik Bekati", "metroUz", 41.294132, 69.321717, "METRO", "O`zbekiston"));
        busStopList.add(new BusStop(1040, "Do`stlik Bekati", "metroUz", 41.293496, 69.323708, "METRO", "O`zbekiston"));

        */
/****************************todo yer usti xalqa yo`li linyasi **************************//*


        busStopList.add(new BusStop(1041, "Do`stlik 2 Bekati", "metroUz", 41.294379, 69.322695, "METRO", "yer_usti_halqa_yo`li"));

        busStopList.add(new BusStop(1042, "2 Bekati", "metroUz", 41.298416, 69.348913, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1043, "2 Bekati", "metroUz", 41.297767, 69.349847, "METRO", "yer_usti_halqa_yo`li"));

        busStopList.add(new BusStop(1044, "3 Bekati", "metroUz", 41.291375, 69.356898, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1045, "3 Bekati", "metroUz", 41.291975, 69.356399, "METRO", "yer_usti_halqa_yo`li"));

        busStopList.add(new BusStop(1046, "4 Bekati", "metroUz", 41.282571, 69.360228, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1047, "4 Bekati", "metroUz", 41.281907, 69.360401, "METRO", "yer_usti_halqa_yo`li"));

        busStopList.add(new BusStop(1048, "5 Bekati", "metroUz", 41.244495, 69.262714, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1049, "5 Bekati", "metroUz", 41.265467, 69.364665, "METRO", "yer_usti_halqa_yo`li"));

        busStopList.add(new BusStop(1050, "6 Bekati", "metroUz", 41.256369, 69.358647, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1051, "6 Bekati", "metroUz", 41.256542, 69.358165, "METRO", "yer_usti_halqa_yo`li"));

        busStopList.add(new BusStop(1052, "7 Bekati", "metroUz", 41.294379, 69.322695, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1053, "7 Bekati", "metroUz", 41.237596, 69.327412, "METRO", "yer_usti_halqa_yo`li"));
        busStopList.add(new BusStop(1054, "7 Bekati", "metroUz", 41.237251, 69.326918, "METRO", "yer_usti_halqa_yo`li"));

        */
/****************************todo yunsobot linyasi **************************//*


        busStopList.add(new BusStop(1055, "Turkiston Bekati", "metroUz", 41.378337, 69.296712, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1056, "Turkiston Bekati", "metroUz", 41.378220, 69.295758, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1057, "Turkiston Bekati", "metroUz", 41.376367, 69.295209, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1058, "Turkiston Bekati", "metroUz", 41.376360, 69.296061, "METRO", "yunusobod"));

        busStopList.add(new BusStop(1059, "Yunusobod Bekati", "metroUz", 41.367589, 69.292391, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1070, "Yunusobod Bekati", "metroUz", 41.367227, 69.293108, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1071, "Yunusobod Bekati", "metroUz", 41.366266, 69.291164, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1072, "Yunusobod Bekati", "metroUz", 41.365893, 69.291836, "METRO", "yunusobod"));

        busStopList.add(new BusStop(1073, "Shaxriston Bekati", "metroUz", 41.354000, 69.288047, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1074, "Shaxriston Bekati", "metroUz", 41.353983, 69.288503, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1075, "Shaxriston Bekati", "metroUz", 41.352054, 69.287716, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1076, "Shaxriston Bekati", "metroUz", 41.352024, 69.288155, "METRO", "yunusobod"));

        busStopList.add(new BusStop(1077, "Bodomzor Bekati", "metroUz", 41.337824, 69.284932, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1078, "Bodomzor Bekati", "metroUz", 41.336542, 69.284275, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1079, "Bodomzor Bekati", "metroUz", 41.336026, 69.284579, "METRO", "yunusobod"));

        busStopList.add(new BusStop(1080, "Minor Bekati", "metroUz", 41.327357, 69.283499, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1081, "Minor Bekati", "metroUz", 41.326282, 69.283279, "METRO", "yunusobod"));

        busStopList.add(new BusStop(1082, "Abdulla Qodiriy Bekati", "metroUz", 41.321993, 69.282654, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1083, "Abdulla Qodiriy Bekati", "metroUz", 41.321709, 69.281765, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1084, "Abdulla Qodiriy Bekati", "metroUz", 41.321050, 69.282661, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1085, "Abdulla Qodiriy Bekati", "metroUz", 41.321167, 69.281502, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1086, "Abdulla Qodiriy Bekati", "metroUz", 41.319358, 69.281337, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1087, "Abdulla Qodiriy Bekati", "metroUz", 41.319387, 69.282023, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1088, "Abdulla Qodiriy Bekati", "metroUz", 41.319109, 69.281289, "METRO", "yunusobod"));


        busStopList.add(new BusStop(1089, "Yunus Rajabiy Bekati", "metroUz", 41.313302, 69.284303, "METRO", "yunusobod"));

        busStopList.add(new BusStop(1090, "Ming o`rik Bekati", "metroUz", 41.300322, 69.275174, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1091, "Ming o`rik Bekati", "metroUz", 41.300098, 69.275372, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1092, "Ming o`rik Bekati", "metroUz", 41.299250, 69.273226, "METRO", "yunusobod"));
        busStopList.add(new BusStop(1093, "Ming o`rik Bekati", "metroUz", 41.298741, 69.273803, "METRO", "yunusobod"));

        */
/****************************todo Chilonzor linyasi **************************//*


        busStopList.add(new BusStop(1094, "Buyuk ipak yo`li Bekati", "metroUz", 41.326207, 69.327823, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1095, "Buyuk ipak yo`li Bekati", "metroUz", 41.325812, 69.327538, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1096, "Buyuk ipak yo`li Bekati", "metroUz", 41.326764, 69.326638, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1097, "Buyuk ipak yo`li Bekati", "metroUz", 41.326571, 69.327007, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1098, "Buyuk ipak yo`li Bekati", "metroUz", 41.326449, 69.330017, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1099, "Buyuk ipak yo`li Bekati", "metroUz", 41.326123, 69.329891, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1100, "Pushkin Bekati", "metroUz", 41.322214, 69.312307, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1101, "Pushkin Bekati", "metroUz", 41.321469, 69.310041, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1102, "Xamid Olimjon Bekati", "metroUz", 41.317858, 69.294565, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1103, "Xamid Olimjon Bekati", "metroUz", 41.317592, 69.294911, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1104, "Xamid Olimjon Bekati", "metroUz", 41.318822, 69.296726, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1105, "Xamid Olimjon Bekati", "metroUz", 41.318561, 69.296921, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1106, "Amir Temur Bekati", "metroUz", 41.313107, 69.284620, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1107, "Amir Temur Bekati", "metroUz", 41.312285, 69.282074, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1108, "Amir Temur Bekati", "metroUz", 41.312229, 69.282696, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1109, "Amir Temur Bekati", "metroUz", 41.311777, 69.281138, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1110, "Amir Temur Bekati", "metroUz", 41.311712, 69.281744, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1111, "Mustaqillik Bekati", "metroUz", 41.314598, 69.272024, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1112, "Mustaqillik Bekati", "metroUz", 41.315362, 69.270652, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1113, "Mustaqillik Bekati", "metroUz", 41.315553, 69.269914, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1114, "Paxtakor Bekati", "metroUz", 41.317726, 69.255919, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1115, "Paxtakor Bekati", "metroUz", 41.317531, 69.254738, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1116, "Paxtakor Bekati", "metroUz", 41.317687, 69.253707, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1117, "Xalqlar do`stligi Bekati", "metroUz", 41.311947, 69.243197, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1118, "Xalqlar do`stligi Bekati", "metroUz", 41.311504, 69.243302, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1119, "Xalqlar do`stligi Bekati", "metroUz", 41.311369, 69.243129, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1120, "Xalqlar do`stligi Bekati", "metroUz", 41.311453, 69.241888, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1121, "Xalqlar do`stligi Bekati", "metroUz", 41.310977, 69.242614, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1122, "Milliy bog` Bekati", "metroUz", 41.304606, 69.235098, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1123, "Milliy bog` Bekati", "metroUz", 41.304330, 69.234910, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1124, "Milliy bog` Bekati", "metroUz", 41.304271, 69.236082, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1125, "Milliy bog` Bekati", "metroUz", 41.303922, 69.235794, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1126, "Novza Bekati", "metroUz", 41.293046, 69.223814, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1127, "Novza Bekati", "metroUz", 41.292608, 69.224631, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1128, "Novza Bekati", "metroUz", 41.291915, 69.222546, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1129, "Novza Bekati", "metroUz", 41.291915, 69.222546, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1130, "Novza Bekati", "metroUz", 41.292066, 69.224198, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1131, "Novza Bekati", "metroUz", 41.291454, 69.223327, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1132, "Novza Bekati", "metroUz", 41.291643, 69.222281, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1133, "Novza Bekati", "metroUz", 41.291126, 69.223018, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1134, "Mirzo Ulug`bek Bekati", "metroUz", 41.283130, 69.212826, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1135, "Mirzo Ulug`bek Bekati", "metroUz", 41.282824, 69.212473, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1136, "Mirzo Ulug`bek Bekati", "metroUz", 41.282549, 69.213552, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1137, "Mirzo Ulug`bek Bekati", "metroUz", 41.282315, 69.213272, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1138, "Mirzo Ulug`bek Bekati", "metroUz", 41.281914, 69.211499, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1139, "Mirzo Ulug`bek Bekati", "metroUz", 41.281626, 69.211163, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1140, "Mirzo Ulug`bek Bekati", "metroUz", 41.281128, 69.211931, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1141, "Mirzo Ulug`bek Bekati", "metroUz", 41.281446, 69.212285, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1142, "Chilonzor Bekati", "metroUz", 41.275313, 69.204831, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1143, "Chilonzor Bekati", "metroUz", 41.275032, 69.204611, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1144, "Chilonzor Bekati", "metroUz", 41.274933, 69.205716, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1145, "Chilonzor Bekati", "metroUz", 41.274655, 69.205505, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1146, "Chilonzor Bekati", "metroUz", 41.273982, 69.203822, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1147, "Chilonzor Bekati", "metroUz", 41.273667, 69.203577, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1148, "Chilonzor Bekati", "metroUz", 41.273600, 69.204715, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1149, "Chilonzor Bekati", "metroUz", 41.273307, 69.204449, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1150, "Olmazor Bekati", "metroUz", 41.257341, 69.195366, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1151, "Olmazor Bekati", "metroUz", 41.257591, 69.195953, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1152, "Olmazor Bekati", "metroUz", 41.257234, 69.195964, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1153, "Olmazor Bekati", "metroUz", 41.256049, 69.195918, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1154, "Olmazor Bekati", "metroUz", 41.255678, 69.195920, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1155, "1 Bekati (Chilonzor)", "metroUz", 41.238562, 69.195852, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1156, "2 Bekati (Chilonzor)", "metroUz", 41.228199, 69.203396, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1157, "2 Bekati (Chilonzor)", "metroUz", 41.221852, 69.208177, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1158, "3 Bekati (Chilonzor)", "metroUz", 41.221494, 69.208288, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1159, "3 Bekati (Chilonzor)", "metroUz", 41.220190, 69.209213, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1160, "4 Bekati (Chilonzor)", "metroUz", 41.214645, 69.213196, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1161, "4 Bekati (Chilonzor)", "metroUz", 41.213142, 69.214330, "METRO", "chilonzor"));

        busStopList.add(new BusStop(1162, "5 Bekati (Chilonzor)", "metroUz", 41.207018, 69.218746, "METRO", "chilonzor"));
        busStopList.add(new BusStop(1163, "5 Bekati (Chilonzor)", "metroUz", 41.205481, 69.219829, "METRO", "chilonzor"));

        for (BusStop busStop : busStopList) {
            BusMapAccessor.getInstance().addBusStop(busStop);
        }


        List<MetroStop> metroStops = new ArrayList<>();
//        chilonzor
        metroStops.add(new MetroStop("Buyuk ipak yo`li Bekati", "metroUz", bIY.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Purshkin Bekati", "metroUz", pushB.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Xamid Olimjon Bekati", "metroUz", xob.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Amir Temur Bekati", "metroUz", atb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Mustaqillik Bekati", "metroUz", musB.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Paxtakor Bekati", "metroUz", pah.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Xalqlar do`stligi Bekati", "metroUz", xalq.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Milliy bog` Bekati", "metroUz", mb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Novza Bekati", "metroUz", nb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Chilonzor Bekati", "metroUz", chb.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Mirzo Ulug`bek Bekati", "metroUz", mub.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("Olmazor Bekati", "metroUz", ob.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("1 Bekati (chilonzor)", "metroUz", bch1.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("2 Bekati (chilonzor)", "metroUz", bch2.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("3 Bekati (chilonzor)", "metroUz", bch3.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("4 Bekati (chilonzor)", "metroUz", bch4.toString(), "METRO", "chilonzor"));
        metroStops.add(new MetroStop("5 Bekati (chilonzor)", "metroUz", bch5.toString(), "METRO", "chilonzor"));
// o`zbekiston
        metroStops.add(new MetroStop("Do`stlik Bekati", "metroUz", dost.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Mashinasozlar Bekati", "metroUz", mash.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Toshkent Bekati", "metroUz", tosh.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Oybek Bekati", "metroUz", oybek.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Kasmanaftlar Bekati", "metroUz", kasB.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("O`zbekiston Bekati", "metroUz", ozb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Alisher Navoiy Bekati", "metroUz", anb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("G`ofur G`ulom Bekati", "metroUz", ggb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Chorsu Bekati", "metroUz", chob.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Tinchlik Bekati", "metroUz", tb.toString(), "METRO", "O`zbekiston"));
        metroStops.add(new MetroStop("Beruniy Bekati", "metroUz", bb.toString(), "METRO", "O`zbekiston"));
//yer usti xalqa yo`li
        metroStops.add(new MetroStop("Do`stlik 2 Bekati", "metroUz", dost2.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("2 Bekati", "metroUz", b2.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("3 Bekati", "metroUz", b3.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("4 Bekati", "metroUz", b4.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("5 Bekati", "metroUz", b5.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("6 Bekati", "metroUz", b6.toString(), "METRO", "yer_usti_halqa_yo`li"));
        metroStops.add(new MetroStop("7 Bekati", "metroUz", b7.toString(), "METRO", "yer_usti_halqa_yo`li"));
//yunusobod
        metroStops.add(new MetroStop("Turkiston Bekati", "metroUz", turk.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Yunusobod Bekati", "metroUz", yb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Shaxriston Bekati", "metroUz", shb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Bodomzor Bekati", "metroUz", bodom.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Minor Bekati", "metroUz", minor.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Abdulla Qodiriy Bekati", "metroUz", aqb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Yunus Rajabiy Bekati", "metroUz", yrb.toString(), "METRO", "yunusobod"));
        metroStops.add(new MetroStop("Ming o`rik Bekati", "metroUz", mob.toString(), "METRO", "yunusobod"));

        metroRepository.deleteAll();
        for (MetroStop metro : metroStops) {
            metroRepository.save(metro);
        }
    }
}*/
