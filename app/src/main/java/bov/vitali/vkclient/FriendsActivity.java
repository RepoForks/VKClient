package bov.vitali.vkclient;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.model.VKApiUserFull;

import bov.vitali.vkclient.adapters.FriendsAdapter;
import bov.vitali.vkclient.listeners.RequestListenerFriends;
import bov.vitali.vkclient.utils.Observer;
import bov.vitali.vkclient.utils.Settings;

/**
 * Friends activity for showing friends.
 */
public class FriendsActivity extends ListActivity implements Observer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RequestListenerFriends requestListenerFriends = new RequestListenerFriends();
        requestListenerFriends.registerObserver(this);

        request = VKApi.friends().get(VKParameters.from(VKApiConst.FIELDS, "id,photo_max_orig,photo_200,first_name,last_name,sex,bdate,city"));
        request.executeWithListener(requestListenerFriends);

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        friendsAdapter = new FriendsAdapter(layoutInflater);

        setListAdapter(friendsAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                VKApiUserFull user = friends[position];
                Intent intent = new Intent(getApplicationContext(), UserInfoActivity.class);

                intent.putExtra(Settings.KEY_USER_PHOTO, user.photo_200);
                intent.putExtra(Settings.KEY_USER_NAME, user.toString());
                intent.putExtra(Settings.KEY_USER_BDATE, user.bdate);

                intent.putExtra(Settings.KEY_USER_FULL_PHOTO, user.photo_max_orig);

                if (user.city != null) {
                    intent.putExtra(Settings.KEY_USER_CITY, user.city.toString());
                }

                startActivity(intent);
            }
        });
    }

    /**
     * VK request.
     */
    private VKRequest request;

    /**
     * Friends adapter.
     */
    private FriendsAdapter friendsAdapter;

    @Override
    public void update(VKApiUserFull[] users) {
        friends = users;

        friendsAdapter.setVKApiUsers(friends);
        friendsAdapter.notifyDataSetChanged();
    }

    /**
     * Friends by current user.
     */
    private VKApiUserFull[] friends = null;

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        super.onBackPressed();
    }

}