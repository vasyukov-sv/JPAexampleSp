package ru.javastudy.entities;

import javax.persistence.*;

@Entity
@Table(name = "contact_tel_detail")
class ContactTelDetailEntity {
    private Integer id;
    private String telType;
    private String telNumber;
    private int version;
    private ContactEntity contact = new ContactEntity();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tel_type", nullable = false, length = 20)
    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    @Basic
    @Column(name = "tel_number", nullable = false, length = 20)
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @ManyToOne
    @JoinColumn(name = "contact_id", referencedColumnName = "id", nullable = false)
    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetailEntity that = (ContactTelDetailEntity) o;

        return id.equals(that.id) &&
                version == that.version &&
                (telType != null ? telType.equals(that.telType) : that.telType == null) &&
                (telNumber != null ? telNumber.equals(that.telNumber) : that.telNumber == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @Override
    public String toString() {
        return "ContactTelDetailEntity{" +
                "version=" + version +
                ", telNumber='" + telNumber + '\'' +
                ", telType='" + telType + '\'' +
                ", id=" + id +
                '}';
    }
}
