
-- ================= 1°) Création des agences ================= 

INSERT INTO AGENCE (id, numero, date) VALUES ('1', 'AG001', '2018-01-01');



-- ================= 2°) Création des gérants ================= 

INSERT INTO GERANT (id, nom, prenom, agence_id) VALUES ('1', 'nom_gerant', 'prenom_gerant', '1');



-- ================= 3°) Création des conseillers ================= 

INSERT INTO CONSEILLER (id, nom, prenom, login, password, gerant_id) VALUES ('1', 'nom_conseiller1', 'prenom_conseiller1','c1', 'pwd', '1');
INSERT INTO CONSEILLER (id, nom, prenom, login, password, gerant_id) VALUES ('2', 'nom_conseiller2', 'prenom_conseiller2','c2', 'pwd', '1');



-- ================= 4°) Création des cartes ================= 

INSERT INTO CARTE (id, numero, active) VALUES ('1', '123456789', false);
INSERT INTO CARTEPREMIER (id) VALUES ('1');

INSERT INTO CARTE (id, numero, active) VALUES ('2', '234567891', true);
INSERT INTO CARTEELECTRON (id) VALUES ('2');

INSERT INTO CARTE (id, numero, active) VALUES ('3', '345678912', true);
INSERT INTO CARTEPREMIER (id) VALUES ('3');

INSERT INTO CARTE (id, numero, active) VALUES ('4', '456789123', true);
INSERT INTO CARTEELECTRON (id) VALUES ('4');

INSERT INTO CARTE (id, numero, active) VALUES ('5', '567891234', true);
INSERT INTO CARTEPREMIER (id) VALUES ('5');

INSERT INTO CARTE (id, numero, active) VALUES ('6', '678912345', true);
INSERT INTO CARTEELECTRON (id) VALUES ('6');

INSERT INTO CARTE (id, numero, active) VALUES ('7', '789123456', true);
INSERT INTO CARTEPREMIER (id) VALUES ('7');

INSERT INTO CARTE (id, numero, active) VALUES ('8', '891234567', true);
INSERT INTO CARTEELECTRON (id) VALUES ('8');

INSERT INTO CARTE (id, numero, active) VALUES ('9', '912345678', true);
INSERT INTO CARTEPREMIER (id) VALUES ('9');

INSERT INTO CARTE (id, numero, active) VALUES ('10', '012345678', true);
INSERT INTO CARTEELECTRON (id) VALUES ('10');



-- ================= 5°) Création des comptes courants================= 

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('1', '1234567890', '1000.00', '2018-01-01');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('1', '-2600.00', '1');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('2', '2345678901', '2000.00', '2018-01-02');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('2', '-1000.00', '2');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('3', '3456789012', '3000.00', '2018-01-03');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('3', '-1000.00', '3');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('4', '4567890123', '4000.00', '2018-01-04');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('4', '-1000.00', '4');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('5', '5678901234', '5000.00', '2018-01-05');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('5', '-1000.00', '5');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('6', '6789012345', '-6000.00', '2018-01-06');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('6', '-10000.00', '6');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('7', '7890123456', '7000.00', '2018-01-07');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('7', '-1000.00', '7');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('8', '8901234567', '8000.00', '2018-01-08');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('8', '-1000.00', '8');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('9', '9012345678', '9000.00', '2018-01-09');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('9', '-1000.00', '9');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('10', '0123456789', '-10000.00', '2018-01-10');
INSERT INTO COMPTECOURANT (id, decouvert, carte_id) VALUES ('10', '-10000.00', '10');



-- ================= 5°) Création des comptes épargne================= 

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('11','0000000001', '1000',  '2018-01-01');
INSERT INTO COMPTEEPARGNE (id, taux) VALUES ('11', '0.01');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('13','0000000003', '3000',  '2018-02-01');
INSERT INTO COMPTEEPARGNE (id, taux) VALUES ('13', '0.03');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('15', '0000000005','5000',  '2018-03-01');
INSERT INTO COMPTEEPARGNE (id, taux) VALUES ('15', '0.05');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('17', '0000000007','7000',  '2018-04-01');
INSERT INTO COMPTEEPARGNE (id, taux) VALUES ('17', '0.07');

INSERT INTO COMPTE (id, numero, solde, date) VALUES ('19','0000000009', '9000',  '2018-05-01');
INSERT INTO COMPTEEPARGNE (id, taux) VALUES ('19', '0.09');



-- ================= 6°) Création des clients ================= 

INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('1', 'AVCI', 'Ozlem', '1 rue du soleil', '1000','BOURG EN BRESSE', '01 53 82 74 10', '1', '11', '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('2', 'BLANC', 'Jean-Baptiste', '2 rue du nuage', '2000','AULNOIS SOUS LAON', '01 53 82 74 11', '2', null, '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('3', 'HILTBRUNNER', 'Jean-Michel', '3 rue du ciel', '3000','AVERMES', '01 53 82 74 15', '3', '13', '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('4', 'JOUMARD', 'Sebastien', '4 rue de l etoile', '4000','DIGNE LES BAINS', '01 53 82 74 17', '4', null, '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('5', 'LE CIGNE', 'Anthony', '5 rue de l espace', '5000','GAP', '01 53 82 74 42', '5', '15', '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('6', 'LE MENTEC', 'Sandrine', '6 rue de la constellation', '6000','NICE', '01 53 82 74 21', '6', null, '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('7', 'MUSA', 'Morane', '7 rue de la naine blanche', '7000','AJOUX', '01 53 82 74 22', '7', '17', '1');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('8', 'RENARD', 'Arnaud', '8 rue de la naine rouge', '8000','LA FRANCHEVILLE', '01 53 82 74 27', '8', null, '2');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('9', 'SAVARY', 'Etienne', '9 rue du big bang', '9000','FOIX', '01 53 82 74 25', '9', '19', '2');
INSERT INTO CLIENT (id, nom, prenom, adresse, codePostal, ville, telephone, compteCourant_id, compteEpargne_id, conseiller_id) VALUES ('10', 'SZYMEZAK', 'Clothilde', '10 rue du satellite', '10000','TROYES', '01 53 82 74 31', '10', null, '2');



-- ================= 7°) Création des virements ================= 

INSERT INTO VIREMENT (id, date, comptedebit_id, comptecredit_id, montant) VALUES ('1', '2018-08-01', '1', '11', '4000');