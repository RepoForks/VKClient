package bov.vitali.vkclient.fragments.callbacks;

/**
 * Created by vitali on 13.03.17.
 */

/**
 * Login callback interface for  interaction between activity and
 * fragment login.
 */

public interface LoginCallback {

    /**
     * Vk sdk login. Runs form vk login from sdk.
     */
    void vkSDKLogin();

    /**
     * Shows friends by current user.
     */
    void showFriends();
}
