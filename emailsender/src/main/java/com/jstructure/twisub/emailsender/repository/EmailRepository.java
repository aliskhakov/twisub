package com.jstructure.twisub.emailsender.repository;

public interface EmailRepository {

    void set(String user, String email);

    String get(String user);

    void delete(String user);

}
