package dev.growi.hibp.pwnedpasswords.controller.api;


import dev.growi.hibp.pwnedpasswords.model.PwnedPasswordEntry;
import dev.growi.hibp.pwnedpasswords.repository.PwnedPasswordEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PwnedPasswordEntryController {

    @Autowired
    private PwnedPasswordEntryRepository repo;

    @GetMapping("/api/pwnedpassword/{hash}")
    public PwnedPasswordEntry getPwnedPassword(@PathVariable("hash") String hash) {
        try {
            assert hash != null;
            assert !hash.isEmpty();
            assert hash.length() == 40;
            assert hash.matches("[0-9a-fA-F]*");
        } catch(AssertionError err) {
            throw new IllegalParameterException(err);
        }
        return repo.findPwnedPasswordEntryByPrefixAndHash(hash.substring(0, 5), hash.substring(5));
    }

    @GetMapping("/api/range/{prefix}")
    public Set<PwnedPasswordEntry> getPwnedPasswords(@PathVariable("prefix") String prefix) {
        try {
            assert prefix != null;
            assert !prefix.isEmpty();
            assert prefix.length() == 5;
            assert prefix.matches("[0-9a-fA-F]*");
        } catch(AssertionError err) {
            throw new IllegalParameterException(err);
        }
        return repo.findPwnedPasswordEntryByPrefix(prefix.toUpperCase());
    }
}