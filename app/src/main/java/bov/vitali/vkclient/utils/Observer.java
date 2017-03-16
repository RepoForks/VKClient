package bov.vitali.vkclient.utils;

/**
 * Created by vitali on 13.03.17.
 */

import com.vk.sdk.api.model.VKApiUserFull;

/**
 * Base interface for observers.
 */
public interface Observer {

    /**
     * Updates the data.
     * @param users Users info.
     */
    void update(final VKApiUserFull[] users);
}