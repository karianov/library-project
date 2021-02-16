-- -----------------------------------------------------
-- Table author
-- -----------------------------------------------------
CREATE TABLE author (
  id_author INT GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  fullname VARCHAR(100) NOT NULL,
  birthdate DATE NULL,
  birth_city VARCHAR(45) NULL,
  email VARCHAR(65) NULL,
  CONSTRAINT id_author_pk PRIMARY KEY (id_author)
);

-- -----------------------------------------------------
-- Table editorial
-- -----------------------------------------------------
CREATE TABLE editorial (
  id_editorial INT GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  name VARCHAR(100) NOT NULL,
  address VARCHAR(45) NOT NULL,
  phone VARCHAR(60) NOT NULL,
  email VARCHAR(65) NULL,
  max_books_reg INT NOT NULL,
  CONSTRAINT id_editorial_pk PRIMARY KEY (id_editorial)
);

-- -----------------------------------------------------
-- Table book
-- -----------------------------------------------------
CREATE TABLE book (
  id_book INT GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  title VARCHAR(100) NOT NULL,
  year INT NULL,
  genre VARCHAR(45) NOT NULL,
  pages INT NOT NULL,
  id_author INT NOT NULL,
  id_editorial INT,
  CONSTRAINT fk_book_to_author
    FOREIGN KEY (id_author)
    REFERENCES author (id_author),
  CONSTRAINT fk_book_to_editorial
    FOREIGN KEY (id_editorial)
    REFERENCES editorial (id_editorial),
  CONSTRAINT id_book_pk PRIMARY KEY (id_book)
);

-- -----------------------------------------------------
-- Comments
-- -----------------------------------------------------
comment on column editorial.max_books_reg
  is 'Maximum of books registered. If not exists, this column must be -1.';