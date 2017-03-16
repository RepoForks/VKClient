package bov.vitali.vkclient.adapters;

/**
 * Created by vitali on 13.03.17.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.vk.sdk.api.model.VKApiUser;
import com.vk.sdk.api.model.VKApiUserFull;

import bov.vitali.vkclient.R;


public class FriendsAdapter extends BaseAdapter {

    /**
     * Constructor with parameter.
     * @param layoutInflater LayoutInflater.
     */
    public FriendsAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    /**
     * Layout inflater.
     */
    private LayoutInflater layoutInflater;

    /**
     * Sets VK users.
     * @param users Users.
     */
    public void setVKApiUsers(VKApiUserFull[] users) {
        friends = users;
        notifyDataSetChanged();
    }

    /**
     * Friends by user.
     */
    private VKApiUserFull[] friends;

    @Override
    public int getCount() {
        if (friends == null)
            return 0;
        return friends.length;
    }

    @Override
    public Object getItem(int position) {
        if (friends == null)
            return 0;
        return friends[position];
    }

    @Override
    public long getItemId(int position) {
        if (friends == null)
            return 0;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (friends != null) {
            convertView = layoutInflater.inflate(R.layout.activity_friends, null);

            VKApiUser user = friends[position];

            TextView fullName = (TextView) convertView.findViewById(R.id.full_name_descr);
            fullName.setText(user.toString());

            ImageView avatar = (ImageView)convertView.findViewById(R.id.avatar);

            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(user.photo_200,avatar);
        }
        return convertView;
    }
}