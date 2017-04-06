--tabel kursus
create table kursus (
    kode varchar(4) primary key not null,
    nama varchar(30) not null,
    jam date not null
) Engine=InnoDB;

-- tabel kelas --
create table kelas (
    kode varchar(10) primary key not null,
    kode_kursus varchar(4) not null,
    tgl_mulai date not null
) Engine=InnoDB;
