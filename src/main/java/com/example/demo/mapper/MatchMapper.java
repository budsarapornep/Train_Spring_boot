package com.example.demo.mapper;

import com.example.demo.dto.MatchDTO;
import com.example.demo.entity.Match;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MatchMapper {
    private static SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static Match getmatch(MatchDTO matchDTO) {
        Match match = new Match();
        try {
            match.setEnd_date(sm.parse(matchDTO.getEnd_date()));
            match.setStart_date(sm.parse(matchDTO.getStart_date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        match.setId(matchDTO.getMatchid());
        match.setStatus(matchDTO.getStatus());

        return match;
    }

    public static MatchDTO getMatchDTO(Match match) {
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setMatchid(match.getId());
        matchDTO.setStatus(match.getStatus());
        try {
            matchDTO.setEnd_date(sm.format(match.getEnd_date()));
            matchDTO.setStart_date(sm.format(match.getStart_date()));
        }catch (Exception e){
            e.getMessage();
        }
        return matchDTO;
    }
}
