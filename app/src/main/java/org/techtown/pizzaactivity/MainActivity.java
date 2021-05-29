package org.techtown.pizzaactivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.techtown.pizzaactivity.ui.pizza.Pizza;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Pizza> pizzaItem = new ArrayList<Pizza>();
    public static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(count == 0) {
            Pizza p1 = new Pizza("01", "치즈 피자", R.drawable.cheeze);
            Pizza p2 = new Pizza("02", "베이컨 피자", R.drawable.bacon);
            Pizza p3 = new Pizza("03", "치킨 피자", R.drawable.chicken);
            Pizza p4 = new Pizza("04", "페페로니 피자", R.drawable.peperoni);
            Pizza p5 = new Pizza("05", "포테이토 피자", R.drawable.potato);
            Pizza p6 = new Pizza("06", "슈퍼 디럭스피자", R.drawable.supreme);

            p1.setInfo("피자도우와 치즈만으로 승부수를 걸었다.\n" +
                    "토마토 소스와 모차렐라 치즈를 가득 넣은 피자. 기본기에 충실한 피자를 느껴보자.");
            p2.setInfo("노오란 체더치즈의 고소함과 푸짐한 베이컨이 만들어내는 완벽한 콤비, 매니아층의 꾸준한 사랑을 받고 있는 메뉴");
            p3.setInfo("세상에서 가장 매운 고추 '캐롤라이나 리퍼'로 매콤한 미국 현지 맛을 담은 피자!");
            p4.setInfo("진정한 피자매니아는 페퍼로니 피자만 고집한다.\n" +
                    "\n" +
                    "산뜻한 토마토소스, 그 위에 페퍼로니와 주욱 늘어나는 모차렐라 치즈~\n" +
                    "\n" +
                    "짭짤한 풍미가 일품인 정통 아메리칸 스타일");
            p5.setInfo("고소한 감자, 베이컨, 버섯, 양파가 푸짐하게 어우러진 인기메뉴\n" +
                    "\n" +
                    "남녀노소 모두 좋아하는 담백한 웰빙피자");
            p6.setInfo("쇠고기, 페퍼로니, 햄, 버섯, 피망, 양파, 올리브 등 가장 많은 토핑이 들어가 풍부한 맛을 내는 피자!\n" +
                    "\n" +
                    "무난한 맛으로 누구에게나 사랑받는 기본메뉴");


            pizzaItem.add(p1);
            pizzaItem.add(p2);
            pizzaItem.add(p3);
            pizzaItem.add(p4);
            pizzaItem.add(p5);
            pizzaItem.add(p6);
            count ++;
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

}