package com.example.rezero;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class designer_mypage_1 extends AppCompatActivity {

    //메뉴 - 드로우 관련 변수
    private ImageButton padding;
    private ImageButton cartBtn;
    private ImageButton homeBtn;
    private ImageButton boxBtn;
    private ImageButton likeBtn;
    private ImageButton myBtn;
    Button kitchenBtn;

    //이 화면에서 사용할 변수

    @Override
    public void onCreate(Bundle savedInstance)
    {
        //1. 화면 띄우기
        super.onCreate(savedInstance);
        setContentView(R.layout.designer_mypage_1);

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



    }
}
