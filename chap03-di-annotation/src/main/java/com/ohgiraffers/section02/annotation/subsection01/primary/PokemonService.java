package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {
    private Pokemon pokemon;

    /* (석현) 생성자가 하나만 있을 시에는 Autowired를 생략해도 문제가 없음*/
    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }

}
