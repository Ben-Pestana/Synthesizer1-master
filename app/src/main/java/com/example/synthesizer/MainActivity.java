package com.example.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int WHOLE_NOTE = 1000;
    private static final int HALF_NOTE = WHOLE_NOTE/2;

    //buttons
    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;

    private Button highButtonA;
    private Button highButtonBb;
    private Button highButtonB;
    private Button highButtonC;
    private Button highButtonCs;
    private Button highButtonD;
    private Button highButtonDs;
    private Button highButtonE;
    private Button highButtonF;
    private Button highButtonFs;
    private Button highButtonG;
    private Button highButtonGs;

    private Button longScaleButton;
    private Button scaleButton;

    private Button challenge2;

    private NumberPicker notePicker;
    private NumberPicker numPicker;
    private NumberPicker twinkleLineTwoPlayer;
    private Button twinklePartThree;
    private Button twinklePartOne;
    private Button twinklePartTwo;
    private Button numPickerButton;

    private Button mySong;

    private int[] notes;

    //sounds
    private SoundPool soundPool;
    private int noteA;
    private int noteB;
    private int noteBb;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;

    private int highNoteA;
    private int highNoteB;
    private int highNoteBb;
    private int highNoteC;
    private int highNoteCs;
    private int highNoteD;
    private int highNoteDs;
    private int highNoteE;
    private int highNoteF;
    private int highNoteFs;
    private int highNoteG;
    private int highNoteGs;

    private Map<Integer, Integer> noteMap;


    public static final float DEFAULT_VOL = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
        initializeNumberPickers();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        // in a map, you store a key:value pair
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bb, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_highA, highNoteA);
        noteMap.put(R.id.button_synth_highBb, highNoteBb);
        noteMap.put(R.id.button_synth_highB, highNoteB);
        noteMap.put(R.id.button_synth_highC, highNoteC);
        noteMap.put(R.id.button_synth_highCs, highNoteCs);
        noteMap.put(R.id.button_synth_highD, highNoteD);
        noteMap.put(R.id.button_synth_highDs, highNoteDs);
        noteMap.put(R.id.button_synth_highE, highNoteE);
        noteMap.put(R.id.button_synth_highF, highNoteF);
        noteMap.put(R.id.button_synth_highFs, highNoteFs);
        noteMap.put(R.id.button_synth_highG, highNoteG);
        noteMap.put(R.id.button_synth_highGs, highNoteGs);






    }

    private void initializeNumberPickers() {
        numPicker.setMaxValue(10);
        numPicker.setMinValue(0);

        notes = new int[] {noteA, noteBb, noteB , noteC, noteCs, noteD, noteDs, noteE, noteF, noteFs, noteG,
                noteGs, highNoteA, highNoteBb, highNoteB, highNoteC, highNoteCs, highNoteD, highNoteDs, highNoteE,
                highNoteF, highNoteFs, highNoteG, highNoteGs};
        String[] noteLabels = {"A", "Bb", "B", "C", "Cs", "D", "Ds", "E", "F", "Fs", "G", "Gs", "High A", "High Bb",
                "High B", "High C", "High Cs", "High D", "High Ds", "High E", "High F", "High Fs", "High G", "High Gs"};
        notePicker.setDisplayedValues(noteLabels);
        notePicker.setMaxValue(noteLabels.length-1);
        notePicker.setMinValue(0);
        twinkleLineTwoPlayer.setMinValue(0);
        twinkleLineTwoPlayer.setMaxValue(5);

    }

    private void initializeSoundPool() {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this, R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);

        highNoteA = sound(R.raw.scalehigha);
        highNoteB = sound(R.raw.scalehighb);
        highNoteBb = sound(R.raw.scalehighbb);
        highNoteC = sound(R.raw.scalehighc);
        highNoteCs = sound(R.raw.scalehighcs);
        highNoteD = sound(R.raw.scalehighd);
        highNoteDs = sound(R.raw.scalehighds);
        highNoteE = sound(R.raw.scalehighe);
        highNoteF = sound(R.raw.scalehighf);
        highNoteFs = sound(R.raw.scalehighfs);
        highNoteG = sound(R.raw.scalehighg);
        highNoteGs = sound(R.raw.scalehighgs);



    }

    private int sound(int scale) {
        return soundPool.load(this, scale, 1);
    }


    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);

        highButtonA.setOnClickListener(noteListener);
        highButtonBb.setOnClickListener(noteListener);
        highButtonB.setOnClickListener(noteListener);
        highButtonC.setOnClickListener(noteListener);
        highButtonCs.setOnClickListener(noteListener);
        highButtonD.setOnClickListener(noteListener);
        highButtonDs.setOnClickListener(noteListener);
        highButtonE.setOnClickListener(noteListener);
        highButtonF.setOnClickListener(noteListener);
        highButtonFs.setOnClickListener(noteListener);
        highButtonG.setOnClickListener(noteListener);
        highButtonGs.setOnClickListener(noteListener);

        longScaleButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);
        challenge2.setOnClickListener(this);
        notePicker.setOnClickListener(this);
        numPicker.setOnClickListener(this);
        twinkleLineTwoPlayer.setOnClickListener(this);
        twinklePartOne.setOnClickListener(this);
        numPickerButton.setOnClickListener(this);
        twinklePartTwo.setOnClickListener(this);
        mySong.setOnClickListener(this);
        twinklePartThree.setOnClickListener(this);
    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById(R.id.button_synth_b);
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);

        highButtonA = findViewById(R.id.button_synth_highA);
        Log.d("LOOK AT ME", "wireWidgets: " + (highButtonA == null));
        highButtonBb = findViewById(R.id.button_synth_highBb);
        highButtonB = findViewById(R.id.button_synth_highB);
        highButtonC = findViewById(R.id.button_synth_highC);
        highButtonCs = findViewById(R.id.button_synth_highCs);
        highButtonD = findViewById(R.id.button_synth_highD);
        highButtonDs = findViewById(R.id.button_synth_highDs);
        highButtonE = findViewById(R.id.button_synth_highE);
        highButtonF = findViewById(R.id.button_synth_highF);
        highButtonFs = findViewById(R.id.button_synth_highFs);
        highButtonG = findViewById(R.id.button_synth_highG);
        highButtonGs = findViewById(R.id.button_synth_highGs);

        challenge2 = findViewById(R.id.button_synth_challenge2);
        longScaleButton = findViewById(R.id.button_synth_long);
        scaleButton = findViewById(R.id.button_synth_scale);
        notePicker = findViewById(R.id.numberPicker_synth_notePicker);
        numPicker = findViewById(R.id.numberPicker_synth_numPicker);
        twinklePartOne = findViewById(R.id.button_synth_twinklePartOne);
        twinklePartTwo = findViewById(R.id.button_synth_twinkleparttwo);
        numPickerButton = findViewById(R.id.button_synth_numPickerButton);
        mySong = findViewById(R.id.button_synth_challengeTwelve);
        twinkleLineTwoPlayer = findViewById(R.id.numberPicker_synth_twinkleline2);
        twinklePartThree = findViewById(R.id.button_synth_twinklePartThree);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_synth_scale:
                playScale();
                break;
            case R.id.button_synth_long:
                playLong();
                break;
            case R.id.numberPicker_synth_notePicker:
                pickNumber();
                break;
            case R.id.numberPicker_synth_numPicker:
                pickNumber();
                break;
            case R.id.button_synth_twinklePartOne:
                playTwinkleLineOne();
                break;
            case R.id.button_synth_numPickerButton:
                pickNumber();
                break;
            case R.id.button_synth_twinkleparttwo:
                playTwinkleLineOne();
                playTwinkleLineTwo();
                playTwinkleLineTwo();
                playTwinkleLineOne();
                break;
            case R.id.button_synth_twinklePartThree:
                playTwinkleLineOne();
                for (int i = numberOfLineTwo(); i > 0; i--) {
                    playTwinkleLineTwo();
                }
                playTwinkleLineOne();

        }
    }

    private void playLong() {
        playNote(noteE);
        delay(HALF_NOTE);
        playNote(noteFs);
        delay(HALF_NOTE);
        playNote(noteG);
        delay(HALF_NOTE);
        playNote(highNoteA);
        delay(HALF_NOTE);
        playNote(highNoteB);
        delay(HALF_NOTE);
        playNote(highNoteCs);
        delay(HALF_NOTE);
        playNote(highNoteD);
        delay(HALF_NOTE);
        playNote(highNoteE);
       
    }

    private void pickNumber(){
        int num = numPicker.getValue();
        int noteNum = notePicker.getValue();
        int note = notes[noteNum];
        playNote(note, num-1);
    }

    private int numberOfLineTwo(){
        int num = twinkleLineTwoPlayer.getValue();
        return num;
    }

    private void playScale() {
        //play all notes one at a time with delay in between
        Song scale = new Song();
        scale.add(new Note(noteA));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteB));

        playSong(scale);

        }

    private void playTwinkleLineOne() {
        Song twinkle = new Song();
        twinkle.add(new Note(noteA, WHOLE_NOTE/2));
        twinkle.add(new Note(noteA, WHOLE_NOTE/2));
        twinkle.add(new Note(highNoteE, WHOLE_NOTE/2));
        twinkle.add(new Note(highNoteE, WHOLE_NOTE/2));
        twinkle.add(new Note(highNoteFs, WHOLE_NOTE/2));
        twinkle.add(new Note(highNoteFs, WHOLE_NOTE/2));
        twinkle.add(new Note(highNoteE, WHOLE_NOTE/2));
        twinkle.add(new Note(noteD, WHOLE_NOTE/2));
        twinkle.add(new Note(noteD, WHOLE_NOTE/2));
        twinkle.add(new Note(noteCs, WHOLE_NOTE/2));
        twinkle.add(new Note(noteCs, WHOLE_NOTE/2));
        twinkle.add(new Note(noteB, WHOLE_NOTE/2));
        twinkle.add(new Note(noteB, WHOLE_NOTE/2));
        twinkle.add(new Note(noteA, WHOLE_NOTE/2));
        playSong(twinkle);

    }

    private void playTwinkleLineTwo() {
        Song twinkleLineTwo = new Song();
        twinkleLineTwo.add(new Note(highNoteE, WHOLE_NOTE/2));
        twinkleLineTwo.add(new Note(highNoteE, WHOLE_NOTE/2));
        twinkleLineTwo.add(new Note(noteD, WHOLE_NOTE/2));
        twinkleLineTwo.add(new Note(noteD, WHOLE_NOTE/2));
        twinkleLineTwo.add(new Note(noteCs, WHOLE_NOTE/2));
        twinkleLineTwo.add(new Note(noteCs, WHOLE_NOTE/2));
        twinkleLineTwo.add(new Note(noteB, WHOLE_NOTE/2));
    }

    private void playMySong(){
        Song mySong = new Song();
        mySong.add(new Note(noteE, WHOLE_NOTE/1));
        mySong.add(new Note(noteE, WHOLE_NOTE/2));
        mySong.add(new Note(noteG, WHOLE_NOTE/2));
        mySong.add(new Note(noteE, WHOLE_NOTE/2));
        mySong.add(new Note(noteD, WHOLE_NOTE/2));
        mySong.add(new Note(noteC, WHOLE_NOTE/2));
        mySong.add(new Note(noteB, WHOLE_NOTE/1));
        mySong.add(new Note(noteB, WHOLE_NOTE*2));
        mySong.add(new Note(noteE, WHOLE_NOTE/1));
        mySong.add(new Note(noteE, WHOLE_NOTE/2));
        mySong.add(new Note(noteG, WHOLE_NOTE/2));
        mySong.add(new Note(noteE, WHOLE_NOTE/2));
        mySong.add(new Note(noteD, WHOLE_NOTE/2));
        mySong.add(new Note(noteC, WHOLE_NOTE/1));
        mySong.add(new Note(noteB, WHOLE_NOTE*2));
        mySong.add(new Note(noteB, WHOLE_NOTE*2));
        mySong.add(new Note(noteE, WHOLE_NOTE/1));
        mySong.add(new Note(noteE, WHOLE_NOTE/2));
        mySong.add(new Note(noteG, WHOLE_NOTE/2));
        mySong.add(new Note(noteE, WHOLE_NOTE/2));
        mySong.add(new Note(noteD, WHOLE_NOTE/2));
        mySong.add(new Note(noteC, WHOLE_NOTE/2));
        mySong.add(new Note(noteB, WHOLE_NOTE*2));



    }

    private void playSong(Song song) {
        for(Note note : song.getNotes()) {
            playNote(note);
            delay(note.getDelay());
        }
    }


    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note, DEFAULT_VOL, DEFAULT_VOL, DEFAULT_PRIORITY, loop, DEFAULT_RATE);
    }
    private void playNote(int note){
        playNote(note, 0);
    }

    public void playNote(Note note) {
        playNote(note.getNoteId(), 0);

    }



    //make an inner class to handle the button clicks
    //for the individual notes
    private class KeyboardNoteListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // get the id of the button  that was clicked
            int id = view.getId();
            // use the map to figure out what note to play
            int note = noteMap.get(id);
            // play note
            playNote(note);


        }
    }
}
