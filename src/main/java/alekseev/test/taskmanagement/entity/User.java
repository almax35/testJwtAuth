package alekseev.test.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Table(name = "users")
@Entity
public class User {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;
        private String login;
        private String password;
        @ManyToOne
        @JoinColumn(name = "role_id")
        private Role role;
}
