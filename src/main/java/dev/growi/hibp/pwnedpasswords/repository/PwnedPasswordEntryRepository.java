package dev.growi.hibp.pwnedpasswords.repository;

import dev.growi.hibp.pwnedpasswords.model.PwnedPasswordEntry;
import org.springframework.data.repository.Repository;

import java.util.Set;

public interface PwnedPasswordEntryRepository extends Repository<PwnedPasswordEntry, String> {

    PwnedPasswordEntry findPwnedPasswordEntryByHash(String hash);

    PwnedPasswordEntry findPwnedPasswordEntryByPrefixAndHash(String prefix, String hash);

    Set<PwnedPasswordEntry> findPwnedPasswordEntryByHashStartsWith(String hash);

    Set<PwnedPasswordEntry> findPwnedPasswordEntryByPrefix(String prefix);
}
