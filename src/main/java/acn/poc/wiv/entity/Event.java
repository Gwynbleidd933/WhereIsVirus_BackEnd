package acn.poc.wiv.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
//@JsonIgnoreProperties({"creator", "confirmingUsers"})
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="occurrence_date")
    private LocalDateTime occurrenceDate;

    @Column(name="is_confirmed_by_sanepid")
    private Boolean isConfirmedBySanepid;

    @Column(name="is_in_quarantine")
    private Boolean isInQuarantine;

    @Column(name="has_cough")
    private Boolean hasCough;

    @Column(name="has_fever")
    private Boolean hasFever;

    @Column(name="has_shortness_breath")
    private Boolean hasShortnessBreath;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    @Column(name="last_update_date")
    private LocalDateTime lastUpdateDate;

    @Column(name="description")
    private String description;

    @Column(name="longitude")
    private Double longitude;

    @Column(name="latitude")
    private Double latitude;

    @Column(name="address")
    private String address;

//    @ManyToOne(targetEntity = User.class)
//    @JoinColumn(name = "creator")
//    private User creator;


//    @ManyToMany(
//            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
//                    CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(
//            name="event_confirming_users",
//            joinColumns=@JoinColumn(name="event_id"),
//            inverseJoinColumns=@JoinColumn(name="user_id")
//    )
//    private List<User> confirmingUsers = new ArrayList<>();


    public Event() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOccurrenceDate() {
        return occurrenceDate;
    }

    public void setOccurrenceDate(LocalDateTime occurrenceDate) {
        this.occurrenceDate = occurrenceDate;
    }

    public Boolean getConfirmedBySanepid() {
        return isConfirmedBySanepid;
    }

    public void setConfirmedBySanepid(Boolean confirmedBySanepid) {
        isConfirmedBySanepid = confirmedBySanepid;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

//    public User getCreator() {
//        return creator;
//    }
//
//    public void setCreator(User creator) {
//        //prevent endless loop
//        if (sameAsFormerCreator(creator))
//            return ;
//        //set new creator
//        User oldCreator = this.creator;
//        this.creator = creator;
//        //remove from the old creator
//        if (oldCreator!=null)
//            oldCreator.removeCreatedEvent(this);
//        //set myself to new creator
//        if (creator!=null)
//            creator.addCreatedEvent(this);
//
//        this.creator = creator;
//    }
//
//    private boolean sameAsFormerCreator(User newCreator) {
//        return Objects.equals(creator, newCreator);
//    }



//    public List<User> getConfirmingUsers() {
//
//        //defensive copy, nobody will be able to change the
//        //list from the outside
//        return new ArrayList<>(confirmingUsers);
//    }
//
//    public void addConfirmingUser(User newConfirmingUser) {
//        //prevent endless loop
//        if (confirmingUsers.contains(newConfirmingUser))
//            return ;
//        //add new confirmingUser
//        confirmingUsers.add(newConfirmingUser);
//        //set myself into the newConfirmingUser
//        newConfirmingUser.addConfirmedEvent(this);
//    }
//
//    public void removeConfirmingUser(User confirmingUser) {
//        //prevent endless loop
//        if (!confirmingUsers.contains(confirmingUser))
//            return ;
//        //remove the confirmingUser
//        confirmingUsers.remove(confirmingUser);
//        //remove myself from the confirmingUser
//        confirmingUser.removeConfirmedEvent(this);
//    }

    public Boolean getInQuarantine() {
        return isInQuarantine;
    }

    public void setInQuarantine(Boolean inQuarantine) {
        isInQuarantine = inQuarantine;
    }


    public Boolean getHasCough() {
        return hasCough;
    }

    public void setHasCough(Boolean hasCough) {
        this.hasCough = hasCough;
    }

    public Boolean getHasFever() {
        return hasFever;
    }

    public void setHasFever(Boolean hasFever) {
        this.hasFever = hasFever;
    }

    public Boolean getHasShortnessBreath() {
        return hasShortnessBreath;
    }

    public void setHasShortnessBreath(Boolean hasShortnessBreath) {
        this.hasShortnessBreath = hasShortnessBreath;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", occurrenceDate=" + occurrenceDate +
                ", isConfirmedBySanepid=" + isConfirmedBySanepid +
                ", isInQuarantine=" + isInQuarantine +
                ", hasCough=" + hasCough +
                ", hasFever=" + hasFever +
                ", hasShortnessBreath=" + hasShortnessBreath +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", description='" + description + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", address='" + address + '\'' +
                '}';
    }
}

