package dev.david.content.calendar.controller;

import dev.david.content.calendar.model.Content;
import dev.david.content.calendar.repository.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    //@Autowired pero si se tiene un solo contructor no se necesita de la notacion
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    //make a reuest and find all the pieces of content in the system
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }

    public void create(Content content){
        repository.save(content);
    }
}
