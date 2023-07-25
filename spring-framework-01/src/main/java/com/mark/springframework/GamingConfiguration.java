package com.mark.springframework;

import com.mark.springframework.game.GameRunner;
import com.mark.springframework.game.GamingConsole;
import com.mark.springframework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {
        return new PacmanGame();
    }

    @Bean
    public GameRunner runner(GamingConsole gamingConsole) {
        return new GameRunner(gamingConsole);
    }
}
