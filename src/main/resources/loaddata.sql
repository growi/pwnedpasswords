.mode csv
.separator ":"
CREATE TABLE hashes(prefix TEXT, hash TEXT, count INTEGER);
.import pwned-passwords-sha1-ordered-by-hash-v5-prefixed.txt hashes
CREATE INDEX hashes_index ON hashes (hash);
CREATE INDEX prefix_index ON hashes (prefix);

