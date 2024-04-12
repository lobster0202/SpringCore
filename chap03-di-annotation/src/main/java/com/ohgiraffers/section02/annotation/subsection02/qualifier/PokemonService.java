package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {
    /* default 주입보다 생성자 주입을 더 많이 사용함 */
    /* 필드 주입 방식 */
//    @Autowired
//    @Qualifier("pikachu")
    private Pokemon pokemon;

    /* 생성자 주입 방식 */
    @Autowired
    public PokemonService(@Qualifier("squirtle") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAattack() {
        pokemon.attack();
    }

}
