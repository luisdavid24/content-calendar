package dev.david.content.calendar.repository;

import dev.david.content.calendar.model.Content;
import dev.david.content.calendar.model.Status;
import dev.david.content.calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c ->c.id().equals(id)).findFirst();
    }
    @PostConstruct
    private void init(){
        Content c = new Content(1,
                "My first blog Post",
                "My fist blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        content.add(c);

    }
}