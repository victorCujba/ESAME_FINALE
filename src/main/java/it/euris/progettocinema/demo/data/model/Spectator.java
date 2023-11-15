package it.euris.progettocinema.demo.data.model;

import it.euris.progettocinema.demo.data.archetype.Model;
import it.euris.progettocinema.demo.data.dto.SpectatorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "spectator")
public class Spectator implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idSpectator;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_od_birth")
    private LocalDateTime dateOfBirth;

    @OneToMany(mappedBy = "spectator", cascade = CascadeType.MERGE)
    private List<Ticket> ticketList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_room")
    private Room room;


    @Override
    public SpectatorDTO toDto() {
        List<String> idStringTickets = new ArrayList<>();
        if (ticketList == null) {
            idStringTickets = null;
        } else {

            List<Long> idLongRoom = ticketList.stream()
                    .map(Ticket::getId).toList();
            for (Long id : idLongRoom) {
                idStringTickets.add(id.toString());
            }
        }


        return SpectatorDTO.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(localDateTimeToString(dateOfBirth))
                .idTickets(idStringTickets)
                .build();
    }

    public Boolean has18Yeast() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(localDateTimeToString(dateOfBirth));
        Date date1 = sdf.parse(LocalDateTime.now().toString().substring(0, 19));
        Date date2 = sdf.parse(localDateTimeToString(dateOfBirth.plusYears(18L)));
        if (date1.before(date2)) {
            return true;
        } else {
            return false;
        }
    }
}
