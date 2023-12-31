package aamm.order.model;

public abstract class NotificationTemplate {

    String templateMessage;
    String contactInfo;
    ContactType contactType;
    long id;


    public NotificationTemplate() {

    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }
    public abstract void setNotificationTemplate();

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }
    
    public String getTemplateMessage() {
        return templateMessage;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public String toString() {
        return "NotificationTemplate{" +
                "templateMessage='" + templateMessage + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", contactType=" + contactType +
                '}';
    }
}
