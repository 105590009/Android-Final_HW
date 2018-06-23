package com.example.ntut;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;



public class Puzzle extends Fragment {

    private ImageView firstImage,secondImage,thirdImage,
                      fourthImage, fifthImage,sixthImage,
                      seventhImage, eighthImage, ninthImage;
    private ImageView combineImage;
    private Button combineButton,refreshBotton;
    private int unlock=0;

    public Puzzle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_puzzle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        firstImage = (ImageView) getView().findViewById(R.id.imageView1);
        secondImage = (ImageView) getView().findViewById(R.id.imageView2);
        thirdImage = (ImageView) getView().findViewById(R.id.imageView3);
        fourthImage = (ImageView) getView().findViewById(R.id.imageView4);
        fifthImage = (ImageView) getView().findViewById(R.id.imageView5);
        sixthImage = (ImageView) getView().findViewById(R.id.imageView6);
        seventhImage = (ImageView) getView().findViewById(R.id.imageView7);
        eighthImage = (ImageView) getView().findViewById(R.id.imageView8);
        ninthImage = (ImageView) getView().findViewById(R.id.imageView9);
        combineImage = (ImageView) getView().findViewById(R.id.imageView10);
        combineButton = (Button) getView().findViewById(R.id.combine_button);
        refreshBotton = (Button) getView().findViewById(R.id.refresh_bottom);

        combineButton.setOnClickListener(combineOnclick);
        refreshBotton.setOnClickListener(refreshOnclick);
        firstImage.setVisibility(View.INVISIBLE);
        secondImage.setVisibility(View.INVISIBLE);
        thirdImage.setVisibility(View.INVISIBLE);
        fourthImage.setVisibility(View.INVISIBLE);
        fifthImage.setVisibility(View.INVISIBLE);
        sixthImage.setVisibility(View.INVISIBLE);
        seventhImage.setVisibility(View.INVISIBLE);
        eighthImage.setVisibility(View.INVISIBLE);
        ninthImage.setVisibility(View.INVISIBLE);
        combineImage.setVisibility(View.INVISIBLE);
    }
    private View.OnClickListener combineOnclick = new View.OnClickListener(){
        public void onClick(View v) {
            if(unlock>=9){
                combineImage.setVisibility(View.VISIBLE);
                firstImage.setVisibility(View.INVISIBLE);
                secondImage.setVisibility(View.INVISIBLE);
                thirdImage.setVisibility(View.INVISIBLE);
                fourthImage.setVisibility(View.INVISIBLE);
                fifthImage.setVisibility(View.INVISIBLE);
                sixthImage.setVisibility(View.INVISIBLE);
                seventhImage.setVisibility(View.INVISIBLE);
                eighthImage.setVisibility(View.INVISIBLE);
                ninthImage.setVisibility(View.INVISIBLE);
            }
        }
    };
    private View.OnClickListener refreshOnclick = new View.OnClickListener(){
        public void onClick(View v) {
            unlock = ((MainActivity)getActivity()).getmPlayerWin();
            if (unlock == 1) {
                firstImage.setVisibility(View.VISIBLE);
            } else if (unlock == 2) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
            } else if (unlock == 3) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
            } else if (unlock == 4) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
                fourthImage.setVisibility(View.VISIBLE);
            } else if (unlock == 5) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
                fourthImage.setVisibility(View.VISIBLE);
                fifthImage.setVisibility(View.VISIBLE);
            } else if (unlock == 6) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
                fourthImage.setVisibility(View.VISIBLE);
                fifthImage.setVisibility(View.VISIBLE);
                sixthImage.setVisibility(View.VISIBLE);
            } else if (unlock == 7) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
                fourthImage.setVisibility(View.VISIBLE);
                fifthImage.setVisibility(View.VISIBLE);
                sixthImage.setVisibility(View.VISIBLE);
                seventhImage.setVisibility(View.VISIBLE);
            } else if (unlock == 8) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
                fourthImage.setVisibility(View.VISIBLE);
                fifthImage.setVisibility(View.VISIBLE);
                sixthImage.setVisibility(View.VISIBLE);
                seventhImage.setVisibility(View.VISIBLE);
                eighthImage.setVisibility(View.VISIBLE);
            } else if (unlock >= 9) {
                firstImage.setVisibility(View.VISIBLE);
                secondImage.setVisibility(View.VISIBLE);
                thirdImage.setVisibility(View.VISIBLE);
                fourthImage.setVisibility(View.VISIBLE);
                fifthImage.setVisibility(View.VISIBLE);
                sixthImage.setVisibility(View.VISIBLE);
                seventhImage.setVisibility(View.VISIBLE);
                eighthImage.setVisibility(View.VISIBLE);
                ninthImage.setVisibility(View.VISIBLE);
            }else{
                firstImage.setVisibility(View.INVISIBLE);
                secondImage.setVisibility(View.INVISIBLE);
                thirdImage.setVisibility(View.INVISIBLE);
                fourthImage.setVisibility(View.INVISIBLE);
                fifthImage.setVisibility(View.INVISIBLE);
                sixthImage.setVisibility(View.INVISIBLE);
                seventhImage.setVisibility(View.INVISIBLE);
                eighthImage.setVisibility(View.INVISIBLE);
                ninthImage.setVisibility(View.INVISIBLE);
            }
        }
    };
}
