package bov.vitali.vkclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bov.vitali.vkclient.utils.Settings;

/**
 * Created by vitali on 13.03.17.
 */
public class UserInfoActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        ImageView userPhotoImageView = (ImageView) findViewById(R.id.user_photo);
        TextView userFullNameTextView = (TextView) findViewById(R.id.full_name_descr);
        TextView userBDateTextView = (TextView) findViewById(R.id.bdate);
        TextView cityTextView = (TextView) findViewById(R.id.city);

        Intent intent = getIntent();
        String photo = intent.getStringExtra(Settings.KEY_USER_PHOTO);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(photo,userPhotoImageView);

        String userNameData = intent.getStringExtra(Settings.KEY_USER_NAME);
        String bDateData = intent.getStringExtra(Settings.KEY_USER_BDATE);

        userFullNameTextView.setText(userNameData);
        userBDateTextView.setText(bDateData);

        String city = intent.getStringExtra(Settings.KEY_USER_CITY);
        if (city != null) {
            cityTextView.setText(city);
        }

        userPhotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FullSizeFragment fullSizeFragment = new FullSizeFragment();
                fragmentTransaction.add(R.id.container_user, fullSizeFragment);
                fragmentTransaction.commit();
            }
        });
    }

}