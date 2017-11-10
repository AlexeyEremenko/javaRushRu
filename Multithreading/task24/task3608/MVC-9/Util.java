
//Who then is Paul, and who is Apollos, but ministers by whom you believed, even as the Lord gave to every man? (1Cor 3:5)

package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.bean.User;

public final class Util {
    public static final String DELETED_MARKER = " (deleted)";

    public static boolean isUserDeleted(User user) {
        return user.getName().endsWith(DELETED_MARKER);
    }

    public static void markDeleted(User user) {
        if (User.NULL_USER != user && !Util.isUserDeleted(user)) {
            user.setName(user.getName() + DELETED_MARKER);
        }
    }
}
