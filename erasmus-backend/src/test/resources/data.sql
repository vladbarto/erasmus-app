INSERT INTO public.person(
    dateofbirth, facultycode, person_id, userid, city, cnp, country, name, phonenumber, universitycode)
VALUES ('2003-01-27',
        '50000000-0000-0000-0000-000000000000',
        '10000000-0000-0000-0000-000000000000',
        '10000000-0000-0000-0000-000000000001',
        'Oradea',
        '6030127055831',
        'Romania',
        'Natalia Boncea',
        '0745752480',
        'UTCN_01');
INSERT INTO representative(person_id, titles, type)
VALUES ('10000000-0000-0000-0000-000000000000',
        'conf.univ.',
        'TEACHER');
INSERT INTO announcement(announcement_id, title, description, representativeId, universityCode)
VALUES ('00000000-0000-0000-0000-000000000000',
        'Stiri Erasmus',
        'S-a publicat lista cu studentii admisi.',
        '10000000-0000-0000-0000-000000000000',
        'UTCN_01');
