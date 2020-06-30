package edu.gtu.SoftwareStoreManager;

import java.util.LinkedList;

/**
 * Overall storage class that keeps the data related to
 * software-store.
 */
public class SystemStorage {

    /**
     * General administrator password.
     */
    static final String GENERAL_PASSWORD = "gtu";

    /**
     * Software container that keeps the data in general binary tree.
     */
    SearchTree<Software> softwareTree;

    /**
     * Linked-List for just printing all software.
     */
    LinkedList<Software> softwareList;

    /**
     * Storage Constructor.
     */
    SystemStorage( SearchTree<Software> givenContainer ) {

        if( givenContainer != null ) {
            softwareTree =  givenContainer;
            softwareList = new LinkedList<>();
        } else {
            throw new IllegalStateException("Construction of structure must be initialized before.");
        }

    }

    /**
     * Return tree structure.
     * @return Structure that implement SearchTree interface
     */
    public SearchTree<Software> getSoftwareTree() {
        return softwareTree;
    }

    /**
     * Return the list of software
     * @return list.
     */
    public LinkedList<Software> getSoftwareList() {
        return softwareList;
    }

    /**
     * Return the password.
     * @return password.
     */
    static String getGeneralPassword() {
        return GENERAL_PASSWORD;
    }

    /**
     * Given an console output of all software in the store.
     */
    public void listSoftware() {
        System.out.println("------All-Software------");
        System.out.println(softwareList);
    }

}
