package com.example.rezero;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class user_mypage_1_activity extends AppCompatActivity {

    //메뉴 - 드로우 관련 변수
    private ImageButton padding;
    private ImageButton cartBtn;
    private ImageButton homeBtn;
    private ImageButton boxBtn;
    private ImageButton likeBtn;
    private ImageButton myBtn;
    Button kitchenBtn;

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
    private LinearLayout user_mypage_1_layout_name;
    private FrameLayout user_mypage_1_layout_box_1;
    private FrameLayout user_mypage_1_layout_box_2;
    private FrameLayout user_mypage_1_layout_box_3;
    private FrameLayout user_mypage_1_layout_box_4;
    private LinearLayout user_mypage_1_layout_qna;
    private LinearLayout user_mypage_1_layout_setting;
    private LinearLayout user_mypage_1_layout_notice;
    private TextView user_mypage_1_textview_name;
    private TextView user_mypage_1_textview_box_1;
    private TextView user_mypage_1_textview_box_2;
    private TextView user_mypage_1_textview_box_3;
    private TextView user_mypage_1_textview_box_4;



    @Override
    public void onCreate(Bundle savedInstance)
    {
        //0. 로그인 값 받아오기
        Intent intent = new Intent(this.getIntent());

        login = intent.getStringExtra("login");
        Log.i("user_mypage -> 로그인함?",login+" ");

        login_user_email  = intent.getStringExtra("login_user_email");
        login_user_pwd  = intent.getStringExtra("login_user_pwd");
        Log.i("가져온 로그인 값?", login+"했으면? "+login_user_email+" "+login_user_pwd);

        login_user_name = intent.getStringExtra("login_user_name");
        Log.i("가져오는 user_name은 ",login_user_name);
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
        Log.i("가져온 핸드폰", login_user_phone_num);

        //1. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.user_mypage_1);

        //2. 드로우 메뉴바
        padding = (ImageButton) findViewById(R.id.padding);
        padding.setImageResource(R.drawable.menubtn);

        /*드로우 메뉴바 실제 코드 내용*/
        {
            // 전체화면인 DrawerLayout 객체 참조
            final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLay);

            // Drawer 화면(뷰) 객체 참조
            final View drawerView = (View) findViewById(R.id.drawer);

            // 드로어 여는 버튼 리스너
            padding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(drawerView);
                }
            });


            System.out.println(55);
            // 드로어 닫는 버튼 리스너
