package it.euris.progettocinema.demo.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MovieType {

    ACTION("ACTION"),
    HORROR("HORROR"),
    FANTASY("FANTASY"),
    DRAMA("DRAMA");

    private final String type;

}
