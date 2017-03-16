package bov.vitali.vkclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bov.vitali.vkclient.utils.Settings;


public class FullSizeFragment extends android.support.v4.app.Fragment {

    public FullSizeFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_full_size, container, false);

        ImageView fullSizePhoto = (ImageView) v.findViewById(R.id.full_size_photo);

        Intent intent = getActivity().getIntent();
        String photo = intent.getStringExtra(Settings.KEY_USER_FULL_PHOTO);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(photo,fullSizePhoto);

        return v;
    }



}
