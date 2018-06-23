package com.example.ntut;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainGame extends Fragment {

    private ImageButton mImgBtnScissors,mImgBtnStone,mImgBtnPaper;
    private ImageView mImgViewComPlay;
    private ImageView mImgHeartOne,mImgHeartTwo,mImgHeartThree,mImgHeartFour,mImgHeartFive;
    private TextView mTxtResult;
    private int miCountPlayerWin = 0,miCountComWin = 0;

    public MainGame() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_game, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTxtResult = (TextView) getView().findViewById(R.id.txtResult);
        mImgBtnScissors = (ImageButton) getView().findViewById(R.id.imgBtnScissors);
        mImgBtnStone = (ImageButton) getView().findViewById(R.id.imgBtnStone);
        mImgBtnPaper = (ImageButton) getView().findViewById(R.id.imgBtnPaper);
        mImgViewComPlay = (ImageView) getView().findViewById(R.id.imgViewComPlay);
        mImgHeartOne = (ImageView) getView().findViewById(R.id.imgHeartOne);
        mImgHeartTwo = (ImageView) getView().findViewById(R.id.imgHeartTwo);
        mImgHeartThree = (ImageView) getView().findViewById(R.id.imgHeartThree);
        mImgHeartFour = (ImageView) getView().findViewById(R.id.imgHeartFour);
        mImgHeartFive = (ImageView) getView().findViewById(R.id.imgHeartFive);

        mImgBtnScissors.setOnClickListener(imgBtnScissorsOnClick);
        mImgBtnStone.setOnClickListener(imgBtnStoneOnClick);
        mImgBtnPaper.setOnClickListener(imgBtnPaperOnClick);
    }

    private void LoseHeart(){
        if(miCountComWin==1){
            mImgHeartFive.setVisibility(View.INVISIBLE);
        } else if(miCountComWin==2){
            mImgHeartFour.setVisibility(View.INVISIBLE);
        } else if(miCountComWin==3){
            mImgHeartThree.setVisibility(View.INVISIBLE);
        } else if(miCountComWin==4){
            mImgHeartTwo.setVisibility(View.INVISIBLE);
        } else if(miCountComWin==5){
            mTxtResult.setText("很可惜失敗了，遊戲重新開始");
            miCountPlayerWin=0;
            miCountComWin=0;
            mImgHeartFive.setVisibility(View.VISIBLE);
            mImgHeartFour.setVisibility(View.VISIBLE);
            mImgHeartThree.setVisibility(View.VISIBLE);
            mImgHeartTwo.setVisibility(View.VISIBLE);
        }
    }

    private View.OnClickListener imgBtnScissorsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // Decide computer play.
            int iComPlay = (int)(Math.random()*3 + 1);

//            mEdtCountSet.setText(String.valueOf(miCountSet));

            // 1 - scissors, 2 - stone, 3 - net.
            if(miCountPlayerWin==0||miCountPlayerWin==2||miCountPlayerWin==5||miCountPlayerWin==8){
                if (iComPlay == 1) {
                    mImgViewComPlay.setImageResource(R.drawable.scissors);
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_draw));
//                mEdtCountDraw.setText(String.valueOf(miCountDraw));
                }
                else if (iComPlay == 2) {
                    mImgViewComPlay.setImageResource(R.drawable.stone);
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_lose));
                    miCountComWin++;
                    LoseHeart();
//                mEdtCountComWin.setText(String.valueOf(miCountComWin));
                }
                else {
                    mImgViewComPlay.setImageResource(R.drawable.paper);
                    miCountPlayerWin++;
                    ((MainActivity)getActivity()).setmPlayerWin(miCountPlayerWin);
                    if(miCountPlayerWin>=9){
                        mTxtResult.setText("恭喜過關，請前往觀看戰利品");
                    }else if(miCountPlayerWin==1){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win1));
                    }else if(miCountPlayerWin==2){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win2));
                    }else if(miCountPlayerWin==3){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win3));
                    }else if(miCountPlayerWin==4){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win4));
                    }else if(miCountPlayerWin==5){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win5));
                    }else if(miCountPlayerWin==6){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win6));
                    }else if(miCountPlayerWin==7){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win7));
                    }else if(miCountPlayerWin==8){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win8));
                    }
//                mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin));
                }
            }
            else{
                mImgViewComPlay.setImageResource(R.drawable.paper);
                miCountPlayerWin++;
                ((MainActivity)getActivity()).setmPlayerWin(miCountPlayerWin);
                if(miCountPlayerWin>=9){
                    mTxtResult.setText("恭喜過關，請前往觀看戰利品");
                }else if(miCountPlayerWin==1){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win1));
                }else if(miCountPlayerWin==2){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win2));
                }else if(miCountPlayerWin==3){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win3));
                }else if(miCountPlayerWin==4){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win4));
                }else if(miCountPlayerWin==5){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win5));
                }else if(miCountPlayerWin==6){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win6));
                }else if(miCountPlayerWin==7){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win7));
                }else if(miCountPlayerWin==8){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win8));
                }
            }
        }
    };
    private View.OnClickListener imgBtnStoneOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            int iComPlay = (int)(Math.random()*3 + 1);

