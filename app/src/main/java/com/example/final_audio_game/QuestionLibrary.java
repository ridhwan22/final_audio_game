package com.example.final_audio_game;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class QuestionLibrary extends AppCompatActivity {
    // List of songs
    private MediaPlayer[] Songs = new MediaPlayer[18];

    // Array of arrays of different song choices
    private String[][] choices = {
            {"Lucid Dreams", "What a Time", "God's Plan", "Comethru"},
            {"7 Rings", "Tik Tok", "The Only", "The Middle"},
            {"Sweet but Psycho", "Rolling in the Deep", "Without Me", "Talk"},
            {"Lucid Dreams", "Let Me Down Slowly", "Please Me", "What A Time"},
            {"A Little Braver", "Without Me", "Tik Tok", "7 Rings"},
            {"Sweet but Psycho", "Better Now", "Dancing With a Stranger", "The Middle"},
            {"Let Me Down Slowly", "The Middle", "Please Me", "Comethru"},
            {"Better Now", "Talk", "Tik Tok", "Without Me"},
            {"7 Rings", "What a Time", "Rolling in the Deep", "Comethru"},
            {"Dancing With a Stranger", "What a Time", "Lucid Dreams", "Talk"},
            {"What a Time", "Better Now", "The Middle", "Sweet but Psycho"},
            {"Tik Tok", "Let Me Down Slowly", "Older", "A Little Braver"},
            {"Sweet but Psycho", "What a Time", "Talk", "Older"},
            {"The Only", "A Little Braver", "Let Me Down Slowly", "Comethru"},
            {"Comethru", "Please Me", "Without Me", "Better Now"},
            {"Lucid Dreams", "Dancing with a Stranger", "Let Me Down Slowly", "Talk"},
            {"Older", "The Only", "What a Time", "Sweet but Psycho"},
            {"The Middle", "The Only", "Talk", "Better Now"}
    };

    // Array of answers
    private String[] answers = {"God's Plan", "The Only", "Rolling in the Deep", "Let Me Down Slowly",
            "7 Rings", "Sweet but Psycho", "Please Me", "Without Me", "Comethru", "Lucid Dreams",
            "What a Time", "Tik Tok", "Talk", "A Little Braver", "Better Now", "Dancing with a Stranger",
            "Older", "The Middle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the songs
        MediaPlayer RollingInTheDeep = MediaPlayer.create(this, R.raw.adele_rolling_in_the_deep);
        MediaPlayer LetMeDownSlowly = MediaPlayer.create(this, R.raw.alec_benjamin_let_me_down_slowly);
        MediaPlayer SevenRings = MediaPlayer.create(this, R.raw.ariana_grande_7_rings);
        MediaPlayer SweetButPsycho = MediaPlayer.create(this, R.raw.ava_max_sweet_but_psycho);
        MediaPlayer PleaseMe = MediaPlayer.create(this, R.raw.cardi_b_bruno_mars_please_me);
        MediaPlayer God_s_Plan = MediaPlayer.create(this, R.raw.drake_god_s_plan);
        MediaPlayer WithoutMe = MediaPlayer.create(this, R.raw.halsey_without_me);
        MediaPlayer Comethru = MediaPlayer.create(this, R.raw.jeremy_zucker_comethru);
        MediaPlayer LucidDreams = MediaPlayer.create(this, R.raw.juice_wrld_lucid_dreams);
        MediaPlayer WhatATime = MediaPlayer.create(this, R.raw.julia_michaels_what_a_time);
        MediaPlayer TikTok = MediaPlayer.create(this, R.raw.ke_ha_tik_tok);
        MediaPlayer Talk = MediaPlayer.create(this, R.raw.khalid_talk);
        MediaPlayer ALittleBraver = MediaPlayer.create(this, R.raw.new_empire_a_little_braver);
        MediaPlayer BetterNow = MediaPlayer.create(this, R.raw.post_malone_better_now);
        MediaPlayer DancingWithAStranger = MediaPlayer.create(this, R.raw.sam_smith_normani_dancing_with_a_stranger);
        MediaPlayer TheOnly = MediaPlayer.create(this, R.raw.sasha_sloan_the_only);
        MediaPlayer Older = MediaPlayer.create(this, R.raw.sasha_sloan_older);
        MediaPlayer TheMiddle = MediaPlayer.create(this, R.raw.zedd_grey_the_middle);

        // Adding all the songs to the ArrayList Songs
        MediaPlayer[] songArr = {God_s_Plan, TheOnly, RollingInTheDeep, LetMeDownSlowly, SevenRings,
                SweetButPsycho, PleaseMe, WithoutMe, Comethru, LucidDreams, WhatATime, TikTok, Talk,
                ALittleBraver, BetterNow, DancingWithAStranger, Older, TheMiddle};
        Songs = songArr;
    }

    // Getter for each song;
    public MediaPlayer getSong(int index) {
        MediaPlayer song = Songs[index];
        return song;
    }

    // Get the first choice of each question
    public String getChoice1(int index) {
        String choice1 = choices[index][0];
        return choice1;
    }

    // Get the second choice of each question
    public String getChoice2(int index) {
        String choice2 = choices[index][1];
        return choice2;
    }

    // Get the third choice of each question
    public String getChoice3(int index) {
        String choice3 = choices[index][2];
        return choice3;
    }

    // Get the fourth choice of each question
    public String getChoice4(int index) {
        String choice4 = choices[index][3];
        return choice4;
    }

    // Get the answer for each question
    public String getAnswer(int index) {
        String answer = answers[index];
        return answer;
    }
}