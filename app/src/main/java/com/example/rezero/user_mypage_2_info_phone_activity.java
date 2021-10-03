package com.example.rezero;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class user_mypage_2_info_phone_activity extends AppCompatActivity {

    private ImageView back;
    private InputMethodManager imm;


    //로그인 변수
    String login;
    String login_user_email;
    String login_user_pwd;
    String login_user_name;
    String login_user_order;
    String login_user_point;
    String login_user_coupon;
    String login_user_birth;
    String login_user_phone_num;
    String login_user_bank;
    String login_user_account;
    String login_user_address;
    String login_user_like_pro;
    String login_user_mission;
    String login_user_like_designer;
    String login_user_cart;
    String login_user_chat;
    String login_user_review;

    //이 화면에서 사용할 변수
    EditText user_mypage_2_info_phone_edittext_phone;
    EditText user_mypage_2_info_phone_edittext_check;
    View user_mypage_2_info_phone_view_check;
    View user_mypage_2_info_phone_view_check_2;
    LinearLayout user_mypage_2_info_phone_layout_all;
    View new_designer_2_view_success;
    Boolean check;

    public void onCreate(Bundle savedInstance)
    {
        //0. 로그인했을 때 조회한 db 값 가져오기
        Intent intent = new Intent(this.getIntent());

        login = intent.getStringExtra("login");
        Log.i("로그인함?",login+" ");

        login_user_email  = intent.getStringExtra("login_user_email");
        login_user_pwd  = intent.getStringExtra("login_user_pwd");
        Log.i("가져온 로그인 값?", login+"했으면? "+login_user_email+" "+login_user_pwd);

        login_user_name = intent.getStringExtra("login_user_name");
        login_user_order = intent.getStringExtra("login_user_order");
        login_user_point = intent.getStringExtra("login_user_point");
        login_user_coupon = intent.getStringExtra("login_user_coupon");
        login_user_birth = intent.getStringExtra("login_user_birth");
        login_user_phone_num = intent.getStringExtra("login_user_phone_num");
        login_user_bank = intent.getStringExtra("login_user_bank");
        login_user_account = intent.getStringExtra("login_user_account");
        login_user_address = intent.getStringExtra("login_user_address");
        login_user_like_pro = intent.getStringExtra("login_user_like_pro");
        login_user_mission = intent.getStringExtra("login_user_mission");
        login_user_like_designer = intent.getStringExtra("login_user_like_designer");
        login_user_cart = intent.getStringExtra("login_user_cart");
        login_user_chat = intent.getStringExtra("login_user_chat");
        login_user_review = intent.getStringExtra("login_user_review");

        //1. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_2_info_phone);

        //2. 뒤로가기 버튼
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });


        //3. 자바-XML
        user_mypage_2_info_phone_edittext_phone = (EditText) findViewById(R.id.user_mypage_2_info_phone_edittext_phone);
        user_mypage_2_info_phone_edittext_check = (EditText) findViewById(R.id.user_mypage_2_info_phone_edittext_check);
        user_mypage_2_info_phone_view_check = (View) findViewById(R.id.user_mypage_2_info_phone_view_check);
        user_mypage_2_info_phone_view_check_2 = (View) findViewById(R.id.user_mypage_2_info_phone_view_check_2);
        user_mypage_2_info_phone_layout_all = (LinearLayout) findViewById(R.id.user_mypage_2_info_phone_layout_all);
        new_designer_2_view_success = (View) findViewById(R.id.new_designer_2_view_success);


        //4. 키보드 내려가기
        imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

        user_mypage_2_info_phone_layout_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imm.hideSoftInputFromWindow(user_mypage_2_info_phone_edittext_phone.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(user_mypage_2_info_phone_edittext_check.getWindowToken(), 0);

            }
        });

        //5. 인증 번호 클릭하기
        user_mypage_2_info_phone_view_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //문자 서비스 구현하기
                user_mypage_2_info_phone_edittext_check.setHint("인증 서비스 구현 중...\n(확인과 수정완료 버튼 클릭)"); //문자 인증 구현하면 없애기
            }
        });

        //6. 인증 확인 클릭하기
        user_mypage_2_info_phone_view_check_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if (전송 = 입력번호)
                check = true; //인증했음!!

                //else -> 문자 인증 실패 다시 해주세요!
                //CustomDialog dlg = new CustomDialog(user_mypage_2_info_activity.this);
                //dlg.show();
                //check_text.setText("");

            }
        });

        //5. 수정 완료 버튼 클릭시
        new_designer_2_view_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String user_phone = user_mypage_2_info_phone_edittext_phone.getText().toString();
                //1. XML에서  비밀번호, 이름, 생년월일, 이메일, 핸드폰 번호 조회
                Log.i("새로 입력된 핸드폰 : ", user_phone);


                //(1-2) 요청 responseListenr 정의 (Volley 사용)
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("response", "응답 왔음?");
                            Log.i(">>>>>", response.toString());
                            //JSON 형태로 담아준다음에 서버로 전송 위해 패키징 (문자열로 전송할 수 없어서 사용)
                            JSONObject jsonObject = new JSONObject(response);

                            //성공 여부 가져오기
                            boolean success = jsonObject.getBoolean("success"); //php에 있는 success 키 값을 가져와서 True / False 담
                            Log.i("성공?", success + "");

                            //성공했으면
                            if (success) {
                                //php에 있는 쿼리 결과 바인딩 변수 user_email랑 user_pwd 키의 값을 가져와서 해당 변수에 담음!

                                String user_phone_num = jsonObject.getString("user_phone_num");
                                String username = jsonObject.getString("username");
                                String user_email = jsonObject.getString("user_email");

                                Log.i("업데이트된 user_phone은 ", user_phone_num);
                                Log.i("업데이트된 user_email은 ", user_email);

                                Log.i("성공 ", ": O");

                                //성공 화면으로 넘기기
                                Intent intent = new Intent(user_mypage_2_info_phone_activity.this, user_mypage_2_info_phone_success.class);
                                startActivity(intent);

                                return;
                            } else //실패했으면
                            {
                                // (2) 틀렸으면 경고창 문구 띄우고 다시
                                //틀림 알람 문구 띄우기
                                Log.i("실패 띄우기", "");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // (3) 서버로 Volley를 이용해서 요청함

                //login_1_request 클래스 (URL/PHP/전송방식 설정) 형식의 login_check_request 클래스 생성 > edittext에서 가져온 값 실제 전송
                user_mypage_info_phone_new_request login_pwd_request = new user_mypage_info_phone_new_request(user_phone, login_user_name, login_user_email, responseListener);
                //login_1_화면에서 큐 생성
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                //큐에 login_check_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                queue.add(login_pwd_request);


            }
        });

    }
}
