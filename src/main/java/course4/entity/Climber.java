package course4.entity;

import jakarta.persistence.*;
import lombok.*;

import  java.lang.String;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NonNull
@RequiredArgsConstructor

public class Climber extends BaseId {

    @Column(unique = true, nullable = false)
    private String name;
    private String adress;

    public Climber(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @Setter
    private GroupList groupList;
}