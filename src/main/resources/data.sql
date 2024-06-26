INSERT INTO eleves (id, date_de_naissance, details, email, actif, genre, nom, prenom, telephone)
VALUES
    ('5FD2CE6E-7358-204F-E15E-C8D9982160F9', '2000-04-28', 'Lorem ipsum', 'augue.id@outlook.ca', 'true', 'F', 'addison', 'mona', '04 12 15 89 88'),
    ('3CB059BE-CC68-FA22-CB7C-1C47801D7EEF', '1993-05-25', 'Lorem ipsum', 'augue.id@outlook.ca', 'false', 'H', 'aennifer', 'armand', '02 85 07 68 20'),
    ('936AC4C1-B9A5-9640-1517-3CD1D931B995', '2004-03-21', 'Lorem', 'vehicula.aliquet@outlook.couk', 'true', 'H', 'aoble', 'murphy', '07 39 86 63 88'),
    ('2D16475C-8CE5-B684-D87E-839147CBC96E', '1996-10-12', 'Lorem ipsum', 'arcu@hotmail.couk', 'true', 'F', 'austin', 'carson', '06 52 61 36 51'),
    ('4A8C1645-8D67-6527-1688-C1D13C129F6C', '1991-11-09', 'Lorem ipsum dolor sit amet, consectetuer', 'tellus.non@protonmail.couk', 'true', 'F', 'jared', 'trevor', '09 67 36 72 26'),
    ('93E6DE8D-C30F-6342-FEB1-7BDE5D237DA9', '1995-07-30', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'non.nisi@yahoo.couk', 'false', 'H', 'tasha', 'brielle', '01 46 45 50 86'),
    ('A747AD47-7232-6909-0BDD-E9B7A29293E8', '1996-07-01', 'Lorem', 'ultrices.sit@icloud.ca', 'true', 'F', 'gabriel', 'morgan', '07 25 17 48 86'),
    ('616CDE31-E357-1637-5FDE-3571ECA81C1C', '2001-06-10', 'Lorem ipsum dolor sit', 'metus.in@aol.org', 'false', 'H', 'debra', 'moana', '04 94 22 51 02'),
    ('2BB36E57-DED7-A363-7BF9-FCC3DA87988B', '1994-07-08', 'Lorem ipsum dolor sit amet,', 'praesent.eu.dui@protonmail.com', 'false', 'H', 'bo', 'ella', '08 13 63 30 63'),
    ('489C1E5D-764C-0A4C-5E47-68A99DB2A505', '2003-10-16', 'Lorem ipsum', 'diam.proin@hotmail.org', 'false', 'H', 'aurora', 'elaine', '07 52 12 21 67'),
    ('7B91A893-80B4-8F24-FE1B-04B532D78EE0', '2003-11-13', 'Lorem', 'mi.enim@aol.com', 'false', 'F', 'jermaine', 'amethyst', '04 43 21 57 70'),
    ('383CE3BC-D6D3-C2B2-77A6-45ABE3877D9C', '1991-11-08', 'Lorem', 'semper.egestas@outlook.edu', 'false', 'F', 'larissa', 'lois', '07 71 18 78 64'),
    ('2BB17ACD-5818-E053-E92F-B22D6B889A10', '2004-12-15', 'Lorem ipsum dolor', 'neque.nullam@protonmail.edu', 'true', 'H', 'damian', 'cameron', '07 83 11 44 62'),
    ('61338D6E-9CE5-D946-8D26-A13657DE7CBA', '2000-03-29', 'Lorem ipsum', 'in.aliquet@hotmail.net', 'true', 'H', 'nissim', 'odette', '08 84 56 57 86'),
    ('1AB24CB6-AF24-9157-735E-271984A15B77', '2004-01-19', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'mauris@hotmail.com', 'false', 'F', 'mara', 'ruby', '05 65 31 96 64');

INSERT INTO moniteurs (id,actif,email,nom,prenom,qualification,telephone)
VALUES
    ('8150B7B2-A4EA-7794-B882-35D886DBC17B','false','nunc@yahoo.edu','Dalton','Clarke','ANIMATEUR','03 98 25 42 41'),
    ('C44264C3-A1DF-AB14-FDA9-395E1DDD0259','true','purus.sapien@hotmail.org','Drake','Tanek','ANIMATEUR','05 62 71 56 68'),
    ('122A2ED4-ED45-ADB9-A68C-2E5D8D362405','false','facilisis.facilisis@protonmail.ca','Forrest','Rafael','INITIATEUR','01 92 96 78 47'),
    ('8CA18B54-8DD7-C821-E34F-494680C45235','false','justo.nec@outlook.ca','Kay','Hamish','INITIATEUR','03 18 83 84 86'),
    ('676AD84B-36A0-47E9-9354-C7E24C673016','true','auctor@google.net','Aiko','Sonya','EDUCATEUR','07 68 54 61 85'),
    ('42541A97-A48C-5DAA-2E4E-48106584C541','true','nulla@protonmail.edu','Colt','Melanie','EDUCATEUR','08 33 46 80 65'),
    ('9ACFCA7C-A36D-2E82-5125-2E2980D71D46','true','vulputate@outlook.net','Shay','Ralph','ENTRAINEUR','04 31 60 91 44'),
    ('A4E119A8-928E-66CD-6413-1B2B51E79170','false','ut.sagittis@protonmail.ca','Yvette','Ezekiel','ENTRAINEUR','07 54 28 04 33'),
    ('CC63D5AC-72B9-E453-117C-6697FAEA679C','true','porttitor.tellus@icloud.org','Zachary','Otto','ANIMATEUR','04 82 32 45 48');