//            mEdtCountSet.setText(String.valueOf(miCountSet));

            // 1 - scissors, 2 - stone, 3 - net.
            if(miCountPlayerWin==0||miCountPlayerWin==2||miCountPlayerWin==5||miCountPlayerWin==8){
                if (iComPlay == 1) {
                    mImgViewComPlay.setImageResource(R.drawable.scissors);
                    miCountPlayerWin++;
                    ((MainActivity)getActivity()).setmPlayerWin(miCountPlayerWin);
                    if(miCountPlayerWin>=9){
                        mTxtResult.setText("恭喜過關，請前往觀看戰利品");
                    }else if(miCountPlayerWin==1){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win1));
                    }else if(miCountPlayerWin==2){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win2));
                    }else if(miCountPlayerWin==3){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win3));
                    }else if(miCountPlayerWin==4){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win4));
                    }else if(miCountPlayerWin==5){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win5));
                    }else if(miCountPlayerWin==6){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win6));
                    }else if(miCountPlayerWin==7){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win7));
                    }else if(miCountPlayerWin==8){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win8));
                    }
    //                mEdtCountPlayerWin.setText(String.valueOf(miCountPlayerWin));
                }
                else if (iComPlay == 2) {
                    mImgViewComPlay.setImageResource(R.drawable.stone);
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_draw));
    //                mEdtCountDraw.setText(String.valueOf(miCountDraw));
                }
                else {
                    mImgViewComPlay.setImageResource(R.drawable.paper);
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_lose));
                    miCountComWin++;
                    LoseHeart();
    //                mEdtCountComWin.setText(String.valueOf(miCountComWin));
                }
            } else{
                mImgViewComPlay.setImageResource(R.drawable.scissors);
                miCountPlayerWin++;
                ((MainActivity)getActivity()).setmPlayerWin(miCountPlayerWin);
                if(miCountPlayerWin>=9){
                    mTxtResult.setText("恭喜過關，請前往觀看戰利品");
                }else if(miCountPlayerWin==1){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win1));
                }else if(miCountPlayerWin==2){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win2));
                }else if(miCountPlayerWin==3){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win3));
                }else if(miCountPlayerWin==4){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win4));
                }else if(miCountPlayerWin==5){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win5));
                }else if(miCountPlayerWin==6){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win6));
                }else if(miCountPlayerWin==7){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win7));
                }else if(miCountPlayerWin==8){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win8));
                }
            }
        }
    };

    private View.OnClickListener imgBtnPaperOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            int iComPlay = (int)(Math.random()*3 + 1);

            // 1 - scissors, 2 - stone, 3 - net.
            if(miCountPlayerWin==0||miCountPlayerWin==2||miCountPlayerWin==5||miCountPlayerWin==8) {
                if (iComPlay == 1) {
                    mImgViewComPlay.setImageResource(R.drawable.scissors);
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_lose));
                    miCountComWin++;
                    LoseHeart();
                } else if (iComPlay == 2) {
                    mImgViewComPlay.setImageResource(R.drawable.stone);
                    miCountPlayerWin++;
                    ((MainActivity)getActivity()).setmPlayerWin(miCountPlayerWin);
                    if(miCountPlayerWin>=9){
                        mTxtResult.setText("恭喜過關，請前往觀看戰利品");
                    }else if(miCountPlayerWin==1){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win1));
                    }else if(miCountPlayerWin==2){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win2));
                    }else if(miCountPlayerWin==3){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win3));
                    }else if(miCountPlayerWin==4){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win4));
                    }else if(miCountPlayerWin==5){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win5));
                    }else if(miCountPlayerWin==6){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win6));
                    }else if(miCountPlayerWin==7){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win7));
                    }else if(miCountPlayerWin==8){
                        mTxtResult.setText(getString(R.string.result) +
                                getString(R.string.player_win8));
                    }
                } else {
                    mImgViewComPlay.setImageResource(R.drawable.paper);
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_draw));
                }
            }else{
                mImgViewComPlay.setImageResource(R.drawable.stone);
                miCountPlayerWin++;
                ((MainActivity)getActivity()).setmPlayerWin(miCountPlayerWin);
                if(miCountPlayerWin>=9){
                    mTxtResult.setText("恭喜過關，請前往觀看戰利品");
                }else if(miCountPlayerWin==1){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win1));
                }else if(miCountPlayerWin==2){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win2));
                }else if(miCountPlayerWin==3){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win3));
                }else if(miCountPlayerWin==4){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win4));
                }else if(miCountPlayerWin==5){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win5));
                }else if(miCountPlayerWin==6){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win6));
                }else if(miCountPlayerWin==7){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win7));
                }else if(miCountPlayerWin==8){
                    mTxtResult.setText(getString(R.string.result) +
                            getString(R.string.player_win8));
                }
            }
        }
    };
}
