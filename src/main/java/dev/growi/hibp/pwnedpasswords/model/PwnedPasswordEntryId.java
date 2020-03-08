package dev.growi.hibp.pwnedpasswords.model;

import java.io.Serializable;
import java.util.Objects;

public class PwnedPasswordEntryId implements Serializable {

    private String prefix;

    private String hash;

    public PwnedPasswordEntryId(){}

    public PwnedPasswordEntryId(String prefix, String hash) {
        this.prefix = prefix;
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PwnedPasswordEntryId that = (PwnedPasswordEntryId) o;
        return prefix.equals(that.prefix) &&
                hash.equals(that.hash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, hash);
    }
}