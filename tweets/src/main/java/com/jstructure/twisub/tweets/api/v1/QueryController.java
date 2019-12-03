package com.jstructure.twisub.tweets.api.v1;

import com.jstructure.twisub.tweets.dto.QueryDto;
import com.jstructure.twisub.tweets.service.QueryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/v1/queries")
@RequiredArgsConstructor
public class QueryController {

    private final QueryDataService dataService;

    @PostMapping(path = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public QueryDto create(@RequestBody QueryDto query) {
        dataService.createQuery(query);
        return query;
    }

    @GetMapping(path = "/{username}/{id}", produces = "application/json")
    public QueryDto read(@PathVariable String username, @PathVariable UUID id) {
        return dataService.getQueryByUsernameAndId(username, id);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public QueryDto update(@PathVariable UUID id, @RequestBody QueryDto query) {
        query.setId(id);
        dataService.updateQuery(query);
        return query;
    }

    @DeleteMapping(path = "/{username}/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String username, @PathVariable UUID id) {
        dataService.deleteQuery(username, id);
    }

    @GetMapping(path = "/", produces = "application/json")
    public Iterable<QueryDto> list() {
        return dataService.getAll();
    }

    @GetMapping(path = "/{username}", produces = "application/json")
    public Iterable<QueryDto> list(@PathVariable String username) {
        return dataService.getAll(username);
    }

}
