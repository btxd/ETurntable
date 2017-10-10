package com.wx.demo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.wx.eturntable.ETurntableMenuView;

public class MoreActivity extends AppCompatActivity {

    private ETurntableMenuView mETurntableMenuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        setContentView(R.layout.activity_more);
        mETurntableMenuView = (ETurntableMenuView) findViewById(R.id.eturnable_view);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.getMinLenght(this),Utils.getMinLenght(this));
        if (Utils.getMinLenght(this)*1.4f<Utils.getMaxLenght(this)) {
            if (Utils.getWidth(this)>Utils.getHeigth(this)) {
                layoutParams = new RelativeLayout.LayoutParams((int) (Utils.getHeigth(this)*1.4f), Utils.getHeigth(this));
            } else {
                layoutParams = new RelativeLayout.LayoutParams(Utils.getWidth(this), (int) (Utils.getWidth(this)*1.4f));
            }
        }
        mETurntableMenuView.setLayoutParams(layoutParams);

        mETurntableMenuView.setMenuItemIconsAndTexts(DataConstant.getImages(8),DataConstant.getTexts(8));
        mETurntableMenuView.setOnMenuItemClickListener(new ETurntableMenuView.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                Toast.makeText(MoreActivity.this,pos+" "+DataConstant.TextItems[pos],Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_pre).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mETurntableMenuView.slide(false);
            }
        });

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mETurntableMenuView.slide(true);
            }
        });

    }

    private void initWindows() {

        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        int width = manager.getDefaultDisplay().getWidth();
        int height = manager.getDefaultDisplay().getHeight();

        if (width<height) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

    }

}