INSERT INTO formulescours (id, effectif_maximum, nombre_seance_total, nombre_seance_hebdomadaire, duree_seance_minute_formule_cours, tarif, date_debut, date_fin, periode, type_balle, niveau, actif, categorie_age)
VALUES
    ('9F9DAD95-9FAD-0B87-8452-67035E83345B', 4, 25, 1, 60, 350.00, '2023-09-11', '2024-02-05', 'HIVER', 'JAUNE', 'LOISIR', 'true', 'ADULTE'),
    ('57FDE1D9-877A-DD4C-7736-1DA9E947E544', 4, 8, 1, 60, 180.00, '2024-04-11', '2024-06-05', 'ETE', 'JAUNE', 'LOISIR', 'true', 'ADULTE'),
    ('371E7276-427B-7D8C-3564-3894D752D186', 4, 28, 1, 60, 420.00, '2023-09-11', '2024-05-04', 'ANNEE', 'JAUNE', 'QUATRIEME_SERIE', 'true', 'ADULTE'),
    ('E289A9C2-9429-870B-C3A1-9B1AAD135D7A', 4, 30, 1, 60, 450.00, '2023-09-23', '2024-05-03', 'ANNEE', 'JAUNE', 'TROISIEME_SERIE', 'true', 'ADULTE'),
    ('790D38B8-1EAE-BFF5-5F65-DD51722A9B55', 4, 25, 1, 60, 380.00, '2023-09-15', '2024-05-02', 'ANNEE', 'JAUNE', 'DEUXIEME_SERIE', 'true', 'ADULTE'),
    ('4BC58C7A-5698-8D22-D8B4-57C48113400A', 2, 22, 1, 60, 330.00, '2023-09-18', '2024-05-02', 'ANNEE', 'JAUNE', 'LOISIR', 'true', 'ADULTE'),
    ('8ADE8184-61B6-C15B-CDB2-8D4E725C1E7E', 2, 22, 1, 60, 330.00, '2023-09-12', '2024-05-02', 'ANNEE', 'JAUNE', 'QUATRIEME_SERIE', 'true', 'ADULTE'),
    ('4BC58C7A-5698-8D22-D8B4-57000B13400A', 4, 22, 1, 60, 330.00, '2023-09-18', '2024-05-02', 'ANNEE', 'VERTE', 'LOISIR', 'true', 'JEUNE'),
    ('4BC58C7A-5698-8D22-D8B4-57C481134999', 2, 5, 1, 60, 130.00, '2022-09-18', '2023-05-02', 'ANNEE', 'JAUNE', 'LOISIR', 'false', 'ADULTE'), -- A utiliser pour les prestations
    ('8ADE8184-61B6-C15B-CDB2-8D4E725C1777', 4, 5, 1, 60, 100.00, '2022-09-12', '2023-05-02', 'ANNEE', 'JAUNE', 'QUATRIEME_SERIE', 'false', 'ADULTE'); -- A utiliser pour les prestations


INSERT INTO groupescours (id,libelle,actif)
VALUES
    ('8CA18B54-8DD7-C821-E34F-AB1580C45235','Cours ADULTE 2 élèves - Jeudi 2022','true'),
    ('52B79754-D67D-6E55-389D-5F662D469781','Cours JEUNE 4 élèves - Mercredi 2022 ','true'),
    ('2EFB65CD-5652-F9B6-099D-C8E6146E738F','Cours ADULTE 4 élèves - Vendredi 2023','true'),
    ('15D2C74C-98B1-EE7D-8351-AFBE7008B01C','Cours ADULTE 4 élèves - Mardi 2023','false');

