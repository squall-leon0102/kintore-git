package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="training")
@NamedQueries({
        @NamedQuery(
                name = "getAllTrainings",
                query = "SELECT t FROM Training AS t ORDER BY t.id DESC"
                ),
        @NamedQuery(
                name = "getTrainingsCount",
                query = "SELECT COUNT(t) FROM Training AS t"
                ),
})

@Entity

public class Training {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "training_date", nullable = false)
    private Date training_date;

    @Column(name = "pushup", nullable = false)
    private Integer pushup;

    @Column(name = "kensui", nullable = false)
    private Integer kensui;

    @Column(name = "sideraise", nullable = false)
    private Integer sideraise;

    @Column(name = "abs",nullable = false)
    private Integer abs;

    @Column(name = "squat", nullable = false)
    private Integer squat;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTraining_date() {
        return training_date;
    }

    public void setTraining_date(Date training_date) {
        this.training_date = training_date;
    }

    public Integer getPushup() {
        return pushup;
    }

    public void setPushup(Integer pushup) {
        this.pushup = pushup;
    }

    public Integer getKensui() {
        return kensui;
    }

    public void setKensui(Integer kensui) {
        this.kensui = kensui;
    }

    public Integer getSideraise() {
        return sideraise;
    }

    public void setSideraise(Integer sideraise) {
        this.sideraise = sideraise;
    }

    public Integer getAbs() {
        return abs;
    }

    public void setAbs(Integer abs) {
        this.abs = abs;
    }

    public Integer getSquat() {
        return squat;
    }

    public void setSquat(Integer squat) {
        this.squat = squat;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }




}
