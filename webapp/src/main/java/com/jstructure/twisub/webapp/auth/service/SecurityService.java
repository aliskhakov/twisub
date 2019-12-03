package com.jstructure.twisub.webapp.auth.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);

}