INSERT INTO inscriptionsformule (id, date_paiement, montant_percu, moyen_paiement, note_paiement, reference_eleve, reference_formule, reference_groupe)
VALUES
    ('30438922-D04A-942B-984F-D21D1C56581C', '2022-09-10', 130.00, 'VIREMENT', '', '5FD2CE6E-7358-204F-E15E-C8D9982160F9', '4BC58C7A-5698-8D22-D8B4-57C481134999', '8CA18B54-8DD7-C821-E34F-AB1580C45235'),
    ('122BEEA2-CB35-870F-9F61-7F605D2C231A', '2022-09-10', 80.00, 'LIQUIDE', 'Manque 50€', '3CB059BE-CC68-FA22-CB7C-1C47801D7EEF', '4BC58C7A-5698-8D22-D8B4-57C481134999', '8CA18B54-8DD7-C821-E34F-AB1580C45235'),
    ('3F077CEF-B1DD-CEE0-2FB6-51BD331AF3AB', '2022-09-10', 100.00, 'VIREMENT', '', '936AC4C1-B9A5-9640-1517-3CD1D931B995', '8ADE8184-61B6-C15B-CDB2-8D4E725C1777', '52B79754-D67D-6E55-389D-5F662D469781'),
    ('1C1537D2-CF82-1684-A7E8-BA0AA8281322', '2022-09-10', 100.00, 'VIREMENT', '', '2D16475C-8CE5-B684-D87E-839147CBC96E', '8ADE8184-61B6-C15B-CDB2-8D4E725C1777', '52B79754-D67D-6E55-389D-5F662D469781'),
    ('D871815F-14A1-1399-7A85-781AF8D98EC5', '2022-09-10', 100.00, 'VIREMENT', '', '4A8C1645-8D67-6527-1688-C1D13C129F6C', '8ADE8184-61B6-C15B-CDB2-8D4E725C1777', '52B79754-D67D-6E55-389D-5F662D469781'),
    ('152E58A6-78C1-DA27-4D82-B3EEDB83A08C', '2022-09-10', 100.00, 'VIREMENT', '', '93E6DE8D-C30F-6342-FEB1-7BDE5D237DA9', '8ADE8184-61B6-C15B-CDB2-8D4E725C1777', '52B79754-D67D-6E55-389D-5F662D469781');


INSERT INTO prestationscours (id, date_prestation, duree_seance_minute_prestation, commentaire, reference_groupe, reference_moniteur)
VALUES
    ('17EDF727-55E7-A893-032C-9E8FCC6AD123', '2022-09-22', 60, '', '8CA18B54-8DD7-C821-E34F-AB1580C45235', '8150B7B2-A4EA-7794-B882-35D886DBC17B'),
    ('16703712-1044-4AB1-E66C-D64C6EF1DEEA', '2022-10-22', 60, '', '8CA18B54-8DD7-C821-E34F-AB1580C45235', '8150B7B2-A4EA-7794-B882-35D886DBC17B'),
    ('B16ED7BD-14AB-2685-DBC7-4EC59FCE6A71', '2022-11-22', 60, '', '8CA18B54-8DD7-C821-E34F-AB1580C45235', '8150B7B2-A4EA-7794-B882-35D886DBC17B'),
    ('177F7DD7-3433-9D2B-ECB6-D40C56CDAEEE', '2022-12-22', 60, '', '8CA18B54-8DD7-C821-E34F-AB1580C45235', '8150B7B2-A4EA-7794-B882-35D886DBC17B'),
    ('5559446C-2DD9-BE93-CC48-4687E2B4054C', '2023-01-22', 60, '', '8CA18B54-8DD7-C821-E34F-AB1580C45235', '8150B7B2-A4EA-7794-B882-35D886DBC17B'),
    ('45BC8221-C97E-8702-258B-BEDC5E52B714', '2022-09-22', 60, '', '52B79754-D67D-6E55-389D-5F662D469781', 'C44264C3-A1DF-AB14-FDA9-395E1DDD0259'),
    ('AAAD14AC-B672-D428-5D6A-5417456429C4', '2022-10-22', 60, '', '52B79754-D67D-6E55-389D-5F662D469781', 'C44264C3-A1DF-AB14-FDA9-395E1DDD0259'),
    ('166B23C0-945F-E4DB-37EF-212D0799C4EA', '2022-11-22', 60, '', '52B79754-D67D-6E55-389D-5F662D469781', 'C44264C3-A1DF-AB14-FDA9-395E1DDD0259'),
    ('05EA1E4C-BE9A-5996-4194-C5AD6A088923', '2022-12-22', 60, '', '52B79754-D67D-6E55-389D-5F662D469781', 'C44264C3-A1DF-AB14-FDA9-395E1DDD0259'),
    ('0490DBFC-7D70-970B-376D-12CC105A6224', '2023-01-22', 60, '', '52B79754-D67D-6E55-389D-5F662D469781', 'C44264C3-A1DF-AB14-FDA9-395E1DDD0259');






