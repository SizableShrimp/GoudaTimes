def actually_hash(s: str) -> bytes:
    hasher = hashlib.sha256()
    hasher.update(s.encode('utf-8'))
    return hasher.digest()
