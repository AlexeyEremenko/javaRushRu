USE test;

DROP TABLE IF EXISTS book;

CREATE TABLE book(   id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     title VARCHAR(100),
                     description VARCHAR(255),
                     author VARCHAR(100),
                     isbn VARCHAR(20),
                     printyear INT(4),
                     readalready BOOLEAN)

                     ENGINE = InnoDB
                     DEFAULT CHARACTER SET = utf8;

INSERT INTO book (title, description, author, isbn, printyear, readalready)
VALUES (
        'Bible',
        'alive Book, given to us from Holy Spirit to save us from our sins',
        'God Almighty',
        7777777,
        0,
        true);

INSERT INTO book (title, description, author, isbn, printyear, readalready)
VALUES (
        'Bible',
        'alive Book, given to us from Holy Spirit to save us from our sins',
        'God Almighty',
        7777777,
        0,
        true);

