package asdum.uz.entity.secoud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BugList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String table_name;

    @Column(length = 50)
    private String className;

    @Column(length = 50)
    private String methodName;

    @Column(length = 250)
    private String command;

    public BugList(String table_name, String className, String methodName, String command) {
        this.table_name = table_name;
        this.className = className;
        this.methodName = methodName;
        this.command = command;
    }
}
