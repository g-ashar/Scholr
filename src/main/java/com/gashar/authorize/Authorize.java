/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.authorize;

/**
 *
 * @author gasha
 */
public interface Authorize {

    Object authorize();

    void saveCredentials(String path);

    String[] getCredentials();
}
