  INSERT INTO eleves (id,date_de_naissance,details,email,actif,genre,nom,prenom,telephone)
  VALUES
  ('5FD2CE6E-7358-204F-E15E-C8D9982160F9','28/04/2000','Lorem ipsum','augue.id@outlook.ca','true','F','Addison','Mona','04 12 15 89 88'),
  ('3CB059BE-CC68-FA22-CB7C-1C47801D7EEF','25/05/1993','Lorem ipsum','luctus.ut@aol.net','false','H','Jennifer','Armand','02 85 07 68 20'),
  ('936AC4C1-B9A5-9640-1517-3CD1D931B995','21/03/2004','Lorem','vehicula.aliquet@outlook.couk','true','H','Noble','Murphy','07 39 86 63 88'),
  ('2D16475C-8CE5-B684-D87E-839147CBC96E','12/10/1996','Lorem ipsum','arcu@hotmail.couk','true','F','Dustin','Carson','06 52 61 36 51'),
  ('4A8C1645-8D67-6527-1688-C1D13C129F6C','09/11/1991','Lorem ipsum dolor sit amet, consectetuer','tellus.non@protonmail.couk','true','F','Jared','Trevor','09 67 36 72 26'),
  ('93E6DE8D-C30F-6342-FEB1-7BDE5D237DA9','30/07/1995','Lorem ipsum dolor sit amet, consectetuer adipiscing','non.nisi@yahoo.couk','false','H','Tasha','Brielle','01 46 45 50 86'),
  ('A747AD47-7232-6909-0BDD-E9B7A29293E8','01/07/1996','Lorem','ultrices.sit@icloud.ca','true','F','Gabriel','Morgan','07 25 17 48 86'),
  ('616CDE31-E357-1637-5FDE-3571ECA81C1C','10/06/2001','Lorem ipsum dolor sit','metus.in@aol.org','false','H','Debra','Moana','04 94 22 51 02'),
  ('2BB36E57-DED7-A363-7BF9-FCC3DA87988B','08/07/1994','Lorem ipsum dolor sit amet,','praesent.eu.dui@protonmail.com','false','H','Bo','Ella','08 13 63 30 63'),
  ('489C1E5D-764C-0A4C-5E47-68A99DB2A505','16/10/2003','Lorem ipsum','diam.proin@hotmail.org','false','H','Aurora','Elaine','07 52 12 21 67'),
  ('7B91A893-80B4-8F24-FE1B-04B532D78EE0','13/11/2003','Lorem','mi.enim@aol.com','false','F','Jermaine','Amethyst','04 43 21 57 70'),
  ('383CE3BC-D6D3-C2B2-77A6-45ABE3877D9C','08/11/1991','Lorem','semper.egestas@outlook.edu','false','F','Larissa','Lois','07 71 18 78 64'),
  ('2BB17ACD-5818-E053-E92F-B22D6B889A10','15/12/2004','Lorem ipsum dolor','neque.nullam@protonmail.edu','true','H','Damian','Cameron','07 83 11 44 62'),
  ('61338D6E-9CE5-D946-8D26-A13657DE7CBA','29/03/2000','Lorem ipsum','in.aliquet@hotmail.net','true','H','Nissim','Odette','08 84 56 57 86'),
  ('1AB24CB6-AF24-9157-735E-271984A15B77','19/01/2004','Lorem ipsum dolor sit amet, consectetuer adipiscing','mauris@hotmail.com','false','F','Mara','Ruby','05 65 31 96 64');

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

    INSERT INTO formulescours (id,actif,annee,date_debut,date_fin,duree_seance_minute,effectif_maximum,libelle,niveau,nombre_seance_total,nombre_seance_hebdomadaire,periode,tarif,type_balle)
    VALUES
    ('9F9DAD95-9FAD-0B87-8452-67035E83345B','true','2022','11/09/2023','05/02/2024',60,4,'Cours Adulte groupe de 4 - LOISIR', 'LOISIR', 25,1,'HIVER', 350.00, 'JAUNE'),
    ('57FDE1D9-877A-DD4C-7736-1DA9E947E544','true','2022','11/04/2023','05/06/2024',60,4,'Cours Adulte groupe de 4 - LOISIR', 'LOISIR',  8,1,'ETE', 150, 'JAUNE'),
    ('371E7276-427B-7D8C-3564-3894D752D186','true','2022','11/09/2023','04/05/2024',60,4,'Cours Ado groupe de 4 - 4e série','QUATRIME_SERIE',  28,1, 'ANNEE', 400, 'JAUNE'),
    ('E289A9C2-9429-870B-C3A1-9B1AAD135D7A','true','2022','23/09/2023','03/05/2024',60,4, 'Cours Ado groupe de 4 - 3e série','TROISIEME_SERIE', 30,2, 'ANNEE', 380, 'JAUNE'),
    ('790D38B8-1EAE-BFF5-5F65-DD51722A9B55','true','2022','15/09/2023','02/05/2024',90,4, 'Cours Ado groupe de 4 - 2e série','DEUXIEME_SERIE', 35,2, 'ANNEE', 450, 'JAUNE'),
    ('4BC58C7A-5698-8D22-D8B4-57C48113400A','true','2022','18/09/2023','02/05/2024',60,2, 'Cours Adulte groupe de 2 - LOISIR','LOISIR', 22,1, 'ANNEE', 320, 'JAUNE'),
    ('8ADE8184-61B6-C15B-CDB2-8D4E725C1E7E','true','2022','12/09/2023','02/05/2024',60,2, 'Cours Ado groupe de 2 - 4e série - Intensif','QUATRIME_SERIE', 22,1,'ANNEE', 325, 'JAUNE'),
    ('4BC58C7A-5698-8D22-D8B4-578B4B13400A','true','2022','18/09/2023','02/05/2024',60,4, 'Cours Enfant groupe de 4 - LOISIR','LOISIR', 22,1, 'ANNEE', 280, 'VERTE');



