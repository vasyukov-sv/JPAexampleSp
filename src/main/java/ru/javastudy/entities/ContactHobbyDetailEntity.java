package ru.javastudy.entities;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "contact_hobby_detail")
@IdClass(ContactHobbyDetailEntityPK.class)
public class ContactHobbyDetailEntity {
    private int contactId;
    private String hobbyId;
    private ContactEntity contactByContactId;

    @Id
    @Column(name = "contact_id", nullable = false)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Id
    @Column(name = "hobby_id", nullable = false, length = 20)
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
    public ContactEntity getContactByContactId() {
        return contactByContactId;
    }

    public void setContactByContactId(ContactEntity contactByContactId) {
        this.contactByContactId = contactByContactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactHobbyDetailEntity that = (ContactHobbyDetailEntity) o;

        return contactId == that.contactId &&
                (hobbyId != null ? hobbyId.equals(that.hobbyId) : that.hobbyId == null);
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + (hobbyId != null ? hobbyId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactHobbyDetailEntity{" +
                "contactId=" + contactId +
                ", hobbyId='" + hobbyId + '\'' +
                '}';
    }
}
