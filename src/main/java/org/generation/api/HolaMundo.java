package org.generation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/holaMundo/")//http://localhost:8080
public class HolaMundo {

    @GetMapping(path="metodo")
    public String holaMundo(){
        return "<h1>Hola mundo!</h1>";
    }//holaMundo
}//class holamundo
