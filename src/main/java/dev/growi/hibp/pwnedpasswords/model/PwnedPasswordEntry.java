package dev.growi.hibp.pwnedpasswords.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;

@Entity(name = "hashes")
@IdClass(PwnedPasswordEntryId.class)
public class PwnedPasswordEntry {

    @Id
    String prefix;

    @Id
    String hash;

    Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Transient
    public String getPasswordHash(){
        return this.prefix + this.hash;
    }
}
