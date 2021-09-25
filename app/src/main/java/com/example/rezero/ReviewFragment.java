package com.example.rezero;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.Fragment;

import android.support.v4.media.RatingCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    int reviewNum=10;

    RatingBar starPoint;
    TextView score;
    View view;
    LinearLayout basicLay;

    //리뷰생성을위한 배열생성
    LinearLayout[] llay = new LinearLayout[reviewNum];
    TextView[] userName = new TextView[reviewNum];
    RatingBar[] ratingBar = new RatingBar[reviewNum];
    ImageView[] img = new ImageView[reviewNum];
    TextView[] review = new TextView[reviewNum];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_review, container, false);

        //전체별점
        starPoint = (RatingBar) view.findViewById(R.id.starPoint);//.getRating() - 레이팅바 점수 가져오는 함수
        score = (TextView) view.findViewById(R.id.score);
        score.setText(Float.toString(starPoint.getRating()));

        //사용자리뷰생성
        basicLay = (LinearLayout)view.findViewById(R.id.basicLay);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.CustomRatingBar);//레이팅바스타일

        LinearLayout.LayoutParams llayParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llayParams.topMargin=20;

        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,600);
        imgParams.rightMargin=50;
        imgParams.leftMargin=50;
        imgParams.topMargin=10;

        LinearLayout.LayoutParams txvParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txvParams.rightMargin=80;
        txvParams.leftMargin=80;
        txvParams.topMargin=10;
        txvParams.bottomMargin=10;

        for (int i=0;i<reviewNum;i++){
            llay[i] = new LinearLayout(getContext());
            userName[i] = new TextView(getContext());
            ratingBar[i] = new RatingBar(contextThemeWrapper,null,R.attr.ratingBarStyleIndicator);
            img[i] = new ImageView(getContext());
            review[i] =new TextView(getContext());

            llay[i].setGravity(Gravity.CENTER);
            llay[i].setLayoutParams(llayParams);

            userName[i].setText("사용자명");
            userName[i].setTextColor(Color.parseColor("#263959"));
            userName[i].setTextSize(18);
            userName[i].setPadding(10,0,10,0);

            ratingBar[i].setRating(3);
            ratingBar[i].setMax(5);
            ratingBar[i].setIsIndicator(true);

            llay[i].addView(userName[i]);
            llay[i].addView(ratingBar[i]);

            img[i].setBackground(getResources().getDrawable(R.drawable.rounding_imageback));
            img[i].setLayoutParams(imgParams);

            review[i].setText("-----------리뷰내용---------------");
            review[i].setLayoutParams(txvParams);

            basicLay.addView(llay[i]);
            basicLay.addView(img[i]);
            basicLay.addView(review[i]);

        }

        //1ㄷ1문의버튼
        LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btnParams.topMargin=20;
        btnParams.bottomMargin=20;
        btnParams.gravity=Gravity.CENTER;
        Button qnaBtn = new Button(getContext());
        qnaBtn.setPadding(200,5,200,5);
        qnaBtn.setLayoutParams(btnParams);
        qnaBtn.setBackground(getResources().getDrawable(R.drawable.roundingqna));
        qnaBtn.setText("1:1문의하기");
        qnaBtn.setTextColor(Color.WHITE);
        basicLay.addView(qnaBtn);

        return view;
    }
}