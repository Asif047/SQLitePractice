package com.example.user.sqliteproject2.Model;

/**
 * Created by User on 6/18/2017.
 */

public class ContactModel {

    private int ContactId;
    private String ContactName;
    private String ContactPhone;

    public ContactModel(int contactId, String contactName, String contactPhone) {
        ContactId = contactId;
        ContactName = contactName;
        ContactPhone = contactPhone;
    }

    public ContactModel(String contactName, String contactPhone) {
        ContactName = contactName;
        ContactPhone = contactPhone;
    }


    public int getContactId() {
        return ContactId;
    }

    public void setContactId(int contactId) {
        ContactId = contactId;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        ContactPhone = contactPhone;
    }
}
