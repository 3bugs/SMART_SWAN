package th.ac.dusit.dbizcom.smartswan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //todo:
                    return true;
                case R.id.navigation_dashboard:
                    //todo:
                    return true;
                case R.id.navigation_notifications:
                    //todo:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNav();
        setupImageMenu();
    }

    private void setupBottomNav() {
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 60, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
        bottomNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupImageMenu() {
        ImageView menu01ImageView = findViewById(R.id.menu_01_image_view);
        menu01ImageView.setOnClickListener(this);
        ImageView menu02ImageView = findViewById(R.id.menu_02_image_view);
        menu02ImageView.setOnClickListener(this);
        ImageView menu03ImageView = findViewById(R.id.menu_03_image_view);
        menu03ImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.menu_01_image_view:
                intent = new Intent(this, SduActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_02_image_view:
                intent = new Intent(this, SduActivity.class); //todo:
                startActivity(intent);
                break;
            case R.id.menu_03_image_view:
                intent = new Intent(this, SduActivity.class); //todo:
                startActivity(intent);
                break;
        }
    }
}