//            btnCloseDrawer.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    drawerLayout.closeDrawer(drawerView);
//                }
//            });

            //드로우메뉴바의 버튼객체생성 및 눌럿을때 화면전환
            kitchenBtn = (Button) findViewById(R.id.kitchenBtn);

            /*주방으로 화면전환 - 여기 생략한 거 다시 주석 없애기!!!! - 너무 가져올 거 많아서 잠시 업앰
            kitchenBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Kitchen.class);
                    startActivity(intent);
                }
            });*/
        }

        //3. 아래 아이콘 4개 바

        {

            //하단 버튼객체생성
            homeBtn = (ImageButton)findViewById(R.id.homeBtn);
            boxBtn = (ImageButton)findViewById(R.id.boxBtn);
            likeBtn = (ImageButton)findViewById(R.id.likeBtn);
            myBtn = (ImageButton)findViewById(R.id.myBtn);

            //하단바 버튼 누름효과지정 - 주석 처리 바꿔주기
            {
                homeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent intent = new Intent(getApplicationContext(),SettingP.class);
                        //startActivity(intent);
                    }
                });
                boxBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Intent goDesigner = new Intent(MainActivity.this,DesignerList.class);
                        //startActivity(goDesigner);
                    }
                });
                likeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 좋아요 화면으로 이동
                        //Intent intent = new Intent(MainActivity.this, point.class); // product_like
                        //startActivity(intent);
                    }
                });
                myBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //로그인 화면으로 이동
                        //Intent intent = new Intent(MainActivity.this, login_1_activity.class);
                        //startActivity(intent);
                    }
                });
            }


        }

        //4. 장바구니 클릭 시
        {
            cartBtn = (ImageButton) findViewById(R.id.cartBtn);
            cartBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Intent goCart = new Intent(getApplicationContext(),Cart.class);
                    //startActivity(goCart);
                }
            });
        }


        //5. 자바 - XML 변수 연결
        user_mypage_1_layout_name = (LinearLayout) findViewById(R.id.user_mypage_1_layout_name);
        user_mypage_1_layout_box_1 = (FrameLayout) findViewById(R.id.user_mypage_1_layout_box_1);
        user_mypage_1_layout_box_2 = (FrameLayout) findViewById(R.id.user_mypage_1_layout_box_2);
        user_mypage_1_layout_box_3 = (FrameLayout) findViewById(R.id.user_mypage_1_layout_box_3);
        user_mypage_1_layout_box_4 = (FrameLayout) findViewById(R.id.user_mypage_1_layout_box_4);
        user_mypage_1_layout_qna = (LinearLayout) findViewById(R.id.user_mypage_1_layout_qna);
        user_mypage_1_layout_setting = (LinearLayout) findViewById(R.id.user_mypage_1_layout_setting);
        user_mypage_1_layout_notice = (LinearLayout) findViewById(R.id.user_mypage_1_layout_notice);
        user_mypage_1_textview_name = (TextView) findViewById(R.id.user_mypage_1_textview_name);
        user_mypage_1_textview_box_1 = (TextView) findViewById(R.id.user_mypage_1_textview_box_1);
        user_mypage_1_textview_box_2 = (TextView) findViewById(R.id.user_mypage_1_textview_box_2);
        user_mypage_1_textview_box_3 = (TextView) findViewById(R.id.user_mypage_1_textview_box_3);
        user_mypage_1_textview_box_4 = (TextView) findViewById(R.id.user_mypage_1_textview_box_4);

        //5-(1). 로그인했으면 화면 세팅
        if(login.equals("true"))
        {
            //이름
            user_mypage_1_textview_name.setText(login_user_name);

            //주문 배송
            if(login_user_order.equals("null"))
            {
                user_mypage_1_textview_box_1.setText("0");
            }
            else
            {
                user_mypage_1_textview_box_1.setText(login_user_order);
            }
            Log.i("order",login_user_order);

            //작성한 리뷰
            if(login_user_review.equals("null"))
            {
                user_mypage_1_textview_box_2.setText("0");
            }
            else
            {
                user_mypage_1_textview_box_2.setText(login_user_review);
            }
            Log.i("review",login_user_review);

            //쿠폰
            if(login_user_review.equals("null"))
            {
                user_mypage_1_textview_box_3.setText("0");
            }
            else
            {
                user_mypage_1_textview_box_2.setText(login_user_coupon);
            }
            Log.i("coupon",login_user_coupon);

            //포인트
            if(login_user_review.equals("null"))
            {
                user_mypage_1_textview_box_4.setText("0p");
            }
            else
            {
                user_mypage_1_textview_box_4.setText(login_user_point+"p");
            }
            Log.i("point",login_user_point);
        }
        else //로그인 못했을 때!!
        {
            user_mypage_1_textview_box_1.setText("0");
            user_mypage_1_textview_box_2.setText("0");
            user_mypage_1_textview_box_3.setText("0");
            user_mypage_1_textview_box_4.setText("0p");
        }

        //6. 이름 클릭했을 때
        user_mypage_1_layout_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_1_activity.this, user_mypage_name_activity.class);
                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("user_mypage -> 로그인함? ", String.valueOf(login));
                startActivity(intent);
            }
        });

        //7. 4개 박스 중 1 - 주문 배송 눌렀을 때
        user_mypage_1_layout_box_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_1_activity.this, user_mypage_delivery_activity.class);
                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));
                startActivity(intent);
            }
        });

        //8. 4개 박스 중 2 - 작성한 리뷰 눌렀을 때
        user_mypage_1_layout_box_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(user_mypage_1_activity.this, user_mypage_review_activity.class);
                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));
                startActivity(intent);
            }
        });

        //9. 4개 박스 중 3 - 쿠폰 눌렀을 때
        user_mypage_1_layout_box_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 쿠폰 페이지 - 아래 주석 삭제
                Intent intent = new Intent(user_mypage_1_activity.this, Coupon.class);

                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));
                startActivity(intent);
            }
        });

        //10. 4개 박스 중 4 - 포인트 눌렀을 때
        user_mypage_1_layout_box_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 포인트 페이지 - 아래 주석 삭제
                Intent intent = new Intent(user_mypage_1_activity.this, point.class);

                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));

                startActivity(intent);
            }
        });

        //11. 문의 내역 눌렀을 때
        user_mypage_1_layout_qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 문의내역 페이지 - 아래 주석 삭제
                //짧게 알람 문구 보여주기 - 확인용
                Toast.makeText(getApplicationContext(), "문의 내역은 서비스 구현 중입니다. 죄송합니다!", Toast.LENGTH_SHORT).show();
                // Intent intent = new Intent(user_mypage_1.this, 문의내역.class);
                /*
                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login)); */

                // startActivity(intent);
            }
        });

        //12. 설정 눌렀을 때
        user_mypage_1_layout_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 설정 페이지 - 아래 주석 삭제
                Intent intent = new Intent(user_mypage_1_activity.this, SettingP.class);

                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));

                startActivity(intent);
            }
        });

        //13. 공지사항 눌렀을 때
        user_mypage_1_layout_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 공지사항 페이지 - 아래 주석 삭제
                Intent intent = new Intent(user_mypage_1_activity.this, user_mypage_notice_activity.class);

                intent.putExtra("login", login+"");

                intent.putExtra("login_user_email", login_user_email);
                intent.putExtra("login_user_pwd", login_user_pwd);
                intent.putExtra("login_user_name", login_user_name);
                intent.putExtra("login_user_birth", login_user_birth);
                intent.putExtra("login_user_phone_num", login_user_phone_num);
                intent.putExtra("login_user_bank", login_user_bank);
                intent.putExtra("login_user_account", login_user_account);
                intent.putExtra("login_user_address", login_user_address);
                intent.putExtra("login_user_like_pro", login_user_like_pro);
                intent.putExtra("login_user_order", login_user_order);
                intent.putExtra("login_user_point", login_user_point);
                intent.putExtra("login_user_coupon",login_user_coupon);
                intent.putExtra("login_user_mission", login_user_mission);
                intent.putExtra("login_user_like_designer", login_user_like_designer);
                intent.putExtra("login_user_cart", login_user_cart);
                intent.putExtra("login_user_review", login_user_review);
                intent.putExtra("login_user_chat", login_user_chat);

                Log.i("login_1 -> 로그인함? ", String.valueOf(login));
                startActivity(intent);
            }
        });
    }
}