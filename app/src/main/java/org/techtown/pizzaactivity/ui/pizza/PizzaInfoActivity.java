package org.techtown.pizzaactivity.ui.pizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.techtown.pizzaactivity.R;
import org.techtown.pizzaactivity.ui.cart.Cart;
import org.techtown.pizzaactivity.ui.cart.CartFragment;
import org.techtown.pizzaactivity.ui.login.LoginActivity;

public class PizzaInfoActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    ImageView imageView;
    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_info);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();   // 타이틀바 없애기

        ActionBar ac = getSupportActionBar();
        ac.setDisplayShowCustomEnabled(true);
        ac.setDisplayShowTitleEnabled(false);
        ac.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼


        textView = (TextView) findViewById(R.id.pizza_info_name);
        textView2= (TextView) findViewById(R.id.pizza_info_info);
        imageView = (ImageView) findViewById(R.id.pizza_info_image);
        editText = (EditText) findViewById(R.id.editTextNumber);
        button = (Button) findViewById(R.id.button);


        textView.setText(HomeFragment.name);
        textView2.setText(HomeFragment.info);
        imageView.setImageResource(HomeFragment.image);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginChecker(LoginActivity.loginValid)){
                    Cart cart = new Cart(HomeFragment.name, Integer.parseInt(editText.getText().toString()));
                    CartFragment.carts.add(cart);   // 장바구니에 추가
                }else{
//                    Snackbar.make(view, "로그인이 필요한 서비스입니다. 로그인 해주세요!!!", Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        });


    }

    public boolean loginChecker(int loginValid){
        return LoginActivity.loginValid == 1;
    }
    @Override // 뒤로가기 버튼 동작 구현
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}