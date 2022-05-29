package uas.bayu.belajarmusik.utils;

import java.util.HashMap;
import java.util.Map;

import uas.bayu.belajarmusik.R;

public class QuestionDatas {

    public static Map<String, Integer> getImageList(){
        HashMap<String, Integer> images = new HashMap<>();

        //Tradisional
        images.put("Berasal dari manakah alat musik tradisional pada gambar tersebut?", R.drawable.trad_tifa);
        images.put("Apakah nama alat musik tradisional tersebut?", R.drawable.trad_rebab_jabar);
        images.put("Dengan cara apa alat musik tradisional kompang dimainkan?", R.drawable.trad_kompang);
        images.put("Terbuat dari apa alat musik tradisional tehyan?", R.drawable.trad_tehyan);
        images.put("Gambus adalah salah satu alat musik tradisional. Bagaimana cara untuk memainkan alat musik tersebut?", R.drawable.trad_gambus);

        //Modern
        images.put("Bagaimana cara untuk bermain alat musik modern keyboard?", R.drawable.mod_keyboard);
        images.put("Bagaimana cara untuk bermain pada alat musik modern biola?", R.drawable.mod_biola);
        images.put("Bagaimana cara untuk bermain pada alat musik modern harmonika?", R.drawable.mod_harmonika);
        images.put("Jenis genry apakah alat musik modern banjo biasa dimainkan?", R.drawable.mod_banjo);
        images.put("Terbuat dari apakah alat musik modern saxophone?", R.drawable.mod_saxophone);

        return images;
    }

    public static Map<String, Map<String, Boolean>> getQuestionsList(){
        HashMap<String, Map<String, Boolean>> questions = new HashMap<>();

        HashMap<String, Boolean> answerList = new HashMap<>();
        answerList.put("Maluku", false);
        answerList.put("Papua", false);
        answerList.put("Maluku dan Papua", true);
        answerList.put("Riau", false);
        questions.put("Berasal dari manakah alat musik tradisional pada gambar tersebut?", answerList);

        HashMap<String, Boolean> answerList2 = new HashMap<>();
        answerList2.put("Angklung", false);
        answerList2.put("Rebab", true);
        answerList2.put("Gamelan", false);
        answerList2.put("Kolintang", false);
        questions.put("Apakah nama alat musik tradisional tersebut?", answerList2);

        HashMap<String, Boolean> answerList3 = new HashMap<>();
        answerList3.put("Dipetik", false);
        answerList3.put("Ditekan", false);
        answerList3.put("Ditarik", false);
        answerList3.put("Dipukul", true);
        questions.put("Dengan cara apa alat musik tradisional kompang dimainkan?", answerList3);

        HashMap<String, Boolean> answerList4 = new HashMap<>();
        answerList4.put("Kayu Jati", false);
        answerList4.put("Kulit Lembu", true);
        answerList4.put("Bambu", false);
        answerList4.put("Kayu Meranti", false);
        questions.put("Terbuat dari apa alat musik tradisional tehyan?", answerList4);

        HashMap<String, Boolean> answerList5 = new HashMap<>();
        answerList5.put("Dipetik", true);
        answerList5.put("Ditekan", false);
        answerList5.put("Ditarik", false);
        answerList5.put("Dipukul", false);
        questions.put("Gambus adalah salah satu alat musik tradisional. Bagaimana cara untuk memainkan alat musik tersebut?", answerList5);

        HashMap<String, Boolean> answerList6 = new HashMap<>();
        answerList6.put("Dipetik", false);
        answerList6.put("Ditekan", true);
        answerList6.put("Ditarik", false);
        answerList6.put("Dipukul", false);
        questions.put("Bagaimana cara untuk bermain alat musik modern keyboard?", answerList6);

        HashMap<String, Boolean> answerList7 = new HashMap<>();
        answerList7.put("Dipetik", false);
        answerList7.put("Ditekan", false);
        answerList7.put("Digesek", true);
        answerList7.put("Dipukul", false);
        questions.put("Bagaimana cara untuk bermain pada alat musik modern biola?", answerList7);

        HashMap<String, Boolean> answerList8 = new HashMap<>();
        answerList8.put("Dipetik", false);
        answerList8.put("Ditiup", true);
        answerList8.put("Digesek", false);
        answerList8.put("Dipukul", false);
        questions.put("Bagaimana cara untuk bermain pada alat musik modern harmonika?", answerList8);

        HashMap<String, Boolean> answerList9 = new HashMap<>();
        answerList9.put("Country", true);
        answerList9.put("Rock", false);
        answerList9.put("Pop", false);
        answerList9.put("Jazz", false);
        questions.put("Jenis genry apakah alat musik modern banjo biasa dimainkan?", answerList9);

        HashMap<String, Boolean> answerList10 = new HashMap<>();
        answerList10.put("Logam", true);
        answerList10.put("Karet", false);
        answerList10.put("Plastik", false);
        answerList10.put("Kayu", false);
        questions.put("Terbuat dari apakah alat musik modern saxophone?", answerList10);

        return questions;
    }
}
