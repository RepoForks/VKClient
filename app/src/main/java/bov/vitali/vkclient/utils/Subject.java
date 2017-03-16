package bov.vitali.vkclient.utils;

import com.vk.sdk.api.model.VKApiUserFull;

/**
 * Created by vitali on 13.03.17.
 */

public interface Subject {

    /**
     * Registers observer.
     * @param observer Instance of observer.
     */
    void registerObserver(final Observer observer);

    /**
     * Removes observer.
     * @param observer Instance of observer.
     */
    void removeObserver(final Observer observer);

    /**
     * Notifyes all observers.
     * @param vkApiUsers Users info.
     */
    void notifyObservers(VKApiUserFull[] vkApiUsers);
}