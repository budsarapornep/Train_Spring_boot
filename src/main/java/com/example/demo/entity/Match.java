package com.example.demo.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Fe2n_Match")
public class Match {
    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "Fe2n_Match_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    private Integer match_id;

    @Column(name = "status",length = 50,nullable = false)
    private String status;

    @Column(name = "start_date", nullable = false)
    private Date start_date;
    @Column(name = "end_date", nullable = false)
    private Date end_date;

    public Integer getId() {
        return match_id;
    }

    public void setId(Integer id) {
        this.match_id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
