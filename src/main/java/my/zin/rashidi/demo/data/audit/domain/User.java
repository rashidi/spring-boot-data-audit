package my.zin.rashidi.demo.data.audit.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.ZonedDateTime;

/**
 * @author Rashidi Zin
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
public class User {

    private Long id;
    private String name;
    private String username;
    private ZonedDateTime created;
    private ZonedDateTime modified;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        Assert.hasText(name, "name is required");

        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        Assert.hasText(username, "username is required");

        this.username = username;
        return this;
    }

    @CreatedDate
    public ZonedDateTime getCreated() {
        return created;
    }

    public User setCreated(ZonedDateTime created) {
        this.created = created;
        return this;
    }

    @LastModifiedDate
    public ZonedDateTime getModified() {
        return modified;
    }

    public User setModified(ZonedDateTime modified) {
        this.modified = modified;
        return this;
    }
}
