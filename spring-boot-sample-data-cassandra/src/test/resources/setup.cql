CREATE TABLE customer (id text PRIMARY KEY, firstname text, lastname text);
CREATE INDEX customerfistnameindex ON customer (firstname);
CREATE INDEX customersecondnameindex ON customer (lastname);
