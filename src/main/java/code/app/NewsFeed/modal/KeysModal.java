package code.app.NewsFeed.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "keys")
public class KeysModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_date")
    private ZonedDateTime createdDate;

    @Column(name = "key_value") // Column name in the database
    @JsonProperty("key_value") // JSON property name
    private String key;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
