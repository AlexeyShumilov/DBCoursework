package course4.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NonNull
@NoArgsConstructor
@ToString(callSuper = true)
public class GroupList extends BaseId {
    private boolean openGroup = true;
    @OneToMany(mappedBy = "groupList", cascade = CascadeType.PERSIST)
    private final List<Climber> climbers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "mountain_id")
    private Mountain mountain;


    public GroupList(Mountain mountain) {
        this.mountain = mountain;
    }

    public  void  addClimber(Climber... climbers1){
        if (!openGroup){
            System.out.println("Мест нет");
            return;
        }
        for (Climber climber : climbers1) {
            if (climbers.size() < 3) {
                climber.setGroupList(this);
                climbers.add(climber);
            }
            if (climbers.size() == 3){
                openGroup = false;
                System.out.println("Места закончились");
            }
        }
    }
}