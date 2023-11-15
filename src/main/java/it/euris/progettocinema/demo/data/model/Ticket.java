package it.euris.progettocinema.demo.data.model;

import it.euris.progettocinema.demo.data.archetype.Model;
import it.euris.progettocinema.demo.data.dto.TicketDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static it.euris.progettocinema.demo.utility.DataConversionUtils.numberToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ticket")
public class Ticket implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "position")
    private String position;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "id_spectator")
    private Spectator spectator;

    @Override
    public TicketDTO toDto() {
        return TicketDTO.builder()
                .id(numberToString(id))
                .position(position)
                .price(numberToString(price))
                .idSpectator(numberToString(spectator.getIdSpectator()))
                .build();
    }
}
