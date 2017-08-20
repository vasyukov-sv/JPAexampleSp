package ru.javastudy.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getContactsByHobby",
                procedureName = "get_Contacts_By_Hobby",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "hobby", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "contactCount", type = Integer.class)
                }
               )
})


@Entity
@Table(name = "contact")
public class ContactEntity {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private int version;
    private Set<ContactTelDetailEntity> contactTelDetailEntities = new HashSet<ContactTelDetailEntity>();
    private Set<HobbyEntity> hobbies = new HashSet<HobbyEntity>();

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 60)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 40)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    /* mappedBy - свойство в ContactTelDetailEntity, связанное с внешнем ключом в этой таблице
       cascade - операция обновления должна распространяться на дочерние записи
       orphanRemoval - после обновления, записи которых больше нет в наборе должны быть удалены из БД
    */
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ContactTelDetailEntity> getContactTelDetailEntities() {
        return contactTelDetailEntities;
    }

    public void setContactTelDetailEntities(Set<ContactTelDetailEntity> contactTelDetailEntities) {
        this.contactTelDetailEntities = contactTelDetailEntities;
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            //foreign key for ContactEntity in contact_hobby_detail table
            joinColumns = @JoinColumn(name = "contact_id"),
            //key for other side - hobby table
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    public Set<HobbyEntity> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<HobbyEntity> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        return id.equals(that.id) && version == that.version && (firstName != null ? firstName.equals(that.firstName) : that.firstName == null) && (lastName != null ? lastName.equals(that.lastName) : that.lastName == null) && (birthDate != null ? birthDate.equals(that.birthDate) : that.birthDate == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "version=" + version +
                ", birthDate=" + birthDate +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
