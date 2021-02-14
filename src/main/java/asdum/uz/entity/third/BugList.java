package asdum.uz.entity.third;

import asdum.uz.entity.enums.EnumBugStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "via_mobile_bug_list")
public class BugList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String service;

    @Column(length = 50)
    private String tableName;

    @Column(length = 50)
    private String class_name;

    @Column(length = 50)
    private String methodName;

    @Column(length = 250)
    private String command;

    private Boolean fixed;

    @Enumerated(EnumType.STRING)
    private EnumBugStatus enumBugStatus;

    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updatedAt;

    public BugList(String service, String tableName, String className, String methodName, String command) {
        this.service = service != null ? service.toUpperCase() : "VIA-MOBILE-API-V2";
        this.tableName = tableName.toUpperCase();
        this.class_name = className.toUpperCase();
        this.methodName = methodName.toUpperCase();
        this.command = command != null ? command : "commends is not available";
        this.fixed = null;
        this.enumBugStatus = EnumBugStatus.BACKEND;
    }
}
