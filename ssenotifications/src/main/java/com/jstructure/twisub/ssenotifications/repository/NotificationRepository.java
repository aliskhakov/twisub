package com.jstructure.twisub.ssenotifications.repository;

public interface NotificationRepository {

    void set(String to, String notification);

    String get(String to);

    void delete(String userId);

}
