package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class new_user_1_activity extends AppCompatActivity {
    private EditText new_user_1_edittext_email;
    private EditText new_user_1_edittext_pwd;
    private EditText new_user_1_edittext_phone;
    private EditText new_user_1_edittext_check;
    private TextView new_user_1_textview_name;
    private TextView new_user_1_textview_birth;
    private TextView new_user_1_textview_address;
    private TextView new_user_1_textview_email;
    private TextView new_user_1_textview_pwd;
    private TextView new_user_1_textview_phone;
    private EditText new_user_1_edittext_name;
    private EditText new_user_1_edittext_birth;
    private EditText new_user_1_edittext_address;
    private ImageView new_user_1_imageview_check_1; //1. 약관에 모두 동의 체크 버튼
    private TextView new_user_1_textview_check_1; //1. 약관에 모두 동의 텍스트
    private ImageView new_user_1_imageview_check_2; //2. 만 14세 이상입니다 체크 버튼
    private TextView new_user_1_textview_check_2; //2. 만 14세 이상입니다 텍스트
    private ImageView new_user_1_imageview_check_3; //3. 서비스 이용약관 동의 체크 버튼
    private TextView new_user_1_textview_check_3; //3. 서비스 이용약관 동의 텍스트
    private ImageView new_user_1_imageview_check_4; //4. 개인정보 수집 동의 체크 버튼
    private TextView new_user_1_textview_check_4; //4. 개인정보 수집 동의 텍스트
    private ImageView new_user_1_imageview_check_5; //5. 홍보 및 마케팅 이용 동의 체크 버튼
    private TextView new_user_1_textview_check_5; //5. 홍보 및 마케팅 이용 동의 텍스트
    private ImageView new_user_1_imageview_check_sms; //sms 체크 버튼
    private TextView new_user_1_textview_check_sms; //sms 텍스트
    private ImageView new_user_1_imageview_check_email; //이메일 체크 버튼
    private TextView new_user_1_textview_check_email; //이메일 체크 텍스트
    private View new_user_1_view_success; //가입 완료 버튼
    private ImageView back; //뒤로가기 버튼
    private LinearLayout new_user_1_layout;
    private InputMethodManager imm;
    private Boolean name_bool = false;
    private Boolean birth_bool = false;
    private Boolean address_bool = false;
    private Boolean email_bool = false; //이메일 입력했는지 확인
    private Boolean pwd_bool = false; //비밀번호 입력했는지 확인
    private Boolean phone_bool = false; //인증번호 받아서 입력했는지 확인
    private Boolean check_bool = false; //인증번호 입력 값이랑 전송해줬던 값 같은지 확인
    private Boolean check_imageview_1 = false; //모두 동의
    private Boolean check_imageview_2 = false; //14세
    private Boolean check_imageview_3 = false; //서비스 이용
    private Boolean check_imageview_4 = false; //개인 정보
    private Boolean check_imageview_5 = false; //홍보 마케팅
    private View login_find_pwd_view_phone;
    private String username_str;
    private String user_birth_str;
    private String user_address_str;
    private String user_phone_num_str;
    private String user_pwd_str;
    private String user_email_Str;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        //0. 레이아웃에서 띄울 XML 화면
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_1);

        //1. 뒤로 가기 & 키보드 구현
        //1-(0). 뒤로가기
        back = (ImageView) findViewById(R.id.login_find_image_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //1-(1). 키보드 내려가게 만들기
        new_user_1_layout = (LinearLayout) findViewById(R.id.new_user_1_layout_all);
        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        new_user_1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(new_user_1_edittext_email.getWindowToken(), 0); //실제로 내려가게 만들기
                imm.hideSoftInputFromWindow(new_user_1_edittext_pwd.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(new_user_1_edittext_phone.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(new_user_1_edittext_check.getWindowToken(), 0);
            }
        });

        //1-(2). XML과 자바 연결
        new_user_1_edittext_name = (EditText) findViewById(R.id.new_user_1_edittext_name);
        new_user_1_edittext_birth = (EditText) findViewById(R.id.new_user_1_edittext_birth);
        new_user_1_edittext_address = (EditText) findViewById(R.id.new_user_1_edittext_address);
        new_user_1_edittext_email = (EditText) findViewById(R.id.new_user_1_edittext_email);
        new_user_1_edittext_pwd = (EditText) findViewById(R.id.new_user_1_edittext_pwd);
        new_user_1_edittext_phone = (EditText) findViewById(R.id.new_user_1_edittext_phone);
        new_user_1_edittext_check = (EditText) findViewById(R.id.new_user_1_edittext_check);
        new_user_1_imageview_check_1 = (ImageView) findViewById(R.id.new_user_1_imageview_check_1); //1. 약관에 모두 동의 체크 버튼
        new_user_1_textview_check_1 = (TextView) findViewById(R.id.new_user_1_textview_check_1); //1. 약관에 모두 동의 텍스트
        new_user_1_imageview_check_2 = (ImageView) findViewById(R.id.new_user_1_imageview_check_2); //2. 만 14세 이상입니다 체크 버튼
        new_user_1_textview_check_2 = (TextView) findViewById(R.id.new_user_1_textview_check_2); //2. 만 14세 이상입니다 텍스트
        new_user_1_imageview_check_3 = (ImageView) findViewById(R.id.new_user_1_imageview_check_3); //3. 서비스 이용약관 동의 체크 버튼
        new_user_1_textview_check_3 = (TextView) findViewById(R.id.new_user_1_textview_check_3); //3. 서비스 이용약관 동의 텍스트
        new_user_1_imageview_check_4 = (ImageView) findViewById(R.id.new_user_1_imageview_check_4); //4. 개인정보 수집 동의 체크 버튼
        new_user_1_textview_check_4 = (TextView) findViewById(R.id.new_user_1_textview_check_4); //4. 개인정보 수집 동의 텍스트
        new_user_1_imageview_check_5 = (ImageView) findViewById(R.id.new_user_1_imageview_check_5); //5. 홍보 및 마케팅 이용 동의 체크 버튼
        new_user_1_textview_check_5 = (TextView) findViewById(R.id.new_user_1_textview_check_5); //5. 홍보 및 마케팅 이용 동의 텍스트
        new_user_1_imageview_check_sms = (ImageView) findViewById(R.id.new_user_1_imageview_check_sms); //sms 체크 버튼
        new_user_1_textview_check_sms = (TextView) findViewById(R.id.new_user_1_textview_check_sms); //sms 텍스트
        new_user_1_imageview_check_email = (ImageView) findViewById(R.id.new_user_1_imageview_check_email); //이메일 체크 버튼
        new_user_1_textview_check_email = (TextView) findViewById(R.id.new_user_1_textview_check_email); //이메일 체크 텍스트
        new_user_1_view_success = (View) findViewById(R.id.new_user_1_view_success); //가입 완료 버튼
        new_user_1_view_success.setEnabled(false);
        new_user_1_textview_name = (TextView) findViewById(R.id.new_user_1_textview_name); //이름
        new_user_1_textview_birth = (TextView) findViewById(R.id.new_user_1_textview_birth);
        new_user_1_textview_address = (TextView) findViewById(R.id.new_user_1_textview_address);
        new_user_1_textview_email = (TextView) findViewById(R.id.new_user_1_textview_email); //회원가입 텍스트
        new_user_1_textview_pwd = (TextView) findViewById(R.id.new_user_1_textview_pwd);
        new_user_1_textview_phone = (TextView) findViewById(R.id.new_user_1_textview_phone);
        login_find_pwd_view_phone = (View) findViewById(R.id.login_find_pwd_view_phone);
        login_find_pwd_view_phone.setEnabled(false);

        //2. 이름, 생년월일, 주소

        //2-(1). 이름
        new_user_1_edittext_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //입력이 끝났을 때
                String name = new_user_1_edittext_name.getText().toString();

                if (name.length() >= 1 && name.matches(".*[!@#$%^&+.,*()'_+/?=0-9-].*") == false) {
                    Log.i("이름 통과", "한글자 이상");
                    new_user_1_textview_name.setText("이름");
                    new_user_1_textview_name.setTextColor(getResources().getColor(R.color.login_find_navy));
                    new_user_1_edittext_name.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));
                    name_bool = true;

                    //다 할 거 했으면 회원가입 버튼 활성화
                    if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                    {
                        new_user_1_view_success.setEnabled(true);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                    }
                    else
                    {
                        new_user_1_view_success.setEnabled(false);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    }

                } else //입력 안함
                {
                    Log.i("가입 오류", "이름 이상 : 작성 안함");

                    new_user_1_textview_name.setText("올바른 형식으로 이름을 입력해주세요");
                    new_user_1_textview_name.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    new_user_1_edittext_name.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                    name_bool = false;
                    new_user_1_view_success.setEnabled(false); //가입성공 버튼 누르는 거 취소
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 버튼 누르는 거 취소
                    login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }
            }
        });

        //2-(2). 생년월일
        new_user_1_edittext_birth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //입력이 끝났을 때
                String birth = new_user_1_edittext_birth.getText().toString();

                if (birth.length() == 8 && birth.matches(".*[!@#$%^&+.,*()'_+/?=a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*") == false) {
                    Log.i("생년월일 통과", "8글자 이상");
                    new_user_1_textview_birth.setText("생년월일");
                    new_user_1_textview_birth.setTextColor(getResources().getColor(R.color.login_find_navy));
                    new_user_1_edittext_birth.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));
                    birth_bool = true;

                    //다 할 거 했으면 회원가입 버튼 활성화
                    if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                    {
                        new_user_1_view_success.setEnabled(true);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                    }
                    else
                    {
                        new_user_1_view_success.setEnabled(false);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    }

                }
                else //여기서부터
                {
                    Log.i("가입 오류", "생년월일 이상 : 작성 안함");

                    new_user_1_textview_birth.setText("올바른 형식으로 생년월일을 입력해주세요");
                    new_user_1_textview_birth.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    new_user_1_edittext_birth.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                    birth_bool = false;
                    new_user_1_view_success.setEnabled(false); //가입성공 버튼 누르는 거 취소
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 버튼 누르는 거 취소
                    login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }

            }
        });

        //2-(3). 주소
        new_user_1_edittext_address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //입력이 끝났을 때
                String address = new_user_1_edittext_address.getText().toString();

                if (address.length() > 0 && address.matches(".*[!@#$%^&+.,*()'_+/?=].*") == false && address.matches(".*[a-zA-Z].*") == false) {
                    Log.i("주소 통과", "특수문자와 영어 미 포함");
                    new_user_1_textview_address.setText("주소");
                    new_user_1_textview_address.setTextColor(getResources().getColor(R.color.login_find_navy));
                    new_user_1_edittext_address.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));
                    address_bool = true;

                    //다 할 거 했으면 회원가입 버튼 활성화
                    if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                    {
                        new_user_1_view_success.setEnabled(true);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                    }
                    else
                    {
                        new_user_1_view_success.setEnabled(false);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    }

                }
                else //여기서부터
                {
                    Log.i("가입 오류", "주소 이상 : 특수문자나 영어 포함");

                    new_user_1_textview_address.setText("올바른 형식으로 주소를 입력해주세요");
                    new_user_1_textview_address.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    new_user_1_edittext_address.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                    address_bool = false;
                    new_user_1_view_success.setEnabled(false); //가입성공 버튼 누르는 거 취소
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 버튼 누르는 거 취소
                    login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }
            }
        });

        //3. 이메일
        new_user_1_edittext_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //입력이 끝났을 때
                String email = new_user_1_edittext_email.getText().toString();

                if (email.contains("@")) {
                    Log.i("이메일 통과", "@ 있음");
                    new_user_1_textview_email.setText("이메일");
                    new_user_1_textview_email.setTextColor(getResources().getColor(R.color.login_find_navy));
                    new_user_1_edittext_email.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));
                    email_bool = true;

                    //다 할 거 했으면 회원가입 버튼 활성화
                    if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                    {
                        new_user_1_view_success.setEnabled(true);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                    }
                    else
                    {
                        new_user_1_view_success.setEnabled(false);
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    }
                    
                } else //@가 없음
                {
                    Log.i("가입 오류", "메일 형식 이상 : @ 없음");

                    new_user_1_textview_email.setText("올바른 형식으로 메일을 입력해주세요");
                    new_user_1_textview_email.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    new_user_1_edittext_email.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                    email_bool = false;
                    new_user_1_view_success.setEnabled(false); //가입성공 버튼 누르는 거 취소
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 버튼 누르는 거 취소
                    login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }

            }
        });

        //4. 비밀번호
        new_user_1_edittext_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //입력이 끝났을 때
                String pwd = new_user_1_edittext_pwd.getText().toString();

                //1. 숫자 있는지 확인
                if (pwd.matches(".*[0-9].*")) {
                    Log.i("비밀번호 통과", "숫자 있음");
                    new_user_1_textview_pwd.setText("비밀번호");
                    new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_find_navy));
                    new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));

                    //2. 문자 있는지 확인
                    if (pwd.matches(".*[a-zA-Z].*")) {
                        Log.i("비밀번호 통과", "문자 있음");
                        new_user_1_textview_pwd.setText("비밀번호");
                        new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_find_navy));
                        new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));

                        //3. 특수문자 있는지 확인
                        if (pwd.matches(".*[!@#$%^&+=].*")) {
                            Log.i("비밀번호 통과", "특수문자 있음");
                            new_user_1_textview_pwd.setText("비밀번호");
                            new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_find_navy));
                            new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));

                            //4. 8자 이상인지 확인
                            if (pwd.length() > 7) {
                                Log.i("비밀번호 통과", "8글자 있음");
                                new_user_1_textview_pwd.setText("비밀번호");
                                new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_find_navy));
                                new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));

                                pwd_bool = true;
                                //다 할 거 했으면 회원가입 버튼 활성화
                                if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                                {
                                    new_user_1_view_success.setEnabled(true);
                                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                                }
                                else
                                {
                                    new_user_1_view_success.setEnabled(false);
                                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                                }

                            } else //8자 이상 아님
                            {
                                Log.i("비밀번호 오류", "8자 미만임");
                                new_user_1_textview_pwd.setText("비밀번호를 8자 이상 작성해주세요");
                                new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_pwd_red));
                                new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                                pwd_bool = false;
                                new_user_1_view_success.setEnabled(false); //가입 버튼 누르는 거 취소
                                new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                                login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 누르는 거 취소
                                login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                           
                            }
                        } else //특수문자 없음
                        {
                            Log.i("비밀번호 오류", "특수문자 없음");
                            new_user_1_textview_pwd.setText("영문, 숫자, 특수문자를 모두 포함해 작성해주세요");
                            new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_pwd_red));
                            new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                            pwd_bool = false;
                            new_user_1_view_success.setEnabled(false); //가입 성공 버튼 누르는 거 취소
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                            login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 누르는 거 취소
                            login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                        }
                    } else //문자 없음
                    {
                        Log.i("비밀번호 오류", "문자 없음");
                        new_user_1_textview_pwd.setText("영문, 숫자, 특수문자를 모두 포함해 작성해주세요");
                        new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_pwd_red));
                        new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                        pwd_bool = false;
                        new_user_1_view_success.setEnabled(false); //가입 성공 버튼 누르는 거 취소
                        new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 누르는 거 취소
                        login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                    }
                } else //숫자 없음
                {
                    Log.i("비밀번호 오류", "숫자 없음");
                    new_user_1_textview_pwd.setText("영문, 숫자, 특수문자를 모두 포함해 작성해주세요");
                    new_user_1_textview_pwd.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    new_user_1_edittext_pwd.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                    pwd_bool = false;
                    new_user_1_view_success.setEnabled(false); //가입성공 버튼 누르는 거 취소
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    login_find_pwd_view_phone.setEnabled(false); //핸드폰 인증받기 누르는 거 취소
                    login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }
            }
        });

        //5. 핸드폰 번호
        new_user_1_edittext_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //입력하기 전 호출되는 API
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //EditText에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable editable) {

                //입력이 끝났을 때
                String phone = new_user_1_edittext_phone.getText().toString();

                if (phone.matches(".*[!@#$%^&+.,*()'_+/?=-].*") == false) {
                    Log.i("핸드폰 통과", "특수 기호 없음");
                    new_user_1_textview_phone.setText("핸드폰번호");
                    new_user_1_textview_phone.setTextColor(getResources().getColor(R.color.login_find_navy));
                    new_user_1_edittext_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_blue_box));
                    if(phone.length() > 9)
                    {
                        //인증받기 버튼 클릭 가능해짐
                        login_find_pwd_view_phone.setEnabled(true);
                        login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                    }
                    else
                    {
                        login_find_pwd_view_phone.setEnabled(false); //인증받기 버튼 누르는 거 취소
                        login_find_pwd_view_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                    }
                }
                else //특수 기호 있어버림
                {
                    Log.i("비밀번호 오류", "특수기호 있음");
                    new_user_1_textview_phone.setText("올바른 핸드폰번호 형식이 아닙니다");
                    new_user_1_textview_phone.setTextColor(getResources().getColor(R.color.login_pwd_red));
                    new_user_1_edittext_phone.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_1_red_box));
                    new_user_1_view_success.setEnabled(false); //인증받기 버튼 누르는 거 취소
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                }

            }
        });

        //6. 인증받기 버튼 누르면
        //6-(2) 인증받기 버튼 누르면 문자 인증 서비스 실행
        login_find_pwd_view_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //밑에 세줄 코드는 없애기
                new_user_1_edittext_check.setHint("현재 문자 인증 서비스 구현 중... \n(바로 약관 동의 후 가입 버튼을 눌러주세요!)"); //문자 인증 구현하면 없애기
                phone_bool = true; //인증번호 글자수 맞게 입력했으면
                Log.i("인증번호 입력?", phone_bool + " ");
                
                new_user_1_edittext_check.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        //입력하기 전 호출되는 API
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        //EditText에 변화가 있을 때
                    }

                    @Override
                    public void afterTextChanged(Editable editable)
                    {
                        //입력이 끝났을 때
                        String check = new_user_1_edittext_check.getText().toString();

                        //문자 인증 서비스 구현
                        /* if (check.length() >= 인증번호 글자수)
                           {
                                phone_bool = true;

                                //다 할 거 했으면 회원가입 버튼 활성화
                                if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                                {
                                    new_user_1_view_success.setEnabled(true);
                                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                                }
                                else
                                {
                                    new_user_1_view_success.setEnabled(false);
                                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                                }
                          }
                          else
                          {
                                phone_bool = false;
                                new_user_1_view_success.setEnabled(false); //인증받기 버튼 누르는 거 취소
                                new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                          }
                          */
                        }
                    });
                }
        });

        //7. 약관 모두 동의했는지 확인
        // 7-(1). 모두 동의 누르면
        new_user_1_imageview_check_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check_imageview_1 == false) //동의 안 했던 상태면
                    {
                        new_user_1_imageview_check_1.setAlpha((float) 1.0);
                        new_user_1_imageview_check_2.setAlpha((float) 1.0);
                        new_user_1_imageview_check_3.setAlpha((float) 1.0);
                        new_user_1_imageview_check_4.setAlpha((float) 1.0);
                        new_user_1_imageview_check_5.setAlpha((float) 1.0);
                        new_user_1_imageview_check_sms.setAlpha((float) 1.0);
                        new_user_1_imageview_check_email.setAlpha((float) 1.0);

                        //다 동의 눌러지게 만들기
                        check_imageview_2 = true;
                        check_imageview_3 = true;
                        check_imageview_4 = true;
                        check_imageview_5 = true;
                        check_imageview_1 = true;

                        Log.i("약관 : ", "모두 동의 누름");
                        //다 할 거 했으면 회원가입 버튼 활성화
                        if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                        {
                            new_user_1_view_success.setEnabled(true);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                        }
                        else
                        {
                            new_user_1_view_success.setEnabled(false);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        }


                        //확인좀
                        Log.i("email_bool : ", email_bool+" \npwd_bool : "+pwd_bool+" \nphone_bool : "+phone_bool+" \ncheck_bool : "+check_bool+" \ncheck_imageview_2+ : "+check_imageview_2+" \ncheck_imageview_3+ : "+check_imageview_3+" \ncheck_imageview_4+ : "+check_imageview_4);


                    }
                else //이미 동의 눌렀던 상태면
                {
                    new_user_1_imageview_check_1.setAlpha((float) 0.5);
                    new_user_1_imageview_check_2.setAlpha((float) 0.5);
                    new_user_1_imageview_check_3.setAlpha((float) 0.5);
                    new_user_1_imageview_check_4.setAlpha((float) 0.5);
                    new_user_1_imageview_check_5.setAlpha((float) 0.5);
                    new_user_1_imageview_check_sms.setAlpha((float) 0.5);
                    new_user_1_imageview_check_email.setAlpha((float) 0.5);

                    //다 누른 거 취소되게 만들기
                    check_imageview_2 = false;
                    check_imageview_3 = false;
                    check_imageview_4 = false;
                    check_imageview_5 = false;
                    check_imageview_1 = false;

                    Log.i("약관 : ", "모두 동의 취소 누름");
                    new_user_1_view_success.setEnabled(false);
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }

            }
        });

        //7-(2). 만 14세 동의 누르면
        new_user_1_imageview_check_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (check_imageview_2 == false) //동의 안 했던 상태면
                    {
                        new_user_1_imageview_check_2.setAlpha((float) 1.0);

                        //동의 눌렀음
                        check_imageview_2 = true;

                        Log.i("약관 : ", "만 14세 동의 누름");
                        //다 할 거 했으면 회원가입 버튼 활성화
                        if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                        {
                            new_user_1_view_success.setEnabled(true);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                        }
                        else
                        {
                            new_user_1_view_success.setEnabled(false);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        }
                    } else //이미 동의 눌렀던 상태면
                {
                    new_user_1_imageview_check_2.setAlpha((float) 0.5);

                    //누른 거 취소되게 만들기
                    check_imageview_2 = false;

                    Log.i("약관 : ", "만 14세 동의 취소 누름");
                    new_user_1_view_success.setEnabled(false);
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }
            }
        });

        //7-(3). 서비스 동의 누르면
        new_user_1_imageview_check_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check_imageview_3 == false) //동의 안 했던 상태면
                    {
                        new_user_1_imageview_check_3.setAlpha((float) 1.0);

                        //동의 눌렀음
                        check_imageview_3 = true;

                        Log.i("약관 : ", "서비스 동의 누름");
                        //다 할 거 했으면 회원가입 버튼 활성화
                        if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                        {
                            new_user_1_view_success.setEnabled(true);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                        }
                        else
                        {
                            new_user_1_view_success.setEnabled(false);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        }
                    } else //이미 동의 눌렀던 상태면
                {
                    new_user_1_imageview_check_3.setAlpha((float) 0.5);

                    //누른 거 취소되게 만들기
                    check_imageview_3 = false;

                    Log.i("약관 : ", "서비스 동의 취소 누름");
                    new_user_1_view_success.setEnabled(false);
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }

            }
        });

        //7-(4). 개인정보 동의 누르면
        new_user_1_imageview_check_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check_imageview_4 == false) //동의 안 했던 상태면
                    {
                        new_user_1_imageview_check_4.setAlpha((float) 1.0);

                        //동의 눌렀음
                        check_imageview_4 = true;

                        Log.i("약관 : ", "개인정보 동의 누름");
                        //다 할 거 했으면 회원가입 버튼 활성화
                        if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                        {
                            new_user_1_view_success.setEnabled(true);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                        }
                        else
                        {
                            new_user_1_view_success.setEnabled(false);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        }
                    } else //이미 동의 눌렀던 상태면
                {
                    new_user_1_imageview_check_4.setAlpha((float) 0.5);

                    //누른 거 취소되게 만들기
                    check_imageview_4 = false;

                    Log.i("약관 : ", "개인정보 동의 취소 누름");
                    new_user_1_view_success.setEnabled(false);
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }

            }
        });

        //7-(5). 홍보 동의 누르면
        new_user_1_imageview_check_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check_imageview_5 == false) //동의 안 했던 상태면
                    {
                        new_user_1_imageview_check_5.setAlpha((float) 1.0);
                        new_user_1_imageview_check_email.setAlpha((float) 1.0);
                        new_user_1_imageview_check_sms.setAlpha((float) 1.0);

                        //동의 눌렀음
                        check_imageview_5 = true;

                        Log.i("약관 : ", "홍보 동의 누름");
                        //다 할 거 했으면 회원가입 버튼 활성화
                        if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                        {
                            new_user_1_view_success.setEnabled(true);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                        }
                        else
                        {
                            new_user_1_view_success.setEnabled(false);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        }
                    } else //이미 동의 눌렀던 상태면
                {
                    new_user_1_imageview_check_5.setAlpha((float) 0.5);
                    new_user_1_imageview_check_email.setAlpha((float) 0.5);
                    new_user_1_imageview_check_sms.setAlpha((float) 0.5);

                    //누른 거 취소되게 만들기
                    check_imageview_5 = false;

                    Log.i("약관 : ", "홍보 동의 취소 누름");
                    new_user_1_view_success.setEnabled(false);
                    new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러

                }

            }
        });

        //8. 회원가입 버튼 누르면
        new_user_1_view_success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //확인 기능 밑에 만들면 아래 한줄 지우기
                check_bool = true;

                //인증번호랑 일치하는지 확인!!! 맞으면 check_bool true로!
                /* if (맞으면)
                {
                    check_bool = true;

                    if (name_bool && birth_bool && address_bool && email_bool && pwd_bool && check_bool && phone_bool && check_imageview_2 && check_imageview_3 && check_imageview_4)
                        {
                            new_user_1_view_success.setEnabled(true);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green_dark)); //인증받기 버튼 투명도 0.5러
                        }
                        else
                        {
                            new_user_1_view_success.setEnabled(false);
                            new_user_1_view_success.setBackground(ContextCompat.getDrawable(new_user_1_activity.this, R.drawable.new_user_rectangle_green)); //인증받기 버튼 투명도 0.5러
                        }
                }
                else
                {
                    check_bool = false;
                }
                 */

                if(check_bool)
                {
                    //1. 실제 요청

                    //(1-1). 입력 완성된 값 가져오기
                    username_str = new_user_1_edittext_name.getText().toString();
                    user_birth_str = new_user_1_edittext_birth.getText().toString();
                    user_address_str = new_user_1_edittext_address.getText().toString();
                    user_email_Str = new_user_1_edittext_email.getText().toString();
                    user_pwd_str = new_user_1_edittext_pwd.getText().toString();
                    user_phone_num_str = new_user_1_edittext_phone.getText().toString();

                    Log.i("입력된 username은 ", username_str);
                    Log.i("입력된 user_birth는 ", user_birth_str);
                    Log.i("입력된 user_email은 ", user_email_Str);
                    Log.i("입력된 user_address는 ", user_address_str);
                    Log.i("입력된 user_pwd는 ", user_pwd_str);
                    Log.i("입력된 user_phone_num은 ", user_phone_num_str);


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
                                    String username = jsonObject.getString("username");
                                    String user_pwd = jsonObject.getString("user_pwd");
                                    String user_birth = jsonObject.getString("user_birth");
                                    String user_email = jsonObject.getString("user_email");
                                    String user_phone_num = jsonObject.getString("user_phone_num");
                                    String user_address = jsonObject.getString("user_address");

                                    Log.i("올라간 username은 ", username);
                                    Log.i("올라간 user_birth는 ", user_birth);
                                    Log.i("올라간 user_address는 ", user_address);
                                    Log.i("올라간 user_email은 ", user_email);
                                    Log.i("올라간 user_pwd는 ", user_pwd);
                                    Log.i("올라간 user_phone_num은 ", user_phone_num);

                                    Log.i("성공 ", ": O");

                                    //(2). 회원가입 성공 화면 띄우기
                                    Intent intent = new Intent(new_user_1_activity.this, new_user_success_activity.class);
                                    startActivity(intent);

                                    return;
                                }
                                else //실패했으면
                                {
                                    //틀림 알람 문구 띄우기
                                    Log.i("데이터베이스 서버 이슈", "");
                                }
                            }
                            catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    // (1-3) 서버로 Volley를 이용해서 요청함

                    // new_user_1_request 클래스 (URL/PHP/전송방식 설정) 형식의 new_user_request 클래스 생성 > edittext에서 가져온 값 실제 전송
                    new_user_1_request new_user_request = new new_user_1_request(username_str, user_birth_str, user_address_str, user_email_Str, user_pwd_str, user_phone_num_str, responseListener);
                    //new_user_1_화면에서 큐 생성
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    //큐에 new_user_request 클래스 담음 (실제 값 전송-성공여부담아옴)
                    queue.add(new_user_request);

                }
                else
                {
                    //인증번호가 일치하지 않습니다. 다시 시도해주세요 오류 창 띄우기.
                    //CustomDialog dlg = new CustomDialog(new_user_1_activity.this);
                    //dlg.show();
                }
            }
        });
    }
}