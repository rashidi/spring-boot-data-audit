package my.zin.rashidi.demo.data.audit.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
    @NotBlank(message = "name is required")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "username is required")
    private String username;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedBy
    @Column(nullable = false)
    private String modifiedBy;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}
