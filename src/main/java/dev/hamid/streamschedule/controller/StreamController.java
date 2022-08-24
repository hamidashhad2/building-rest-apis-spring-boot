package dev.hamid.streamschedule.controller;

import dev.hamid.streamschedule.exception.LiveStreamNotFoundException;
import dev.hamid.streamschedule.model.LiveStream;
import dev.hamid.streamschedule.repository.LiveStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stream")
public class StreamController {

    private final LiveStreamRepository repository;

    @Autowired
    public StreamController(LiveStreamRepository repository) {
        this.repository = repository;
    }

    // GET http://localhost:8080/streams
    @GetMapping
    public List<LiveStream> finAll() {
        return repository.findAll();
    }

    // GET http://localhost:8080/streams/fe4418b2-8791-4001-87c1-9bd2722938ae
    @GetMapping("/{id}")
    public LiveStream findById(@PathVariable String id) throws LiveStreamNotFoundException {
        return repository.findById(id);
    }

    // POST http://localhost:8080/streams/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LiveStream create(@RequestBody LiveStream stream) {
        return repository.create(stream);
    }

    // PUT http://localhost:8080/streams/fe4418b2-8791-4001-87c1-9bd2722938ae
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody LiveStream stream) {
        repository.update(id, stream);
    }

    // DELETE http://localhost:8080/streams/fe4418b2-8791-4001-87c1-9bd2722938ae
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.delete(id);
    }

}
