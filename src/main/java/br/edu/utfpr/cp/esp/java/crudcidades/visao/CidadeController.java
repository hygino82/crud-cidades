package br.edu.utfpr.cp.esp.java.crudcidades.visao;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CidadeController {

    @GetMapping("/")
    public String listar(Model memoria) {
        var cidades = Set.of(
                new Cidade("Coronel Vivida", "PR"),
                new Cidade("Marcelino Ramos", "RS"),
                new Cidade("São Domingos", "SC")
        );
        memoria.addAttribute("listaCidades", cidades);
        return "/crud";
    }
}
