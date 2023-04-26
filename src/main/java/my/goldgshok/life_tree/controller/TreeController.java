package my.goldgshok.life_tree.controller;

import lombok.RequiredArgsConstructor;
import my.goldgshok.life_tree.controller.dto.GenogramDto;
import my.goldgshok.life_tree.converter.PersonConverter;
import my.goldgshok.life_tree.service.TreeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "web/tree", produces = MediaType.APPLICATION_JSON_VALUE)
public class TreeController {

    private final TreeService treeService;

    @GetMapping(value = "get-tree-data")
    public List<GenogramDto> getTreeData() {
        var persons = treeService.getAllPersons();
        return persons.stream()
                .map(PersonConverter::convertTree)
                .toList();
    }

}
