package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceCollection")
public class PokemonService {

    /* List 타입을 주입 */
/*    private List<Pokemon> pokemonList;
    @Autowired
    public PokemonService(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void pokemonAttack() {
        // 결론 : 포켓몬 리스트에 담겨있는 포켓몬들의 공격 메소드를 호출하라는 뜻
        // Pokemon::attack : Pokemon 클래스에 있는 attack 메소드를 호출 하라는 뜻
        pokemonList.forEach(Pokemon::attack);
    }*/

    // (석현) Map 방식으로 하면 key 값과 value값을 볼 수 있음
    private Map<String, Pokemon> pokemonMap;

    public PokemonService(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    /* k와 v는 forEach에서 람다 표현식을 쓴 것
       코드해석 : forEach를 써서 key 값에 대한 value를 나타내는데
       그 value 값에 attack 메소드를 호출 하라는 뜻                */
    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key : " + k);
            System.out.println("공격 : ");
            v.attack();
        });
    }
}
