package net.pis.demo.anton.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import net.pis.demo.anton.dao.BeritaDao;
import net.pis.demo.anton.entity.Berita;
import net.pis.demo.anton.exception.DataNotFoundException;


@RestController
@RequestMapping("/api/berita")
@Transactional(readOnly = true)
public class BeritaController {

    @Autowired
    private BeritaDao beritaDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Berita> findAll(Pageable page) {
        return beritaDao.findAll(page);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ResponseEntity<Void> create(@RequestBody @Valid Berita p, UriComponentsBuilder uriBuilder) {
        beritaDao.save(p);
        URI location = uriBuilder.path("/api/berita/{id}")
                .buildAndExpand(p.getId()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Berita findById(@PathVariable("id") Berita p) {
        if (p == null) {
            throw new DataNotFoundException("No data with the specified id");
        }

        return p;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = false)
    public void update(@PathVariable("id") Integer id, @RequestBody @Valid Berita p) {
        if (!beritaDao.exists(id)) {
            throw new DataNotFoundException("tidak ada berita with the specified id");
        }
        p.setId(id);
        beritaDao.save(p);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = false)
    public void delete(@PathVariable("id") Integer id) {
        if (!beritaDao.exists(id)) {
            throw new DataNotFoundException("No data with the specified id");
        }
        beritaDao.delete(id);
}

}