--      INSERT INTO inscriptionsformule (id,date_paiement,montant_percu,note_paiement,reference_eleve_id,reference_formule_id,reference_groupe_id)
--      VALUES
--      ('5FD2CE6E-7358-204F-AA12-C8D9982160F9','22/09/2023','350.00', 'paiement complet, ras.', '5FD2CE6E-7358-204F-E15E-C8D9982160F9','9F9DAD95-9FAD-0B87-8452-67035E83345B', '');
--      ('3CB059BE-CC68-FA22-AA13-1C47801D7EEF','true','2022','11/04/2023','05/06/2024',1,4,'Cours Adulte groupe de 4 - LOISIR', 'LOISIR',  8,1,'ETE', 150, 'JAUNE'),
--      ('3CB059BE-CC68-FA22-BB07-1C47801D7EEF','true','2022','11/09/2023','04/05/2024',1,4,'Cours Ado groupe de 4 - 4e série','QUATRIME_SERIE',  28,1, 'ANNEE', 400, 'JAUNE'),
--      ('3CB059BE-CC68-FA22-CC54-1C47801D7EEF','true','2022','23/09/2023','03/05/2024',1,4, 'Cours Ado groupe de 4 - 3e série','TROISIEME_SERIE', 30,2, 'ANNEE', 380, 'JAUNE'),
--      ('790D38B8-1EAE-BFF5-5F65-DD51722A9B55','true','2022','15/09/2023','02/05/2024',1.5,4, 'Cours Ado groupe de 4 - 2e série','DEUXIEME_SERIE', 35,2, 'ANNEE', 450, 'JAUNE'),
--      ('4BC58C7A-5698-8D22-D8B4-57C48113400A','true','2022','18/09/2023','02/05/2024',1,2, 'Cours Adulte groupe de 2 - LOISIR','LOISIR', 22,1, 'ANNEE', 320, 'JAUNE'),
--      ('8ADE8184-61B6-C15B-CDB2-8D4E725C1E7E','true','2022','12/09/2023','02/05/2024',1.5,2, 'Cours Ado groupe de 2 - 4e série - Intensif','QUATRIME_SERIE', 22,1,'ANNEE', 325, 'JAUNE'),
--      ('4BC58C7A-5698-8D22-D8B4-578B4B13400A','true','2022','18/09/2023','02/05/2024',1,4, 'Cours Enfant groupe de 4 - LOISIR','LOISIR', 22,1, 'ANNEE', 280, 'VERTE');



--    INSERT INTO groupescours (id,libelle,jour1,jour2,moniteur_responsable_id)
--    VALUES
--    ('8CA18B54-8DD7-C821-E34F-AB1580C45235','MARDI','','')


--INSERT INTO prestationscours







