package com.jstructure.twisub.tweets.api.v1;

import com.jstructure.twisub.tweets.dto.QueryDto;
import com.jstructure.twisub.tweets.service.QueryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/v1/queries")
public class QueryController {

    @Autowired
    private QueryDataService dataService;

    @PostMapping(path = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public QueryDto create(@RequestBody QueryDto query) {
        dataService.createQuery(query);
        return query;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public QueryDto read(@PathVariable UUID id) {
        return dataService.getQueryById(id);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public QueryDto update(@PathVariable UUID id, @RequestBody QueryDto query) {
        query.setId(id);
        dataService.updateQuery(query);
        return query;
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        dataService.deleteQuery(id);
    }

    @GetMapping(path = "/", produces = "application/json")
    public Iterable<QueryDto> list() {
        return dataService.getAll();
    }

}
