package com.example.ntut;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Game extends Fragment {


    public Game() {
        // Required empty public constructor
    }

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mTxtComPlay = (TextView)getView().findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)getView().findViewById(R.id.txtResult);
        mBtnScissors = (Button)getView().findViewById(R.id.btnScissors);
        mBtnStone = (Button)getView().findViewById(R.id.btnStone);
        mBtnPaper = (Button)getView().findViewById(R.id.btnPaper);

        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            Main2 machine = new Main2(1);
            mTxtComPlay.setText(machine.getComputerChoice());
            mTxtResult.setText(machine.getResult());
        }
    };

    private View.OnClickListener btnStoneOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            Main2 machine = new Main2(2);
            mTxtComPlay.setText(machine.getComputerChoice());
            mTxtResult.setText(machine.getResult());
        }
    };

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            Main2 machine = new Main2(3);
            mTxtComPlay.setText(machine.getComputerChoice());
            mTxtResult.setText(machine.getResult());
        }
    };

    public class Main2 {
        private static final short HUM = 0;
        private static final short COM = 1;
        private static final short TIE = 2;
        private static short[][] map = {{TIE, COM, HUM}, {HUM, TIE, COM}, {COM, HUM, TIE}};

        private int CChoice;
        private short result;

        public Main2(int PChoice) {
            this.CChoice = (int)(Math.random() * 3 + 1);
            this.result = map[PChoice - 1][CChoice - 1];
        }

        public String getComputerChoice() {
            switch (CChoice) {
                case 1:  return "剪刀";
                case 2:  return "石頭";
                default: return "布";
            }
        }

        public String getResult() {
            switch (result) {
                case HUM: return "判定輸贏：恭喜，你贏了！";
                case COM: return "判定輸贏：很可惜，你輸了！";
                default:  return "判定輸贏：雙方平手！";
            }
        }

    }
}
