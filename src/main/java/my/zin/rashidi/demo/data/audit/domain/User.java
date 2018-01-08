package my.zin.rashidi.demo.data.audit.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
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

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private ZonedDateTime created;

    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy;

    @LastModifiedDate
    @Column(nullable = false)
    private ZonedDateTime modified;

    public Long getId() {
        return id;
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

    public ZonedDateTime getCreated() {
        return created;
    }

    public ZonedDateTime getModified() {
        return modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}
